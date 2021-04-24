package com.wisstudio.recruit.dao.Impl;

import com.wisstudio.recruit.dao.UserDao;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.SqlUtils;
import com.wisstudio.recruit.util.Impl.SqlUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;

import java.util.List;

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
        System.out.println(user);
        String sql = "insert into tab_user(password,name,gender,major,grade,contactNumber," +
                "choiceOfDirection,skillMastered,selfIntroduce,studentId) value(?,?,?,?,?,?,?,?,?)";
        int i= sqlUtils.update(sql,user.getPassword(),user.getName(),user.getGender(),
                user.getMajor(),user.getGrade(),user.getContactNumber(),user.getChoiceOfDirection(),user.getSkillMastered(),
               user.getSelfIntroduce(),user.getStudentId());

        return i>0;
    }
    @Override
    public boolean modify(User user) {
        User u = findByUsernameAndPassword(user.getName(),user.getPassword());
        if(u!=null){
            String sql = "update tab_user set password = ?,name = ?,gender = ?,major = ?,grade = ?,contactNumber = ?,choiceofdirection = ?,skillMastered = ?,selfIntroduce = ? where studentId = ?";
            Integer i = sqlUtils.update(sql,user.getPassword(),user.getName(),user.getGender(),
                    user.getMajor(),user.getGrade(),user.getContactNumber(),user.getChoiceOfDirection(),user.getSkillMastered(),
                    user.getSelfIntroduce(),user.getStudentId());
            System.out.println(u);
            System.out.println(i);
            return i > 0;
        }else {
            return false;
        }

    }
    @Override
    public User login(String username, String password) {
        String sql = "select * from tab_user where ( name = ? and password = ?)";
        List<User> query = sqlUtils.query(sql, User.class, username, password);
        if (query.size() != 0){
            return query.get(0);
        }
        return null;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = " select * from tab_user where ( name = ? and password = ?)";
        List<User> query = sqlUtils.query(sql, User.class, username, password);
        if (query.size() != 0){
            return query.get(0);
        }
        return null;
    }
    @Override
    public User findByUsername(String username) {
        String sql = " select * from tab_user where ( name = ? )";
        List<User> query = sqlUtils.query(sql, User.class,username);
        System.out.println("dao:"+query.size());
        if (query.size() != 0){
            return query.get(0);
        }
        return null;
    }
}
