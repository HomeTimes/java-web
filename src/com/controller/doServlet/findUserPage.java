package com.controller.doServlet;

import com.domain.pageUserBean;
import com.sevice.impl.UserserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserPage")
public class findUserPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        获取请求参数
//        当前页
        String currentPage = req.getParameter("CurrentPage");
//         每页的条数
        String rows = req.getParameter("rows");
//        这里是进入的时候查询时没参数的情况


        if(currentPage==null || "".equals(currentPage) ){
            currentPage="1";
        }
        if(rows==null || "".equals(rows) ){
            rows="3";
        }
//        获取查询的条件参数
        Map<String, String[]> parameterMap = req.getParameterMap();

        UserserviceImpl userservice=new UserserviceImpl();
        pageUserBean userPage = userservice.findUserPage(currentPage, rows,parameterMap);
        System.out.println(userPage);
        req.setAttribute("userPage",userPage);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
