package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import com.atguigu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: com.atguigu.service
 *
 * @author: 赵伟风
 * description:
 */
@Service
public class StudentServiceImpl  implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        return studentList;
    }
}
