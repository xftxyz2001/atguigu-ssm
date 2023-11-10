package com.atguigu.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * projectName: com.atguigu.error
 *
 * @author: 赵伟风
 * description: 全局异常处理器
 */

//全局异常发生，会走此类写的handler!
//@ControllerAdvice  //可以返回逻辑视图 转发和重定向的！
@RestControllerAdvice //@ResponseBody直接返回json字符串
public class GlobalExceptionHandler {


    //发生异常 -》 ControllerAdvice 注解的类型  -》 @ExceptionHandler(指定的异常) -> handler
    //指定的异常 可以精准查找，或者查找父异常！

    @ExceptionHandler(ArithmeticException.class)
    public Object ArithmeticExceptionHandler(ArithmeticException e){
        //自定义处理异常即可 handler
        String message = e.getMessage();
        System.out.println("message = " + message);

        return message;
    }



    @ExceptionHandler(Exception.class)
    public Object ExceptionHandler(Exception e){
        //自定义处理异常即可 handler
        String message = e.getMessage();
        System.out.println("message = " + message);
        return  message;
    }
}
