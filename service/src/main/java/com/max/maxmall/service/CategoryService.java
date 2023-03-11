package com.max.maxmall.service;

import com.max.maxmall.vo.ResultVO;
import org.springframework.stereotype.Service;

@Service("categoryService")
public interface CategoryService {
    public ResultVO listCategories();
}
