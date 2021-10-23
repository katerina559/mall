package com.s3.service;

public interface ReviewService {

    // 根据商品id查询商品评论数
    Integer getReviewById(Integer pid);

}
