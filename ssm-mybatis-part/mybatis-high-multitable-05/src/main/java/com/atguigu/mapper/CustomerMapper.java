package com.atguigu.mapper;

import com.atguigu.pojo.Customer;

import java.util.List;

/**
 * projectName: com.atguigu.mapper
 *
 * @author: 赵伟风
 * description: 客户的方法
 */
public interface CustomerMapper {

    //查询所有客户信息以及客户对应的订单信息
    List<Customer> queryList();
}
