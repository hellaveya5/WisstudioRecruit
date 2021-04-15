package com.wisstudio.recruit.dao;

import com.wisstudio.recruit.po.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * @param user 新增用户
     * @return 修改的结果
     */
     boolean add(User user);

    /**
     * @param user 修改用户
     * @return 修改的结果
     */
     boolean modify(User user);

    /**
     *  根据用户名和密码找到用户
     * @param username 用户名
     * @param password 密码
     * @return  用户信息
     */

    User findByUsernameAndPassword(String username, String password);

    User login(String username,String password);

}
