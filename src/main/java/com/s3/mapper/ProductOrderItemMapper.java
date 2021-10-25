package com.s3.mapper;

import com.s3.pojo.ProductOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductOrderItemMapper {

    // 根据商品主键查询商品成交量
    Integer saleCount(@Param("pid") Integer pid);
    // 加入购物车
    int addBuyCar(ProductOrderItem productOrderItem);
    // 修改商品数量
    int updateOrderNumber(@Param("pid") Integer pid,@Param("uid") Integer uid);
    // 查询登录用户的购物车集合
    List<ProductOrderItem> getBuyCarInUser(@Param("uid") Integer uid);
    // 根据订单id删除购物车订单
    int removeOrder(@Param("oid") Integer oid);

}
