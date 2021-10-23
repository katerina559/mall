package com.s3.service;

import com.s3.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  商品类型业务逻辑层接口
 */
public interface CategoryService {
    List<Category> getList();
    // 根据商品外键查询类型信息
    Category getCategory(Integer pid);
}
