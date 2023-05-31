package com.csfirst.marketmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csfirst.marketmanage.common.Result;
import com.csfirst.marketmanage.entity.Sales;
import com.csfirst.marketmanage.service.CustomerService;
import com.csfirst.marketmanage.service.ProductService;
import com.csfirst.marketmanage.service.SalesService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @GetMapping("/page")
    public Result<Page<Sales>> select(Long page, Long pageSize, String name) {
        Page<Sales> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Sales> lbw = new LambdaQueryWrapper<>();
        lbw.like(StringUtils.isNotEmpty(name), Sales::getSalesNo, name);
        lbw.orderByDesc(Sales::getSalesId);
        salesService.page(pageInfo, lbw);
        //把custId和prodId在对应表中找到然后变成相应的姓名和商品名称
        for (Sales record : pageInfo.getRecords()) {
            record.setCustId(customerService.getById(record.getCustId()).getCustName());
            record.setProdId(productService.getById(record.getProdId()).getProdName());
        }
        return Result.success(pageInfo);
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody Sales sales) {
        salesService.save(sales);
        return Result.success("添加成功!~~");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Sales sales) {
        salesService.updateById(sales);
        return Result.success("修改成功!~~");
    }

    @GetMapping("/{id}")
    public Result<Sales> getSalesById(@PathVariable Long id) {
        Sales salesGotById = salesService.getById(id);
        if (salesGotById == null) {
            return Result.error("找不到这个客户哦~~");
        } else {
            return Result.success(salesGotById);
        }
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteSalesById(@PathVariable Long id) {
        salesService.removeById(id);
        return Result.success("删除成功!~~~");
    }
}
