package com.bagnliu.dao;

import com.bagnliu.model.Admin;
import com.bagnliu.model.User;
import com.bagnliu.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bagnliu
 * @create 2019-06-05 22:31
 */
public class UserDao {

    public Admin login(String username, String idcard, String password) {
        //实例化一个用户对象
        Admin admin =null;
        Connection conn = DataBaseUtil.getConn();
        String sql = "select * from users where username = ? and userpassword = ? and idcard =? and admin='Y'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, idcard);

            //执行查询获取结果集
            ResultSet rs = ps.executeQuery();

            //判断结果集是否有效,如过有效，则对用户进行赋值
            while (rs.next()) {

                admin = new Admin();

                //对用户对象进行复制
                admin.setUsername(rs.getString("username"));
                admin.setIdcard(rs.getString("idcard"));
                admin.setUserpassword(rs.getString("userpassword"));
            }
            //释放资源
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeConn(conn);
        }
        return admin;
    }

    /**
     * 在用户提交注册信息时，如果注册成功需要将，需要将用户注册的信息存入数据库
     */
    public void saveUser(User user) {
        //获取数据库连接
        Connection conn = DataBaseUtil.getConn();
        //插入信息的sql语句
        String sql = "insert into users(userid,username,userpassword,school) values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserid());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getUserpassword());
            ps.setString(4, user.getSchool());
            //执行更新操作
            ps.executeUpdate();
            //释放资源
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
