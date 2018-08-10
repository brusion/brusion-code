package com.demo.factory;

/**
 * @author brusion
 * @date 2018/8/9
 */
public class CarFactory {

    public CarObject createCar() {
        CarObject carObject = new CarObject();
        carObject.setColor("银灰色");
        carObject.setTitle("雷克萨斯");
        return carObject;
    }

    public static CarObject newCar() {
        CarObject carObject = new CarObject();
        carObject.setColor("银灰色");
        carObject.setTitle("雷克萨斯");
        return carObject;
    }
}
