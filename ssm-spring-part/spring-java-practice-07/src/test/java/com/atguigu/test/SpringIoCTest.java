package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */
public class SpringIoCTest {

    @Test
    public void test(){

        ApplicationContext applicationContext
                 = new AnnotationConfigApplicationContext(JavaConfig.class);

        StudentController controller = applicationContext.getBean(StudentController.class);

        controller.findAll();

    }
}
