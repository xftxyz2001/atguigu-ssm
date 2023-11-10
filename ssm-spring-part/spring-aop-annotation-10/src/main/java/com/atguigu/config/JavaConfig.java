package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 配置类
 */

@Configuration
@ComponentScan("com.atguigu")
@EnableAspectJAutoProxy //开启aspectj的注解 <aop:aspectj-autoproxy />
public class JavaConfig {
}
