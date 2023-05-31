package com.csfirst.marketmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csfirst.marketmanage.common.Result;
import com.csfirst.marketmanage.entity.Purchase;
import com.csfirst.marketmanage.service.PurchaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/page")
    public Result<Page<Purchase>> select(Long page, Long pageSize, String name) {
        Page<Purchase> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Purchase> lbw = new LambdaQueryWrapper<>();
        lbw.like(StringUtils.isNotEmpty(name), Purchase::getPurchaseNo, name);
        lbw.orderByDesc(Purchase::getPurchaseId);
        purchaseService.page(pageInfo, lbw);
        return Result.success(pageInfo);
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody Purchase purchase) {
        //TODOSOLVED purchase.setPurchaseDate(purchase.getPurchaseDate().plusDays(1));
        purchaseService.save(purchase);
        return Result.success("添加成功!~~");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Purchase purchase) {
        //TODOSOLVED purchase.setPurchaseDate(purchase.getPurchaseDate().plusDays(1));
        purchaseService.updateById(purchase);
        return Result.success("修改成功!~~");
    }

    @GetMapping("/{id}")
    public Result<Purchase> getPurchaseById(@PathVariable Long id) {
        Purchase purchaseGotById = purchaseService.getById(id);
        if (purchaseGotById == null) {
            return Result.error("找不到这个采购信息哦~~");
        } else {
            return Result.success(purchaseGotById);
        }
    }

    @DeleteMapping("/{id}")
    public Result<String> deletePurchaseById(@PathVariable Long id) {
        purchaseService.removeById(id);
        return Result.success("删除成功!~~~");
    }
}
