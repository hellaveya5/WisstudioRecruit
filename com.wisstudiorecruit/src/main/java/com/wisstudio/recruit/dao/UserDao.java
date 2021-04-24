package com.wisstudio.recruit.dao;

import com.wisstudio.recruit.po.PageBean;
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
     *  根据用户名和密码找到用户
     * @param username 用户名
     * @param password 密码
     * @return  用户信息
     */

    User findByUsernameAndPassword(String username, String password);

    User login(String username,String password);


    User findByUsername(String username);

    User findByStudentId(Long studentId);

    /**
     * 查询总的记录数
     * @return 总的记录数
     */
    int findTotalCount();

    /**
     * 分页查询每页记录
     * @param start 开始查找的索引
     * @param rows  查找行数
     * @return  信息集
     */
    List<User> findByPage(int start, int rows);
}
