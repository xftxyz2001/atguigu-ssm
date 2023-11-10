package com.atguigu.service;

import com.atguigu.pojo.Student;

import java.util.List;

/**
 * projectName: com.atguigu.service
 *
 * @author: 赵伟风
 * description: 学员的业务接口
 */
public interface StudentService {

    List<Student> findAll();
}
