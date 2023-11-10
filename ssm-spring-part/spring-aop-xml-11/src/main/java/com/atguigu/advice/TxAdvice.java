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
 * @Author: 赵伟风
 */
@Component
public class TxAdvice {


    public void begin(JoinPoint joinPoint){
        System.out.println("开启事务");
    }

    public void commit(Object result){
        System.out.println("事务提交");
    }

    public void rollback(JoinPoint joinPoint,Throwable t){
        System.out.println("事务回滚");
    }
}
