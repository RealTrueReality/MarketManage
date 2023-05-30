package com.csfirst.marketmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csfirst.marketmanage.common.Result;
import com.csfirst.marketmanage.entity.Customer;
import com.csfirst.marketmanage.entity.Employee;
import com.csfirst.marketmanage.service.CustomerService;
import com.csfirst.marketmanage.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/page")
    public Result<Page<Employee>> select(Long page, Long pageSize,String name) {
        Page<Employee> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Employee> lbw = new LambdaQueryWrapper<>();
        lbw.like(StringUtils.isNotEmpty(name),Employee::getEmpName,name);
        lbw.orderByDesc(Employee::getEmpId);
        employeeService.page(pageInfo, lbw);
        return Result.success(pageInfo);
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody Employee employee) {
        employeeService.save(employee);
        return Result.success("添加成功!~~");
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody Employee employee) {
        employeeService.updateById(employee);
        return Result.success("修改成功!~~");
    }

    @GetMapping("/{id}")
    public Result<Employee> getEmployeeById(@PathVariable Long id) {
        Employee EmployeeGotById = employeeService.getById(id);
        if (EmployeeGotById == null) {
            return Result.error("找不到这个员工哦~~");
        } else {
            return Result.success(EmployeeGotById);
        }
    }
    @DeleteMapping("/{id}")
    public Result<String> deleteEmployeeById(@PathVariable Long id){
        employeeService.removeById(id);
        return Result.success("删除成功!~~~");
    }
}
