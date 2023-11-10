package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * projectName: com.atguigu.advice
 *
 * @author: 赵伟风
 * description: 定义四个增强方法,获取目标方法的信息 返回值 异常对象
 *
 * 1.定义方法 - 增强代码
 * 2.使用注解指定对应的位置
 * 3.配置切点表达式选中方法
 * 4.切面和ioc的配置
 * 5.开启aspectj注解的支持
 *
 * TODO: 增强方法中获取目标方法信息
 *     1. 全部增强方法中,获取目标方法的信息(方法名,参数,访问修饰符,所属的类的信息...)
 *         (JoinPoint jointPoint) import org.aspectj.lang.JoinPoint;
 *         joinPoint包含目标方法的信息!
 *     2. 返回的结果 - @AfterReturning
 *        (Object result) result接收返回结果
 *        @AfterReturning(value = "execution(* com..impl.*.*(..))",returning = "形参名即可")
 *     3. 异常的信息 - @AfterThrowing
 *        (Throwable t) t接收异常信息
 *        @AfterThrowing(value = "execution(* com..impl.*.*(..))",throwing = "形参名即可")
 */

//@Component
//@Aspect
public class MyAdvice {

    @Before("com.atguigu.pointcut.MyPointCut.myPc()")
    public void before(JoinPoint jointPoint){

        //1.获取方法属于的类的信息
        String simpleName = jointPoint.getTarget().getClass().getSimpleName();
        //2.获取方法名称
        int modifiers = jointPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
        String name = jointPoint.getSignature().getName(); //获取方法名
        //3.获取参数列表
        Object[] args = jointPoint.getArgs(); //获取目标方法参数

    }


    @AfterReturning(value = "com.atguigu.pointcut.MyPointCut.myPc()",returning = "result")
    public void afterReturning(JoinPoint jointPoint,Object result){

    }

    @After("com.atguigu.pointcut.MyPointCut.myPc()")
    public void after(JoinPoint jointPoint){

    }


    @AfterThrowing(value = "execution(* com..impl.*.*(..))",throwing = "throwable")
    public void afterThrowing(JoinPoint jointPoint,Throwable throwable){

    }

}
