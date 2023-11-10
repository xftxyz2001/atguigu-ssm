package com.atguigu.service;

import com.atguigu.pojo.Student;

import java.util.List;

/**
 * projectName: com.atguigu.service
 *
 * @author: 赵伟风
 * description: 学生业务接口
 */
public interface StudentService {


    /**
     * 查询所有学员数据业务
     * @return
     */
    List<Student> findAll();

}
