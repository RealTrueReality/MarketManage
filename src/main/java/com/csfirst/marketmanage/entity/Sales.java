package com.csfirst.marketmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@Data
@TableName("sales_info")

public class Sales {
    @TableId(type = IdType.AUTO)

    private int salesId;
    private String salesNo;
    private LocalDate salesDate;
    private int custId;
    private int prodId;
    private int salesQuantity;
    private BigDecimal salesPrice;
}
