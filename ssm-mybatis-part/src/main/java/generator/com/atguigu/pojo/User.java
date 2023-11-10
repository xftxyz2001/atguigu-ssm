package generator.com.atguigu.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName user
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}