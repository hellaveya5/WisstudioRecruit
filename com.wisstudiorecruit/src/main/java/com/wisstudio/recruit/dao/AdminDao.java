package com.wisstudio.recruit.dao;

import com.wisstudio.recruit.po.Administrator;
import com.wisstudio.recruit.po.User;

import java.util.List;
import java.util.Map;

public interface AdminDao  {
    /**
     * 管理员登录
     * @param name 管理员名字
     * @param password 管理员密码
     * @return 布尔值
     */
    Administrator login(String name , String password);
    /**
     * 删除用户
     * @param id 根据id
     * @return 修改的结果
     */
    boolean delete(Integer id);
    /**
     *
     * @param user 条件
     * @return
     */
    List<User> select (User user);
}
