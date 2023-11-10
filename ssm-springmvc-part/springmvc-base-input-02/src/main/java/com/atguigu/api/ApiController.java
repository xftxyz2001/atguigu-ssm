package com.atguigu.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * projectName: com.atguigu.api
 *
 * @author: 赵伟风
 * description:
 */
@Controller
public class ApiController {

    @Autowired  // ioc容器获取对应类型实体对象（组件） 并自动装配
    private ServletContext servletContext;

    public void data(HttpServletResponse response,
                     HttpServletRequest request,
                     HttpSession session){

        //使用原生对象就可以
        //ServletContext  [1.最大的配置文件 2.全局最大共享域  3.核心api getRealPath]
        //方案1： request获取 session获取
        ServletContext servletContext = request.getServletContext();
        ServletContext servletContext1 = session.getServletContext();
        //方案2： ServletContext 会自动装入到ioc容器！ 程序启动servletContext - ioc容器
        //直接全局注入可以
    }
}
