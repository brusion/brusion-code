package com.demo.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Action分发中心
 *
 * @author brusion
 * @date 2018/4/1
 */
public class ActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //: /demo/register.action
        String requestURI = req.getRequestURI();
        String path = requestURI.substring(requestURI.lastIndexOf("/")+1, requestURI.lastIndexOf("."));
        System.out.println(path);

        Action action ;
        if (path.equals("login")){
            action = new LoginAction();
        }else {
            action = new RegisterAction();
        }

        String url = action.execute(req, resp);
        if (url.contains("redirect")){
            // 字符串截取
            String substring = url.substring(url.lastIndexOf(":")+1);
            resp.sendRedirect(req.getContextPath()+substring);
        }else {
            req.getRequestDispatcher(url).forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
