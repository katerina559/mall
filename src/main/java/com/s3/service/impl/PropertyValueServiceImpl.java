package com.s3.service.impl;

import com.s3.mapper.PropertyValueMapper;
import com.s3.pojo.PropertyValue;
import com.s3.service.PropertyValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {

    @Resource
    PropertyValueMapper propertyValueMapper;

    @Override
    public List<PropertyValue> getValue(Integer pid) {
        return propertyValueMapper.getValue(pid);
    }
}
