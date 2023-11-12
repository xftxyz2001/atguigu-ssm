package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName news_user
 */
@Data
public class User implements Serializable {

    @TableId
    private Integer uid;

    private String username;

    private String userPwd;

    private String nickName;

    @Version
    private Integer version;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}