package com.max.controller;

import com.max.maxmall.service.UserService;
import com.max.maxmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@ResponseBody
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/delete/{id}")
    public ResultVO delete(@PathVariable("id") int id){
        return userService.deleteById(id);
    }
    @GetMapping(value="/login")
    public ResultVO login(String username,String password){
        return userService.ckeckLogin(username,password);
    }

    @RequestMapping("register")
    public ResultVO register(String username,String password){
        return userService.userRegister(username,password);
    }
    @RequestMapping("/list")
    public ResultVO list(){
        return userService.list();
    }


}
