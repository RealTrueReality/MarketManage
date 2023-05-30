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
@TableName("store_info")

public class Store {
    @TableId(type = IdType.AUTO)

    private int storeId;
    private String storeName;
    private String managerName;
    private String managerContact;
    private String storeAddress;
}
