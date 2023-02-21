package com.max.maxmall.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user")
public class User implements Serializable {
    @TableId("user_id")
    private int userId;
    @TableField("username")
    private String username;
    private String password;
    private String nickname;
    private String realname;
    private String profilphoto;
    private String phonenumber;
    private String email;
    private String gender;
    private Date birthday;
    private Date registerdate;
    private Date userUpdate;
}
