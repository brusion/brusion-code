package com.demo.di.constant;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class IntBean {

    private int index;
    private String message;

    public void getData() {
        System.out.println(index + " : " + message);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}