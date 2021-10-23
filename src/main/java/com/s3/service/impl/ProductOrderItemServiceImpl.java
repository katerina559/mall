package com.s3.service.impl;

import com.s3.mapper.ProductOrderItemMapper;
import com.s3.service.ProductOrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductOrderItemServiceImpl implements ProductOrderItemService {

    @Resource
    ProductOrderItemMapper productOrderItemMapper;

    @Override
    public Integer saleCount(Integer pid) {
        return productOrderItemMapper.saleCount(pid);
    }
}
