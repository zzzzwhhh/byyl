///
/// @file FormalParam.h
/// @brief 函数形参定义头文件
/// @author zenglj (zenglj@live.com)
/// @version 1.0
/// @date 2024-11-21
///
/// @copyright Copyright (c) 2024
///
#pragma once

#include "LocalVariable.h"

///
/// @brief 描述函数形参的类
///
class FormalParam {

public:
    /// @brief 构造函数
    /// @param var 形参变量
    /// @brief 构造函数(从LocalVariable创建)
    /// @param var 形参变量
    explicit FormalParam(LocalVariable * var) : variable(var), irName(""), regId(-1), memoryAddr(0) {}

    /// @brief 构造函数(从类型和名称创建)
    /// @param type 形参类型
    /// @param name 形参名称
    explicit FormalParam(Type * type, const std::string &name) : 
        variable(new LocalVariable(type, name, 1)), irName(""), regId(-1), memoryAddr(0) {}

    /// @brief 获取形参变量
    /// @return 形参变量
    LocalVariable * getVariable() const {
        return variable;
    }

    /// @brief 获取形参类型
    /// @return 形参类型
    Type * getType() const {
        return variable->getType();
    }

    /// @brief 获取形参名称
    /// @return 形参名称
    std::string getName() const {
        return variable->getName();
    }

    /// @brief 获取形参的IR名称
    /// @return IR名称
    std::string getIRName() const {
        return irName;
    }

    /// @brief 设置形参的IR名称
    /// @param name IR名称
    void setIRName(const std::string &name) {
        irName = name;
    }

    /// @brief 设置寄存器ID
    /// @param id 寄存器编号
    void setRegId(int id) {
        regId = id;
    }

    /// @brief 获取寄存器ID
    /// @return 寄存器编号
    int getRegId() const {
        return regId;
    }

    /// @brief 设置内存地址
    /// @param reg 基址寄存器编号
    /// @param offset 偏移量
    void setMemoryAddr(int reg, int offset) {
        memoryAddr = (reg << 16) | (offset & 0xFFFF);
    }

    /// @brief 获取内存地址
    /// @return 内存地址信息(高16位是寄存器编号，低16位是偏移量)
    int getMemoryAddr() const {
        return memoryAddr;
    }

private:
    /// @brief 形参变量
    LocalVariable * variable;
    
    /// @brief 形参的IR名称
    std::string irName;

    /// @brief 寄存器ID
    int regId;

    /// @brief 内存地址偏移量
    int memoryAddr;
};
