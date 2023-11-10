package com.atguigu.controller;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> query(){
        userService.delete();
        return null;
    }
}
