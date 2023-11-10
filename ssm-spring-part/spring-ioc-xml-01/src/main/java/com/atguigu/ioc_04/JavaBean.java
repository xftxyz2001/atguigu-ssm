package com.atguigu.ioc_04;

/**
 * projectName: com.atguigu.ioc_04
 *
 * @author: 赵伟风
 * description:
 */
public class JavaBean {


    /**
     * 必须是public 必须是 void 返回值 必须是无参数的!
     * 命名随意!
     * 初始化方法 -> 初始化业务逻辑即可!!
     */
    public void init(){
        System.out.println("JavaBean.init");
    }


    /**
     * 销毁方法
     */
    public void clear(){
        System.out.println("JavaBean.clear");
    }
}
