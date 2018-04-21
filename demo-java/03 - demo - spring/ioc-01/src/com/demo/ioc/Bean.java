package com.demo.ioc;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class Bean implements BeanApi {

    @Override
    public void sayHello() {
        System.out.println("hello spring");
    }
}