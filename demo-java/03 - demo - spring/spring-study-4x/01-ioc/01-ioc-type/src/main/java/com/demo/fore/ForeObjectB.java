package com.demo.fore;

/**
 * @author brusion
 * @date 2018/8/9
 */
public class ForeObjectB {

    private String title;
    private ForeObjectA foreObjectA;

    public ForeObjectB(String title, ForeObjectA foreObjectA) {
        this.title = title;
        this.foreObjectA = foreObjectA;
    }

    public void getData() {
        System.out.println( "ForeObjectB{" +
                "title='" + title + '\'' +
                ", foreObjectA=" + foreObjectA +
                '}');
    }
}
