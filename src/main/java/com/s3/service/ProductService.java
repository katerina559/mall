package com.s3.service;

import com.s3.pojo.Product;
import com.s3.util.PageUtil;

/**
 *  商品信息业务逻辑层
 */
public interface ProductService {
    PageUtil<Product> get4Page(String productName,Integer categoryId,
                               Integer[] productIsEnabled,Float hPrice,
                               Float lPrice,Integer pageIndex,Integer pageSize);
}
