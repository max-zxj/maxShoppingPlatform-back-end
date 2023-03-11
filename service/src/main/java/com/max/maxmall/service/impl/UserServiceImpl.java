package com.max.maxmall.service.impl;
import com.max.maxmall.dao.UserDao;
import com.max.maxmall.entity.User;
import com.max.maxmall.service.UserService;
import com.max.maxmall.utils.MD5Utils;
import com.max.maxmall.vo.ResStatus;
import com.max.maxmall.vo.ResultVO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
        return new ResultVO(ResStatus.OK,"password doesn't match",null);
    }



    @Override
    public ResultVO ckeckLogin(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        List<User> users = userDao.selectByMap(map);
        if(users == null || users.size() != 1){
            return new ResultVO(ResStatus.FAIL,"username doesn't exist or service broken down",null);
        }else{
            User user = users.get(0);
            String md5Password = MD5Utils.md5(password);
            if(user.getPassword().equals(md5Password)){
                String key = "MAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXzhang";
//                Base64.getEncoder().encode((key.getBytes()))
                JwtBuilder jwtBuilder = Jwts.builder();

                HashMap<String,Object> map1 = new HashMap<>();

                String token = jwtBuilder.setSubject(username)
                        .setId(user.getUserId()+"")
                        .setIssuedAt(new Date())
                        .setClaims(map1)
                        .setExpiration(new Date(System.currentTimeMillis()+24*60*60*1000))
                        .signWith(SignatureAlgorithm.HS256,key)
                        .compact();
                return new ResultVO(ResStatus.OK,token,user);
            }else{
                return new ResultVO(ResStatus.FAIL,"password doesn't match",null);
            }
        }
    }

    @Transactional
    public ResultVO userRegister(String username, String password) {
        synchronized (this){
            Map<String, Object> map = new HashMap<>();
            map.put("username",username);
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
                    return new ResultVO(ResStatus.OK, "register success", null);
                } else {
                    return new ResultVO(ResStatus.FAIL, "register fail", null);
                }
            } else {
                return new ResultVO(ResStatus.FAIL, "username has already existed", null);
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
            return new ResultVO(ResStatus.OK, "deletion success", null);
        } else {
            return new ResultVO(ResStatus.FAIL, "deletion fail", null);
        }
    }
}
