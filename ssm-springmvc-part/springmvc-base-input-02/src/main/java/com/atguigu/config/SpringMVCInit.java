package com.atguigu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 初始化类
 */
public class SpringMVCInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * Specify {@code @Configuration} and/or {@code @Component} classes for the
     * {@linkplain #createRootApplicationContext() root application context}.
     *
     * @return the configuration for the root application context, or {@code null}
     * if creation and registration of a root context is not desired
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
       springmvc需要组件的配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    /**
     *
     * Servlet DispatcherServlet
     *
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/"};
    }
}
