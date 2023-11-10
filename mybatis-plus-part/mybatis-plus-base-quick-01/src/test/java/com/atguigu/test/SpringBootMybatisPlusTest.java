package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description: springboot的测试类
 */
@SpringBootTest
public class SpringBootMybatisPlusTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test(){

        List<User> users = userMapper.selectList(null);

        System.out.println("users = " + users);
    }

}
