package com.s3.service;

import com.s3.pojo.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyService {

    // 根据商品类型主键查询属性信息
    List<Property> getPropertyByCid(Integer cid);

}
