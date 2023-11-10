package com.atguigu.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName: com.atguigu.cookie
 *
 * @author: 赵伟风
 * description: 接收cookie
 */

@Controller
@RequestMapping("cookie")
@ResponseBody
public class CookieController {

    @RequestMapping("data")
    public String data(@CookieValue(value = "cookieName") String value){
        System.out.println("value = " + value);
        return value;
    }


    @GetMapping("save")
    public String save(HttpServletResponse response){
        Cookie cookie = new Cookie("cookieName","root");
        response.addCookie(cookie);
        return "ok";
    }

}
