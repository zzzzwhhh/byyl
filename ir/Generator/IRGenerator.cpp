///
/// @file IRGenerator.cpp
/// @brief AST遍历产生线性IR的源文件
/// @author zenglj (zenglj@live.com)
/// @version 1.1
/// @date 2024-11-23
///
/// @copyright Copyright (c) 2024
///
/// @par 修改日志:
/// <table>
/// <tr><th>Date       <th>Version <th>Author  <th>Description
/// <tr><td>2024-09-29 <td>1.0     <td>zenglj  <td>新建
/// <tr><td>2024-11-23 <td>1.1     <td>zenglj  <td>表达式版增强
/// </table>
///
#include <cstdint>
#include <cstdio>
#include <unordered_map>
#include <vector>
#include <iostream>

#include "AST.h"
#include "Common.h"
#include "Function.h"
#include "IRCode.h"
#include "IRGenerator.h"
#include "Module.h"
#include "EntryInstruction.h"
#include "LabelInstruction.h"
#include "ExitInstruction.h"
#include "FuncCallInstruction.h"
#include "BinaryInstruction.h"
#include "MoveInstruction.h"
#include "GotoInstruction.h"

// ===== break label stack管理 =====
namespace {
    thread_local std::vector<LabelInstruction *> breakLabelStack;
}

/// @brief 构造函数
/// @param _root AST的根
/// @param _module 符号表
IRGenerator::IRGenerator(ast_node * _root, Module * _module) : root(_root), module(_module)
{
    /* 叶子节点 */
    ast2ir_handlers[ast_operator_type::AST_OP_LEAF_LITERAL_UINT] = &IRGenerator::ir_leaf_node_uint;
    ast2ir_handlers[ast_operator_type::AST_OP_LEAF_VAR_ID] = &IRGenerator::ir_leaf_node_var_id;
    ast2ir_handlers[ast_operator_type::AST_OP_LEAF_TYPE] = &IRGenerator::ir_leaf_node_type;

    /* 表达式运算 */
    ast2ir_handlers[ast_operator_type::AST_OP_SUB] = &IRGenerator::ir_sub;
    ast2ir_handlers[ast_operator_type::AST_OP_ADD] = &IRGenerator::ir_add;
    ast2ir_handlers[ast_operator_type::AST_OP_NEG] = &IRGenerator::ir_neg;
    ast2ir_handlers[ast_operator_type::AST_OP_MUL] = &IRGenerator::ir_mul;
    ast2ir_handlers[ast_operator_type::AST_OP_DIV] = &IRGenerator::ir_div;
    ast2ir_handlers[ast_operator_type::AST_OP_MOD] = &IRGenerator::ir_mod;
    ast2ir_handlers[ast_operator_type::AST_OP_EQ] = &IRGenerator::ir_cmp;
    ast2ir_handlers[ast_operator_type::AST_OP_NE] = &IRGenerator::ir_cmp;
    ast2ir_handlers[ast_operator_type::AST_OP_GT] = &IRGenerator::ir_cmp;
    ast2ir_handlers[ast_operator_type::AST_OP_LT] = &IRGenerator::ir_cmp;
    ast2ir_handlers[ast_operator_type::AST_OP_GE] = &IRGenerator::ir_cmp;
    ast2ir_handlers[ast_operator_type::AST_OP_LE] = &IRGenerator::ir_cmp;
    ast2ir_handlers[ast_operator_type::AST_OP_LOGICAL_AND] = &IRGenerator::ir_bool;
    ast2ir_handlers[ast_operator_type::AST_OP_LOGICAL_OR] = &IRGenerator::ir_bool;
    ast2ir_handlers[ast_operator_type::AST_OP_LOGICAL_NOT] = &IRGenerator::ir_bool;

    /* 语句 */
    ast2ir_handlers[ast_operator_type::AST_OP_ASSIGN] = &IRGenerator::ir_assign;
    ast2ir_handlers[ast_operator_type::AST_OP_RETURN] = &IRGenerator::ir_return;
    ast2ir_handlers[ast_operator_type::AST_OP_IF] = &IRGenerator::ir_if;
    ast2ir_handlers[ast_operator_type::AST_OP_WHILE] = &IRGenerator::ir_while;

    /* 函数调用 */
    ast2ir_handlers[ast_operator_type::AST_OP_FUNC_CALL] = &IRGenerator::ir_function_call;

    /* 函数定义 */
    ast2ir_handlers[ast_operator_type::AST_OP_FUNC_DEF] = &IRGenerator::ir_function_define;
    ast2ir_handlers[ast_operator_type::AST_OP_FUNC_FORMAL_PARAMS] = &IRGenerator::ir_function_formal_params;

    /* 变量定义语句 */
    ast2ir_handlers[ast_operator_type::AST_OP_DECL_STMT] = &IRGenerator::ir_declare_statment;
    ast2ir_handlers[ast_operator_type::AST_OP_VAR_DECL] = &IRGenerator::ir_variable_declare;

    /* 语句块 */
    ast2ir_handlers[ast_operator_type::AST_OP_BLOCK] = &IRGenerator::ir_block;

    /* break语句 */
    ast2ir_handlers[ast_operator_type::AST_OP_BREAK] = &IRGenerator::ir_break;

    /* 编译单元 */
    ast2ir_handlers[ast_operator_type::AST_OP_COMPILE_UNIT] = &IRGenerator::ir_compile_unit;
}

