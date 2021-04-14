package com.wisstudio.recruit.dao.Impl;

import com.wisstudio.recruit.dao.UserDao;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.SqlUtils;
import com.wisstudio.recruit.util.Impl.SqlUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;

/**
 * 用户有增，删功能
 * @author 98333
 */
public class UserDaoImpl implements UserDao {
    private  JDBCUtils dbUtil = new JDBCUtils();
    private SqlUtils sqlUtils;

    {
        try {
            sqlUtils = new SqlUtilsimpl(dbUtil.getCon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean add(User user) {
        String sql = "insert into tab_user(id,password,name,gender,major,grade,contactNumber," +
                "choiceofdirection,skillMastered,selfIntroduce) value(?,?,?,?,?,?,?,?,?,?)";
        int i= sqlUtils.update(sql,"id,name,gender,major,grade," +
                "contactNumber,choiceofdirection,skillMastered,selfIntroduce");

        return i>0;
    }
    @Override
    public boolean modify(User user) {
        String sql = "update tab_uesr set id= ?,password,name= ?,gender= ?,major= ?,grade= ?,contactNumber= ?,choiceofdirection= ?,skillMastered= ?,selfIntroduce= ?";
        Integer i = sqlUtils.update(sql,"id","name","gender","major","grade","ontactNumber","choiceofdirection","skillMastered","selfIntroduce");
        return i > 0;
    }
    @Override
    public User login(String username, String password) {
        String sql = "select * from tab_user where ( username = ? and password = ?)";
        return sqlUtils.query(sql,User.class,username,password).get(0);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = " slect * from tab_user where ( username = ? and password = ?)";
        return sqlUtils.query(sql,User.class,username,password).get(0);
    }
}
