package com.atguigu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * projectName: com.atguigu.pojo
 *
 * @author: 赵伟风
 *
 *   读取配置的方式1: @Value
 *       直接可以在属性上添加即可
 *       @Value(key必须写全了)
 *       @value只能读取单个值
 *   批量配置读取:
 *      @ConfigurationProperties(prefix = "zwf.user") 通用的前缀
 *      实体类
 *        属性名 = 最后一个key的值
 *      优势1: 方便 不用一个一个读取
 *      优势2: 可以给集合类型赋值
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "zwf.user")
public class User {

    //@Value("${zwf.user.username}") //di
    private String username; //等于key

    //@Value("${zwf.user.password}") //di
    private String password;

    //@Value("${zwf.user.gfs}") //di
    private List<String> gfs;
}
