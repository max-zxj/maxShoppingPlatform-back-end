package com.max.maxmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.max.maxmall.entity.ProductVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao extends BaseMapper<ProductVO> {
    public List<ProductVO> selectRecommendProducts();
}
