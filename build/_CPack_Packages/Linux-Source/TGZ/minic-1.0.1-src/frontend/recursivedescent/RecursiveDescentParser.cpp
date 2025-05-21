///
/// @file RecursiveDescentParser.cpp
/// @brief 递归下降分析法实现的语法分析后产生抽象语法树的实现
/// @author zenglj (zenglj@live.com)
/// @version 1.1
/// @date 2024-11-23
///
/// @copyright Copyright (c) 2024
///
/// @par 修改日志:
/// <table>
/// <tr><th>Date       <th>Version <th>Author  <th>Description
/// <tr><td>2024-11-21 <td>1.0     <td>zenglj  <td>新做
/// <tr><td>2024-11-23 <td>1.1     <td>zenglj  <td>表达式版增强
/// </table>
///
#include <stdarg.h>

#include "AST.h"
#include "AttrType.h"
#include "RecursiveDescentFlex.h"
#include "RecursiveDescentParser.h"

// 定义全局变量给词法分析使用，用于填充值
RDSType rd_lval;

// 词法识别的记号值，原始文本字符串
extern std::string tokenValue;

// 语法分析过程中的错误数目
static int errno_num = 0;

// 语法分析过程中的LookAhead，指向下一个Token
static RDTokenType lookaheadTag = RDTokenType::T_EMPTY;

static ast_node * Block();
static ast_node * expr();

///
/// @brief 继续检查LookAhead指向的记号是否是T，用于符号的FIRST集合或Follow集合判断
///
#define _(T) || (lookaheadTag == T)

///
/// @brief 第一个检查LookAhead指向的记号是否属于C，用于符号的FIRST集合或Follow集合判断
/// 如判断是否是T_ID，或者T_INT，可结合F和_两个宏来实现，即F(T_ID) _(T_INT)
///
#define F(C) (lookaheadTag == C)

///
/// @brief lookahead指向下一个Token
///
static void advance()
{
    lookaheadTag = (RDTokenType) rd_flex();
}

///
/// @brief flag若匹配则跳过Token，使得LookAhead指向下一个Token
/// @param tag 是否匹配指定的Tag
/// @return true：匹配，false：未匹配
///
static bool match(RDTokenType tag)
{
    bool result = false;

    if (F(tag)) {

        result = true;

        // 匹配，则向前获取下一个Token
        advance();
    }

    return result;
}

///
/// @brief 语法错误输出
/// @param format 格式化字符串，和printf的格式化字符串一样
///
static void semerror(const char * format, ...)
{
    char logStr[1024];

    va_list ap;
    va_start(ap, format);

    // 利用vsnprintf函数将可变参数按照一定的格式，格式化为一个字符串。
    vsnprintf(logStr, sizeof(logStr), format, ap);

    va_end(ap);

    printf("Line(%d): %s\n", rd_line_no, logStr);

    errno_num++;
}

///
/// @brief 实参列表语法分析，文法: realParamList: expr (T_COMMA expr)*;
/// @return ast_node* 实参列表节点
///
static void realParamList(ast_node * realParamsNode)
{
    // 实参表达式expr识别
    ast_node * param_node = expr();
    if (!param_node) {

        // 不是合法的实参
        return;
    }

    // 实参作为孩子插入到父节点realParamsNode中
    (void) realParamsNode->insert_son_node(param_node);

    // 后续是一个闭包(T_COMMA expr)*，即循环，不断的识别逗号与实参
    for (;;) {

        // 识别逗号
        if (match(T_COMMA)) {

            // 识别实参
            param_node = expr();

            (void) realParamsNode->insert_son_node(param_node);
        } else {

            // 不是逗号，则说明没有实参，可终止循环

            break;
        }
    }
}

