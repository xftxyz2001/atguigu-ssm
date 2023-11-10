package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


@Transactional(timeout = 3)
@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;


    /**
     * 添加事务：
     *      @Transactional
     *      位置： 方法 | 类上
     *      方法： 当前方法有事务
     *      类上： 类下的所有方法都有事务
     *
     * 1.只读模式
     *   只读模式可以提升查询事务的效率！ 推荐事务中只有查询代码，使用只读模式！
     *   默认： boolean readOnly() default false;
     *   解释： 一般情况下，都是通过类添加注解添加事务！
     *         类下的所有方法都有事务！
     *         查询方法可以通过再次添加注解，设置为只读模式，提高效率!
     *
     * 2.超时时间
     *   默认： 永远不超时  -1
     *   设置 timeout = 时间 秒数  超过时间，就会回滚事务和释放异常！ TransactionTimedOutException
     *   如果类上设置事务属性，方法也设置了事务注解！ 方法会不会生效？？
     *   不会生效： 方法上的注解覆盖了类上的注解！
     *
     * 3.指定异常回滚和指定异常不回滚：
     *   默认情况下，指定发生运行时异常事务才会回滚！
     *   我们可以指定Exception异常来控制所有异常都回滚！
     *   rollbackFor = Exception.class
     *   noRollbackFor = 回滚异常范围内，控制某个异常不回滚！
     *
     * 4.隔离级别设置
     *   推荐设置第二个隔离级别！
     *   isolation = Isolation.READ_COMMITTED
     *
     */
    @Transactional(readOnly = false ,rollbackFor = Exception.class , noRollbackFor = FileNotFoundException.class
    ,isolation = Isolation.READ_COMMITTED)
    public void changeInfo() throws FileNotFoundException {
        studentDao.updateAgeById(99,1);
        new FileInputStream("xxxx");
        studentDao.updateNameById("test3",1);
    }




    /**
     * 声明两个独立修改数据库的事务业务方法
     *
     * propagation = Propagation.REQUIRED 父方法有事务，我们就加入到父方法的事务！
     *              最终是同一个事务！ 推荐使用默认值！！
     *
     * propagation = Propagation.REQUIRES_NEW
     *               不管父方法是否有事务，我都是独立的事务！
     *               两个事务或者三个事务！
     *
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeAge(){
        studentDao.updateAgeById(998,1);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeName(){
        studentDao.updateNameById("二狗子",1);
        int i = 1/0; //报错
    }



    @Transactional(readOnly = true)
    public void getStudentInfo(){
        //查询 没有必要添加事务！
        //获取学生信息 查询数据库 不修改
    }
}
