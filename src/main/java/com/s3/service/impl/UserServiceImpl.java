package com.s3.service.impl;

import com.s3.mapper.UserMapper;
import com.s3.pojo.User;
import com.s3.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User login(String name, String pwd) {
        return userMapper.login(name,pwd);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public User getUser(Integer uid) {
        return userMapper.getUser(uid);
    }

}
