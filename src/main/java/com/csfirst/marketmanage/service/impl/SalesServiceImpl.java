package com.csfirst.marketmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csfirst.marketmanage.dao.SalesDao;
import com.csfirst.marketmanage.entity.Sales;
import com.csfirst.marketmanage.service.SalesService;
import org.springframework.stereotype.Service;


/**
 * @author TrueReality
 * @date 2023/3/14
 * @apiNotes
 */
@Service
public class SalesServiceImpl extends ServiceImpl<SalesDao, Sales> implements SalesService {
}
