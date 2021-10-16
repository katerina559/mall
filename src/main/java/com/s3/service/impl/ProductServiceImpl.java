package com.s3.service.impl;

import com.s3.mapper.ProductMapper;
import com.s3.pojo.Product;
import com.s3.service.ProductService;
import com.s3.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *  商品信息业务逻辑层实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public PageUtil<Product> get4Page(String productName, Integer categoryId, Integer[] productIsEnabled, Float hPrice, Float lPrice, Integer pageIndex, Integer pageSize) {
        PageUtil<Product> page = new PageUtil<>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(productMapper.getCount(productName,categoryId,productIsEnabled,hPrice,lPrice));
        page.setList(productMapper.getProductList(productName,categoryId,productIsEnabled,hPrice,lPrice,(pageIndex-1)*pageSize,pageSize));
        return page;
    }

}
