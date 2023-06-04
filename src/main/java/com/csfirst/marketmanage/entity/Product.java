package com.csfirst.marketmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@Data
@TableName("product_info")

public class Product {
    @TableId(type = IdType.AUTO)

    private int prodId;
    private String prodName;
    private String prodCategory;
    private BigDecimal prodPrice;
    private String supplierId;
}
