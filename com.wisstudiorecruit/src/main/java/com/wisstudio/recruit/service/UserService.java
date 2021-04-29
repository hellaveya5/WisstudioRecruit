package com.wisstudio.recruit.service;

import com.wisstudio.recruit.vo.PageBean;
import com.wisstudio.recruit.po.User;

import java.util.Map;

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

    /**
     *
     * @param name
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String name, String password);

    /**
     *
     * @param StudentId
     * @return
     */
    User findByStudentId(Long StudentId);

    /**
     *
     * @param currentPage 当前页数
     * @param rows  行数
     * @param condition 条件
     * @return 分页查询结果
     */
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
