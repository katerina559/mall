package com.s3.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *  商品订单详情类
 */
@Data
public class ProductOrderItem implements Serializable {
    private Integer productorderitemId;     // 商品订单详情主键
    private Integer productorderitemNumber; // 商品订单该商品数量
    private Float productorderitemPrice;    // 商品订单该商品总价
    private Integer productorderitemProductId;  // 对应商品表的主键
    private Integer productorderitemOrderId;    // 对应商品订单表的主键
    private Integer productorderitemUserId;     // 对应用户表的主键
    private String productorderitemUserMessage; // 该商品订单备注
    private Product productOrderItemProduct;        // 商品订单中的商品属性

}
