package com.atguigu.json;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName: com.atguigu.json
 *
 * @author: 赵伟风
 * description:
 */
//@Controller
@RequestMapping("json")
//@ResponseBody //返回json的注解。添加到类和方法上！

@RestController  // @Controller + @ResponseBody
public class JsonController {

    /**
     *
     * TODO: @ResponseBody 数据直接放入响应体返回！ 也不会在走视图解析器
     *       快速查找视图， 转发和重定向都不生效了！
     */

    @GetMapping("data")
    public User data(){
        // 对象 -》json -> {}
        // 集合 -》json -> []
        User user = new User();
        user.setName("two dogs!");
        user.setAge(3);
        return user; // user-> handlerAdapter -> json -》 @ResponseBody -> json直接返回 【前后端分离模式】
    }

    @GetMapping("data2")
    public List<User> data1(){
        User user = new User();
        user.setName("two dogs!");
        user.setAge(3);

        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

}
