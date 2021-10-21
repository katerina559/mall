package com.s3.mapper;

import com.s3.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper {

    // 查询所有省份
    List<Address> getAddress();
    // 根据省份id获取城市或者根据城市id获取区域
    List<Address> getCity(@Param("regionId") Integer regionId);

}
