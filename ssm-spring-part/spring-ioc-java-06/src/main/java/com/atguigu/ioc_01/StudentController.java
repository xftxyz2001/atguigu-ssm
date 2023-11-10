package com.atguigu.ioc_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * projectName: com.atguigu.ioc_01
 *
 * @author: 赵伟风
 * description:
 */

@Controller
public class StudentController {

    @Autowired
    //@Resource
    private StudentService studentService;
}
