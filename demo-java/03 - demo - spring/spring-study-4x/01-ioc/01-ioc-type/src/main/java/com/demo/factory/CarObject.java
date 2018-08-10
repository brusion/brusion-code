package com.demo.factory;

/**
 * @author brusion
 * @date 2018/8/9
 */
public class CarObject {

    private String color;
    private String title;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CarObject{" +
                "color='" + color + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