/// @brief 遍历抽象语法树产生线性IR，保存到IRCode中
/// @param root 抽象语法树
/// @param IRCode 线性IR
/// @return true: 成功 false: 失败
bool IRGenerator::run()
{
    ast_node * node;

    // 从根节点进行遍历
    node = ir_visit_ast_node(root);

    return node != nullptr;
}

/// @brief 根据AST的节点运算符查找对应的翻译函数并执行翻译动作
/// @param node AST节点
/// @return 成功返回node节点，否则返回nullptr
ast_node * IRGenerator::ir_visit_ast_node(ast_node * node)
{
    // 空节点
    if (nullptr == node) {
        return nullptr;
    }

    bool result;

    std::unordered_map<ast_operator_type, ast2ir_handler_t>::const_iterator pIter;
    pIter = ast2ir_handlers.find(node->node_type);
    if (pIter == ast2ir_handlers.end()) {
        // 没有找到，则说明当前不支持
        result = (this->ir_default)(node);
    } else {
        result = (this->*(pIter->second))(node);
    }

    if (!result) {
        // 语义解析错误，则出错返回
        node = nullptr;
    }

    return node;
}

/// @brief 未知节点类型的节点处理
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_default(ast_node * node)
{
    // 未知的节点
    printf("Unkown node(%d)\n", (int) node->node_type);
    return true;
}

/// @brief 编译单元AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_compile_unit(ast_node * node)
{
    module->setCurrentFunction(nullptr);

    for (auto son: node->sons) {

        // 遍历编译单元，要么是函数定义，要么是语句
        ast_node * son_node = ir_visit_ast_node(son);
        if (!son_node) {
            // TODO 自行追加语义错误处理
            return false;
        }
    }

    return true;
}

/// @brief 函数定义AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_function_define(ast_node * node)
{
    bool result;

    // 创建一个函数，用于当前函数处理
    if (module->getCurrentFunction()) {
        // 函数中嵌套定义函数，这是不允许的，错误退出
        // TODO 自行追加语义错误处理
        return false;
    }

    // 函数定义的AST包含四个孩子
    // 第一个孩子：函数返回类型
    // 第二个孩子：函数名字
    // 第三个孩子：形参列表
    // 第四个孩子：函数体即block
    ast_node * type_node = node->sons[0];
    ast_node * name_node = node->sons[1];
    ast_node * param_node = node->sons[2];
    ast_node * block_node = node->sons[3];

    // 创建一个新的函数定义
    Function * newFunc = module->newFunction(name_node->name, type_node->type);
    if (!newFunc) {
        // 新定义的函数已经存在，则失败返回。
        // TODO 自行追加语义错误处理
        return false;
    }

    // 当前函数设置有效，变更为当前的函数
    module->setCurrentFunction(newFunc);

    // 进入函数的作用域
    module->enterScope();

    // 获取函数的IR代码列表，用于后面追加指令用，注意这里用的是引用传值
    InterCode & irCode = newFunc->getInterCode();

    // 这里也可增加一个函数入口Label指令，便于后续基本块划分

    // 创建并加入Entry入口指令
    irCode.addInst(new EntryInstruction(newFunc));

    // 创建出口指令并不加入出口指令，等函数内的指令处理完毕后加入出口指令
    LabelInstruction * exitLabelInst = new LabelInstruction(newFunc);

    // 函数出口指令保存到函数信息中，因为在语义分析函数体时return语句需要跳转到函数尾部，需要这个label指令
    newFunc->setExitLabel(exitLabelInst);

    // 遍历形参，没有IR指令，不需要追加
    result = ir_function_formal_params(param_node);
    if (!result) {
        // 形参解析失败
        // TODO 自行追加语义错误处理
        return false;
    }

    // 在函数开始处添加形参赋值指令
    node->blockInsts.addInst(param_node->blockInsts);

    // 新建一个Value，用于保存函数的返回值，如果没有返回值可不用申请
    LocalVariable * retValue = nullptr;
    if (!type_node->type->isVoidType()) {

        // 保存函数返回值变量到函数信息中，在return语句翻译时需要设置值到这个变量中
        retValue = static_cast<LocalVariable *>(module->newVarValue(type_node->type));
    }
    newFunc->setReturnValue(retValue);

    // 函数内已经进入作用域，内部不再需要做变量的作用域管理
    block_node->needScope = false;

    // 遍历block
    result = ir_block(block_node);
    if (!result) {
        // block解析失败
        // TODO 自行追加语义错误处理
        return false;
    }

    // IR指令追加到当前的节点中
    node->blockInsts.addInst(block_node->blockInsts);

    // 此时，所有指令都加入到当前函数中，也就是node->blockInsts

    // node节点的指令移动到函数的IR指令列表中
    irCode.addInst(node->blockInsts);

    // 添加函数出口Label指令，主要用于return语句跳转到这里进行函数的退出
    irCode.addInst(exitLabelInst);

    // 函数出口指令
    irCode.addInst(new ExitInstruction(newFunc, retValue));

    // 恢复成外部函数
    module->setCurrentFunction(nullptr);

    // 退出函数的作用域
    module->leaveScope();

    return true;
}

