package com.atguigu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 可以被web项目加载,会初始化ioc容器,会设置dispatcherServlet的地址
 */
public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // service mapper层的ioc容器的配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }


    // 设置我们项目对应的配置 springmvc controller
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    // 配置springmvc内部自带servlet 的访问地址 !
    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/"};
    }
}
