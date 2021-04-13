package com.wisstudio.recruit.service;

import com.wisstudio.recruit.po.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    public boolean regist(User user);

    /**
     * 登录用户
     * @param user
     * @return
     */
    public boolean login(User user);

}
