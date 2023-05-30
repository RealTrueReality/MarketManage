package com.csfirst.marketmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@Data
@TableName("employee_info")

public class Employee {
    @TableId(type = IdType.AUTO)

    private int empId;
    private String empName;
    private String empEmail;
    private String empContact;
    private int storeId;
}
