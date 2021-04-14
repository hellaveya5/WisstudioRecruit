package com.wisstudio.recruit.service.Impl;

import com.wisstudio.recruit.dao.Impl.UserDaoImpl;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean login(String username, String password) {

        String sql = "select * from administrator where username = ? and password = ?";
        new UserDaoImpl().login(username,password);
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean modify(User user) {
        return false;
    }

    @Override
    public List<User> select(Object obj) {
        return null;
    }
}
