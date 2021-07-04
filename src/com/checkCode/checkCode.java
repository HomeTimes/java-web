package com.checkCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/code")
public class checkCode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           int width=100;
           int height=50;
           BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
           Graphics graphics = image.getGraphics();
           graphics.setColor(new Color(100,230,200));
           graphics.fillRect(0,0,width,height);
          char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456".toCharArray();
          Random random=new Random();
          StringBuilder builder=new StringBuilder();
        for(int i = 1; i<=4;i++){
//            随机下标
            int index = random.nextInt(codeChar.length);
            char c = codeChar[index];
            builder.append(c);
            graphics.setColor(new Color(random.nextInt(150),random.nextInt(200),random.nextInt(255)));
            graphics.setFont( new Font("宋体",Font.BOLD,20));
            graphics.drawString(c+"",20*i,30);
        }
//        验证码
         String s = builder.toString();
         HttpSession session = req.getSession();
         session.setAttribute("code",s);
//        干扰线
        for(int i=0;i<4;i++){
            graphics.setColor(new Color(random.nextInt(150),random.nextInt(200),random.nextInt(255)));
            graphics.drawLine(random.nextInt(100),random.nextInt(50),random.nextInt(100),random.nextInt(50));
        }
        ImageIO.write(image,"jpg",resp.getOutputStream());

    }{}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
