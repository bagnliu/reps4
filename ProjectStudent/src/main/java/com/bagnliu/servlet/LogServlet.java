package com.bagnliu.servlet;

import com.bagnliu.dao.UserDao;
import com.bagnliu.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bagnliu
 * @create 2019-06-05 21:32
 */
@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("name");
        String idcard = request.getParameter("card");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        //根据密码查询用户
        Admin user  = userDao.login(username,idcard, password);
        //判断user是否为空
        if (user != null) {
            //将用户的对象放到session中
            request.getSession().setAttribute("user", user);

            response.getWriter().write("{\"code\":\"2\"}");
        }else {
            //将数据写入流中
            response.getWriter().write("{\"code\":\"1\"}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
