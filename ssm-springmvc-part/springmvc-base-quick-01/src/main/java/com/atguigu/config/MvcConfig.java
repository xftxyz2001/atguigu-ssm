package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description:
 *
 *   1. controller配置ioc容器
 *   2. handlerMapping  handlerAdapter加入到ioc容器
 *
 */

@Configuration
@ComponentScan("com.atguigu.controller")
public class MvcConfig {

    @Bean
    public RequestMappingHandlerMapping handlerMapping(){
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }

}
