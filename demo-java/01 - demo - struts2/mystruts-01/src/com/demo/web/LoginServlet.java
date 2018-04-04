package com.demo.web;

import com.demo.User;
import com.demo.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author brusion
 * @date 2018/4/1
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);

        UserService service = new UserService();
        User login = service.login(user);

        String path = req.getContextPath();

        if (login ==null){
            path = path +"/error.jsp";
        }else {
            path = path+"/home.jsp";
        }

        resp.sendRedirect(path);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
