package com.wisstudio.recruit.service.Impl;

import com.wisstudio.recruit.dao.Impl.AdminDaoImpl;
import com.wisstudio.recruit.dao.Impl.UserDaoImpl;
import com.wisstudio.recruit.po.Administrator;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean login(String username, String password) {

        return new AdminDaoImpl().login(username,password)!=null;

    }

    @Override
    public boolean delete(Integer id) {
        return new AdminServiceImpl().delete(id);

    }

    @Override
    public boolean modify(User user) {
        return new AdminServiceImpl().modify(user);
    }

    @Override
    public List<User> select(Object obj) {
        return new AdminServiceImpl().select(obj);
    }

    @Override
    public List<User> findAll() {
        return new AdminServiceImpl().findAll();
    }
}
