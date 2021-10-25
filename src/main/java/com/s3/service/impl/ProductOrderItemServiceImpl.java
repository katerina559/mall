package com.s3.service.impl;

import com.s3.mapper.ProductOrderItemMapper;
import com.s3.pojo.ProductOrderItem;
import com.s3.service.ProductOrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductOrderItemServiceImpl implements ProductOrderItemService {

    @Resource
    ProductOrderItemMapper productOrderItemMapper;

    @Override
    public Integer saleCount(Integer pid) {
        return productOrderItemMapper.saleCount(pid);
    }

    @Override
    public int addBuyCar(ProductOrderItem productOrderItem) {
        return productOrderItemMapper.addBuyCar(productOrderItem);
    }

    @Override
    public int updateOrderNumber(Integer pid, Integer uid) {
        return productOrderItemMapper.updateOrderNumber(pid,uid);
    }

    @Override
    public List<ProductOrderItem> getBuyCarInUser(Integer uid) {
        return productOrderItemMapper.getBuyCarInUser(uid);
    }

    @Override
    public int removeOrder(Integer oid) {
        return productOrderItemMapper.removeOrder(oid);
    }
}
