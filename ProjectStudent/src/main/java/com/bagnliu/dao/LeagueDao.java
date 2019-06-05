package com.bagnliu.dao;

import com.bagnliu.model.League;
import com.bagnliu.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author bagnliu
 * @create 2019-06-05 23:00
 */
public class LeagueDao {

    /**
     * 需要将信息存入数据库
     */
    public void saveUser(League league) {
        //获取数据库连接
        Connection conn = DataBaseUtil.getConn();
        //插入信息的sql语句
        String sql = "insert into league(project,username,college,achievement,ranking) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, league.getProject());
            ps.setString(2, league.getName());
            ps.setString(3, league.getCollege());
            ps.setString(4, league.getAchievement());
            ps.setString(5, league.getRanking());
            //执行更新操作
            ps.executeUpdate();
            //释放资源
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
