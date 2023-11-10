package com.atguigu.mapper;

import com.atguigu.pojo.Teacher;

/**
 * projectName: com.atguigu.mapper
 *
 * @author: 赵伟风
 * description:
 */
public interface TeacherMapper {

    int insertTeacher(Teacher teacher);

    Teacher queryById(String tId);
}
