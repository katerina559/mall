package com.s3.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  商品表
 */
@Data
public class Product implements Serializable {
    private Integer productId;      // 商品主键
    private String productName;     // 商品姓名
    private String productTitle;    // 商品标题
    private Float productPrice;     // 商品价格
    private Float productSalePrice; // 商品原价格
    private String productCreateDate;   // 商品上传时间
    private Integer productCategoryId;  // 商品类型外键
    private Integer productIsEnabled;   // 商品是否上架  0:销售中、1:停售中、2:促销中
    private Category productCategory;
    private List<ProductImage> singleProductImageList;  // 商品预览图地址
    private Integer productSaleCount;       // 商品的成交量
    private Integer productReviewCount;     // 商品的评论数
}
