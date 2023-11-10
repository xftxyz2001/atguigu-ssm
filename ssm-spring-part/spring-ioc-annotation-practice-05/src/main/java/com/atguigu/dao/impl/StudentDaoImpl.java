package com.atguigu.dao.impl;

import com.atguigu.dao.StudentDao;
import com.atguigu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName: com.atguigu.dao.impl
 *
 * @author: 赵伟风
 * description: StudentDaoImpl - jdbcTemplate [xml]
 */
@Repository
public class StudentDaoImpl  implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> queryAll() {

        String sql = "select id , name , age , gender , class as classes from students ;";

        /*
          query可以返回集合!
          BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
         */
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

        return studentList;
    }
}
