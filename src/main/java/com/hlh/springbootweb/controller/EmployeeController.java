package com.hlh.springbootweb.controller;

import com.hlh.springbootweb.dao.EmployeeDao;
import com.hlh.springbootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public  String list(Model model) {
     Collection<Employee> employees = employeeDao.getAll();

     model.addAttribute("emps",employees);
        // thymeleaf默认会拼串
        return "emp/product-list";
    }
}
