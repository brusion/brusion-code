package com.demo.constructor;

/**
 * @author brusion
 * @date 2018/8/9
 */
public class ConstructorObject {

    private String desc;
    private String title;
    private int size;

    public ConstructorObject(String desc, int size) {
        this.desc = desc;
        this.size = size;
    }

    public ConstructorObject(String desc, String title, int size) {
        this.desc = desc;
        this.title = title;
        this.size = size;
    }

    public void getData() {
        System.out.println("ConstructorObject{" +
                "desc='" + desc + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                '}');
    }
}
