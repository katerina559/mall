package com.s3.service.impl;

import com.s3.mapper.ReviewMapper;
import com.s3.service.ReviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Resource
    ReviewMapper reviewMapper;

    @Override
    public Integer getReviewById(Integer pid) {
        return reviewMapper.getReviewById(pid);
    }
}
