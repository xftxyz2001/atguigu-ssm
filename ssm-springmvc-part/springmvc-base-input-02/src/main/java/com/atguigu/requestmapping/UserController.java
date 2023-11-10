package com.atguigu.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * projectName: com.atguigu.requestmapping
 *
 * @author: 赵伟风
 * description:
 */


//@Controller
//@RequestMapping("user")
public class UserController {

    //handler -> handlerMapping 指定访问地址

    /**
     * @WebServlet(" 必须使用 /开头")
     *
     * @RequestMapping(不要必须使用/开头)  user/login  /user/login
     *
     *  1. 精准地址 [一个 | 多个]  /user/login  {"地址1","地址2"}
     *  2. 支持模糊 * 任意一层字符串 | **  任意层任意字符串
     *           /user/* -> user/a  user/aaaaa 可以  /user/a/b 不行
     *           /user/** -> user user/a  user/a/a/a/a/a/a
     *  3. 类上和方法上添加@RequestMapping的区别
     *          类上提取通用的访问地址
     *          方法上是具体的handler地址
     *          访问: 类地址 + 方法地址即可
     *  4. 请求方式指定
     *      客户端 -> http (get | post | put | delete ) -> ds ->  handler
     *      默认情况:  @RequestMapping("login") 主要地址正确,任何请求方式都可以访问
     *      指定请求方式: method = {RequestMethod.GET,RequestMethod.POST}
     *      不符合请求方式: 会出现405异常!
     *  5.注解进阶   只能使用在方法上!
     *      get @GetMapping  == @RequestMapping(xxx,method=GET);
     *       post @PostMapping  == @RequestMapping(xxx,method=POST);
     *        put @PUTMapping  == @RequestMapping(xxx,method=PUT);
     *         delete @DeleteMapping  == @RequestMapping(xxx,method=DELETE);
     *
     */

    @RequestMapping  //  /user
    @GetMapping //get请求地址
    public String index(){

        return null;
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)  //作用注册地址 将handler注册到handlerMapping
    // ||
    @PostMapping("login")
    public String login(){

        return null;
    }

    @RequestMapping(value = "register", method = {RequestMethod.GET,RequestMethod.POST})
    public String register(){

        return null;
    }
}
