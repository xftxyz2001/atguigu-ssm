package com.atguigu.service;

import com.atguigu.pojo.Type;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Jackiechan
* @description 针对表【news_type】的数据库操作Service
* @createDate 2023-08-04 15:31:10
*/
public interface TypeService extends IService<Type> {

    /**
     * 查询所有类别数据
     * @return
     */
    Result findAllTypes();
}
