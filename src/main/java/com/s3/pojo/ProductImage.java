package com.s3.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *  商品图片类
 */
@Data
public class ProductImage implements Serializable {
    private Integer productimageId;         // 商品图片主键
    private Integer productimageType;       // 商品图片类型
    private String productImageSrc;         // 商品图片地址
    private Integer productimageProductId;  // 商品图片对应的商品id
}
