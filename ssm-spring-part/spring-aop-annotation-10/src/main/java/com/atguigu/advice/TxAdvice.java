package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * projectName: com.atguigu.advice
 *
 * @author: 赵伟风
 * description: 使用普通方式进行事务的添加
 */
@Component
@Aspect
@Order(10) //指定一个优先级的值, 值越小 优先级越高! 越高的前置先执行,后置后执行
public class TxAdvice {


    @Before("com.atguigu.pointcut.MyPointCut.pc()")
    public void begin(JoinPoint joinPoint){
        System.out.println("开启事务");
    }


    @AfterReturning(value = "com.atguigu.pointcut.MyPointCut.pc()",returning = "result")
    public void commit(Object result){
        System.out.println("事务提交");
    }

    @AfterThrowing(value = "com.atguigu.pointcut.MyPointCut.pc()",throwing = "t")
    public void rollback(JoinPoint joinPoint,Throwable t){
        System.out.println("事务回滚");
    }
}
