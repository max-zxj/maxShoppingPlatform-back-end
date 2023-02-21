package com.max.maxmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.max.maxmall.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserDao extends BaseMapper<User> {
    public Map<String,Object> selectMapById(int id);
}
