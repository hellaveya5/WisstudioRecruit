package com.wisstudio.recruit.dao.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisstudio.recruit.dao.UserDao;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.SqlUtils;
import com.wisstudio.recruit.util.Impl.SqlUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
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
                "choiceOfDirection,skillMastered,selfIntroduce,studentId) value(?,?,?,?,?,?,?,?,?,?)";
        int i= sqlUtils.update(sql,user.getPassword(),user.getName(),user.getGender(),
                user.getMajor(),user.getGrade(),user.getContactNumber(),user.getChoiceOfDirection(),user.getSkillMastered(),
               user.getSelfIntroduce(),user.getStudentId());

        return i>0;
    }
    @Override
    public boolean modify(User user) {
        User u = findByStudentId(user.getStudentId());
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
        if (query.size() != 0){
            return query.get(0);
        }
        return null;
    }
    @Override
    public User findByStudentId(Long studentId) {
        String sql = "select * from tab_user where studentId = ?";
        List<User> query = sqlUtils.query(sql, User.class, studentId);
        if (query.size() != 0){
            return query.get(0);
        }
        return null;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select * from tab_user where 1=1 ";
        StringBuilder sb = new StringBuilder();
        sb.append(sql);
        Set<String> keySet = condition.keySet();
        List<Object> list = new ArrayList<>();
        for(String key : keySet){
            //取条件值
            if("rows".equals(key) || "currentPage".equals(key)){
                continue;
            }
            String value =condition.get(key)[0];
            if(value != null && !"".equals(value)){
                //模糊查询
                sb.append(" and ").append(key).append(" = ?");
                list.add(value);
            }
            System.out.println(sb.toString());
            System.out.println(list);
        }
        return sqlUtils.query(sb.toString(),User.class,list.toArray()).size();
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from tab_user where 1=1 ";
        StringBuilder sb = new StringBuilder();
        sb.append(sql);
        Set<String> keySet = condition.keySet();
        List<Object> list = new ArrayList<>();
        for(String key : keySet){
            //取条件值
            if("rows".equals(key) || "currentPage".equals(key)){
                continue;
            }
            String value =condition.get(key)[0];
            if(value != null && !"".equals(value)){
                //查询
                sb.append(" and ").append(key).append(" = ?");
                list.add(value);
            }
            System.out.println(sb.toString());
            System.out.println(list);
        }
        sb.append(" limit ?,? ");
        list.add(start);
        list.add(rows);
        System.out.println(sb.toString());
        System.out.println(list);
        return sqlUtils.query(sb.toString(), User.class , list.toArray());
    }

}
