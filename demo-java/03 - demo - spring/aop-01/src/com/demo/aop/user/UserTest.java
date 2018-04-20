package com.demo.aop.user;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 *
 * @author brusion
 * @date 2018/4/19
 */
public class UserTest {

    @Test
    public void getUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService service = (UserService) context.getBean("user");
        service.say();
    }
}