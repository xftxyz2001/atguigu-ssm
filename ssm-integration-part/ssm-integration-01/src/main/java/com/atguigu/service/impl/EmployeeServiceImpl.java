package com.atguigu.service.impl;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.atguigu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: com.atguigu.service.impl
 *
 * @author: 赵伟风
 * description:
 */
@Service
public class EmployeeServiceImpl  implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeMapper.queryList();
        return employees;
    }
}
