package com.best.consumer.controller;

import com.best.consumer.remote.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brusion
 * @date 2018/8/25
 */
@RestController
public class UserController {

    @Autowired
    private UserRemote userRemote;

    @RequestMapping("/consumer")
    public String indexTest() {
        return userRemote.index();
    }
}
