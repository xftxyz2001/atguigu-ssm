package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    private UserMapper userMapper;

    @Test
    public void testPage(){

        //IPage -> Page(页码,页容量)
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);

        //结果 page最后也会被封装结果
        long current = page.getCurrent(); //页码
        long size = page.getSize(); //页容量
        List<User> records = page.getRecords(); //当前页的数据
        long total = page.getTotal(); //总条数
    }


    @Test
    public void testMyPage(){
        Page<User> page = new Page<>(1,3);
        userMapper.queryByAge(page,1);

        long current = page.getCurrent(); //页码
        System.out.println("current = " + current);
        long size = page.getSize(); //页容量
        System.out.println("size = " + size);
        List<User> records = page.getRecords(); //当前页的数据
        System.out.println("records = " + records);
        long total = page.getTotal(); //总条数
        System.out.println("total = " + total);

    }


    @Test
    public void testDelete(){

        //全表删除 Error updating database.  Cause: com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Prohibition of table update operation
        userMapper.delete(null);

    }





}
