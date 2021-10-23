package com.s3.service.impl;

import com.s3.mapper.ProductImageMapper;
import com.s3.pojo.ProductImage;
import com.s3.service.ProductImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Resource
    ProductImageMapper productImageMapper;

    @Override
    public List<ProductImage> getImgSrc(Integer pid) {
        return productImageMapper.getImgSrc(pid);
    }

    @Override
    public List<ProductImage> getHomePageImg(Integer pid) {
        return productImageMapper.getHomePageImg(pid);
    }
}
