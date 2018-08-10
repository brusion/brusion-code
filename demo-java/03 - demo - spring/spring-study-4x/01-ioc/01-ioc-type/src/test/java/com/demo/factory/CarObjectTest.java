package com.demo.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author brusion
 * @date 2018/8/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/factory_car.xml"})
public class CarObjectTest {

    @Autowired
    private CarObject car;

    @Autowired
    private CarObject newCar;


    @Test
    public void getBean() {
        System.out.println(car.toString());
    }

    @Test
    public void newCar() {
        System.out.println(newCar.toString());
    }
}