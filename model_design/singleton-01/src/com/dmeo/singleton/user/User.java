package com.dmeo.singleton.user;

/**
 * 对象实现克隆接口
 *
 * @author brusion
 * @date 2018/4/19
 */
public class User implements Cloneable {

    private static final User user = new User();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static User getUser() {
        return user;
    }

    public void say(){
        System.out.println("say say ");
    }
}