package com.wisstudio.recruit.service.Impl;

import com.wisstudio.recruit.dao.UserDao;
import com.wisstudio.recruit.dao.Impl.UserDaoImpl;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    /**
     * 注册
     * @param user  用户信息
     * @return  返回结果
     */
    @Override
    public boolean regist(User user) {
        UserDao userDaoImpl = new UserDaoImpl();
        List<User> list = new ArrayList<>();
        list.add(userDaoImpl.findByUsernameAndPassword(user.getName(),user.getPassword()));
        //返回结果
        if(list.size()>0){
            return true;
        }
        return false;
       /*return false;*/
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
