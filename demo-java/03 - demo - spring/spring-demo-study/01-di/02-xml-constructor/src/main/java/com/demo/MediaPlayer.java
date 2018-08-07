package com.demo;

/**
 * @author brusion
 * @date 2018/8/7
 */
public class MediaPlayer implements CompactDisc {

    private String title;
    private String desc;

    public MediaPlayer(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public void play() {
        System.out.println("paly " + title + "   " + desc);
    }

}
