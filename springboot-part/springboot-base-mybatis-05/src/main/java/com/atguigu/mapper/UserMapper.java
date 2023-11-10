package com.atguigu.mapper;

import com.atguigu.pojo.User;

import java.util.List;

/**
 * projectName: com.atguigu.mapper
 *
 * @author: 赵伟风
 * description:
 */
public interface UserMapper {

    List<User> queryAll();

    int delete(int i);
}
