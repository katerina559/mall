package com.s3.service;

import com.s3.pojo.Address;
import java.util.List;

public interface AddressService {

    // 查询所有省份
    List<Address> getAddress();
    // 根据省份id获取城市或者根据城市id获取区域
    List<Address> getCity(Integer regionId);
}
