package com.s3.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductOrderItemMapper {

    // 根据商品主键查询商品成交量
    Integer saleCount(@Param("pid") Integer pid);

}
