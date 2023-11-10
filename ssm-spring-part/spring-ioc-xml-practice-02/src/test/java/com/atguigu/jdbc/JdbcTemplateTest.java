package com.atguigu.jdbc;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.controller.StudentController;
import com.atguigu.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * projectName: com.atguigu.jdbc
 *
 * @author: 赵伟风
 * description: 测试javaTemplate如何使用
 */
public class JdbcTemplateTest {


    public void testForJava(){

        /**
         * JdbcTemplate 简化数据库的crud 不提供连接池
         *    |
         * DruidDataSource 负责连接的创建和数据库驱动的注册等等
         */

        //0.创建一个连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql:///studb"); //url地址
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //jdbc驱动
        dataSource.setUsername("root"); //账号
        dataSource.setPassword("root"); //密码

        //1.实例化对象即可
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);

        //2.调用方法即可
        // jdbcTemplate.update() DDL DML DCL ... 非查询语句
        // jdbcTemplate.queryForObject()  DQL 查询单个对象
        // jdbcTemplate.query() DQL 查询集合


    }

    /**
     * 通过ioc容器读取配置的JdbcTemplate组件
     */
    @Test
    public void testForIoC(){

        //1.创建ioc容器
        ApplicationContext applicationContext
                  = new ClassPathXmlApplicationContext("spring-01.xml");
        //2.获取jdbcTemplate组件

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        //3.进行数据库的curd动作
        //3.1 插入 删除 和 修改 DML update
        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?) ";
        /**
         * 参数1: String sql 可以带占位符 ?  ?只能替代值 不能替代关键字和容器名
         * 参数2: Object...param 传入占位符的值 顺序 从左开始对象
         * 返回值: int  影响函数
         */
        int rows = jdbcTemplate.update(sql,9,"二狗子","男",18,"三年二班");
        System.out.println("rows = " + rows);

        //3.2 查询单条数据
        //根据id查询学生数据 返回一个对应的实体对象
        sql = "select * from students where id = ? ;";
        /**
         * 参数1: sql语句 可以使用?
         * 参数2: RowMapper 列名和属性名的映射器接口
         * 参数3: Object...param 可以变参数 占位符的值
         * 返回值 rowMapper指定的对象
         */
        Student student1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            //rs 结果集
            //rowNum 行数
            //rs结果集中获取列的值 赋值给实体类对象即可
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setGender(rs.getString("gender"));
            student.setClasses(rs.getString("class"));
            return student;
        }, 1);
        System.out.println("student1 = " + student1);

        //3.3 查询所有学生数据
        sql = "select id , name ,gender , age , class as classes from students ;";

        //TODO: BeanPropertyRowMapper帮助我们自动映射列和属性值!要求列名和属性名一致!不一致 起别名!
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList = " + studentList);

    }


    /**
     * 从ioc容器中获取controller并且调用业务! 内部都是ioc容器进行组装
     */

    @Test
    public void testQueryAll(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-02.xml");
        //2.获取组件对象
        StudentController controller = applicationContext.getBean(StudentController.class);
        //3.使用组件对象
        controller.findAll();
        //4.关闭容器
        applicationContext.close();
    }


}
