package com.demo;

/**
 * 切面类，执行固定操作方法
 *
 * @author brusion
 * @date 2018/2/16
 */
public class MyAspect {

    public void befor(){
        System.out.println("befor method");
    }

    public void after(){
        System.out.println("after  method");
    }
}