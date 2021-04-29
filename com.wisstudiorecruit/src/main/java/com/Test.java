package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisstudio.Annotation.GetMapping;
import com.wisstudio.recruit.controller.AdminAddServlet;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.service.Impl.AdminServiceImpl;
import com.wisstudio.recruit.util.BeanUtils;
import com.wisstudio.recruit.util.Impl.BeanUtilsImpl;
import com.wisstudio.recruit.util.Impl.SqlUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;
import com.wisstudio.recruit.util.MailUtils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int studentId = 43;
        String sql = "select * from tab_user where studentId = ?";
        SqlUtilsimpl sqlUtilsimpl = null;
        try {
            sqlUtilsimpl = new SqlUtilsimpl(jdbcUtils.getCon());
            List<User> query = sqlUtilsimpl.query(sql, User.class, studentId);
            System.out.println(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @org.junit.Test
    public void test02() {
        Integer id = 1;
        Object obj = id;
        String sql = "delete from tab_user where " + obj.toString() + " = ?";
        int i = beanUtilsimpl.update(sql, obj.toString());
    }

    @org.junit.Test
    public void test03() {
        Map<String, String[]> map = new HashMap<>();
        String[] strArray = {"123123123"};
        map.put("studentId", strArray);
        map.put("password", strArray);
        BeanUtilsImpl beanUtils = new BeanUtilsImpl();
        User populate = beanUtils.populate(User.class, map);
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(populate);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }

    @org.junit.Test
    public void test04() throws Exception {
        String emailAddr = "983338078@qq.com";
        String randomCode = MailUtils.generateRandomCode(6);
        try {
            MailUtils.sendMail(emailAddr, randomCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test05() {
        Map<String, String[]> map = new HashMap<>();
        BeanUtilsImpl beanUtils = new BeanUtilsImpl();
        User populate = beanUtils.populate(User.class, map);
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(populate);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }

    @org.junit.Test
    public void test06() {
        String sql = "select * from tab_user";
        JDBCUtils jdbcUtils = new JDBCUtils();
        SqlUtilsimpl sqlUtils = null;
        try {
            sqlUtils = new SqlUtilsimpl(jdbcUtils.getCon());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert sqlUtils != null;
        List<User> users = sqlUtils.query(sql, User.class);
        System.out.println(users);
    }
    @org.junit.Test
    public void test07(){
        String sql = "select count(*) from tab_user";
        Connection con = null;
        int total=-1;
        Statement stmt ;
        JDBCUtils dbUtil = new JDBCUtils();
        try {
            con = dbUtil.getCon();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                total=rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(total);
    }
    @org.junit.Test
    public void test08(){
        String sql = "select * from tab_user limit ? , ? ";
        int currentPages = 1;
        int rows =5;
        JDBCUtils jdbcUtils = new JDBCUtils();
        SqlUtilsimpl sqlUtils = null;
        try {
            sqlUtils = new SqlUtilsimpl(jdbcUtils.getCon());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert sqlUtils != null;
        Integer i = sqlUtils.query(sql,User.class,currentPages,rows).size();
    }
    @org.junit.Test
    public void test09(){
        try {
            AdminAddServlet a = AdminAddServlet.class.getConstructor().newInstance();
            Class<? extends AdminAddServlet> aClass = a.getClass();
            Method[] methods = aClass.getMethods();
            System.out.println(aClass.toString());
            for (Method i :
                    methods) {
                Annotation b = i.getAnnotation(GetMapping.class);
                if(null!=b){
                    System.out.println("i : "+b);
                }else{
                    System.out.println("not");
                }
            }





        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }



    }
}