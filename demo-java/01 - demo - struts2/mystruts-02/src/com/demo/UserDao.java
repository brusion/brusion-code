package com.demo;

/**
 * @author brusion
 * @date 2018/4/1
 */
public class UserDao {

    public void addUser(User user){

        if (user != null){
            System.out.println("user add Success");
        }
    }

    public User queryUser(User user){
        String name = user.getName();
        String pwd = user.getPwd();
        if ("test name".equals(name) && "123".equals(pwd)){
            return user;
        }else {
            return null;
        }

    }
}
