package com.max.maxmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.max.maxmall.entity.IndexImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexImageDao extends BaseMapper<IndexImage> {
    public List<IndexImage> selectImage();
}
