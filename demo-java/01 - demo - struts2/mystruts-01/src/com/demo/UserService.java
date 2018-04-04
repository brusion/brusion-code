package com.demo;

/**
 * @author brusion
 * @date 2018/4/1
 */
public class UserService {

    private final UserDao userDao;

    public UserService (){
        userDao = new UserDao();
    }

    public void register(User user){
        userDao.addUser(user);
    }

    public User login(User user){
        return userDao.queryUser(user);
    }
}