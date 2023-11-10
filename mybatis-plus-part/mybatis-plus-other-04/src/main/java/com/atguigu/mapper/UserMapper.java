package com.atguigu.mapper;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
 * projectName: com.atguigu.mapper
 *
 * @author: 赵伟风
 * description:
 *
 * mybatis: 1.mapper接口 curd方法  2. mapperxml curd sql语句
 * mybatis-plus: 1. mapper接口 extends BaseMapper  2. curd方法 curd的sql
 *
 */
public interface UserMapper extends BaseMapper<User> {

    //定义一个根据年龄参数查询，并且分页的方法 age > xx
    IPage<User> queryByAge(IPage<User> page, @Param("age") Integer age);

}
