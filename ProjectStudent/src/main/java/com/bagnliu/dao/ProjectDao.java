package com.bagnliu.dao;

import com.bagnliu.model.Project;
import com.bagnliu.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bagnliu
 * @create 2019-06-05 22:58
 */
public class ProjectDao {


    /**
     * 需要将信息存入数据库
     */
    public void saveUser(Project project) {
        // 获取数据库连接
        Connection conn = DataBaseUtil.getConn();
        // 插入信息的sql语句
        String sql = "insert into project(boy_100m,boy_800m,boy_5000m,boy_relay,boy_height,boy_long,girl_100m,girl_400m,girl_2000m,girl_relay,girl_height,girl_long,volunteer_court,volunteer_waiting,volunteer_logistics,number_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, project.getBoy_100m());
            ps.setString(2, project.getBoy_800m());
            ps.setString(3, project.getBoy_5000m());
            ps.setString(4, project.getBoy_relay());
            ps.setString(5, project.getBoy_height());
            ps.setString(6, project.getBoy_long());
            ps.setString(7, project.getGirl_100m());
            ps.setString(8, project.getGirl_400m());
            ps.setString(9, project.getGirl_2000m());
            ps.setString(10, project.getGirl_relay());
            ps.setString(11, project.getGirl_height());
            ps.setString(12, project.getGirl_long());
            ps.setString(13, project.getVolunteer_court());
            ps.setString(14, project.getVolunteer_waiting());
            ps.setString(15, project.getVolunteer_logistics());
            ps.setString(16, project.getNumber_id());
            // 执行更新操作
            ps.executeUpdate();
            // 释放资源
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Project seletProje(String number_id) {
        // 实例化一个用户对象
        Project project = null;
        Connection conn = DataBaseUtil.getConn();
        String sql = "select * from project where number_id = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, number_id);

            // 执行查询获取结果集
            ResultSet rs = ps.executeQuery();

            // 判断结果集是否有效,如过有效，则对用户进行赋值
            while (rs.next()) {

                project = new Project();
                // 对用户对象进行复制
                project.setNumber_id(rs.getString("number_id"));
            }
            // 释放资源
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeConn(conn);
        }
        return project;
    }

    public void update(Project project) {
        Connection conn = DataBaseUtil.getConn();
        if (project.getVolunteer_court() != null || project.getVolunteer_waiting() != null
                || project.getVolunteer_logistics() != null) {
            String sql = "update project set volunteer_court=?,volunteer_waiting=?,volunteer_logistics=? where number_id = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, project.getVolunteer_court());
                ps.setString(2, project.getVolunteer_waiting());
                ps.setString(3, project.getVolunteer_logistics());
                ps.setString(4, project.getNumber_id());

                // 执行更新操作
                ps.executeUpdate();
                // 释放资源
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DataBaseUtil.closeConn(conn);
            }
        } else {
            String sql = "update project set boy_100m=?,boy_800m=?,boy_5000m=?,boy_relay=?,boy_height=?,boy_long=?,girl_100m=?,girl_400m=?,girl_2000m=?,girl_relay=?,girl_height=?,girl_long=? where number_id=?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, project.getBoy_100m());
                ps.setString(2, project.getBoy_800m());
                ps.setString(3, project.getBoy_5000m());
                ps.setString(4, project.getBoy_relay());
                ps.setString(5, project.getBoy_height());
                ps.setString(6, project.getBoy_long());
                ps.setString(7, project.getGirl_100m());
                ps.setString(8, project.getGirl_400m());
                ps.setString(9, project.getGirl_2000m());
                ps.setString(10, project.getGirl_relay());
                ps.setString(11, project.getGirl_height());
                ps.setString(12, project.getGirl_long());
                ps.setString(13, project.getNumber_id());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
