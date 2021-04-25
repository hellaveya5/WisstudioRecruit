package com.wisstudio.recruit.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 反射有关的工具类
 * @Author:98333
 * @Date:2021/4/25
 * @Description:com.wisstudio.recruit.util
 */
public class ReflectUtils {

    /**
     *  反射获取结果集
     * @param clazz 类型名称
     * @param ps 执行sql语句对象
     * @param <T>   类型
     * @return 数据库对应的结果集封装到实现类中
     */
    public static <T> ArrayList<T> getObjectList(Class<T> clazz, PreparedStatement ps) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ArrayList<T> objList = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        //结果集详细信息，列名，列类型，列值
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        while(rs.next()){
            //实例化实体类
            T object = clazz.getDeclaredConstructor().newInstance();
            for(int j =1 ; j <= columnCount; j++){
                String columnName = metaData.getColumnLabel(j);
                Object columnValue = rs.getObject(j);
                Class<?> aClass = object.getClass();
                try {
                    //获得指定名的属性
                    Field field = aClass.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(object,columnValue);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

            }
            objList.add(object);
        }
        return objList;
    }

}
