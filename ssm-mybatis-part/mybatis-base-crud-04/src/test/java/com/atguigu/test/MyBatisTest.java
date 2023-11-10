package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */
public class MyBatisTest {

    private SqlSession sqlSession;

    @BeforeEach  //每次走测试方法之前 先走的初始化方法
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);//开启自动提交
    }



    @AfterEach //每次走测试方法之后调用的方法!
    public void clean(){
        sqlSession.close();
    }


    @Test
    public void testInsert() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setPassword("123456");
        user.setUsername("root");
        int insert = mapper.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    public void testUpdate(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setPassword("123456");
        user.setUsername("root");
        int insert = mapper.update(user);
        System.out.println("insert = " + insert);
    }

    @Test
    public void testDelete(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delete = mapper.delete(1);
        System.out.println("delete = " + delete);

    }

    @Test
    public void testSelectById(){

    }

    @Test
    public void testSelectAll(){

    }


}
