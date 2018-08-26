package com.best.provide.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brusion
 * @date 2018/8/25
 */
@RestController
public class UserController {

    @RequestMapping("/index")
    public String index() {
        return " index data ： " + getClass().toString();
    }

}
