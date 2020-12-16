package com.hlh.springbootweb.dao;

import com.hlh.springbootweb.entities.Department;
import com.hlh.springbootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDao {
    private static Map<Integer, Employee> employess = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
         employess=new HashMap<Integer, Employee>();

        employess.put(1011, new Employee(1001, "E-AA", "aa@qq.com", 1, new Department(101, "D-AA")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employess.put(employee.getId(),employee);
    }

}
