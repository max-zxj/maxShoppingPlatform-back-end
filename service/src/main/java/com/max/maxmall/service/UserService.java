package com.max.maxmall.service;

import com.max.maxmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public interface UserService {
    public ResultVO list();
    public ResultVO ckeckLogin(String username, String password);
    public ResultVO userRegister(String username, String password);

    public ResultVO deleteById(int id);

}
