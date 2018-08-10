package com.demo.setter;

/**
 * @author brusion
 * @date 2018/8/9
 */
public class SetterObject {

    private String color;
    private int size;

    public void getData() {
        System.out.println("SetterObject{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}');
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
