package com.atguigu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//1.配置类 @SpringBootConfiguration
//2.自动加载配置 @EnableAutoConfiguration 自动加载其他的配置类
//3.@ComponentScan 默认是当前类所在的包,子包的注解
@SpringBootApplication  //启动类
public class Main {
    public static void main(String[] args) {
        // 1.创建ioc容器,加载配置  2.启动内置的web服务器
        SpringApplication.run(Main.class,args); //自动创建ioc容器,启动tomcat服务器软件
    }

    @Bean
    public Object object(){
        return new Object();
    }
}