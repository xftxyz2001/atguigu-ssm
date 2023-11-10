package com.atguigu.config;

import com.atguigu.interceptor.MyInterceptor;
import com.atguigu.interceptor.MyInterceptor1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: mvc组件的配置类
 */

@Configuration
@ComponentScan({"com.atguigu.controller","com.atguigu.error"})
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    //handlerMapping handlerAdapter json转化器
    //试图解析器，指定前后锥


    //开启静态资源查找
    // dispatcherServlet -> handlerMapping找有没有对应的handler -》【 没有 -》 找有没有静态资源 】
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置方案1： 拦截全部请求
        //registry.addInterceptor(new MyInterceptor());

        //配置方案2： 指定地址拦截 .addPathPatterns("/user/data");
        //   *  任意一层字符串   ** 任意多层字符串
//        registry.addInterceptor(new MyInterceptor())
//                .addPathPatterns("/user/**");

        //配置方案3：排除拦截 排除的地址应该在拦截地址内部！
//        registry.addInterceptor(new MyInterceptor())
//                .addPathPatterns("/user/**").excludePathPatterns("/user/data1");

        registry.addInterceptor(new MyInterceptor());
        registry.addInterceptor(new MyInterceptor1());

    }
}
