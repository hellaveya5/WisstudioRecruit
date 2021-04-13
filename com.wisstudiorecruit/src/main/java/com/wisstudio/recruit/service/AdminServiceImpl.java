package com.wisstudio.recruit.service;

import com.wisstudio.recruit.po.User;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdminServiceImpl implements UserService {
    /**
     * 注册
     * @param user  用户信息
     * @return
     */
    @Override
    public boolean regist(User user) {

        return false;
    }

    @Override
    public boolean login(User user) {
        return false;
    }

    /**
     * 删除所有选中的用户
     * @return 是否删除成功
     */
    public boolean deleteAllSelect(ArrayList<Integer> ids){

        return false;
    }

    @Override
    public boolean modify(Integer id) {
        return false;
    }
}
