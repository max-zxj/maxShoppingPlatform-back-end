package com.max.maxmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("index_image")
public class IndexImage implements Serializable {
    @TableId("img_id")
    private int imgId;
    private String imgUrl;
    private String imgBgColor;
    private int prodId;
    private int categoryId;
    private int indexType;
    private int seq;
    private int status;
    private Date createTime;
    private Date updateTime;
}
