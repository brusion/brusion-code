package com.demo.ioc;

/**
 * 定义带参构造方法用于在xml中添加数据
 *
 * @author brusion
 * @date 2018/4/16
 */
public class BeanData {
    private String data;

    public BeanData(String data) {
        this.data = data;
    }

    public void getData() {
        System.out.println("get data:" + data);
    }
}