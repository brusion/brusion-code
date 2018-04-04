package com.demo.web;


import com.demo.cfg.ActionMapping;
import com.demo.cfg.ConfigurationManager;
import com.demo.cfg.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author brusion
 * @date 2018/4/1
 */
public class ServletAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("utf-8");
            ConfigurationManager configurationManager = new ConfigurationManager();
            Map<String, ActionMapping> configuration = configurationManager.getConfigurationMapping();

            String  uri= req.getRequestURI();
            String requestActon = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));

            ActionMapping actionMapping = configuration.get(requestActon);
            String className = actionMapping.getClassName();
            String method = actionMapping.getMethod();

            Class aClass = Class.forName(className);
            Object object = aClass.newInstance();

            Method actionMethod = aClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            String flag = (String) actionMethod.invoke(object, req, resp);

            Map<String, Result> results = actionMapping.getResults();
            Result result = results.get(flag);
            String page = result.getPage();
            String type = result.getType();
            if ("redirect".equals(type)){
                req.getRequestDispatcher(page).forward(req,resp);
            }else {
                resp.sendRedirect(req.getContextPath()+page);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
