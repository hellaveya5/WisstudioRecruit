package com.wisstudio.recruit.util.Impl;

import com.wisstudio.Exception.TypeNotEnoughException;
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
        ResultSet rs = null;
        PreparedStatement ps;
        //给？赋予参数
        try {
            ps = conn.prepareStatement(sql);
            if (null != args) {
                for (int i = 1; i <= args.length; i++) {
                    ps.setObject(i, args[i - 1]);
                }
                rs = ps.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //列名
        List<String> propertyKeys = new ArrayList<>();
        //值名
        List<Object> propertyValues = new ArrayList<>();
        //数据类型字节码对象
        List<Class<?>> propertyClass = new ArrayList<>();
        //返回的List集合
        List<T> objList = new ArrayList<>();
        //获取类中所有属性,返回Field 对象的一个数组
        Field[] fields = clazz.getDeclaredFields();
        //获取列名和列类型的对象
        for (Field field : fields) {
            propertyClass.add(field.getType());
            propertyKeys.add(field.getName());
        }
        //获取列值
        int columnCount;
        try {
            assert rs != null;
            columnCount= rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <=columnCount; i++) {
                    System.out.println(rs.getMetaData().getColumnTypeName(i).toString());
                    if ("INT".equalsIgnoreCase(rs.getMetaData().getColumnTypeName(i))) {

                        propertyValues.add(rs.getInt(i));
                    } else if ("VARCHAR".equalsIgnoreCase(rs.getMetaData().getColumnTypeName(i))) {

                        propertyValues.add(rs.getString(i));
                    }//else if
                    else if ("bigint".equalsIgnoreCase(rs.getMetaData().getColumnTypeName(i))) {
                    propertyValues.add(rs.getLong(i));
                }
                    else {
                        throw new TypeNotEnoughException();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //操作 T 对象调用它的方法给他成员变量赋值
        for (int j = 0; j < propertyValues.size(); ) {
            T object = null;
            try {
                object = clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < propertyKeys.size(); i++, j++) {
                //Stringbuilder获取方法的字段
                StringBuilder sb = new StringBuilder("set");
                sb.append(propertyKeys.get(i).substring(0, 1).toUpperCase()).append((propertyKeys.get(i).substring(1)));
                System.out.println("操作"+sb.toString());
                //执行方法对象
                Method method = null;
                try {
                    assert object != null;
                    //获取
                    method = object.getClass().getDeclaredMethod(sb.toString(), propertyClass.get(i));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    assert method != null;
                    //执行
                    method.invoke(object, propertyValues.get(j));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            objList.add(object);
        }
        return objList;
    }

    @Override
    public Integer update(String sql, Object... args) {
        int impactline = -1;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (null != args) {
                for (int i = 1; i <= args.length; i++) {
                    ps.setObject(i, args[i - 1]);
                }
            }
            impactline = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return impactline;
    }

    @Override
    public <T> List<T> query(String sql, Class<T> clazz) {
        ResultSet rs = null;
        PreparedStatement ps;
        //直接执行sql
        try {
            ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //列名
        List<String> propertyKeys = new ArrayList<>();
        //值名
        List<Object> propertyValues = new ArrayList<>();
        //数据类型字节码对象
        List<Class<?>> propertyClass = new ArrayList<>();
        //返回的List集合
        List<T> objList = new ArrayList<>();
        //获取类中所有属性,返回Field 对象的一个数组
        Field[] fields = clazz.getDeclaredFields();
        //获取列名和列类型的对象
        for (Field field : fields) {
            propertyClass.add(field.getType());
            propertyKeys.add(field.getName());
        }
        //获取列值
        int columnCount;
        try {
            assert rs != null;
            columnCount= rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <=columnCount; i++) {
                    if ("INT".equalsIgnoreCase(rs.getMetaData().getColumnTypeName(i))) {
                        propertyValues.add(rs.getInt(i));
                    } else if ("VARCHAR".equalsIgnoreCase(rs.getMetaData().getColumnTypeName(i))) {
                        propertyValues.add(rs.getString(i));
                    }//else if
                    else if ("bigint".equalsIgnoreCase(rs.getMetaData().getColumnTypeName(i))) {
                        propertyValues.add(rs.getLong(i));
                    }
                    else {
                        throw new TypeNotEnoughException();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //操作 T 对象调用它的方法给他成员变量赋值
        for (int j = 0; j < propertyValues.size(); ) {
            T object = null;
            try {
                object = clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < propertyKeys.size(); i++, j++) {
                //Stringbuilder获取方法的字段
                StringBuilder sb = new StringBuilder("set");
                sb.append(propertyKeys.get(i).substring(0, 1).toUpperCase()).append((propertyKeys.get(i).substring(1)));
                //执行方法对象
                Method method = null;
                try {
                    assert object != null;
                    //获取
                    method = object.getClass().getDeclaredMethod(sb.toString(), propertyClass.get(i));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    assert method != null;
                    //执行
                    method.invoke(object, propertyValues.get(j));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            objList.add(object);
        }
        return objList;
    }
}