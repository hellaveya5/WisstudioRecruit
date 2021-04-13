package com.wisstudio.recruit.service;

import com.wisstudio.recruit.dao.UserDao;
import com.wisstudio.recruit.dao.UserDaoImpl;
import com.wisstudio.recruit.po.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    /**
     * 注册
     * @param user  用户信息
     * @return  返回结果
     */
    @Override
    public boolean regist(User user) {
        UserDao userDaoImpl = new UserDaoImpl();
        List<User> list= userDaoImpl.select(user);
        //返回结果
        if(list.size()>0){
            return false;
        }
        return userDaoImpl.add(user);
    }

    /**
     * 登录
     * @param user 前端用户参数
     * @return  返回登录信息
     */
    @Override
    public User login(User user) {
        UserDao userDaoImpl = new UserDaoImpl();
        user= userDaoImpl.login(user.getName(),user.getPassword());
        return user;
    }

    @Override
    public boolean modify(User user) {
        UserDao userDaoImpl = new UserDaoImpl();
        userDaoImpl.modify(user);
        return false;
    }

    /**
     * 提交
     * @param user 用户信息
     * @return 返回结果
     */
    @Override
    public boolean submit(User user) {
        UserDaoImpl userDaoImpl;
        userDaoImpl = new UserDaoImpl();
        return userDaoImpl.add(user);
    }
}
