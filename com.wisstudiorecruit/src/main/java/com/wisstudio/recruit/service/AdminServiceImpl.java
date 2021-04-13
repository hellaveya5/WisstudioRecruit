package com.wisstudio.recruit.service;

import com.wisstudio.recruit.po.Administrator;
import com.wisstudio.recruit.po.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean login(String username, String password) {
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
