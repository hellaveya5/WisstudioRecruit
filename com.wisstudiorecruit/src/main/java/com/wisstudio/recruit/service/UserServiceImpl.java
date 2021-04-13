package com.wisstudio.recruit.service;

import com.wisstudio.recruit.dao.UserDao;
import com.wisstudio.recruit.dao.UserDaoImpl;
import com.wisstudio.recruit.po.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Override
    public boolean regist(User user) {
        UserDao userDaoImpl = new UserDaoImpl();
        List<User> list= userDaoImpl.select(user);
        for (User i :
                list) {

        }
        return false;
    }

    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean modify(Integer id) {
        return false;
    }
}
