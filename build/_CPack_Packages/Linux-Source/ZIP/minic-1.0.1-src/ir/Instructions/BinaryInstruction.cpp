///
/// @file BinaryInstruction.cpp
/// @brief 二元操作指令
///
/// @author zenglj (zenglj@live.com)
/// @version 1.0
/// @date 2024-09-29
///
/// @copyright Copyright (c) 2024
///
/// @par 修改日志:
/// <table>
/// <tr><th>Date       <th>Version <th>Author  <th>Description
/// <tr><td>2024-09-29 <td>1.0     <td>zenglj  <td>新建
/// </table>
///
#include "BinaryInstruction.h"
#include "ir/Types/IntegerType.h"

/// @brief 构造函数(二元运算)
/// @param _op 操作符
/// @param _srcVal1 源操作数1
/// @param _srcVal2 源操作数2
/// @param _type 结果类型
BinaryInstruction::BinaryInstruction(Function * _func,
                                     IRInstOperator _op,
                                     Value * _srcVal1,
                                     Value * _srcVal2,
                                     Type * _type)
    : Instruction(_func, _op, _type)
{
    addOperand(_srcVal1);
    addOperand(_srcVal2);
}

/// @brief 构造函数(一元运算)
/// @param _op 操作符
/// @param _srcVal 源操作数
/// @param _type 结果类型
BinaryInstruction::BinaryInstruction(Function * _func, IRInstOperator _op, Value * _srcVal, Type * _type)
    : Instruction(_func, _op, _type)
{
    addOperand(_srcVal);
}

/// @brief 构造函数(分支指令)
/// @param _func 所属函数
/// @param _op 操作符
/// @param _cond 条件值
/// @param _trueLabel 真分支标签
/// @param _falseLabel 假分支标签
BinaryInstruction::BinaryInstruction(Function * _func,
                                     IRInstOperator _op,
                                     Value * _cond,
                                     Value * _trueLabel,
                                     Value * _falseLabel)
    : Instruction(_func, _op, IntegerType::getTypeInt())
{
    addOperand(_cond);
    addOperand(_trueLabel);
    addOperand(_falseLabel);
}

/// @brief 转换成字符串
/// @param str 转换后的字符串
void BinaryInstruction::toString(std::string & str)
{

    Value * src1 = getOperand(0);
    Value * src2 = op != IRInstOperator::IRINST_OP_NEG ? getOperand(1) : nullptr;

    switch (op) {
        case IRInstOperator::IRINST_OP_ADD_I:
            // 加法指令，二元运算
            str = getIRName() + " = add " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_SUB_I:
            // 减法指令，二元运算
            str = getIRName() + " = sub " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_MUL_I:
            // 乘法指令，二元运算
            str = getIRName() + " = mul " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_DIV_I:
            // 除法指令，二元运算
            str = getIRName() + " = div " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_MOD_I:
            // 取余指令，二元运算
            str = getIRName() + " = mod " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_EQ:
            // 等于比较指令
            str = getIRName() + " = icmp eq " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_NE:
            // 不等于比较指令
            str = getIRName() + " = icmp ne " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_GT:
            // 大于比较指令
            str = getIRName() + " = icmp gt " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_LT:
            // 小于比较指令
            str = getIRName() + " = icmp lt " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_GE:
            // 大于等于比较指令
            str = getIRName() + " = icmp ge " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_LE:
            // 小于等于比较指令
            str = getIRName() + " = icmp le " + src1->getIRName() + "," + src2->getIRName();
            break;
        case IRInstOperator::IRINST_OP_NEG:
            // 负号指令，一元运算
            str = getIRName() + " = neg " + src1->getIRName();
            break;
        case IRInstOperator::IRINST_OP_BRANCH:
            // 条件分支指令
            str = "bc " + src1->getIRName() + ", label " + getOperand(1)->getIRName() + ", label " +
                  getOperand(2)->getIRName();
            break;
        default:
            // 未知指令
            Instruction::toString(str);
            break;
    }
}
