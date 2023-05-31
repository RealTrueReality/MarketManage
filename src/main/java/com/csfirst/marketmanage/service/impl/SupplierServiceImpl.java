package com.csfirst.marketmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csfirst.marketmanage.dao.SupplierDao;
import com.csfirst.marketmanage.entity.Supplier;
import com.csfirst.marketmanage.service.SupplierService;
import org.springframework.stereotype.Service;


/**
 * @author TrueReality
 * @date 2023/3/14
 * @apiNotes
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierDao, Supplier> implements SupplierService {
}
