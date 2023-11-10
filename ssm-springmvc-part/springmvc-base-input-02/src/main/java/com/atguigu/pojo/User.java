package com.atguigu.pojo;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * projectName: com.atguigu.pojo
 *
 * @author: 赵伟风
 * description:
 */

@Data
public class User {


    private String name;  //属性必须等于参数名
    private int age = 18;


}
