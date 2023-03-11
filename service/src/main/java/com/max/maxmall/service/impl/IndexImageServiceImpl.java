package com.max.maxmall.service.impl;

import com.max.maxmall.dao.IndexImageDao;
import com.max.maxmall.entity.IndexImage;
import com.max.maxmall.service.IndexImageService;
import com.max.maxmall.vo.ResStatus;
import com.max.maxmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("indexImageService")
public class IndexImageServiceImpl implements IndexImageService {
    @Autowired
    private IndexImageDao indexImageDao;
    @Override
    public ResultVO getImage() {
        List<IndexImage> images = indexImageDao.selectImage();
        return new ResultVO(ResStatus.OK,"success",images);
    }
}
