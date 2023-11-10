package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: java的配置类，替代xml配置文件
 *    1.包扫描注解配置 @ComponentScan({"com.atguigu.ioc_01","com.atguigu.ioc_02"})
 *    2.引用外部的配置文件
 *    3.声明第三方依赖的bean组件
 *
 * 步骤1： 添加 @Configuration 代表我们是配置类
 * 步骤2： 实现上面的三个功能注解
 *
 */

@ComponentScan({"com.atguigu.ioc_01","com.atguigu.ioc_02"})
@PropertySource("classpath:jdbc.properties")
@Configuration
public class JavaConfiguration {

    @Value("${atguigu.url}")
    private String url;
    @Value("${atguigu.driver}")
    private String driver;
    @Value("${atguigu.username}")
    private String username;
    @Value("${atguigu.password}")
    private String password;

    /**
     *
     * <bean -》 一个方法
     *
     * 方法的返回值类型 == bean组件的类型或者他的接口和父类
     * 方法的名字 = bean id
     *
     * 方法体可以自定义实现过程即可！
     * 最重要一步： @Bean 会真正让配置类的方法创建的组件存储到ioc容器！！
     *
     *
     * 问题1： beanName的问题
     *         默认： 方法名
     *         指定：  name / value属性起名字，覆盖方法名
     * 问题2： 周期方法如何指定
     *        原有注解方案： PostConstruct + PreDestroy 注解指定
     *        bean属性指定： initMethod  / destroyMethod指定
     * 问题3： 作用域
     *         和以前还是一样@Scope注解，默认是单例
     *
     * 问题4： 如何引用其他的ioc组件
     *         直接调用对方的bean方法即可
     *         直接形参变量进行引入，要求必须有对应的组件，如果有多个，形参名 = 组件id标识即可
     */


    //@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "ergouzi")
    public DruidDataSource dataSource1(){
        //实现具体的实例化过程
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "lvdandan")
    public DruidDataSource dataSource2(){
        //实现具体的实例化过程
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    //JdbcTemplate -> DataSource

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //需要DataSource 需要ioc容器的其他组件
        //方案1： 如果其他组件也是@Bean方法，可以直接调用 | 从ioc容器获取组件
        jdbcTemplate.setDataSource(dataSource1());
        return jdbcTemplate;
    }


    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource lvdandan,DataSource ergouzi){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //需要DataSource 需要ioc容器的其他组件
        //方案2： 形参列表声明想要的组件类型，可以是一个也可以是多个！  ioc容器也会注入
        //如果没有：形参变量注入。要求必须有对应的类型的组件，如果没有抛异常！
        //如果有多个：可以使用形参名称等同于对应的beanid标识即可
        jdbcTemplate.setDataSource(lvdandan);
        return jdbcTemplate;
    }

}
