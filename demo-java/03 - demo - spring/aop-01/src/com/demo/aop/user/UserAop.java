package com.demo.aop.user;

/**
 * 定义切面类
 *
 * @author brusion
 * @date 2018/4/19
 */
public class UserAop {

    public void beforeSay() {
        System.out.println("User aop before say ... ");
    }

    public void afterSay() {
        System.out.println("user aop after say ... ");
    }
}