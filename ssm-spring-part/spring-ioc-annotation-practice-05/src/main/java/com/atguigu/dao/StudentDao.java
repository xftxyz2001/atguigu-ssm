package com.atguigu.dao;

import com.atguigu.pojo.Student;

import java.util.List;

/**
 * projectName: com.atgguigu.dao
 *
 * @author: 赵伟风
 * description: 学员持久层访问接口
 */
public interface StudentDao {

    List<Student> queryAll();
}
