package com.max.maxmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.max.maxmall.entity.CategoryVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends BaseMapper<CategoryVO> {
    //1.连接查询
    public List<CategoryVO> selectAllCategories(); //2.子查询:根据parentId查询子分类
    public List<CategoryVO> selectAllCategories2(int parentId);
}
