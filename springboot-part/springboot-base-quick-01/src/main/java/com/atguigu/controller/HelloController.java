package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */

@RestController
@RequestMapping("hello")
public class HelloController {

    @Value("${zwf.name}")
    private String name;


    @GetMapping("boot")
    public String hello(){
        System.out.println(name);
        return "hello springboot3!!";
    }
}
