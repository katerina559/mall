package com.s3.mapper;

import com.s3.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  商品类型数据访问层
 */
@Mapper
public interface CategoryMapper {
    List<Category> getList();
}
