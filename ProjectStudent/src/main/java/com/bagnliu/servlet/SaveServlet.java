package com.bagnliu.servlet;

import com.bagnliu.dao.LeagueDao;
import com.bagnliu.model.League;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bagnliu
 * @create 2019-06-05 21:34
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        // 获取信息
        String project = request.getParameter("project");
        String name = request.getParameter("name");
        String college = request.getParameter("college");
        String achievement = request.getParameter("achievement");
        String ranking = request.getParameter("ranking");

        // 实例化UserDao对象
        LeagueDao leagueDao = new LeagueDao();
        // 实例化一个User对象
        League league = new League();
        // 对用户对象的属性赋值
        league.setAchievement(achievement);
        league.setCollege(college);
        league.setName(name);
        league.setProject(project);
        league.setRanking(ranking);

        leagueDao.saveUser(league);
        response.getWriter().write("{\"code\":\"1\"}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
