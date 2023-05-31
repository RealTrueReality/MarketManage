package com.csfirst.marketmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csfirst.marketmanage.dao.StoreDao;
import com.csfirst.marketmanage.entity.Store;
import com.csfirst.marketmanage.service.StoreService;
import org.springframework.stereotype.Service;


/**
 * @author TrueReality
 * @date 2023/3/14
 * @apiNotes
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreDao, Store> implements StoreService {
}
