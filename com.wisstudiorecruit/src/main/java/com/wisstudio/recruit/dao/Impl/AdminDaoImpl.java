package com.wisstudio.recruit.dao.Impl;

import com.wisstudio.recruit.dao.AdminDao;
import com.wisstudio.recruit.po.Administrator;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.SqlUtils;
import com.wisstudio.recruit.util.Impl.SqlUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private JDBCUtils dbUtil = new JDBCUtils();
    private SqlUtils sqlUtils;

    {
        try {
            sqlUtils = new SqlUtilsimpl(dbUtil.getCon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Administrator login(String name, String password) {
        String sql ="select * from administrator where where ( username = ? and password = ?)";
        return sqlUtils.query(sql, Administrator.class,name,password).get(0);

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<User> select(User user) {
        return null;
    }
}
