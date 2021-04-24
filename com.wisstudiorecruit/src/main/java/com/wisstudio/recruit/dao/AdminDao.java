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
     * @param studentId 根据学号
     * @return 修改的结果
     */
    boolean delete(Long studentId);
    /**
     *查询所有用户返回用户集合
     * @param user 条件
     * @return  用户集合
     */
    List<User> select (User user);

    /**
     *查询所有用户返回用户集合
     * @return 用户集合
     */
    List<User> findAll();

    /**
     * 增加用户
     * @param user 用户
     * @return  成功与否
     */
    boolean addUser(User user);
}
