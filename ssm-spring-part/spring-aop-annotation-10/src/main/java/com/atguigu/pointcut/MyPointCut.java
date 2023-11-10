package com.atguigu.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * projectName: com.atguigu
 *
 * @author: 赵伟风
 * description: 存储切点的类
 */
@Component
public class MyPointCut {

    @Pointcut("execution(* com.atguigu.service.impl.*.*(..))")
    public void pc(){}

    @Pointcut("execution(* com..impl.*.*(..))")
    public void myPc(){}

}
