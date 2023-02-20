package com.max.maxmall.dao;

import com.max.maxmall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public int inserUser(User user);
    public User queryUserByName(String username);
}
