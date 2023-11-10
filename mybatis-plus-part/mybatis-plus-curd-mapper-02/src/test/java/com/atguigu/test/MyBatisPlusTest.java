package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_insert(){
        User user = new User();
        user.setAge(88);
        user.setName("呵呵呵");
        user.setEmail("xxxx");
        //baseMapper提供的数据库插入方法
        int row = userMapper.insert(user);
    }

    @Test
    public void test_delete(){

        //根据id删除
        int rows =  userMapper.deleteById(1687124343556005889L);
        System.out.println("rows = " + rows);
        //根据age = 20
        Map param = new HashMap();
        param.put("age",20); // age = 20  and name = xx
        int i = userMapper.deleteByMap(param);
        System.out.println("i = " + i);

        //wrapper 条件封装对象，无限的封装条件
        //userMapper.delete(wrapper);
    }


    @Test
    public void  test_update(){

        //TODO: update 当属性值为null的时候，不修改！

        //updatebyId 实体类id必须有值
        //user id = 1 age改为30
        User user = new User();
        user.setId(1L);
        user.setAge(30);
        // update user set age = 30 where id = 1
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);

        //将所有人的年龄改为22
        //update 实体类可以没有id值
        User user1 = new User();
        user1.setAge(22);
        int rows = userMapper.update(user,null); //null没条件
        System.out.println("rows = " + rows);
    }


    @Test
    public void test_select(){

        User user = userMapper.selectById(1);
        System.out.println("user = " + user);

        //ids集合查询
        List<Long> ids = new ArrayList<>();
        ids.add(1L); ids.add(2L);
        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println("users = " + users);
    }
}
