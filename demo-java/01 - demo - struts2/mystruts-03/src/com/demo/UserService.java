package com.demo;

/**
 * @author brusion
 * @date 2018/4/1
 */
public class UserService {

    private final UserDao dao;

    public UserService (){
        dao = new UserDao();
    }

    public void regiester(User user){
        dao.addUser(user);
    }

    public User login(User user){
        return dao.queryUser(user);
    }
}
