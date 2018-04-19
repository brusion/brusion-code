package com.dmeo.singleton.user;

/**
 * 线程不安全单例
 *
 * @author brusion
 * @date 2018/4/19
 */
public class UserNot {
    private static UserNot userNot = null;

    private UserNot() {
    }

    public static UserNot getUserNot() {
        if (userNot == null) {          //线程不安全：采用加锁实现
            userNot = new UserNot();
        }
        return userNot;
    }
}