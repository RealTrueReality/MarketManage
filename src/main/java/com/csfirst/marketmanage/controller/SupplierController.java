package com.csfirst.marketmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csfirst.marketmanage.common.Result;
import com.csfirst.marketmanage.entity.Supplier;
import com.csfirst.marketmanage.service.SupplierService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/page")
    public Result<Page<Supplier>> select(Long page, Long pageSize, String name) {
        Page<Supplier> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Supplier> lbw = new LambdaQueryWrapper<>();
        lbw.like(StringUtils.isNotEmpty(name), Supplier::getSupplierName, name);
        lbw.orderByDesc(Supplier::getSupplierId);
        supplierService.page(pageInfo, lbw);
        return Result.success(pageInfo);
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody Supplier supplier) {
        supplierService.save(supplier);
        return Result.success("添加成功!~~");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Supplier supplier) {
        supplierService.updateById(supplier);
        return Result.success("修改成功!~~");
    }

    @GetMapping("/{id}")
    public Result<Supplier> getSupplierById(@PathVariable Long id) {
        Supplier supplierGotById = supplierService.getById(id);
        if (supplierGotById == null) {
            return Result.error("找不到这个供应商信息哦~~");
        } else {
            return Result.success(supplierGotById);
        }
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteSupplierById(@PathVariable Long id) {
        supplierService.removeById(id);
        return Result.success("删除成功!~~~");
    }
}
