package com.demo;

/**
 * @author brusion
 * @date 2018/8/7
 */
public class MediaPlayer implements CompactDisc {

    private String title;
    private String desc;

    public void play() {
        System.out.println("Media-player play" + title + " and " + desc);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
