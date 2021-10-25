package com.s3.service;

import com.s3.pojo.ProductOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductOrderItemService {

    // 根据商品主键查询商品成交量
    Integer saleCount(Integer pid);
    // 加入购物车
    int addBuyCar(ProductOrderItem productOrderItem);
    // 修改商品数量
    int updateOrderNumber(Integer pid,Integer uid);
    // 查询登录用户的购物车集合
    List<ProductOrderItem> getBuyCarInUser(Integer uid);
    
}
