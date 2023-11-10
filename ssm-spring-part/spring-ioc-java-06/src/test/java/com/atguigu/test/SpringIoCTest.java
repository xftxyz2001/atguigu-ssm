package com.atguigu.test;

import com.atguigu.config.JavaConfiguration;
import com.atguigu.config.JavaConfigurationA;
import com.atguigu.config.JavaConfigurationB;
import com.atguigu.ioc_01.StudentController;
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
    public void  test(){

        //1.创建ioc容器
        ApplicationContext applicationContext
                 = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();
        applicationContext1.register(JavaConfiguration.class);
        applicationContext1.refresh(); //ioc di
        //2.获取bean

        StudentController bean = applicationContext.getBean(StudentController.class);

        System.out.println("bean = " + bean);

    }


    @Test
    public void test_04(){
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(JavaConfigurationA.class);
    }
}
