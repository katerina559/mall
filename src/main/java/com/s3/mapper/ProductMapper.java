package com.s3.mapper;

import com.s3.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *  商品信息数据访问层
 */
@Mapper
public interface ProductMapper {
    // 查询全部商品信息 并且分页
    /*int getCount(@Param("productName") String productName,
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
                                 @Param("pageSize") Integer pageSize);*/

    // 查询轮播图片
    List<Product> getImg();
    // 根据商品类型查询商品信息
    List<Product> getProductByCid(@Param("cid") Integer cid);
    // 根据商品名称和商品类型id查询商品信息
    List<Product> getListByName(@Param("productName") String productName,
                                @Param("cid") Integer cid);

}
