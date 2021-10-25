package com.s3.mapper;

import com.s3.pojo.PropertyValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PropertyValueMapper {

    // 根据商品id获取商品的属性值
    List<PropertyValue> getValue(@Param("pid") Integer pid);

}
