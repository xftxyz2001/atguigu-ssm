package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */

@SpringBootTest
public class MyBatisPlusTableIdTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = new User();
        user.setName("驴蛋蛋");
        user.setAge(20);
        user.setEmail("xxxx@qq.com");
        //主键不要赋值
        //主键的策略： 雪花算法 -》 不重复的数字 long
        userMapper.insert(user);
    }
}
