package com.bagnliu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author bagnliu
 * @create 2019-06-05 22:19
 */
public class DataBaseUtil {

    //连接数据库
    public static Connection getConn() {
        Connection conn = null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/sqlservice?useUnicode=true&characterEncoding=UTF-8";
        try {
            //获取Connection对象
            conn = DriverManager.getConnection(url, "root", "123456");
            if (conn != null) {
                System.out.println("............连接数据通讯成功.................");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭数据库
    public static void closeConn(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
