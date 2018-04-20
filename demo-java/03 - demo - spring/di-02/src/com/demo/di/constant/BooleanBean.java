package com.demo.di.constant;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class BooleanBean {
    private boolean showData;

    public void getData() {
        System.out.println("the boolean constant showData is :" + showData);
    }

    public void setShowData(boolean showData) {
        this.showData = showData;
    }
}