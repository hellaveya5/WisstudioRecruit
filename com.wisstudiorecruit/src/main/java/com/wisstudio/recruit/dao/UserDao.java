package com.wisstudio.recruit.dao;

import com.wisstudio.recruit.po.User;

import java.util.List;

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
     * 删除用户
     * @param obj 根据不同的条件删除
     * @return 修改的结果
     */
    boolean delete(Object obj);

    /**
     *
     * @param obj 根据不同的条件选择
     * @return 返回符合条件的用户
     */
    List<User> select(Object obj);


}
