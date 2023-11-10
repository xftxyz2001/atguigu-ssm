package com.atguigu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 配置类
 */

@Import(value = {JavaConfigurationB.class})
@Configuration
public class JavaConfigurationA {
}
