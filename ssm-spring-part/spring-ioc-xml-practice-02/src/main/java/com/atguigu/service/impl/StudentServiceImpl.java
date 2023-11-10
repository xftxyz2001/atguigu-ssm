package com.atguigu.service.impl;

import com.atguigu.dao.StudentDao;
import com.atguigu.pojo.Student;
import com.atguigu.service.StudentService;

import java.util.List;

/**
 * projectName: com.atguigu.service.impl
 *
 * @author: 赵伟风
 * description:
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * 查询所有学员数据业务
     *
     * @return
     */
    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("studentService:"+studentList);
        return studentList;
    }
}
