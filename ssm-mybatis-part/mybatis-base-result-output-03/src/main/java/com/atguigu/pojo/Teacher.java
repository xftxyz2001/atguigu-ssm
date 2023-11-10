package com.atguigu.pojo;

/**
 * projectName: com.atguigu.pojo
 *
 * @author: 赵伟风
 * description:
 */
public class Teacher {

    private String tId;
    private String tName;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                '}';
    }
}
