package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 配置类
 */

@Configuration
@ComponentScan(basePackages = "com.atguigu.components")
public class JavaConfig {
}
