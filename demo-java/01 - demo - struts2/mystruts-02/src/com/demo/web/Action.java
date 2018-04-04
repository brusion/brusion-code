package com.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义Action业务接口
 *
 * @author brusion
 * @date 2018/4/1
 */
public interface Action {

    String execute(HttpServletRequest req, HttpServletResponse resp);
}
