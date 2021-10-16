package com.s3.service;

import com.s3.pojo.Admin;

/**
 *  管理员业务逻辑类接口
 */
public interface AdminService {
    // 登录方法
    Admin login(String name, String pwd);
}
