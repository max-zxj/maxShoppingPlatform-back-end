package com.max.maxmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("category")
public class CategoryVO {
    @TableId("category_id")
    private int categoryId;
    private String categoryName;
    private int categoryLevel;
    private int parentId;
    private String categoryIcon;
    private String categorySlogan;
    private String categoryPic;
    private String categoryBgColor;
    private List<CategoryVO> categories;
}