/// @brief 形式参数AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_function_formal_params(ast_node * node)
{
    Function * currentFunc = module->getCurrentFunction();
    if (!currentFunc) {
        return false;
    }

    // 遍历每个形参
    for (size_t i = 0; i < node->sons.size(); i++) {
        auto param = node->sons[i];
        // 获取形参类型和名称
        ast_node * typeNode = param->sons[0];
        ast_node * idNode = param->sons[1];

        // 创建形参局部变量
        LocalVariable * paramVar = static_cast<LocalVariable *>(module->newVarValue(typeNode->type, idNode->name));
        if (!paramVar) {
            return false;
        }

        // 将形参添加到函数参数列表
        currentFunc->addParam(paramVar);

        // 创建函数参数t0，但不将其加入符号表
        std::string paramName = "t" + std::to_string(i);
        Value * funcParam = module->newParamValue(typeNode->type, paramName);

        // 创建形参赋值指令: %l1 = %t0
        MoveInstruction * moveInst = new MoveInstruction(currentFunc, paramVar, funcParam);
        node->blockInsts.addInst(moveInst);

        // 记录形参变量
        param->val = paramVar;
    }

    return true;
}

/// @brief 函数调用AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_function_call(ast_node * node)
{
    std::vector<Value *> realParams;

    // 获取当前正在处理的函数
    Function * currentFunc = module->getCurrentFunction();

    // 函数调用的节点包含两个节点：
    // 第一个节点：函数名节点
    // 第二个节点：实参列表节点

    std::string funcName = node->sons[0]->name;
    int64_t lineno = node->sons[0]->line_no;

    ast_node * paramsNode = node->sons[1];

    // 根据函数名查找函数，看是否存在。若不存在则出错
    // 这里约定函数必须先定义后使用
    auto calledFunction = module->findFunction(funcName);
    if (nullptr == calledFunction) {
        minic_log(LOG_ERROR, "函数(%s)未定义或声明", funcName.c_str());
        return false;
    }

    // 当前函数存在函数调用
    currentFunc->setExistFuncCall(true);

    // 如果没有孩子，也认为是没有参数
    if (!paramsNode->sons.empty()) {

        int32_t argsCount = (int32_t) paramsNode->sons.size();

        // 当前函数中调用函数实参个数最大值统计，实际上是统计实参传参需在栈中分配的大小
        // 因为目前的语言支持的int和float都是四字节的，只统计个数即可
        if (argsCount > currentFunc->getMaxFuncCallArgCnt()) {
            currentFunc->setMaxFuncCallArgCnt(argsCount);
        }

        // 遍历参数列表，孩子是表达式
        // 这里自左往右计算表达式
        if (paramsNode->sons.size() != calledFunction->getParams().size()) {
            minic_log(LOG_ERROR,
                      "第%lld行的函数%s调用参数数量不匹配(需要%zu个,实际%zu个)",
                      (long long) lineno,
                      funcName.c_str(),
                      calledFunction->getParams().size(),
                      paramsNode->sons.size());
            return false;
        }

        for (auto son: paramsNode->sons) {
            ast_node * temp = ir_visit_ast_node(son);
            if (!temp) {
                return false;
            }

            realParams.push_back(temp->val);
            node->blockInsts.addInst(temp->blockInsts);
        }
    }

    // TODO 这里请追加函数调用的语义错误检查，这里只进行了函数参数的个数检查等，其它请自行追加。
    if (realParams.size() != calledFunction->getParams().size()) {
        // 函数参数的个数不一致，语义错误
        minic_log(LOG_ERROR, "第%lld行的被调用函数(%s)未定义或声明", (long long) lineno, funcName.c_str());
        return false;
    }

    // 返回调用有返回值，则需要分配临时变量，用于保存函数调用的返回值
    Type * type = calledFunction->getReturnType();

    // 确保无参函数调用时realParams为空
    if (calledFunction->getParams().empty() && !realParams.empty()) {
        minic_log(LOG_ERROR, "无参函数%s被错误地传入了参数", funcName.c_str());
        return false;
    }

    // 修正函数调用创建逻辑
    FuncCallInstruction * funcCallInst;
    if (realParams.size() != calledFunction->getParams().size()) {
        // 再次验证参数数量匹配
        minic_log(LOG_ERROR,
                  "函数%s参数数量不匹配(需要%zu个,实际%zu个)",
                  funcName.c_str(),
                  calledFunction->getParams().size(),
                  realParams.size());
        return false;
    }

    // 根据是否有参数选择不同的构造函数
    if (calledFunction->getParams().empty()) {
        funcCallInst = new FuncCallInstruction(currentFunc, calledFunction, type);
    } else {
        // 确保realParams非空且数量正确
        funcCallInst = new FuncCallInstruction(currentFunc, calledFunction, realParams, type);
    }

    // 创建函数调用指令
    node->blockInsts.addInst(funcCallInst);

    // 函数调用结果Value保存到node中，可能为空，上层节点可利用这个值
    node->val = funcCallInst;

    return true;
}

