package com.max.controller;

import com.max.maxmall.vo.ResStatus;
import com.max.maxmall.vo.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@ResponseBody
public class ShopCartController {
    @GetMapping("/list")
    public ResultVO listCart(String token){
        return new ResultVO(ResStatus.OK,"success",null);
    }
}
