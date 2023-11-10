package com.atguigu.header;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName: com.atguigu.header
 *
 * @author: 赵伟风
 * description: 获取请求头
 */

@Controller
@RequestMapping("header")
@ResponseBody
public class HeaderController {

    @GetMapping("data")
    public String data(@RequestHeader("Host") String host){
        System.out.println("host = " + host);
        return "host = " + host;
    }
}
