package com.demo.web;

import com.demo.User;
import com.demo.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author brusion
 * @date 2018/4/1
 */
public class RegisterAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);

        UserService service = new UserService();
        service.register(user);
        return "redirect:/login.jsp";
    }
}
