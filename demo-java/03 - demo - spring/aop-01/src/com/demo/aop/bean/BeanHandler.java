package com.demo.aop.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理核心类
 * jdk通过传入object生成代理对象，在代理对象方法执行前添加了调用方法
 *
 * @author brusion
 * @date 2018/4/20
 */
public class BeanHandler implements InvocationHandler {
    private Object object;

    public BeanHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过反射方式在代理方法执行前先做操作

        System.out.println("before method 。。。。");

        Object invoke = method.invoke(object, args);

        System.out.println("after method 。。。。");

        return invoke;
    }

    //获取代理对象
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                object.getClass().getInterfaces(), this);
    }
}