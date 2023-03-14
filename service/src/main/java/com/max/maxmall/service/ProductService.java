package com.max.maxmall.service;

import com.max.maxmall.vo.ResultVO;
import org.springframework.stereotype.Service;

@Service("productService")
public interface ProductService {
    public ResultVO listRecommendProducts();
}
