package com.dmeo.singleton.user;

/**
 * @author brusion
 * @date 2018/4/19
 */
public class UserTest {

    public static void main(String[] args) {
        try {

            User user = (User) User.getUser().clone();
            user.say();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
