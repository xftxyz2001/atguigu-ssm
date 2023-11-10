package com.atguigu.pojo;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * projectName: com.atguigu.pojo
 *
 * @author: 赵伟风
 * description:
 *   1. name 不为null和空字符串
 *     字符串 @NotBlank 集合 @NotEmpty  包装 @NotNull
 *   2. password 长度大于6
 *
 *   3. age 必须 >= 1
 *   4. email 邮箱格式的字符串
 *   5. birthday过去时间
 *
 */
@Data
public class User {

    @NotBlank
    private String name;

    @Length(min = 6)
    private String password;

    @Min(1)
    private int age;

    @Email
    private String email;

    @Past
    private Date birthday;
}
