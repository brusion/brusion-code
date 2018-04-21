package com.demo.ioc;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class StaticBeanFactory {
    public static BeanData newInstance(String data) {
        return new BeanData(data);
    }
}
