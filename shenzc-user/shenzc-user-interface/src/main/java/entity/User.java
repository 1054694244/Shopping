package entity;

import lombok.Data;

import javax.persistence.FieldResult;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author shenzc
 * @create 2019-09-05-8:51
 */
@Data
@Table(name = "user")
public class User {

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private Date created;

    private String salt;

}
