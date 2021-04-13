package com.wisstudio.recruit.service;

import com.wisstudio.recruit.po.User;

import java.util.ArrayList;

public interface UserService {
    /**
     * 注册用户
     * @param user  用户信息
     * @return  返回修改结果
     */
    public boolean regist(User user);

    /**
     * 登录用户
     * @param user 用户信息
     * @return  返回用户信息
     */
    public User login(User user);

    /**
     * @param user 用户信息修改
     * @return 返回修改结果
     */

    public boolean modify(User user);

    /**
     * 提交用户信息
     * @param user 用户信息
     * @return 成功与否
     */
    public boolean submit(User user);
}
