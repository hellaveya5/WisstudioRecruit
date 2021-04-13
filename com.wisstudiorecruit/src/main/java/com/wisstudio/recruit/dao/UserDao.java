package com.wisstudio.recruit.dao;

import com.wisstudio.recruit.po.User;

public interface UserDao {
    /**
     * 增加用户
     * @param user
     * @return
     */
    public int add(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int modify(User user);

}
