package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.sql.DataSource;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 配置类
 */

@Configuration
@ComponentScan(basePackages = "com.atguigu")
@PropertySource(value = "classpath:jdbc.properties")
public class JavaConfig {



    @Bean
    public DataSource dataSource(@Value("${atguigu.driver}") String driver, @Value("${atguigu.url}")String url,
                                 @Value("${atguigu.username}")String username, @Value("${atguigu.password}")String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

}


