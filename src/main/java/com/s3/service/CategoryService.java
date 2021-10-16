package com.s3.service;

import com.s3.pojo.Category;

import java.util.List;

/**
 *  商品类型业务逻辑层接口
 */
public interface CategoryService {
    List<Category> getList();
}
