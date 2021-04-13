package com.wisstudio.recruit.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 98333
 */
public class BeanUtilsimpl implements BeanUtils {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public BeanUtilsimpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public <T> List<T> query(String sql, Class<T> clazz, Object... args) {
        ResultSet rs = null;
        //给？赋予参数
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if(null != args){
                for(int i=1; i <= args.length; i++){
                    ps.setObject(i, args[i - 1]);
                }
                rs = ps.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public <T> Integer update(String sql, Class<T> clazz, Object... args) {

        return 0;
    }
}
