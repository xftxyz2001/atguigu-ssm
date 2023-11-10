package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */

@SpringBootTest
public class MyBatisPlusLambdaQueryWrapperTest
{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_01(){
        //查询用户名包含a like，年龄在20到30之间，并且邮箱不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //链式调用
        queryWrapper.like("name","a").between("age",20,30)
                .isNotNull("email");

        //lambda
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,"a")
                .between(User::getAge,20,30)
                .isNotNull(User::getEmail);

        //select * from user where name like '%a%' and age >= 20 and age <= 30 and email is not null
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
    }


    @Test
    public void test5(){
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE name LIKE ? AND age > ? OR email IS NULL)

        //QueryWrapper修改 【条件】
        //1.准备要修改的实体类数据
        //2.不能改为null

        //UpdateWrapper修改 【条件，修改】
        //1.直接携带修改数据 set("列名","值")
        //2.指定任意修改值 set("列明",null)

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("age",20)
                .like("name","a")  //条件直接调用方法默认使用and 拼接
                .or().isNull("email")  // or().第一个条件是or -> 拼接条件还是and
                .isNull("email")
                .set("email",null)
                .set("age",99);

        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.gt(User::getAge,20)
                .like(User::getName,"a")  //条件直接调用方法默认使用and 拼接
                .or().isNull(User::getEmail)  // or().第一个条件是or -> 拼接条件还是and
                .set(User::getEmail,null)
                .set(User::getAge,99);

        userMapper.update(null, lambdaUpdateWrapper);

    }
}