/// @brief 语句块（含函数体）AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_block(ast_node * node)
{
    // 进入作用域
    if (node->needScope) {
        module->enterScope();
    }

    std::vector<ast_node *>::iterator pIter;
    for (pIter = node->sons.begin(); pIter != node->sons.end(); ++pIter) {

        // 遍历Block的每个语句，进行显示或者运算
        ast_node * temp = ir_visit_ast_node(*pIter);
        if (!temp) {
            return false;
        }

        node->blockInsts.addInst(temp->blockInsts);
    }

    // 离开作用域
    if (node->needScope) {
        module->leaveScope();
    }

    return true;
}

/// @brief 整数加法AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_add(ast_node * node)
{
    ast_node * src1_node = node->sons[0];
    ast_node * src2_node = node->sons[1];

    // 加法节点，左结合，先计算左节点，后计算右节点

    // 加法的左边操作数
    ast_node * left = ir_visit_ast_node(src1_node);
    if (!left) {
        // 某个变量没有定值
        return false;
    }

    // 加法的右边操作数
    ast_node * right = ir_visit_ast_node(src2_node);
    if (!right) {
        // 某个变量没有定值
        return false;
    }

    // 这里只处理整型的数据，如需支持实数，则需要针对类型进行处理

    BinaryInstruction * addInst = new BinaryInstruction(module->getCurrentFunction(),
                                                        IRInstOperator::IRINST_OP_ADD_I,
                                                        left->val,
                                                        right->val,
                                                        IntegerType::getTypeInt());

    // 创建临时变量保存IR的值，以及线性IR指令
    node->blockInsts.addInst(left->blockInsts);
    node->blockInsts.addInst(right->blockInsts);
    node->blockInsts.addInst(addInst);

    node->val = addInst;

    return true;
}

/// @brief 整数乘法AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_mul(ast_node * node)
{
    ast_node * src1_node = node->sons[0];
    ast_node * src2_node = node->sons[1];

    ast_node * left = ir_visit_ast_node(src1_node);
    if (!left) {
        return false;
    }

    ast_node * right = ir_visit_ast_node(src2_node);
    if (!right) {
        return false;
    }

    BinaryInstruction * mulInst = new BinaryInstruction(module->getCurrentFunction(),
                                                        IRInstOperator::IRINST_OP_MUL_I,
                                                        left->val,
                                                        right->val,
                                                        IntegerType::getTypeInt());

    node->blockInsts.addInst(left->blockInsts);
    node->blockInsts.addInst(right->blockInsts);
    node->blockInsts.addInst(mulInst);

    node->val = mulInst;

    return true;
}

/// @brief 整数除法AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_div(ast_node * node)
{
    ast_node * src1_node = node->sons[0];
    ast_node * src2_node = node->sons[1];

    ast_node * left = ir_visit_ast_node(src1_node);
    if (!left) {
        return false;
    }

    ast_node * right = ir_visit_ast_node(src2_node);
    if (!right) {
        return false;
    }

    BinaryInstruction * divInst = new BinaryInstruction(module->getCurrentFunction(),
                                                        IRInstOperator::IRINST_OP_DIV_I,
                                                        left->val,
                                                        right->val,
                                                        IntegerType::getTypeInt());

    node->blockInsts.addInst(left->blockInsts);
    node->blockInsts.addInst(right->blockInsts);
    node->blockInsts.addInst(divInst);

    node->val = divInst;

    return true;
}

/// @brief 整数求余AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_mod(ast_node * node)
{
    ast_node * src1_node = node->sons[0];
    ast_node * src2_node = node->sons[1];

    ast_node * left = ir_visit_ast_node(src1_node);
    if (!left) {
        return false;
    }

    ast_node * right = ir_visit_ast_node(src2_node);
    if (!right) {
        return false;
    }

    BinaryInstruction * modInst = new BinaryInstruction(module->getCurrentFunction(),
                                                        IRInstOperator::IRINST_OP_MOD_I,
                                                        left->val,
                                                        right->val,
                                                        IntegerType::getTypeInt());

    node->blockInsts.addInst(left->blockInsts);
    node->blockInsts.addInst(right->blockInsts);
    node->blockInsts.addInst(modInst);

    node->val = modInst;

    return true;
}