///
/// @brief 识别ID尾部符号，可以是括号，代表函数调用；可以是中括号，代表数组（暂不支持）；可以是空串，代表简单变量
/// 其文法为 idTail: T_L_PAREN realParamList? T_R_PAREN | ε
/// @return ast_node*
///
static ast_node * idTail(var_id_attr & id)
{
    // 标识符节点
    ast_node * node = ast_node::New(id);

    // 对于字符型字面量的字符串空间需要释放，因词法用到了strdup进行了字符串空间的分配
    free(id.id);
    id.id = nullptr;

    if (match(T_L_PAREN)) {

        // 函数调用，idTail: T_L_PAREN realParamList? T_R_PAREN

        ast_node * realParamsNode = create_contain_node(ast_operator_type::AST_OP_FUNC_REAL_PARAMS);

        if (match(T_R_PAREN)) {

            // 被调用函数没有实参，返回一个空的实参清单节点
            return realParamsNode;
        }

        // 识别实参列表
        realParamList(realParamsNode);

        if (!match(T_R_PAREN)) {
            semerror("函数调用缺少右括号");
        }

        // 创建函数调用节点
        node = create_func_call(node, realParamsNode);
    } else {
        // 变量ID，idTail -> ε

        // 前面已经创建，可直接使用，无动作
    }

    return node;
}

///
/// @brief 一元表达式文法识别，其文法为
/// unaryExp: primaryExp | T_ID T_L_PAREN realParamList? T_R_PAREN
/// primaryExp: T_DIGIT | T_L_PAREN expr T_R_PAREN | lVal
/// lVal: T_ID
/// 因primaryExp的FIRST集合包含T_ID，因此该文法产生式不是LL(1)的，需要进行改造
/// 改造后的文法为：
/// unaryExp: T_DIGIT | T_L_PAREN expr T_R_PAREN | T_ID idTail
/// idTail: T_L_PAREN realParamList? T_R_PAREN | ε
/// 其中idTail表示标识符ID后可以是括号，代表函数调用；
/// 可以是中括号，代表数组（暂不支持）；
/// 可以是空串，代表简单变量。
/// @return ast_node*
///
static ast_node * unaryExp()
{
    ast_node * node = nullptr;

    if (F(T_DIGIT)) {

        // 无符号整数，primaryExp: T_DIGIT

        node = ast_node::New(rd_lval.integer_num);

        // 跳过当前记号，指向下一个记号
        advance();

    } else if (match(T_L_PAREN)) {

        // 括号表达式，primaryExp: T_L_PAREN expr T_R_PAREN

        // 括号内表达式识别
        node = expr();

        if (!match(T_R_PAREN)) {
            semerror("缺少右括号");
        }
    } else if (F(T_ID)) {

        // ID开头的表达式，可以是函数调用，也可以是数组(目前不支持)，或者简单变量，primaryExp: T_ID idTail

        var_id_attr & id = rd_lval.var_id;

        // 跳过当前记号，指向下一个记号
        advance();

        // 识别ID尾部符号
        node = idTail(id);
    }

    return node;
}

///
/// @brief 加减运算符, 其文法为addOp : T_ADD | T_SUB;
/// @return ast_operator_type AST中节点的运算符
///
ast_operator_type addOp()
{
    ast_operator_type type = ast_operator_type::AST_OP_MAX;

    if (F(T_ADD)) {

        type = ast_operator_type::AST_OP_ADD;

        // 跳过当前的记号，指向下一个记号
        advance();
    } else if (F(T_SUB)) {

        type = ast_operator_type::AST_OP_SUB;

        // 跳过当前的记号，指向下一个记号
        advance();
    }

    return type;
}

///
/// @brief 加减表达式，文法 addExp : unaryExp (addOp unaryExp)*
/// 其中的*表示闭包，闭包的就是循环
///
/// @return ast_node*
///
static ast_node * addExp()
{
    // 识别第一个unaryExp
    ast_node * left_node = unaryExp();
    if (!left_node) {
        // 非法的一元表达式
        return nullptr;
    }

    // 识别闭包(addOp unaryExp)*，循环
    // 循环退出条件，1) 不是二元加减运算符， 2) 语法错误
    for (;;) {

        // 获取加减运算符
        ast_operator_type op = addOp();
        if (ast_operator_type::AST_OP_MAX == op) {

            // 不是加减运算符则正常结束
            break;
        }

        // 获取右侧表达式
        ast_node * right_node = unaryExp();
        if (!right_node) {

            // 二元加减运算没有合法的右侧表达式
            break;
        }

        // 创建二元运算符节点
        left_node = create_contain_node(op, left_node, right_node);
    }

    return left_node;
}

/// @brief 表达式文法 expr : addExp, 表达式目前只支持加法与减法运算
/// @return AST的节点
static ast_node * expr()
{
    return addExp();
}

