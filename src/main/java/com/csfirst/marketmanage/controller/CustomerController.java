package com.csfirst.marketmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csfirst.marketmanage.common.Result;
import com.csfirst.marketmanage.entity.Customer;
import com.csfirst.marketmanage.entity.Employee;
import com.csfirst.marketmanage.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TrueReality
 * @date 2023/5/14
 * @apiNotes
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/page")
    public Result<Page<Customer>> select(Long page, Long pageSize,String name) {
        Page<Customer> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Customer> lbw = new LambdaQueryWrapper<>();
        lbw.like(StringUtils.isNotEmpty(name), Customer::getCustName,name);
        lbw.orderByDesc(Customer::getCustId);
        customerService.page(pageInfo, lbw);
        return Result.success(pageInfo);
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody Customer Customer) {
        customerService.save(Customer);
        return Result.success("添加成功!~~");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Customer Customer) {
        customerService.updateById(Customer);
        return Result.success("修改成功!~~");
    }

    @GetMapping("/{id}")
    public Result<Customer> getCustomerById(@PathVariable Long id) {
        Customer CustomerGotById = customerService.getById(id);
        if (CustomerGotById == null) {
            return Result.error("找不到这个客户哦~~");
        } else {
            return Result.success(CustomerGotById);
        }
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteCustomerById(@PathVariable Long id) {
        customerService.removeById(id);
        return Result.success("删除成功!~~~");
    }
}