/// @brief 整数减法AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_sub(ast_node * node)
{
    ast_node * src1_node = node->sons[0];
    ast_node * src2_node = node->sons[1];

    // 加法节点，左结合，先计算左节点，后计算右节点

    // 加法的左边操作数
    ast_node * left = ir_visit_ast_node(src1_node);
    if (!left) {
        // 某个变量没有定值
        return false;
    }

    // 加法的右边操作数
    ast_node * right = ir_visit_ast_node(src2_node);
    if (!right) {
        // 某个变量没有定值
        return false;
    }

    // 这里只处理整型的数据，如需支持实数，则需要针对类型进行处理

    BinaryInstruction * subInst = new BinaryInstruction(module->getCurrentFunction(),
                                                        IRInstOperator::IRINST_OP_SUB_I,
                                                        left->val,
                                                        right->val,
                                                        IntegerType::getTypeInt());

    // 创建临时变量保存IR的值，以及线性IR指令
    node->blockInsts.addInst(left->blockInsts);
    node->blockInsts.addInst(right->blockInsts);
    node->blockInsts.addInst(subInst);

    node->val = subInst;

    return true;
}

/// @brief 赋值AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_assign(ast_node * node)
{
    ast_node * son1_node = node->sons[0];
    ast_node * son2_node = node->sons[1];

    // 赋值节点，自右往左运算

    // 赋值运算符的左侧操作数
    ast_node * left = ir_visit_ast_node(son1_node);
    if (!left) {
        // 某个变量没有定值
        // 这里缺省设置变量不存在则创建，因此这里不会错误
        return false;
    }

    // 赋值运算符的右侧操作数
    ast_node * right = ir_visit_ast_node(son2_node);
    if (!right) {
        // 某个变量没有定值
        return false;
    }

    // 这里只处理整型的数据，如需支持实数，则需要针对类型进行处理

    MoveInstruction * movInst = new MoveInstruction(module->getCurrentFunction(), left->val, right->val);

    // 创建临时变量保存IR的值，以及线性IR指令
    node->blockInsts.addInst(right->blockInsts);
    node->blockInsts.addInst(left->blockInsts);
    node->blockInsts.addInst(movInst);

    // 这里假定赋值的类型是一致的
    node->val = movInst;

    return true;
}

/// @brief return节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_return(ast_node * node)
{
    ast_node * right = nullptr;

    // return语句可能没有没有表达式，也可能有，因此这里必须进行区分判断
    if (!node->sons.empty()) {

        ast_node * son_node = node->sons[0];

        // 返回的表达式的指令保存在right节点中
        right = ir_visit_ast_node(son_node);
        if (!right) {

            // 某个变量没有定值
            return false;
        }
    }

    // 这里只处理整型的数据，如需支持实数，则需要针对类型进行处理
    Function * currentFunc = module->getCurrentFunction();

    // 返回值存在时则移动指令到node中
    if (right) {

        // 创建临时变量保存IR的值，以及线性IR指令
        node->blockInsts.addInst(right->blockInsts);

        // 返回值赋值到函数返回值变量上，然后跳转到函数的尾部
        node->blockInsts.addInst(new MoveInstruction(currentFunc, currentFunc->getReturnValue(), right->val));

        node->val = right->val;
    } else {
        // 没有返回值
        node->val = nullptr;
    }

    // 跳转到函数的尾部出口指令上
    node->blockInsts.addInst(new GotoInstruction(currentFunc, currentFunc->getExitLabel()));

    return true;
}

/// @brief 类型叶子节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_leaf_node_type(ast_node * node)
{
    // 不需要做什么，直接从节点中获取即可。

    return true;
}

/// @brief 标识符叶子节点翻译成线性中间IR，变量声明的不走这个语句
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_leaf_node_var_id(ast_node * node)
{
    Value * val;

    // 查找ID型Value
    // 变量，则需要在符号表中查找对应的值

    val = module->findVarValue(node->name);

    node->val = val;

    return true;
}

/// @brief 无符号整数字面量叶子节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_leaf_node_uint(ast_node * node)
{
    ConstInt * val;

    // 新建一个整数常量Value
    val = module->newConstInt((int32_t) node->integer_val);

    node->val = val;

    return true;
}

/// @brief 变量声明语句节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_declare_statment(ast_node * node)
{
    bool result = false;

    for (auto & child: node->sons) {

        // 遍历每个变量声明
        result = ir_variable_declare(child);
        node->blockInsts.addInst(child->blockInsts);
        if (!result) {
            break;
        }
    }

    return result;
}

