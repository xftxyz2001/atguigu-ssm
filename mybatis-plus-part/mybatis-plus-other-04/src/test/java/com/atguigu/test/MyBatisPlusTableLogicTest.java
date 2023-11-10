package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description: 测试逻辑删除
 */

@SpringBootTest
public class MyBatisPlusTableLogicTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        //delete from user where id = 1 物理删除
        //update user set deleted = 1 where id = 1
        userMapper.deleteById(1);

        //deleted = 0 1. 设置了一个逻辑删除字段 2.指定了注解和配置 3.mybatis-plus
        userMapper.selectList(null);
    }

}
