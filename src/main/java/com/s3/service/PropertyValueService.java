package com.s3.service;

import com.s3.pojo.PropertyValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyValueService {
    // 根据商品id获取商品的属性值
    List<PropertyValue> getValue(Integer pid);
}