/// @brief 布尔逻辑AST节点翻译成线性中间IR(使用跳转实现)
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_bool(ast_node * node)
{
    if (node->node_type != ast_operator_type::AST_OP_LOGICAL_AND &&
        node->node_type != ast_operator_type::AST_OP_LOGICAL_OR &&
        node->node_type != ast_operator_type::AST_OP_LOGICAL_NOT) {
        return false;
    }

    Function * currentFunc = module->getCurrentFunction();
    if (!currentFunc)
        return false;

    LabelInstruction * trueLabel = new LabelInstruction(currentFunc);
    LabelInstruction * falseLabel = new LabelInstruction(currentFunc);
    LabelInstruction * endLabel = new LabelInstruction(currentFunc);
    LocalVariable * result = static_cast<LocalVariable *>(module->newVarValue(IntegerType::getTypeInt()));

    if (node->node_type == ast_operator_type::AST_OP_LOGICAL_NOT) {
        // 非运算
        ast_node * operand = ir_visit_ast_node(node->sons[0]);
        if (!operand || !operand->val)
            return false;
        node->blockInsts.addInst(operand->blockInsts);

        // if (operand == 0) goto trueLabel else goto falseLabel
        BinaryInstruction * cmp = new BinaryInstruction(currentFunc,
                                                        IRInstOperator::IRINST_OP_EQ,
                                                        operand->val,
                                                        module->newConstInt(0),
                                                        IntegerType::getTypeBool());
        node->blockInsts.addInst(cmp);
        node->blockInsts.addInst(
            new BinaryInstruction(currentFunc, IRInstOperator::IRINST_OP_BRANCH, cmp, trueLabel, falseLabel));
    } else if (node->node_type == ast_operator_type::AST_OP_LOGICAL_AND) {
        // a && b
        ast_node * left = ir_visit_ast_node(node->sons[0]);
        if (!left || !left->val)
            return false;
        node->blockInsts.addInst(left->blockInsts);

        // 创建右侧表达式入口label
        LabelInstruction * rightEntryLabel = new LabelInstruction(currentFunc);

        // if (left == 0) goto  rightEntryLabel else goto falseLabel
        BinaryInstruction * leftCmp = new BinaryInstruction(currentFunc,
                                                            IRInstOperator::IRINST_OP_EQ,
                                                            left->val,
                                                            module->newConstInt(0),
                                                            IntegerType::getTypeBool());
        node->blockInsts.addInst(leftCmp);
        node->blockInsts.addInst(
            new BinaryInstruction(currentFunc, IRInstOperator::IRINST_OP_BRANCH, leftCmp, falseLabel, rightEntryLabel));

        // 右侧表达式
        node->blockInsts.addInst(rightEntryLabel);
        ast_node * right = ir_visit_ast_node(node->sons[1]);
        if (!right || !right->val)
            return false;
        node->blockInsts.addInst(right->blockInsts);

        // if (right == 0) goto falseLabel  else goto trueLabel
        BinaryInstruction * rightCmp = new BinaryInstruction(currentFunc,
                                                             IRInstOperator::IRINST_OP_EQ,
                                                             right->val,
                                                             module->newConstInt(0),
                                                             IntegerType::getTypeBool());
        node->blockInsts.addInst(rightCmp);
        node->blockInsts.addInst(
            new BinaryInstruction(currentFunc, IRInstOperator::IRINST_OP_BRANCH, rightCmp, falseLabel, trueLabel));
    } else if (node->node_type == ast_operator_type::AST_OP_LOGICAL_OR) {
        // a || b
        ast_node * left = ir_visit_ast_node(node->sons[0]);
        if (!left || !left->val)
            return false;
        node->blockInsts.addInst(left->blockInsts);

        // 创建右侧表达式入口label
        LabelInstruction * rightEntryLabel = new LabelInstruction(currentFunc);

        // if (left != 0) goto trueLabel else goto rightEntryLabel
        BinaryInstruction * leftCmp = new BinaryInstruction(currentFunc,
                                                            IRInstOperator::IRINST_OP_NE,
                                                            left->val,
                                                            module->newConstInt(0),
                                                            IntegerType::getTypeBool());
        node->blockInsts.addInst(leftCmp);
        node->blockInsts.addInst(
            new BinaryInstruction(currentFunc, IRInstOperator::IRINST_OP_BRANCH, leftCmp, trueLabel, rightEntryLabel));

        // 右侧表达式
        node->blockInsts.addInst(rightEntryLabel);
        ast_node * right = ir_visit_ast_node(node->sons[1]);
        if (!right || !right->val)
            return false;
        node->blockInsts.addInst(right->blockInsts);

        // if (right != 0) goto trueLabel else goto falseLabel
        BinaryInstruction * rightCmp = new BinaryInstruction(currentFunc,
                                                             IRInstOperator::IRINST_OP_NE,
                                                             right->val,
                                                             module->newConstInt(0),
                                                             IntegerType::getTypeBool());
        node->blockInsts.addInst(rightCmp);
        node->blockInsts.addInst(
            new BinaryInstruction(currentFunc, IRInstOperator::IRINST_OP_BRANCH, rightCmp, trueLabel, falseLabel));
    }

    // true分支: 结果为1
    node->blockInsts.addInst(trueLabel);
    node->blockInsts.addInst(new MoveInstruction(currentFunc, result, module->newConstInt(1)));
    node->blockInsts.addInst(new GotoInstruction(currentFunc, endLabel));

    // false分支: 结果为0
    node->blockInsts.addInst(falseLabel);
    node->blockInsts.addInst(new MoveInstruction(currentFunc, result, module->newConstInt(0)));
    node->blockInsts.addInst(new GotoInstruction(currentFunc, endLabel));

    // 结束标签
    node->blockInsts.addInst(endLabel);
    node->val = result;

    return true;
}

