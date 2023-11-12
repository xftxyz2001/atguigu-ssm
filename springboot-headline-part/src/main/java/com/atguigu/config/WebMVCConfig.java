package com.atguigu.config;

import com.atguigu.interceptors.LoginProtectedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description:
 */
@Configuration
public class WebMVCConfig  implements WebMvcConfigurer {

    @Autowired
    private LoginProtectedInterceptor loginProtectedInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginProtectedInterceptor).addPathPatterns("/headline/**");
    }
}
