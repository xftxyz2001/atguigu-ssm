package com.atguigu.config;

import com.atguigu.json.EncodingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 项目的配置类,controller handlerMapping handlerAdapater加入ioc容器
 */

@EnableWebMvc  //handlerAdapter配置了json转化器
               // 添加秘书 添加经理  给经理添加jacksonjson处理器
@Configuration
@ComponentScan("com.atguigu.json")
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new EncodingInterceptor());
    }


    //    @Bean
//    public RequestMappingHandlerMapping handlerMapping(){
//       return  new RequestMappingHandlerMapping();
//    }
//
//    @Bean
//    public RequestMappingHandlerAdapter handlerAdapter(){
//        return  new RequestMappingHandlerAdapter();
//    }
}
