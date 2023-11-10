package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.service.Calculator;
import com.atguigu.service.impl.CalculatorPureImpl;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {


    // aop - 代理 - jdk - 接口 - 代理类  - 代理对象和目标对象 拜把子 兄弟关系 - 接口接值
    // aop - ioc - 代理对象
    @Autowired
    private CalculatorPureImpl calculator;


    @Test
    public void test(){
        int add = calculator.div(1, 1);
        System.out.println("add = " + add);
    }

}
