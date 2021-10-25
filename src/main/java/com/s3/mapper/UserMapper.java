package com.s3.mapper;

import com.s3.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    // 登录
    User login(@Param("name") String name,
               @Param("pwd") String pwd);
    // 注册
    int register(User user);
    // 根据用户id查询用户
    User getUser(@Param("uid") Integer uid);

}
