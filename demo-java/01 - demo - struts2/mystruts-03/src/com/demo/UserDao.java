package com.demo;

/**
 * @author brusion
 * @date 2018/4/1
 */
public class UserDao {

    public void addUser(User user) {
        System.out.println(user.toString());
    }

    public User queryUser(User user) {
        String pwd = user.getPwd();
        String name = user.getName();
        if ("test".equals(name) && "123".equals(pwd)) {
            return user;
        }
        return null;
    }
}
