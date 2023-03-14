package com.max.maxmall.service.impl;

import com.max.maxmall.dao.ProductDao;
import com.max.maxmall.dao.ProductImgDao;
import com.max.maxmall.entity.ProductVO;
import com.max.maxmall.service.ProductService;
import com.max.maxmall.vo.ResStatus;
import com.max.maxmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productDao.selectRecommendProducts();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", productVOS);
        return resultVO;
    }
}
