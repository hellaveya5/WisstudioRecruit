package com.wisstudio.recruit.dao;

import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.BeanUtils;
import com.wisstudio.recruit.util.BeanUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;

import java.util.List;

/**
 * 管理者有增，删，改，查用户功能
 * @author 98333
 */
public class AdminDaoImpl extends UserDaoImpl {
    private JDBCUtils dbUtil = new JDBCUtils();
    private BeanUtils beanUtils;
    {
        try {
            beanUtils = new BeanUtilsimpl(dbUtil.getCon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean delete(Object cls) {
        String sql = "delete from tab_user where "+cls.toString()+" = ?";
        int i=beanUtils.update(sql,cls.toString());
        return i>0;
    }

    @Override
    public List<User> select(Object cls) {
        String sql = "select * from tab_user where "+cls.toString()+" = ?";
        return beanUtils.query(sql,User.class,cls.toString());

    }

}