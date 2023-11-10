package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */

@Controller
@ResponseBody
public class HelloController {

    @GetMapping("hello")
    public String ret(){
        return "hello";
    }
}
