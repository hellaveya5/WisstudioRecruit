package com.wisstudio.recruit.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
    private String dbUrl="jdbc:mysql://127.0.0.1:3306/recruit";
    private String dbUserName="root";
    private String dbPassword="root";
    private String jdbcName="com.mysql.jdbc.Driver";
    /*
     * 获得数据库连接
     * @return
     * @throws Exception
     * */
    public Connection getCon() throws  Exception{
        //动态加载
        Class.forName((jdbcName));
        Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }
    /*
     * 关闭数据库连接
     * */
    public  void closeCon(Connection con )throws Exception{
        if(con!=null){
            con.close();
        }
    }

    public static void main(String[] args) {
        JDBCUtils dbUtil =new JDBCUtils();
        try{
            dbUtil.getCon();
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }
}
