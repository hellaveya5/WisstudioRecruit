package com.wisstudio.recruit.dao;

public interface AdminDao {
    /**
     * 管理员登录
     * @param name 管理员名字
     * @param password 管理员密码
     * @return 布尔值
     */
    Boolean login(String name ,String password);
}
