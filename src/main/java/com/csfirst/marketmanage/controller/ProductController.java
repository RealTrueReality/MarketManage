package com.csfirst.marketmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csfirst.marketmanage.common.Result;
import com.csfirst.marketmanage.entity.Product;
import com.csfirst.marketmanage.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/page")
    public Result<Page<Product>> select(Long page, Long pageSize, String name) {
        Page<Product> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Product> lbw = new LambdaQueryWrapper<>();
        lbw.like(StringUtils.isNotEmpty(name), Product::getProdName,name);
        lbw.orderByDesc(Product::getProdId);
        productService.page(pageInfo, lbw);
        return Result.success(pageInfo);
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody Product product) {
        productService.save(product);
        return Result.success("添加成功!~~");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Product product) {
        productService.updateById(product);
        return Result.success("修改成功!~~");
    }

    @GetMapping("/{id}")
    public Result<Product> getproductById(@PathVariable Long id) {
        Product productGotById = productService.getById(id);
        if (productGotById == null) {
            return Result.error("找不到这个商品哦~~");
        } else {
            return Result.success(productGotById);
        }
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteproductById(@PathVariable Long id) {
        productService.removeById(id);
        return Result.success("删除成功!~~~");
    }
}
