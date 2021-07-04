package com.controller.doServlet;

import com.sevice.Userservice;
import com.sevice.impl.UserserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectedUser")
public class deleteSelectedUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] uids = req.getParameterValues("uid");
        UserserviceImpl userservice=new UserserviceImpl();
        userservice.deleteSelectedUser(uids);
        resp.sendRedirect(req.getContextPath()+"/findAllUser");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
