package com.controller.doServlet;

import com.domain.user;
import com.sevice.impl.UserserviceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                 req.setCharacterEncoding("utf-8");
        String code = req.getParameter("verifycode");
        System.out.println("code="+code);
        HttpSession session = req.getSession();
        String session_code = (String) session.getAttribute("code");
        session.removeAttribute("code");
        if (!code.equalsIgnoreCase(session_code)){
            req.setAttribute("err_code","验证码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }
        Map<String, String[]> map = req.getParameterMap();
//        验证心中所想的代码
        Set<String> set = map.keySet();
        for (String key:set){
            System.out.println("key"+key);
            String[] keys = map.get(key);
            System.out.println("keysValue----"+keys);
            String s = map.get(key)[0];
            System.out.println("keyValue----"+s);
        }
        user user = new user();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserserviceImpl userservice=new UserserviceImpl();
        com.domain.user loginUser = userservice.Login(user);
//        System.out.println(loginUser);
        if(loginUser!= null){
           session.setAttribute("user",loginUser);
           resp.sendRedirect(req.getContextPath()+"/loginsecceful.jsp");
        }else {
            req.setAttribute("err_login","登录错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
