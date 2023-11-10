package com.atguigu.ioc_03;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * projectName: com.atguigu.ioc_03
 *
 * @author: 赵伟风
 * description:
 */
@Service
public class UserServiceImpl  implements UserService{


    @Override
    public String show() {
        return "UserServiceImpl show();";
    }
}
