package com.demo;

/**
 * @author brusion
 * @date 2018/8/10
 */
public class CarObject {

    private String title;
    private String desc;

    public void getData() {
        System.out.println( "CarObject{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}');
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
