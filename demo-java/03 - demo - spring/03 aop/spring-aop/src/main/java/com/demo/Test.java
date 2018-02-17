package com.demo;

/**
 * 测试类
 *
 * @author brusion
 * @date 2018/2/16
 */
public class Test {
    public static void main(String[] args) {
        getUserService();
    }

    public static void getUserService(){
        BeanFactory beanFactory = new BeanFactory();
        UserService userService = beanFactory.getUserService();
        userService.addUser();
        userService.deleteUser();
        userService.updateUser();

    }
}