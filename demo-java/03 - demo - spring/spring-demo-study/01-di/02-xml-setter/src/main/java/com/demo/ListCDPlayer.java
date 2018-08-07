package com.demo;

import java.util.List;

/**
 * @author brusion
 * @date 2018/8/7
 */
public class ListCDPlayer implements CompactDisc {

    private List<String> list;

    public void play() {
        for (String data : list) {
            System.out.println(data);
        }
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
