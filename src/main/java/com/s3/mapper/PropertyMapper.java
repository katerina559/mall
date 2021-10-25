package com.s3.mapper;

import com.s3.pojo.Property;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PropertyMapper {

    // 根据商品类型主键查询属性信息
    List<Property> getPropertyByCid(@Param("cid") Integer cid);

}
