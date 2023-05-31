package com.csfirst.marketmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csfirst.marketmanage.common.Result;
import com.csfirst.marketmanage.entity.Store;
import com.csfirst.marketmanage.service.StoreService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/page")
    public Result<Page<Store>> select(Long page, Long pageSize, String name) {
        Page<Store> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Store> lbw = new LambdaQueryWrapper<>();
        lbw.like(StringUtils.isNotEmpty(name), Store::getStoreName, name);
        lbw.orderByDesc(Store::getStoreId);
        storeService.page(pageInfo, lbw);
        return Result.success(pageInfo);
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody Store store) {
        storeService.save(store);
        return Result.success("添加成功!~~");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Store store) {
        storeService.updateById(store);
        return Result.success("修改成功!~~");
    }

    @GetMapping("/{id}")
    public Result<Store> getStoreById(@PathVariable Long id) {
        Store storeGotById = storeService.getById(id);
        if (storeGotById == null) {
            return Result.error("找不到这个商店信息哦~~");
        } else {
            return Result.success(storeGotById);
        }
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteStoreById(@PathVariable Long id) {
        storeService.removeById(id);
        return Result.success("删除成功!~~~");
    }
}
