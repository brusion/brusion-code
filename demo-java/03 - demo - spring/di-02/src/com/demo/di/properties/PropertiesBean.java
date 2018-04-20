package com.demo.di.properties;

import java.util.Properties;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class PropertiesBean {
    private Properties properties;

    public void getData() {
        System.out.println(properties.toString());
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}