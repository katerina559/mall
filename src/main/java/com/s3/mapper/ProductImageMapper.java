package com.s3.mapper;

import com.s3.pojo.ProductImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductImageMapper {

    // 根据商品id查询商品预览图地址(productimageType=0)
    List<ProductImage> getImgSrc(@Param("pid") Integer pid);
    // 根据商品的ID查询每个商品的第一张预览(productimageType=0)图片
    List<ProductImage> getHomePageImg(@Param("pid") Integer pid);
    // 查询商品的所有图片地址
    List<ProductImage> getDetailImgSrc(@Param("pid") Integer pid);

}
