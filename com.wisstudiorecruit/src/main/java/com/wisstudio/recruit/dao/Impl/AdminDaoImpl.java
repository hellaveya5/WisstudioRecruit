package com.wisstudio.recruit.dao.Impl;

import com.wisstudio.recruit.dao.AdminDao;
import com.wisstudio.recruit.po.Administrator;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.SqlUtils;
import com.wisstudio.recruit.util.Impl.SqlUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;

import java.util.ArrayList;
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
        String sql ="select * from administrator where ( name = ? and password = ?)";
        List<Administrator> query = sqlUtils.query(sql, Administrator.class, name, password);
        if(query.size()==0){
            return null;
        }
        return query.get(0);

    }

    @Override
    public boolean delete(Long studentId) {

        String sql = "delete from tab_user where studentId=?";
        return sqlUtils.update(sql , studentId)>=0;
    }


    @Override
    public List<User> select(User user) {

      /*  String sql = "select *from tab_user ";
        sqlUtils.query(sql,User.class,);*/
      return null;
    }
    @Override
    public List<User> findAll(){
        String sql = "select * from tab_user";
       List <User> users= sqlUtils.query(sql,User.class);
       return users;

    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into tab_user(password,name,gender,major,grade,contactNumber," +
                "choiceOfDirection,skillMastered,selfIntroduce,studentId) value(?,?,?,?,?,?,?,?,?,?)";
        int i= sqlUtils.update(sql,user.getPassword(),user.getName(),user.getGender(),
                user.getMajor(),user.getGrade(),user.getContactNumber(),user.getChoiceOfDirection(),user.getSkillMastered(),
                user.getSelfIntroduce(),user.getStudentId());
        return i>0;
    }
}
