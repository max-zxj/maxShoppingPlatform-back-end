package com.max.maxmall.service.impl;

import com.max.maxmall.dao.UserDao;
import com.max.maxmall.entity.User;
import com.max.maxmall.service.UserService;
import com.max.maxmall.utils.MD5Utils;
import com.max.maxmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResultVO ckeckLogin(String username, String password) {
        User user = userDao.queryUserByName(username);
        if(user == null){
            return new ResultVO(1,"username doesn't exist",null);
        }else{
            String md5Password = MD5Utils.md5(password);
            if(user.getPassword().equals(md5Password)){
                return new ResultVO(0,"login success",user);
            }else{
                return new ResultVO(1,"password doesn't match",null);
            }
        }
    }

    @Transactional
    public ResultVO userRegister(String username, String password) {
        synchronized (this){
        User user = userDao.queryUserByName(username);
        if (user == null) {
            String MD5Password = MD5Utils.md5(password);
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRegisterDate(new Date());
            user.setUserUpdate(new Date());
            int i = userDao.inserUser(user);
            if (i > 0) {
                return new ResultVO(0, "register success", null);
            } else {
                return new ResultVO(1, "register fail", null);
            }
        } else {
            return new ResultVO(1, "username has already existed", null);
        }
    }
    }
}
