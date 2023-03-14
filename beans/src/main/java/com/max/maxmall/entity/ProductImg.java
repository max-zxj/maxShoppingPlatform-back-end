package com.max.maxmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("product_img")
public class ProductImg implements Serializable {
    @TableId("img_id")
    private int imgId;
    private int itemId;
    private String imgUrl;
    private int imgSeq;
    private int isMain;
    private Date createTime;
    private Date updateTime;
}
