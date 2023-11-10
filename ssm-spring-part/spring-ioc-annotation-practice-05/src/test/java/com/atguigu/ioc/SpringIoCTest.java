package com.atguigu.ioc;

import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * projectName: com.atguigu.ioc
 *
 * @author: 赵伟风
 * description:
 */
public class SpringIoCTest {

    @Test
    public void test(){

        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring.xml");

        StudentController controller = applicationContext.getBean(StudentController.class);


        controller.findAll();
    }
}
