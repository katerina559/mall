package com.s3.service.impl;

import com.s3.mapper.PropertyMapper;
import com.s3.pojo.Property;
import com.s3.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Resource
    PropertyMapper propertyMapper;

    @Override
    public List<Property> getPropertyByCid(Integer cid) {
        return propertyMapper.getPropertyByCid(cid);
    }
}
