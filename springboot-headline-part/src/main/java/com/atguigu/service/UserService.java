package com.atguigu.service;

import com.atguigu.pojo.User;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Jackiechan
* @description 针对表【news_user】的数据库操作Service
* @createDate 2023-08-04 15:31:10
*/
public interface UserService extends IService<User> {

    /**
     * 登录业务
     * @param user
     * @return
     */
    Result login(User user);

    /**
     * 根据token获取用户数据
     * @param token
     * @return
     */
    Result getUserInfo(String token);

    /**
     * 检查账号是否可用
     * @param username 账号
     * @return
     */
    Result checkUserName(String username);

    /**
     * 注册业务
     * @param user
     * @return
     */
    Result regist(User user);
}
