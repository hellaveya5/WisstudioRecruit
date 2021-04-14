package com;

import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.Impl.SqlUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;

import java.util.List;

/**
 * @author 98333
 */

public class Test {
    JDBCUtils jdbcUtils = new JDBCUtils();
    SqlUtilsimpl beanUtilsimpl = null;


    {
        try {
            beanUtilsimpl = new SqlUtilsimpl(jdbcUtils.getCon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

@org.junit.Test
    public void test01() {
        int id = 1;
        String sql = "select * from tab_user where id = ?";
        List<User> query = beanUtilsimpl.query(sql, User.class, id);
        System.out.println(query);
    }
    @org.junit.Test
    public void test02(){
        Integer id = 1;
        Object obj=id;
            String sql = "delete from tab_user where "+obj.toString()+" = ?";
            int i=beanUtilsimpl.update(sql,obj.toString());



    }
}