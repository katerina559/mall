package com.s3.mapper;

import com.s3.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *  管理员数据访问层接口
 */
@Mapper
public interface AdminMapper {
    // 登录方法
    Admin login(@Param("name") String name,
                @Param("pwd") String pwd);
}
