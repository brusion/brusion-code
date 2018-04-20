package com.demo.di;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class BeanFactory {
    public static Bean getBean(String message, int index) {
        return new Bean(message, index);
    }
}