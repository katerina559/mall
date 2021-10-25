package com.s3.mapper;

import com.s3.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  商品类型数据访问层
 */
@Mapper
public interface CategoryMapper {

    // 获取全部商品类型信息
    List<Category> getList();
    // 根据商品外键查询类型信息
    Category getCategory(@Param("pid") Integer pid);
    // 获取前五条商品类型信息
    List<Category> get5Category();

}
