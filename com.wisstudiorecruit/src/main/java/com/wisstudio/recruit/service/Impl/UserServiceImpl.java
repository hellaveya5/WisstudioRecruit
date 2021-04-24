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
        if(user==null){
            return false;
        }
        UserDao userDaoImpl = new UserDaoImpl();
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
        return new UserDaoImpl().login(user.getName(),user.getPassword());
    }

    @Override
    public boolean modify(User user) {
        return new UserDaoImpl().add(user);
    }

    /**
     * 提交
     * @param user 用户信息
     * @return 返回结果
     */
    @Override
    public boolean submit(User user) {
        return new UserDaoImpl().add(user);
    }

    @Override
    public User findByUsernameAndPassword(String name, String password) {
        return new UserDaoImpl().findByUsernameAndPassword(name,password);
    }
}
