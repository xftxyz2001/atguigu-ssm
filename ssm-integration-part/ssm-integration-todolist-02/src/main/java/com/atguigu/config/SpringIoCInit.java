package com.atguigu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: spring的初始化类
 */
public class SpringIoCInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //rootioc容器的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceJavaConfig.class, MapperJavaConfigNew.class,ServiceJavaConfig.class};
    }

    //webioc容器的配置类指定
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }

    //dispatcherServlet的拦截路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
