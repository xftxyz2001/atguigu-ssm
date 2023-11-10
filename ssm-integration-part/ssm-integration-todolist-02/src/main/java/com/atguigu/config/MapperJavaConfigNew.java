package com.atguigu.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 持久层配置类： 连接池，sqlSessionFactory, Mapper代理对象
 *
 * 方式2: 不保留外部配置文件，全部mybatis的属性都在代码中设置！
 */

@Configuration
public class MapperJavaConfigNew {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        //指定配置文件等信息
        //指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);
        //指定mybatis配置文件的功能，使用代码的形式

        org.apache.ibatis.session.Configuration configuration
                = new org.apache.ibatis.session.Configuration();
        // <setting name="mapUnderscoreToCamelCase" value="true"/>
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);

        //org.apache.ibatis.session.Configuration // 存储setting的配置文件
        sqlSessionFactoryBean.setConfiguration(configuration);

        //别名设置
        sqlSessionFactoryBean.setTypeAliasesPackage("com.atguigu.pojo");

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.addPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }

    //mapper代理对象加入到ioc
    @Bean
    public MapperScannerConfigurer  mapperScannerConfigurer(){
        // Mapper代理兑现的factoryBean -> 指定一个包 -> mapper接口 -》sqlSessionFactory -> sqlSession -> getMapper -> mapper代理对象 -》 ioc
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.atguigu.mapper"); //mapper接口和mapperxml所在的共同包
        return  mapperScannerConfigurer;
    }



}
