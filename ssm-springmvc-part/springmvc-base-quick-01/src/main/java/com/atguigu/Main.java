package com.atguigu;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

public class Main  implements WebApplicationInitializer {
    /**
     * Configure the given {@link ServletContext} with any servlets, filters, listeners
     * context-params and attributes necessary for initializing this web application. See
     * examples {@linkplain WebApplicationInitializer above}.
     *
     * @param servletContext the {@code ServletContext} to initialize
     * @throws ServletException if any call against the given {@code ServletContext}
     *                          throws a {@code ServletException}
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //每当web项目启动,就会自动调用该接口的onStartup
        System.out.println("Main.onStartup");

        //ioc容器的初始化
        //dispatcherServlet

    }
}