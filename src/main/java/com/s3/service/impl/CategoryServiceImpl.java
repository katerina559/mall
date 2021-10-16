package com.s3.service.impl;

import com.s3.mapper.CategoryMapper;
import com.s3.pojo.Category;
import com.s3.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  商品类型业务逻辑层实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getList() {
        return categoryMapper.getList();
    }

}
