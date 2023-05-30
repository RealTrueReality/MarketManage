package com.csfirst.marketmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csfirst.marketmanage.dao.CustomerDao;
import com.csfirst.marketmanage.dao.ProductDao;
import com.csfirst.marketmanage.entity.Customer;
import com.csfirst.marketmanage.entity.Product;
import com.csfirst.marketmanage.service.CustomerService;
import com.csfirst.marketmanage.service.ProductService;
import org.springframework.stereotype.Service;


/**
 * @author TrueReality
 * @date 2023/3/14
 * @apiNotes
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {
}
