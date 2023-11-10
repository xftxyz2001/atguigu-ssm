package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;

import java.util.List;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */

@SpringBootTest
public class MyBatisPlusQueryWrapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_01(){
        //查询用户名包含a like，年龄在20到30之间，并且邮箱不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //条件 动态调用wrapper的方法完成拼接即可
        queryWrapper.like("name","a");
        queryWrapper.between("age",20,30);//orm
        queryWrapper.isNotNull("email");

        //链式调用
        queryWrapper.like("name","a").between("age",20,30)
                .isNotNull("email");

        //select * from user where name like '%a%' and age >= 20 and age <= 30 and email is not null
        List<User> users = userMapper.selectList(queryWrapper);
    }


    @Test
    public void test2(){
        ///按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                        .orderByAsc("id");
        // order by age desc , id asc;
        List<User> users = userMapper.selectList(queryWrapper);
    }


    @Test
    public void test3(){
        ////删除email为空的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        userMapper.delete(queryWrapper);
    }


    @Test
    public void test4(){
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE name LIKE ? AND age > ? OR email IS NULL)

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.gt("age",20)
                .like("name","a")  //条件直接调用方法默认使用and 拼接
                .or().isNull("email")  // or().第一个条件是or -> 拼接条件还是and
                .isNull("email");

        User user = new User();
        user.setAge(88);
        user.setEmail("heheheh");
        userMapper.update(user, userQueryWrapper);

    }


    @Test
    public void test5(){
        //查询用户信息的name和age字段
        //SELECT name,age FROM t_user where id > 1;
        //默认查询的是全部列

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id",1L);
        //默认是查询全部列
        queryWrapper.select("name","age"); //指定查询的列

        userMapper.selectList(queryWrapper);
    }


    @Test
    public void test6(){
        //前端传入了两个参数 name age
        //name不为空，作为条件 = 查询
        //age > 18 ，作为条件，查询等于 age =

        String name = "xx";
        Integer age = 19;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(name)){
            //动态条件判断
            queryWrapper.eq("name",name);
        }

        if (age != null && age > 18){
            queryWrapper.eq("age",age);
        }


        //每个方法都会有一个 boolean condition,允许我们第一位放一个比较表达式 true 整个条件生效 false 不生效
        // if test ="判断"
        //gt(boolean condition, R column, Object val)

        queryWrapper.eq(StringUtils.isNotBlank(name),"name",name);
        queryWrapper.eq(age != null && age > 18,"age",age);

        userMapper.selectList(queryWrapper);

    }

}











