package com.atguigu.pojo;

/**
 * projectName: com.atguigu.pojo
 *
 * @author: 赵伟风
 * description:
 */
public class Student {

    private Integer sid;
    private String  sname;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }
}
