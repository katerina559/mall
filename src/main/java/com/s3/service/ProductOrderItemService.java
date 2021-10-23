package com.s3.service;

import org.apache.ibatis.annotations.Param;

public interface ProductOrderItemService {

    // 根据商品主键查询商品成交量
    Integer saleCount(Integer pid);
    
}
