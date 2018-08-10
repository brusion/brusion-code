package com.demo;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author brusion
 * @date 2018/8/10
 */
public class CarShop implements MethodReplacer {
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        CarObject carObject = new CarObject();
        carObject.setTitle("奔驰");
        carObject.setDesc("黑色");
        return carObject;
    }
}
