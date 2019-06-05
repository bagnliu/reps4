package com.bagnliu.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bagnliu.util.DataBaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bagnliu
 * @create 2019-06-05 22:52
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        Connection conn = DataBaseUtil.getConn();
        String sql = "select * from league where project = ? ORDER BY ranking ASC LIMIT 0,3";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, request.getParameter("project"));

            // 执行查询获取结果集
            ResultSet rs = ps.executeQuery();
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobj = new JSONObject();
            // 判断结果集是否有效,如过有效，则对用户进行赋值
            while (rs.next()) {
                jsonobj.put("project", rs.getString("project"));
                jsonobj.put("ranking", rs.getString("ranking"));
                jsonobj.put("college", rs.getString("college"));
                jsonobj.put("username", rs.getString("username"));
                jsonobj.put("achievement", rs.getString("achievement"));
                jsonarray.add(JSON.parse(JSON.toJSONString(jsonobj, SerializerFeature.DisableCircularReferenceDetect)));// json 拒绝重复引用[{"$ref":"$[0]"}]
            }
            // 输出数据
            out = response.getWriter();
            out.println(jsonarray);
            // 释放资源
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeConn(conn);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
