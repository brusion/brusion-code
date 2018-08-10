package com.demo.fore;

/**
 * @author brusion
 * @date 2018/8/9
 */
public class ForeObjectA {

    private String desc;
    private ForeObjectB foreObjectB;

    public ForeObjectA(String desc, ForeObjectB foreObjectB) {
        this.desc = desc;
        this.foreObjectB = foreObjectB;
    }

    public void getData() {
        System.out.println("ForeObjectA{" +
                "desc='" + desc + '\'' +
                ", foreObjectB=" + foreObjectB +
                '}');
    }
}
