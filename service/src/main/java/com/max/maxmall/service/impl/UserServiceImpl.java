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
import java.util.*;

@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResultVO list() {
        List<User> list = userDao.selectList(null);
        list.forEach(System.out::println);
        return new ResultVO(1,"password doesn't match",null);
    }



    @Override
    public ResultVO ckeckLogin(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        List<User> users = userDao.selectByMap(map);
        if(users == null || users.size() != 1){
            return new ResultVO(1,"username doesn't exist or service broken down",null);
        }else{
            User user = users.get(0);
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
            Map<String, Object> map = new HashMap<>();
            map.put("username",username);
            Map<String,Object> map1 = userDao.selectMapById(3);
            System.out.println(map1);
            List<User> users = userDao.selectByMap(map);
            if (users == null || users.size() == 0) {
                String MD5Password = MD5Utils.md5(password);
                User user = new User();
                user.setUsername(username);
                user.setPassword(MD5Password);
                user.setRegisterdate(new Date());
                user.setUserUpdate(new Date());
                int i = userDao.insert(user);
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

    @Override
    public ResultVO deleteById(int id) {

        Map<String, Object> map = new HashMap<>();
        map.put("username","zxj");
        userDao.deleteByMap(map);
        int i = userDao.deleteById(id);
        if (i > 0) {
            return new ResultVO(0, "deletion success", null);
        } else {
            return new ResultVO(1, "deletion fail", null);
        }
    }
}
