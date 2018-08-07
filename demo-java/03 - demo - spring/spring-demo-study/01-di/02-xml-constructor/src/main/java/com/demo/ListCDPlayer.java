package com.demo;

import java.util.List;

/**
 * @author brusion
 * @date 2018/8/7
 */
public class ListCDPlayer implements CompactDisc {

    private List<String> list;

    public ListCDPlayer(List<String> list) {
        this.list = list;
    }


    public void play() {
        for (String desc : list) {
            System.out.println(desc);
        }
    }
}
