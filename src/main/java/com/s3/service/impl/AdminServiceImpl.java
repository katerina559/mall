package com.s3.service.impl;

import com.s3.mapper.AdminMapper;
import com.s3.pojo.Admin;
import com.s3.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 管理员业务逻辑类实现类
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {
        return adminMapper.login(name,pwd);
    }
}
