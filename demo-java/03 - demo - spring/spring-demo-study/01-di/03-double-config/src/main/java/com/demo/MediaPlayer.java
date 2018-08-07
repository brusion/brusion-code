package com.demo;

import java.util.List;

/**
 * @author brusion
 * @date 2018/8/7
 */
public class MediaPlayer implements CompactDisc {

    private String title;
    private String desc;
    private List<String> list;

    public MediaPlayer(String title, String desc, List<String> list) {
        this.title = title;
        this.desc = desc;
        this.list = list;
    }


    public void play() {
        System.out.println("title : " + title);
        System.out.println("desc : " + desc);
        System.out.println();

        for (String data : list) {
            System.out.println(data);
        }
    }
}