/// @brief returnStatement -> T_RETURN expr T_SEMICOLON
/// @return AST的节点
static ast_node * returnStatement()
{

    if (match(T_RETURN)) {

        // return语句的First集合元素为T_RETURN
        // 若匹配，则说明是return语句

        ast_node * expr_node = expr();

        if (!match(T_SEMICOLON)) {

            // 返回语句后没有分号
            semerror("返回语句后没有分号");
        }

        return create_contain_node(ast_operator_type::AST_OP_RETURN, expr_node);
    }

    return nullptr;
}

/// 识别表达式尾部符号，文法： assignExprStmtTail : T_ASSIGN expr | ε
static ast_node * assignExprStmtTail(ast_node * left_node)
{
    if (match(T_ASSIGN)) {

        // 赋值运算符，说明含有赋值运算

        // 必须要求左侧节点必须存在
        if (!left_node) {

            // 没有左侧节点，则语法错误
            semerror("赋值语句的左侧表达式不能为空");

            return nullptr;
        }

        // 赋值运算符右侧表达式分析识别
        ast_node * right_node = expr();

        return create_contain_node(ast_operator_type::AST_OP_ASSIGN, left_node, right_node);
    } else if (F(T_SEMICOLON)) {
        // 看是否满足assignExprStmtTail的Follow集合。在Follow集合中则正常结束，否则出错
        // 空语句
    }

    return left_node;
}

///
/// @brief 赋值语句或表达式语句识别，文法：assignExprStmt : expr assignExprStmtTail
/// @return ast_node*
///
static ast_node * assignExprStmt()
{
    // 识别表达式，目前还不知道是否是表达式语句或赋值语句
    ast_node * expr_node = expr();

    return assignExprStmtTail(expr_node);
}

///
/// @brief 语句的识别，其文法为：
/// statement:T_RETURN expr T_SEMICOLON | lVal T_ASSIGN expr T_SEMICOLON | block | expr? T_SEMICOLON
/// 需要注意的是赋值语句与表达式语句的FIRST集合有交集，都有T_ID
/// 必须进行语法改造使得满足LL(1)文法的要求，改造后的文法：
/// statement: returnStatement | block | T_SEMICOLON | assignExprStmt T_SEMICOLON
/// returnStatement : T_RETURN expr T_SEMICOLON
/// assignExprStmt : expr assignExprStmtTail
/// assignExprStmtTail : T_ASSIGN expr | ε
/// assignexprstat表示支持赋值的表达式
/// assignExprStmtTail这里只支持一次赋值，C语言中可以支持连续赋值
/// 如需要支持连续赋值，则assignExprStmtTail的文法可改造为assignExprStmtTail : T_ASSIGN expr assignExprStmtTail | ε
/// 注意若有T_ASSIGN，则左侧的expr必须具有左值属性，否则语义错误
///
/// @return AST的节点
///
static ast_node * statement()
{
    ast_node * node = nullptr;
    if (F(T_RETURN)) {

        // Return语句，识别产生式statement: returnStatement
        node = returnStatement();
    } else if (F(T_L_BRACE)) {

        // 语句块，识别产生式statement: block
        node = Block();
    } else if (F(T_SEMICOLON)) {

        // 空语句，识别产生式statement: T_SEMICOLON
        advance();
    } else if (F(T_ID) _(T_L_PAREN) _(T_DIGIT)) {

        // 赋值语句，statement -> assignExprStmt T_SEMICOLON

        // assignExprStmt的FIRST集合为{T_ID, T_L_PAREN, T_DIGIT}

        // 赋值语句以T_ID开头，并且左值要具有左值属性
        // 表达式语句可以以T_ID开头，也可以左小括号T_L_PAREN，甚至一元运算符等开头
        // 目前文法下表达式语句在不支持一元运算符的情况下只能以T_ID或T_L_PAREN开头
        node = assignExprStmt();

        if (!match(T_SEMICOLON)) {
            semerror("语句后缺少分号");
        }
    }

    return node;
}

