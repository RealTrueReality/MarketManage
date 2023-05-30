package com.csfirst.marketmanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csfirst.marketmanage.entity.Customer;
import com.csfirst.marketmanage.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@Mapper
public interface ProductDao extends BaseMapper<Product> {

}
