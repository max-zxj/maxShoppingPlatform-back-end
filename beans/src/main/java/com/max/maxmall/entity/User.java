package com.max.maxmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String username;
    private String password;
    private String nickname;
    private String realName;
    private String profielPhoto;
    private String phoneNumber;
    private String email;
    private String gender;
    private Date birthday;
    private Date registerDate;
    private Date userUpdate;
}
