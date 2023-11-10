package com.atguigu.ioc_05;

/**
 * projectName: com.atguigu.ioc_05
 *
 * @author: 赵伟风
 * description:
 */
public class JavaBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
