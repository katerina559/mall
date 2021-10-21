package com.s3.service;

import com.s3.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    // 登录
    User login(String name,String pwd);
    // 注册
    int register(User user);

}
