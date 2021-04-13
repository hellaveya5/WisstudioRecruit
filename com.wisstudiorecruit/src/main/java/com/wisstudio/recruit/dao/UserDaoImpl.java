package com.wisstudio.recruit.dao;

import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.BeanUtils;
import com.wisstudio.recruit.util.BeanUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;

import java.util.List;

/**
 * 用户有增，删功能
 * @author 98333
 */
public class UserDaoImpl implements UserDao{
    private  JDBCUtils dbUtil = new JDBCUtils();
    private BeanUtils beanUtils;

    {
        try {
            beanUtils = new BeanUtilsimpl(dbUtil.getCon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(User user) {
        String sql = "insert into tab_user(id,name,gender,major,grade,contactNumber," +
                "choiceofdirection,skillMastered,selfIntroduce) value(?,?,?,?,?,?,?,?,?,)";
        int i=beanUtils.update(sql,"id,name,gender,major,grade," +
                "contactNumber,choiceofdirection,skillMastered,selfIntroduce");

        return i>0;
    }

    @Override
    public boolean modify(User user) {
        String sql = "update tab_uesr set id= ?,name= ?,gender= ?,major= ?,grade= ?,contactNumber= ?,choiceofdirection= ?,skillMastered= ?,selfIntroduce= ?";
        Integer i = beanUtils.update(sql,"id","name","gender","major","grade","ontactNumber","choiceofdirection","skillMastered","selfIntroduce");
        return i > 0;
    }

    /**
     *  普通用户没有权限
     * @param obj 根据不同的条件删除
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        return false;
    }

    /**
     * 普通用户没有权限
     * @param obj 根据不同的条件选择
     * @return
     */
    @Override
     public List<User> select(Object obj) {
        return null;
    }
}