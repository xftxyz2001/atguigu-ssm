package com.atguigu.mapper;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Jackiechan
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-08-04 14:23:37
* @Entity com.atguigu.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {


    //方法

    //批量插入
    int insertBatch(@Param("userCollection") Collection<User> userCollection);

    //查询
    List<User> selectByNameAndAgeOrderById(@Param("name") String name, @Param("age") Integer age);

}