///
/// @brief 变量定义列表语法识别 其文法：varDeclList : T_COMMA T_ID varDeclList | T_SEMICOLON
/// @param vardeclstmt_node 变量声明语句节点，所有的变量节点应该加到该节点中
///
static void varDeclList(ast_node * vardeclstmt_node)
{
    if (match(T_COMMA)) {

        // 匹配成功，定义列表中有逗号

        // 检查是否是标识符
        if (F(T_ID)) {

            // 定义列表中定义的变量

            // 新建变量声明节点并加入变量声明语句中
            (void) add_var_decl_node(vardeclstmt_node, rd_lval.var_id);

            // 填过当前的Token，指向下一个Token
            advance();

            // 递归调用，不断追加变量定义
            varDeclList(vardeclstmt_node);
        } else {
            semerror("逗号后必须是标识符");
        }
    } else if (match(T_SEMICOLON)) {
        // 匹配成功，则说明只有前面的一个变量或者变量定义，正常结束
    } else {
        semerror("非法记号: %d", (int) lookaheadTag);

        // 忽略该记号，继续检查
        advance();

        // 继续检查后续的变量
        varDeclList(vardeclstmt_node);
    }
}

///
/// @brief 局部变量的识别，其文法为：
/// varDecl : T_INT T_ID varDeclList
///
/// @return ast_node* 局部变量声明节点
///
static ast_node * varDecl()
{
    if (F(T_INT)) {

        // 这里必须复制，而不能引用，因为rd_lval为全局，下一个记号识别后要被覆盖
        type_attr type = rd_lval.type;

        // 跳过int类型的记号，指向下一个Token
        advance();

        // 检测是否是标识符
        if (F(T_ID)) {

            // 创建变量声明语句，并加入第一个变量
            ast_node * stmt_node = create_var_decl_stmt_node(type, rd_lval.var_id);

            // 跳过标识符记号，指向下一个Token
            advance();

            varDeclList(stmt_node);

            return stmt_node;

        } else {
            semerror("类型后要求的记号为标识符");
            // 这里忽略继续检查下一个记号，为便于一次可检查出多个错误
            // 当然可以直接退出循环，一旦有错就不再检查语法错误。
        }
    }

    return nullptr;
}

///
/// @brief 块中的项目识别，其文法为：
/// blockItem: statement | varDecl
/// varDecl : T_INT T_ID varDeclList
/// statement:T_RETURN expr T_SEMICOLON | lVal T_ASSIGN expr T_SEMICOLON | block | expr? T_SEMICOLON
/// varDecl的FIRST集合为{T_INT}，
/// statement的FIRST集合为{T_RETURN，T_ID，T_L_PAREN，T_SEMICOLON}
/// FIRST集合不交，可正常识别
/// 最终的文法为：
/// blockItem: statement | varDecl
/// varDecl : T_INT T_ID varDeclList
/// statement:T_RETURN expr T_SEMICOLON | lVal T_ASSIGN expr T_SEMICOLON | block | expr? T_SEMICOLON
/// @return 返回AST的节点
///
static ast_node * BlockItem()
{
    if (F(T_INT)) {
        return varDecl();
    } else {
        return statement();
    }
}

///
/// @brief 块内语句列表识别，文法为BlockItemList : BlockItem+
/// @return AST的节点
///
static void BlockItemList(ast_node * blockNode)
{
    for (;;) {

        // 如果是右大括号，则结束循环，提升效率
        if (F(T_R_BRACE)) {
            break;
        }

        // 遍历BlockItem
        ast_node * itemNode = BlockItem();
        if (itemNode) {
            blockNode->insert_son_node(itemNode);
        } else {
            // 没有，则结束
            break;
        }
    }
}

///
/// @brief 语句块识别，文法：Block -> T_L_BRACE BlockItemList? T_R_BRACE
/// @return AST的节点
///
static ast_node * Block()
{
    if (match(T_L_BRACE)) {

        // 创建语句块节点
        ast_node * blockNode = create_contain_node(ast_operator_type::AST_OP_BLOCK);

        // 空的语句块
        if (match(T_R_BRACE)) {
            return blockNode;
        }

        // 块内语句列表识别
        BlockItemList(blockNode);

        // 没有匹配左大括号，则语法错误
        if (!match(T_R_BRACE)) {
            semerror("缺少右大括号");
        }

        // 正常
        return blockNode;
    }

    // 语法解析失败
    return nullptr;
}

