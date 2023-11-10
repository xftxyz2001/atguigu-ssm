package com.atguigu.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * projectName: com.atguigu.advice
 *
 * @author: 赵伟风
 * description: 增强类的内部要存储增强代码
 *
 *   1. 定义方法存储增强代码
 *      具体定义几个方法,根据插入的位置决定!
 *   2. 使用注解配置 指定插入目标方法的位置
 *       前置   @Before
 *       后置   @AfterReturning
 *       异常   @AfterThrowing
 *       最后   @After
 *       环绕   @Around
 *
 *       try{
 *           前置
 *           目标方法执行
 *           后置
 *       }catch(){
 *           异常
 *       }finally{
 *           最后
 *       }
 *
 *   3. 配置切点表达式 [选中插入的方法   切点]
 *
 *   4.补全注解
 *      加入ioc容器 @Component
 *      配置切面  @Aspect  =  切点 + 增强
 *
 *   spring aop 重点是 配置 -> jdk | cglib
 *
 *   5.开启aspect注解的支持
 *
 *
 */
@Component
@Aspect
@Order(20)
public class LogAdvice {

    /**
     * TODO: 切点表达式
     *    固定语法 execution(1 2 3.4.5(6))
     *    1. 访问修饰符
     *       public  / private
     *    2. 方法的返回参数类型
     *       String int void
     *    如果不考虑访问修饰符和返回值! 这两位整合成一起写 *
     *    如果要是不考虑,必须两个都不考虑! 不能出现  * String
     *    3. 包的位置
     *       具体包: com.atguigu.service.impl
     *       单层模糊: com.atguigu.service.*   * 单层模糊
     *       多层模糊: com..impl    ..任意层的模糊
     *       细节: ..不能开头
     *       找所有impl包:  com..impl  不能写..impl 写成: *..impl
     *    4. 类的名称
     *       具体: CalculatorPureImpl
     *       模糊: *
     *       不分模糊: *Impl
     *    5. 方法名 语法和类名一致
     *    6. (6)形参数列表
     *       没有参数: ()
     *       有具体参数: (String)  (String,int)
     *       模糊参数: (..) 有没有参数都可以,有多个也可以!
     *       不分模糊: (String..) String 后面有没有无所谓
     *                 (..int)  最后一个参数是int
     *                 (String..int)
     *
     *   TODO: 实战
     *     1.查询某包某类下，访问修饰符是公有，返回值是int的全部方法
     *       public int xx.xx.jj.*(..)
     *     2.查询某包下类中第一个参数是String的方法
     *       * xx.xx.jj.*(String..)
     *     3.查询全部包下，无参数的方法！
     *        * *..*.*()
     *     4.查询com包下，以int参数类型结尾的方法
     *        * com..*.*(..int)
     *     5.查询指定包下，Service开头类的私有返回值int的无参数方法
     *        private int xx.xx.Service*.*()
     *
     */


    /**
     * TODO: 切点表达式的提取和复用
     *    1. 当前类中提取
     *       定义一个空方法
     *       注解 @Pointcut()
     *       增强注解中引用切点表达式的方法即可  直接调用方法
     *    2. 创建一个存储切点的类
     *       单独维护切点表达式
     *       其他类的切点方法 类的全限定符号.方法名()
     */



    @Before("com.atguigu.pointcut.MyPointCut.pc()")
    public void start(){
        System.out.println("方法开始了");
    }

    @After("com.atguigu.pointcut.MyPointCut.pc()")
    public void after(){
        System.out.println("方法结束了");
    }

    @AfterThrowing("com.atguigu.pointcut.MyPointCut.pc()")
    public void error(){
        System.out.println("方法报错了");
    }
}