/// @brief 比较运算AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_cmp(ast_node * node)
{
    // 验证比较运算节点是否有两个操作数
    if (node->sons.size() != 2) {
        minic_log(LOG_ERROR, "比较运算需要两个操作数");
        return false;
    }

    // 处理左操作数
    ast_node * left = ir_visit_ast_node(node->sons[0]);
    if (!left) {
        minic_log(LOG_ERROR, "左操作数解析失败");
        return false;
    }
    if (!left->val) {
        minic_log(LOG_ERROR, "左操作数值无效");
        return false;
    }

    // 处理右操作数
    ast_node * right = ir_visit_ast_node(node->sons[1]);
    if (!right) {
        minic_log(LOG_ERROR, "右操作数解析失败");
        return false;
    }
    if (!right->val) {
        minic_log(LOG_ERROR, "右操作数值无效");
        return false;
    }

    // 验证操作数类型是否匹配
    if (!left->val->getType() || !right->val->getType()) {
        minic_log(LOG_ERROR, "操作数类型无效");
        return false;
    }
    if (left->val->getType() != right->val->getType()) {
        minic_log(LOG_ERROR, "操作数类型不匹配");
        return false;
    }

    IRInstOperator op;
    switch (node->node_type) {
        case ast_operator_type::AST_OP_EQ:
            op = IRInstOperator::IRINST_OP_EQ;
            break;
        case ast_operator_type::AST_OP_NE:
            op = IRInstOperator::IRINST_OP_NE;
            break;
        case ast_operator_type::AST_OP_GT:
            op = IRInstOperator::IRINST_OP_GT;
            break;
        case ast_operator_type::AST_OP_LT:
            op = IRInstOperator::IRINST_OP_LT;
            break;
        case ast_operator_type::AST_OP_GE:
            op = IRInstOperator::IRINST_OP_GE;
            break;
        case ast_operator_type::AST_OP_LE:
            op = IRInstOperator::IRINST_OP_LE;
            break;
        default:
            return false;
    }

    // 创建比较指令
    BinaryInstruction * cmpInst =
        new BinaryInstruction(module->getCurrentFunction(), op, left->val, right->val, IntegerType::getTypeBool());

    // 合并指令块
    node->blockInsts.addInst(left->blockInsts);
    node->blockInsts.addInst(right->blockInsts);
    node->blockInsts.addInst(cmpInst);

    // 保存结果值
    node->val = cmpInst;

    return true;
}

/// @brief 一元负号AST节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_neg(ast_node * node)
{
    ast_node * src_node = node->sons[0];

    // 处理操作数
    ast_node * operand = ir_visit_ast_node(src_node);
    if (!operand) {
        return false;
    }

    // 生成负号指令
    BinaryInstruction * negInst = new BinaryInstruction(module->getCurrentFunction(),
                                                        IRInstOperator::IRINST_OP_NEG,
                                                        operand->val,
                                                        IntegerType::getTypeInt());

    // 添加指令到当前节点
    node->blockInsts.addInst(operand->blockInsts);
    node->blockInsts.addInst(negInst);

    // 保存结果值
    node->val = negInst;

    return true;
}

/// @brief if语句节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_while(ast_node * node)
{
    // while节点有2个子节点:
    // 0: 条件表达式
    // 1: 循环体

    if (node->sons.size() != 2) {
        minic_log(LOG_ERROR, "while语句缺少必要部分");
        return false;
    }

    Function * currentFunc = module->getCurrentFunction();
    if (!currentFunc) {
        minic_log(LOG_ERROR, "while语句不在函数内");
        return false;
    }

    // 创建循环标签
    LabelInstruction * loopLabel = new LabelInstruction(currentFunc);
    LabelInstruction * bodyLabel = new LabelInstruction(currentFunc);
    LabelInstruction * exitLabel = new LabelInstruction(currentFunc);

    // 添加break目标label
    breakLabelStack.push_back(exitLabel);

    // 添加循环入口标签
    node->blockInsts.addInst(loopLabel);

    // 处理条件表达式
    ast_node * cond = ir_visit_ast_node(node->sons[0]);
    if (!cond || !cond->val) {
        minic_log(LOG_ERROR, "while条件表达式无效");
        return false;
    }
    node->blockInsts.addInst(cond->blockInsts);

    // 生成条件跳转指令
    BinaryInstruction * branchInst =
        new BinaryInstruction(currentFunc, IRInstOperator::IRINST_OP_BRANCH, cond->val, bodyLabel, exitLabel);
    node->blockInsts.addInst(branchInst);

    // 处理循环体
    node->blockInsts.addInst(bodyLabel);
    ast_node * bodyBlock = ir_visit_ast_node(node->sons[1]);
    if (!bodyBlock) {
        minic_log(LOG_ERROR, "while循环体无效");
        return false;
    }
    node->blockInsts.addInst(bodyBlock->blockInsts);

    // 跳转回循环开始
    node->blockInsts.addInst(new GotoInstruction(currentFunc, loopLabel));

    // 添加退出标签
    node->blockInsts.addInst(exitLabel);

    // 弹出break目标label
    breakLabelStack.pop_back();

    return true;
}

