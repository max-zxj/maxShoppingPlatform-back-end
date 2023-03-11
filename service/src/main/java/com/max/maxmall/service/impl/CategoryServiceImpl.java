package com.max.maxmall.service.impl;

import com.max.maxmall.dao.CategoryDao;
import com.max.maxmall.entity.CategoryVO;
import com.max.maxmall.service.CategoryService;
import com.max.maxmall.vo.ResStatus;
import com.max.maxmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryDao.selectAllCategories();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }
}
