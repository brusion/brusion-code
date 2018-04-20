package com.demo.di;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class Bean implements BeanApi {
    private int index;
    private String message;

    public Bean(String message, int index) {
        this.index = index;
        this.message = message;
    }

    @Override
    public void say() {
        System.out.println(index + " : " + message);
    }
}