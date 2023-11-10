package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.service.StudentService;
import com.atguigu.service.TopService;
import org.aspectj.lang.annotation.Around;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */

@SpringJUnitConfig(JavaConfig.class)
public class SpringTxTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;


    @Test
    public void test() throws FileNotFoundException {
        topService.topService();
    }
}
