package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

/**
 * projectName: com.atguigu.mapper
 *
 * @author: 赵伟风
 * description: 规定数据库方法即可
 */
public interface EmployeeMapper {

    //根据id查询员工信息
    Employee queryById(Integer id);

    int deleteById(Integer id);

}
