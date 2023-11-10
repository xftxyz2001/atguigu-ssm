package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 控制层的配置类（controller,springmvc）
 *
 * 1.controller
 * 2.全局异常处理器
 * 3.handlerMapping handlerAdapter
 * 4.静态资源处理
 * 5.jsp 视图解析器前后缀
 * 6.json转化器
 * 7.拦截器...
 */

@EnableWebMvc
@Configuration
@ComponentScan({"com.atguigu.controller","com.atguigu.exceptionhandler"})
public class WebMvcJavaConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/","jsp");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor(new xx()).addPathPatterns().excludePathPatterns()
    }
}
