package com.hlh.springbootweb.dao;

import com.hlh.springbootweb.entities.Department;
import com.hlh.springbootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employess = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employess = new HashMap<Integer, Employee>();
        employess.put(1011, new Employee(1001, "E-AA", "aa@qq.com", 1, new Department(101, "D-AA"), "2020-10-12"));
        employess.put(1012, new Employee(1002, "E-BB", "bb@qq.com", 0, new Department(102, "D-BB"), "2020-10-12"));
        employess.put(1013, new Employee(1003, "E-CC", "cc@qq.com", 1, new Department(103, "D-CC"), "2020-10-12"));
        employess.put(1014, new Employee(1004, "E-DD", "dd@qq.com", 0, new Department(104, "D-DD"), "2020-10-12"));
        employess.put(1015, new Employee(1005, "E-EE", "ee@qq.com", 1, new Department(105, "D-EE"), "2020-10-12"));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employess.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employess.values();
    }

    public Employee get(Integer id) {
        return employess.get(id);
    }

    public void delete(Integer id) {
        employess.remove(id);
    }
}
