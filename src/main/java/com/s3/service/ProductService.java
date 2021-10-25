package com.s3.service;

import com.s3.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *  商品信息业务逻辑层
 */
public interface ProductService {
    /*PageUtil<Product> get4Page(String productName,Integer categoryId,
                               Integer[] productIsEnabled,Float hPrice,
                               Float lPrice,Integer pageIndex,Integer pageSize);*/

    // 查询轮播图片
    List<Product> getImg();
    // 根据商品类型查询商品信息
    List<Product> getProductByCid(Integer cid);
    // 根据商品名称查询商品信息
    List<Product> getListByName(String productName,Integer cid);
    // 根据商品id获取商品信息
    Product getDetailById(Integer pid);

}