bool IRGenerator::ir_if(ast_node * node)
{
    // if节点通常有2-3个子节点:
    // 0: 条件表达式
    // 1: then块
    // 2: else块(可选)

    if (node->sons.size() < 2) {
        minic_log(LOG_ERROR, "if语句缺少必要部分");
        return false;
    }

    Function * currentFunc = module->getCurrentFunction();
    if (!currentFunc) {
        minic_log(LOG_ERROR, "if语句不在函数内");
        return false;
    }

    // 处理条件表达式
    ast_node * cond = ir_visit_ast_node(node->sons[0]);
    if (!cond || !cond->val) {
        minic_log(LOG_ERROR, "if条件表达式无效");
        return false;
    }
    node->blockInsts.addInst(cond->blockInsts);

    // 创建then和else标签
    LabelInstruction * thenLabel = new LabelInstruction(currentFunc);
    LabelInstruction * elseLabel = new LabelInstruction(currentFunc);
    LabelInstruction * mergeLabel = new LabelInstruction(currentFunc);
    BinaryInstruction * NEInst = new BinaryInstruction(currentFunc,
                                                       IRInstOperator::IRINST_OP_NE,
                                                       cond->val,
                                                       module->newConstInt(0),
                                                       IntegerType::getTypeBool());
    node->blockInsts.addInst(NEInst);
    // 生成条件跳转指令
    BinaryInstruction * branchInst = new BinaryInstruction(currentFunc,
                                                           IRInstOperator::IRINST_OP_BRANCH,
                                                           NEInst,
                                                           thenLabel,
                                                           node->sons.size() > 2 ? elseLabel : mergeLabel);
    node->blockInsts.addInst(branchInst);

    // 处理then块
    node->blockInsts.addInst(thenLabel);
    // 支持break嵌套：if语句内break应跳转到最近breakLabel
    ast_node * thenBlock = ir_visit_ast_node(node->sons[1]);
    if (!thenBlock) {
        minic_log(LOG_ERROR, "if then块无效");
        return false;
    }
    node->blockInsts.addInst(thenBlock->blockInsts);
    node->blockInsts.addInst(new GotoInstruction(currentFunc, mergeLabel));

    // 处理else块(如果有)
    if (node->sons.size() > 2) {
        node->blockInsts.addInst(elseLabel);
        ast_node * elseBlock = ir_visit_ast_node(node->sons[2]);
        if (!elseBlock) {
            minic_log(LOG_ERROR, "if else块无效");
            return false;
        }
        node->blockInsts.addInst(elseBlock->blockInsts);
        node->blockInsts.addInst(new GotoInstruction(currentFunc, mergeLabel));
    }

    // 添加合并点
    node->blockInsts.addInst(mergeLabel);

    return true;
}

// break语句IR生成
bool IRGenerator::ir_break(ast_node * node)
{
    Function * currentFunc = module->getCurrentFunction();
    if (!currentFunc) {
        minic_log(LOG_ERROR, "break语句不在函数内");
        return false;
    }
    if (breakLabelStack.empty() || breakLabelStack.back() == nullptr) {
        minic_log(LOG_ERROR, "break语句未处于循环或switch语句内");
        return false;
    }
    // 生成跳转到最近break目标的goto指令
    node->blockInsts.addInst(new GotoInstruction(currentFunc, breakLabelStack.back()));
    return true;
}

/// @brief 变量定声明节点翻译成线性中间IR
/// @param node AST节点
/// @return 翻译是否成功，true：成功，false：失败
bool IRGenerator::ir_variable_declare(ast_node * node)
{
    // 获取当前函数
    Function * currentFunc = module->getCurrentFunction();

    // 先创建变量的Value(对应类型节点sons[0]和变量名节点sons[1])
    Value * varValue = module->newVarValue(node->sons[0]->type, node->sons[1]->name);
    node->val = varValue;

    // 如果存在初始化值(第三个孩子),先访问初始化值节点
    if (node->sons.size() == 3) {
        ast_node * initValue = ir_visit_ast_node(node->sons[2]);
        if (!initValue) {
            minic_log(LOG_ERROR, "变量(%s)初始化值无效", node->sons[1]->name.c_str());
            return false;
        }

        // 处理初始化值的指令
        node->blockInsts.addInst(initValue->blockInsts);

        // 生成变量赋值IR
        MoveInstruction * moveInst = new MoveInstruction(currentFunc,
                                                         varValue,      // 声明的变量作为赋值目标
                                                         initValue->val // 初始化表达式的值作为源操作数
        );
        node->blockInsts.addInst(moveInst);
    }

    return true;
}
