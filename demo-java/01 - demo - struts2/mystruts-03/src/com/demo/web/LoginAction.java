package com.demo.web;


import com.demo.User;
import com.demo.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author brusion
 * @date 2018/4/1
 */
public class LoginAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        User user = new User();
        user.setPwd(pwd);
        user.setName(name);

        UserService service = new UserService();
        User login = service.login(user);
        if (login != null) {
            return "success";
        } else {
            return "error";
        }
    }
}
