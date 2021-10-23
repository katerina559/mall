package com.s3.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {

    // 根据商品id查询商品评论数
    Integer getReviewById(@Param("pid") Integer pid);

}
