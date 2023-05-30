package com.csfirst.marketmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.yaml.snakeyaml.events.Event;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@Data
@TableName("customer_info")
public class Customer {
    @TableId(type = IdType.ASSIGN_ID)
    private int custId;
    private String custName;
    private String custEmail;
    private String custContact;
    private int memberLevel;
}
