package com.controller.doServlet;

import com.domain.user;
import com.sevice.impl.UserserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllUser")
public class findAllUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserserviceImpl userservice=new UserserviceImpl();
        List<user> allUser = userservice.findAllUser();
        HttpSession session = req.getSession();
        session.setAttribute("userList",allUser);
        resp.sendRedirect(req.getContextPath()+"/list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
