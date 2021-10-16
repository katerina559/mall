package com.s3.mapper;

import com.s3.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  商品信息数据访问层
 */
@Mapper
public interface ProductMapper {
    // 查询全部商品信息 并且分页
    int getCount(@Param("productName") String productName,
                 @Param("categoryId") Integer categoryId,
                 @Param("productIsEnabled") Integer[] productIsEnabled,
                 @Param("hPrice") Float hPrice,
                 @Param("lPrice") Float lPrice);
    List<Product> getProductList(@Param("productName") String productName,
                                 @Param("categoryId") Integer categoryId,
                                 @Param("productIsEnabled") Integer[] productIsEnabled,
                                 @Param("hPrice") Float hPrice,
                                 @Param("lPrice") Float lPrice,
                                 @Param("from") Integer from,
                                 @Param("pageSize") Integer pageSize);
}
