package com.wisstudio.recruit.util.Impl;

import com.wisstudio.Exception.TypeNotEnoughException;
import com.wisstudio.recruit.util.ReflectUtils;
import com.wisstudio.recruit.util.SqlUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 98333
 */
public class SqlUtilsimpl implements SqlUtils {

    private Connection conn ;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public SqlUtilsimpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public <T> List<T> query(String sql, Class<T> clazz, Object... args) {
       PreparedStatement ps=null ;
       ResultSet rs =null;
        ArrayList<T> objList = new ArrayList<>();
        //赋值执行sql语句
        try {
            int i =1;
            ps = conn.prepareStatement(sql);
            for (Object obj:
                 args) {
                ps.setObject(i++,obj);
            }
            objList = ReflectUtils.getObjectList(clazz, ps);

        } catch (SQLException | InvocationTargetException | InstantiationException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return objList;
    }


    @Override
    public Integer update(String sql, Object... args) {
        int impactLine = -1;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (null != args) {
                for (int i = 1; i <= args.length; i++) {
                    ps.setObject(i, args[i - 1]);
                }
            }
            impactLine = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return impactLine;
    }

    @Override
    public <T> List<T> queryAll(String sql, Class<T> clazz) {
        PreparedStatement ps = null ;
        ResultSet rs =null;
        ArrayList<T> objList = new ArrayList<>();
        //赋值执行sql语句
        try {
            int i =1;
            ps = conn.prepareStatement(sql);
            //结果集详细信息，列名，列类型，列值
            objList= ReflectUtils.getObjectList(clazz,ps);

        } catch (SQLException | InvocationTargetException | InstantiationException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return objList;
    }




}


