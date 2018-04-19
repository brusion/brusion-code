package com.dmeo.singleton.emperor;

/**
 * 定义创建指定个数实体
 *
 * @author brusion
 * @date 2018/4/19
 */
public class EmperorTest {

    public static void main(String[] args) {
        for (int x = 0; x < 5; x++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
        }
    }
}
