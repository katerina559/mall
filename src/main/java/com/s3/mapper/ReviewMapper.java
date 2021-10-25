package com.s3.mapper;

import com.s3.pojo.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {

    // 根据商品id查询商品评论数
    Integer getReviewById(@Param("pid") Integer pid);
    // 根据商品id查询商品的评论集合
    List<Review> getReview(@Param("pid") Integer pid);

}
