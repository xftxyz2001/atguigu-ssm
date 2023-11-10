package com.atguigu.test;


import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserService userService;

    @Test
    public void  test_save(){

        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(18);
        user.setEmail("jj");
        user.setName("驴蛋蛋");
        list.add(user);

        User user1 = new User();
        user1.setAge(18);
        user1.setEmail("jj");
        user1.setName("狗剩子");
        list.add(user1);

        boolean b = userService.saveBatch(list);
        System.out.println("b = " + b);

    }

    @Test
    public void  test_saveOrUpdate(){

        //如果有id有值 不为null,修改  为null插入
        User user = new User();
        user.setId(1L);
        user.setAge(18);
        user.setEmail("jj");
        user.setName("驴蛋蛋22");
        userService.saveOrUpdate(user);

    }
    @Test
    public void  test_remove(){

        boolean b = userService.removeById(1687120798123302914L);
        System.out.println("b = " + b);
    }
    @Test
    public void  test_update(){

        User user = new User();
        user.setId(1L);
        user.setAge(18);
        user.setEmail("jj");
        user.setName("驴蛋蛋22");
        userService.updateById(user);

    }

    @Test
    public void  test_getOrList(){

        User byId = userService.getById(1L);//get返回的是单个对象

        List<User> list = userService.list(null);//查询全部，返回的集合


    }
}
