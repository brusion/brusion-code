package com.demo;

/**
 * @author brusion
 * @date 2018/8/10
 */
public class CarFactory {

    public CarObject getCar() {
        CarObject carObject = new CarObject();
        carObject.setDesc("宝马3");
        carObject.setTitle("灰色");
        return carObject;
    }
}
