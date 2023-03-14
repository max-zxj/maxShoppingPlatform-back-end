package com.max.maxmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("product")
public class ProductVO implements Serializable {
    @TableId("product_id")
    private int productId;
    private int categoryId;
    private int rootCategoryId;
    private int soldNumber;
    private int productStatus;
    private String content;
    private Date createTime;
    private Date updateTime;
    private String productName;

    private List<ProductImg> imgs;

}
