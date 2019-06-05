package com.bagnliu.servlet;

import com.bagnliu.dao.ProjectDao;
import com.bagnliu.model.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bagnliu
 * @create 2019-06-05 22:57
 */
@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        // 实例化一个User对象
        Project project = new Project();
        //获取信息并 对用户对象的属性赋值
        project.setBoy_100m(request.getParameter("boy_100m"));
        project.setBoy_800m(request.getParameter("boy_800m"));
        project.setBoy_5000m(request.getParameter("boy_5000m"));
        project.setBoy_relay(request.getParameter("boy_relay"));
        project.setBoy_height(request.getParameter("boy_height"));
        project.setBoy_long(request.getParameter("boy_long"));
        project.setGirl_100m(request.getParameter("girl_100m"));
        project.setGirl_400m(request.getParameter("girl_400m"));
        project.setGirl_2000m(request.getParameter("girl_2000m"));
        project.setGirl_relay(request.getParameter("girl_relay"));
        project.setGirl_height(request.getParameter("girl_height"));
        project.setGirl_long(request.getParameter("girl_long"));
        project.setVolunteer_court(request.getParameter("volunteer_court"));
        project.setVolunteer_waiting(request.getParameter("volunteer_waiting"));
        project.setVolunteer_logistics(request.getParameter("volunteer_logistics"));
        project.setNumber_id(request.getParameter("number_id"));

        // 实例化UserDao对象
        ProjectDao projectDao = new ProjectDao();
        // 根据学号查询
        Project pro = projectDao.seletProje(request.getParameter("number_id"));
        // 判断是否已经存在
        if (pro != null) {
            projectDao.update(project);
        } else {
            projectDao.saveUser(project);
        }
        response.getWriter().write("{\"code\":\"1\"}");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
