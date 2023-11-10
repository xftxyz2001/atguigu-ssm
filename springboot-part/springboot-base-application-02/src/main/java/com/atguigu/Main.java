package com.atguigu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //自己是一个配置类,自动加载其他启动器配置类(ioc),扫描当前启动类所在的包和子包的ioc和di注解
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}