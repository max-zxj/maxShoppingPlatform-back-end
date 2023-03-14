package com.max.maxmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.max.maxmall.entity.ProductImg;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductImgDao extends BaseMapper<ProductImg> {
    public List<ProductImg> selectProductImgByProductId(int productId);
}
