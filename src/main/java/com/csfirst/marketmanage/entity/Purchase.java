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
@TableName("purchase_info")

public class Purchase {
    @TableId(type = IdType.AUTO)

    private int purchaseId;
    private String purchaseNo;
    private LocalDate purchaseDate;
    private String supplierId;
    private String prodId;
    private int purchaseQuantity;
    private BigDecimal purchasePrice;
}
