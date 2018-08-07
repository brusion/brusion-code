package com.demo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author brusion
 * @date 2018/8/7
 */
public class CarTest {

    public static Car initByDefaultConst() throws Exception {

        //得到ClassLoader对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //通过java全路径名称获取java实体对象
        Class aClass = loader.loadClass("com.demo.Car");
        //获取反射对
        Constructor constructor = aClass.getDeclaredConstructor(null);

        //通过构造函数实例化java对象
        Car car = (Car) constructor.newInstance();

        //通过类对象获取实体的setter方法
        Method setBrand = aClass.getMethod("setBrand", String.class);
        setBrand.invoke(car, "雷克萨斯 ES");
        Method setColor = aClass.getMethod("setColor", String.class);
        setColor.invoke(car, "银色");
        Method setMaxSpeed = aClass.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 300);
        return car;
    }

    @Test
    public void getCar() throws Exception {
        Car car = initByDefaultConst();
        car.getData();
    }
}