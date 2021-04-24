package com.wisstudio.recruit.service.Impl;

import com.wisstudio.recruit.dao.UserDao;
import com.wisstudio.recruit.dao.Impl.UserDaoImpl;
import com.wisstudio.recruit.po.PageBean;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDaoImpl = new UserDaoImpl();
    /**
     * 注册
     * @param user  用户信息
     * @return  返回结果
     */

    @Override
    public boolean regist(User user) {
        if(user==null){
            return false;
        }
        List<User> list = new ArrayList<>();
        //有没有这个用户信息没有的话注册返回注册成功
        if(userDaoImpl.findByUsername(user.getName()) == null){
            userDaoImpl.add(user);
            return true;
        }
        //有的话返回注册失败
            return false;
    }

    /**
     * 登录
     * @param user 前端用户参数
     * @return  返回登录信息
     */
    @Override
    public User login(User user) {

        return userDaoImpl.login(user.getName(),user.getPassword());
    }

    @Override
    public boolean modify(User user) {
        return userDaoImpl.modify(user);
    }

    @Override
    public User findByStudentId(Long StudentId) {
        return userDaoImpl.findByStudentId(StudentId);
    }

    /**
     * 提交
     * @param user 用户信息
     * @return 返回结果
     */
    @Override
    public boolean submit(User user) {
        return userDaoImpl.add(user);
    }

    @Override
    public User findByUsernameAndPassword(String name, String password) {
        return userDaoImpl.findByUsernameAndPassword(name,password);
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //PageBean对象
        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //查询总记录数
        int totalCount = userDaoImpl.findTotalCount();
        pb.setTotalCount(totalCount);
        //查询页面开始的索引
        int start = (currentPage - 1) * rows;
        List<User> list = userDaoImpl.findByPage(start,rows);
        pb.setList(list);
        //总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : totalCount/rows +1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
