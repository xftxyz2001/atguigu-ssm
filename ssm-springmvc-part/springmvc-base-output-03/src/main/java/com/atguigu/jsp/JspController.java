package com.atguigu.jsp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * projectName: com.atguigu.jsp
 *
 * @author: 赵伟风
 * description: 快速返回一个jsp页面
 */

@Controller
@RequestMapping("jsp")
public class JspController {

    /**
     * TODO：快速查找试图
     *    1. 方法的返回值是字符串类型
     *    2. 不能添加@ResponseBody,直接返回给字符串给浏览器，不找视图，不走试图解析器
     *    3. 返回值 对应中间的视图名称即可  /springmvc/jsp/index
     */
    @GetMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("data","hello jsp!!!");
        System.out.println("JspController.index");
        return "index";
    }


    /**
     * 转发：只能是项目下的资源
     *   1.方法的返回值写成字符串
     *   2.不能添加responseBody注解
     *   3.返回的字符串前 forward: /转发地址
     */

    //转发
    @GetMapping("forward")
    public String forward(){
        System.out.println("JspController.forward");
        return "forward:/jsp/index";
    }

    /**
     * 重定向：
     *   1.方法返回值写成字符串类型
     *   2.不能添加responseBody注解
     *   3.返回字符串前面 redirect: /重定向的地址
     */

    /**
     *
     *  路径细节：【不使用springmvc request response】
     *     转发是项目下的资源跳转。路径： 项目下的地址  /jsp/index 忽略 applicationContext
     *     重定向项目下的资源可以是项目外的地址  重定向属于二次请求  路径： 项目下的地址 全地址 /springmvc/jsp/index  不忽略 applicationContext
     *  使用springmvc路径语法：
     *     "forward: 路径 | redirect: 路径 "  重定向，资源的地址也不需要写项目的根路径！ /jsp/index
     *     转发和重定向的地址都一样了！  /springmvc/jsp/index - >  /springmvc/springmvc/jsp/index
     */

    //重定向
    @GetMapping("redirect")
    public String redirect(){
        System.out.println("JspController.redirect");
        return "redirect:/jsp/index";
    }


    @GetMapping("redirect/baidu")
    public String redirectBaidu(){
        System.out.println("JspController.redirectBaidu");
        return "redirect:http://www.baidu.com";
    }


}
