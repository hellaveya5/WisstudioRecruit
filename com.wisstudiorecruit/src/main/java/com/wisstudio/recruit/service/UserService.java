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
     * @return  返回修改结果
     */
    public boolean login(User user);

    /**
     * @param id 用户id
     * @return 返回修改结果
     */

    public boolean modify(Integer id);
}
