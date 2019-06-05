package com.bagnliu.servlet;

import com.bagnliu.dao.UserDao;
import com.bagnliu.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bagnliu
 * @create 2019-06-05 21:29
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        // 获取用户注册信息
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String college = request.getParameter("college");
        String num = request.getParameter("num");

        // 实例化UserDao对象
        UserDao userDao = new UserDao();
        // 实例化一个User对象
        User user = new User();
        // 对用户对象的属性赋值
        user.setUsername(username);
        user.setUserpassword(password);
        user.setSchool(college);
        user.setUserid(num);
        userDao.saveUser(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
