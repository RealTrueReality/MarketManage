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
@TableName("supplier_info")

public class Supplier {
    @TableId(type = IdType.ASSIGN_ID)

    private int supplierId;
    private String supplierName;
    private String supplierContact;
}
