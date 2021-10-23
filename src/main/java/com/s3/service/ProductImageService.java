package com.s3.service;

import com.s3.pojo.ProductImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductImageService {
    // 根据商品id查询商品预览图地址
    List<ProductImage> getImgSrc(Integer pid);
    // 根据商品的ID查询每个商品的第一张预览(productimageType=0)图片
    List<ProductImage> getHomePageImg(Integer pid);
}
