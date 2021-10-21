package com.s3.service.impl;

import com.s3.mapper.AddressMapper;
import com.s3.pojo.Address;
import com.s3.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    AddressMapper addressMapper;

    @Override
    public List<Address> getAddress() {
        return addressMapper.getAddress();
    }

    @Override
    public List<Address> getCity(Integer regionId) {
        return addressMapper.getCity(regionId);
    }
}
