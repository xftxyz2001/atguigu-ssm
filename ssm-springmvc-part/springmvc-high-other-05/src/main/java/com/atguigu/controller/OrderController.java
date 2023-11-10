package com.atguigu.controller;

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
@RequestMapping("order")
public class OrderController {

    @GetMapping("data")
    public String  data(){
        System.out.println("OrderController.data");
        return "ok";
    }

    @GetMapping("data1")
    public String  data1(){
        System.out.println("OrderController.data1");
        return "ok";
    }

}
