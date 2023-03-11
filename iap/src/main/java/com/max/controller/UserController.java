package com.max.controller;

import com.max.maxmall.entity.User;
import com.max.maxmall.service.CategoryService;
import com.max.maxmall.service.IndexImageService;
import com.max.maxmall.service.UserService;
import com.max.maxmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        ResultVO resultVO = userService.ckeckLogin(username,password);
        return resultVO;
    }

    @PostMapping ("register")
    public ResultVO register(@RequestBody User user){
        ResultVO resultVO = userService.userRegister(user.getUsername(),user.getPassword());
        return resultVO;
    }
    @RequestMapping("/list")
    public ResultVO list(){
        return userService.list();
    }


}