///
/// @brief 文法分析：idtail : varDeclList | T_L_PAREN T_R_PAREN block
/// @param type 类型 变量类型或函数返回值类型
/// @param id 标识符 变量名或者函数名
///
static ast_node * idtail(type_attr & type, var_id_attr & id)
{
    if (match(T_L_PAREN)) {
        // 函数定义

        // 目前函数定义没有形参，因此必须是右小括号
        if (match(T_R_PAREN)) {

            // 识别block
            ast_node * blockNode = Block();

            // 形参结点没有，设置为空指针
            ast_node * formalParamsNode = nullptr;

            // 创建函数定义的节点，孩子有类型，函数名，语句块和形参(实际上无)
            // create_func_def函数内会释放id中指向的标识符空间，切记，之后不要再释放，之前一定要是通过strdup函数或者malloc分配的空间
            return create_func_def(type, id, blockNode, formalParamsNode);
        } else {
            semerror("函数定义缺少右小括号");
        }

        return nullptr;
    }

    // 这里只能是变量定义

    // 根据第一个变量声明创建变量声明语句节点并加入其中
    ast_node * stmt_node = create_var_decl_stmt_node(type, id);

    varDeclList(stmt_node);

    return stmt_node;
}

// 编译单元识别，也就是文法的开始符号
// 其文法（antlr4中定义的）：
// compileUnit: (funcDef | varDecl)* EOF
// funcDef: T_INT T_ID T_L_PAREN T_R_PAREN block
// varDecl: basicType varDef (T_COMMA varDef)* T_SEMICOLON
// 因funcDef的First集合为T_INT，varDecl的First集合也为T_INT，不可区分，不是LL(1)文法，
// 再看第二个记号，第二个都是标识符，也不可区分
// 再检查第三个记号，funcDef为左小括号，变量声明可以为逗号，可以为等号，可以为分号，可以区分
// 因此可改造为 compileUnit : { T_INT T_ID idtail }，其中大括号代表闭包，类似上面的*
// idtail : varDeclList | T_L_PAREN T_R_PAREN block
// varDeclList可以定义多个变量，每次都增加一个逗号和标识符，直到最后一个记号为分号，即
// varDeclList : T_COMMA T_ID <varDeclList> | T_SEMICOLON
// 因此需要对文法进行改造，以便能够适合LL(1)文法的识别
// 因此改造后的文法为：
// 文法：compileUnit -> { T_INT T_ID idtail } EOF
// idtail : varDeclList | T_L_PAREN T_R_PAREN block
// varDeclList : T_COMMA T_ID varDeclList | T_SEMICOLON
// 闭包代表一个循环，可以0以上的循环，最后一个为EOF
static ast_node * compileUnit()
{
    // 创建AST的根节点，编译单元运算符
    ast_node * cu_node = create_contain_node(ast_operator_type::AST_OP_COMPILE_UNIT);

    for (;;) {

        // match匹配并LookAhead往前挪动
        if (F(T_INT)) {

            type_attr type = rd_lval.type;

            // 跳过当前的记号，指向下一个记号
            advance();

            // 检测是否是标识符
            if (F(T_ID)) {

                // 获取标识符的值和定位信息
                var_id_attr id = rd_lval.var_id;

                // 跳过当前的记号，指向下一个记号
                advance();

                // 函数定义的开头为int
                ast_node * node = idtail(type, id);

                // 加入到父节点中，node为空时insert_son_node内部进行了忽略
                (void) cu_node->insert_son_node(node);
            } else {
                semerror("类型后要求的记号为标识符");
                // 这里忽略继续检查下一个记号，为便于一次可检查出多个错误
                // 当然可以直接退出循环，一旦有错就不再检查语法错误。
            }

        } else if (F(T_EOF)) {
            // 文件解析完毕
            break;
        } else {
            // 这里发现错误
            break;
        }
    }

    return cu_node;
}

///
/// @brief 采用递归下降分析法实现词法与语法分析生成抽象语法树
/// @return ast_node* 空指针失败，否则成功
///
ast_node * rd_parse()
{
    // 没有错误信息
    errno_num = 0;

    // lookahead指向第一个Token
    advance();

    ast_node * astRoot = compileUnit();

    // 如果有错误信息，则返回-1，否则返回0
    if (errno_num != 0) {
        return nullptr;
    }

    return astRoot;
}
