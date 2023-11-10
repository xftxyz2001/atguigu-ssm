package com.atguigu.dao.impl;

import com.atguigu.dao.StudentDao;
import com.atguigu.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * projectName: com.atguigu.dao.impl
 *
 * @author: 赵伟风
 * description:
 */
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    //注入我们的jdbcTemplate对象
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 数据库查询全部学生数据
     *
     * @return
     */
    @Override
    public List<Student> queryAll() {

        //jdbcTemplate进行数据库的查询  ioc容器进行装配 不要自己去实例化
        String sql = "select id , name, gender ,age , class as classes from students ";

        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

        System.out.println("studentDao:"+students);

        return students;
    }
}
