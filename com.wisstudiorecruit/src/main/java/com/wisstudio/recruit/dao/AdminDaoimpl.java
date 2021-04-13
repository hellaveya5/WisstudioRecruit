package com.wisstudio.recruit.dao;

import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 98333
 */
public class AdminDaoimpl implements UserDao{
    private static JDBCUtils dbUtil = new JDBCUtils();
    @Override
    public int add(User user) {
        String sql = "insert into tab_user(user_id,user_name,user_gender,user_major,user_grade,user_contactNumber," +
                "user_choiceofdirection,user_killmastered,user_selfIntroduce) value(?,?,?,?,?,?,?,?,?,)";
        try (Connection con = dbUtil.getCon()) {
            user.getClass().getMethod("getStudentId");
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setObject(1,user.getId());
            pstmt.setObject(2,user.getName());
            pstmt.setObject(3,user.getGender());
            pstmt.setObject(4,user.getMajor());
            pstmt.setObject(5,user.getGrade());
            pstmt.setObject(6,user.getContactNumber());
            pstmt.setObject(7,user.getChoiceOfDirection());
            pstmt.setObject(8,user.getSkillMastered());
            pstmt.setObject(9,user.getSelfIntroduce());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    @Override
    public int modify(User user) {
        return -1;
    }



    public boolean delete(Integer id) {
        return false;
    }

    public User select(Object cls) {
        return null;
    }
}
