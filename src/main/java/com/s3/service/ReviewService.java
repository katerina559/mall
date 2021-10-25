package com.s3.service;

import com.s3.pojo.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewService {

    // 根据商品id查询商品评论数
    Integer getReviewById(Integer pid);
    // 根据商品id查询商品的评论集合
    List<Review> getReview(Integer pid);

}
