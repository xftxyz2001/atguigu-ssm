package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * projectName: com.atguigu.mapper
 *
 * @author: 赵伟风
 * description: 定义方法信息
 */
public interface EmployeeMapper {

    //根据id查询员工对象
    Employee queryById(Integer id);

    //根据id删除员工信息
    int deleteById(Integer id);

    //根据工资查询员工信息
    List<Employee> queryBySalary(Double salary);

    //插入员工数据 【实体对象】

    int insertEmp(Employee employee);

    //根据员工姓名和工资查询员工信息
    List<Employee> queryByNameAndSalary(String name, Double salary);

    //插入员工数据，传入的是一个map(name=员工的名字,salary=员工的薪水)
    //mapper接口中不允许重载！！！ 方法名重复了  id名重复了！
    int insertEmpMap(Map data);

}
