package com.demo;

/**
 * @author brusion
 * @date 2018/2/11
 */
public class BeanApi {

    private String message;
    private int index;

    public BeanApi(){
    }

    public BeanApi(String message, int index){
        this.message = message;
        this.index = index;
    }

    public void  test(){
        System.out.println("beanApi test method   :"+ message+" --- "+index);
    }
}