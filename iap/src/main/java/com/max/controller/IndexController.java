package com.max.controller;

import com.max.maxmall.service.CategoryService;
import com.max.maxmall.service.IndexImageService;
import com.max.maxmall.service.ProductService;
import com.max.maxmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
@CrossOrigin
@ResponseBody
public class IndexController {
    @Autowired
    private IndexImageService indexImageService;
    @Autowired
    private  CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/category-list")
    public ResultVO listCatetory(){
        return categoryService.listCategories();
    }
    @GetMapping("/list")
    public ResultVO listCart(){
        return indexImageService.getImage();
    }

    @GetMapping("/list-recommends")
    public ResultVO listRecommendProducts() {
        return productService.listRecommendProducts();
    }
}
