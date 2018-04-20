package com.demo.di;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class BeanSetter implements BeanApi {

    private String message;
    private String index;

    @Override
    public void say() {
        System.out.println(index + " : " + message);
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}