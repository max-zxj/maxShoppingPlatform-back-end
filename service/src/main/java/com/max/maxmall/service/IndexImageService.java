package com.max.maxmall.service;

import com.max.maxmall.vo.ResultVO;
import org.springframework.stereotype.Service;

@Service("indexImageService")
public interface IndexImageService {
    public ResultVO getImage();
}
