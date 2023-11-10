package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */
public class MybatisTest {

    private SqlSession sqlSession;

    @BeforeEach  //每次走测试方法之前 先走的初始化方法
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);//开启自动提交
    }


    //测试if where标签
    @Test
    public void test_01(){
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.query(null,101.0);
        System.out.println("list = " + list);
    }


    @AfterEach //每次走测试方法之后调用的方法!
    public void clean(){
        sqlSession.close();
    }
}
