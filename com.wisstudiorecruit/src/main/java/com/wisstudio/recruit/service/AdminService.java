package com.wisstudio.recruit.service;

import com.wisstudio.recruit.po.User;

import java.util.List;

public interface AdminService {
    /**
     * 登录管理员
     * @param username  用户名
     * @param password 密码
     * @return  用户信息
     */

    public boolean login(String username,String password);

    /**
     * 删除用户
     * @param id 删除用户
     * @return  结果
     */
    public boolean delete(Integer id);

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return 修改用户信息
     */
    public boolean modify(User user);

    /**
     * 根据条件查询用户
     * @param obj 条件学号/姓名/年级查找
     * @return 返回符合条件用户集合
     */
    public List<User> select(Object obj);

    /**
     * 列表查询用户
     * @return 所有表中的用户
     */
    public List<User> findAll();
}
