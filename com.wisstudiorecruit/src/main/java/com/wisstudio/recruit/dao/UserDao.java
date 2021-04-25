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


    User findByUsername(String username);

    User findByStudentId(Long studentId);

    /**
     * 查询符合条件的总记录数
     * @return 总记录数
     * @param condition 条件
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页条件查询每页记录
     * @param start 开始查找的索引
     * @param rows  查找行数
     * @param condition 条件
     * @return  信息集
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
