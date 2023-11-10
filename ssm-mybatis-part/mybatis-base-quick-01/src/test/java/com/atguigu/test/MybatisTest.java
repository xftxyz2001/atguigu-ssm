package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.atguigu.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * projectName: com.atguigu.test
 *
 * @author: 赵伟风
 * description:
 */
public class MybatisTest {

    /**
     * mybatis提供的api进行方法的调用
     *    jdbcTemplate   new  JdbcTemplate -> 使用
     */
    @Test
    public void test_01() throws IOException {

        //1.读取外部配置文件（mybatis-config.xml）
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //3.根据sqlSessionFactory创建sqlSession (每次业务创建一个，用完就释放)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取接口的代理对象 （代理技术） 调用代理对象的方法，就会查找mapper接口的方法
        //jdk动态代理技术生成的mapper代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 内部拼接接口的全限定符号.方法名  去查找sql语句标签
        //1.拼接 类的全限定符.方法名  整合参数  -》 ibatis对应的方法传入参数
        // mybatis底层依然调用ibatis只不过有固定的模式！
        Employee employee = mapper.queryById(1);
        System.out.println("employee = " + employee);

        //5.提交事务（非DQL）和释放资源
        sqlSession.commit();
        sqlSession.close();

    }


    /**
     * 使用ibatis方式进行数据库调用
     * @throws IOException
     */
    @Test
    public void test_02() throws IOException {

        //1.读取外部配置文件（mybatis-config.xml）
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //3.根据sqlSessionFactory创建sqlSession (每次业务创建一个，用完就释放)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取接口的代理对象 （代理技术） 调用代理对象的方法，就会查找mapper接口的方法
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        Employee employee = mapper.queryById(1);
//        System.out.println("employee = " + employee);

        //4. sqlSession提供的curd方法进行数据库查询即可
        //  selectOne selectList  /  insert  / delete  / update  查找对应的sql语句标签，mybatis在执行！
        //  参数1： 字符串  sql标签对应的标识  id | namespace.id  参数2： Object  执行sql语句传入的参数
        Student student = sqlSession.selectOne("kkk", 1);
        //缺点： 1. sql语句标签对应的字符串标识，容易出现错误！  2. 参数需要进行整合只能传递一个！  3.返回值问题！
        System.out.println("student = " + student);

        //解决以上问题： 方法调用，你会不会出错？


        //5.提交事务（非DQL）和释放资源
        sqlSession.commit();
        sqlSession.close();

    }
}
