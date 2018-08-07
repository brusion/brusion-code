package com.demo;

/**
 * @author brusion
 * @date 2018/8/7
 */
public class CDPlayer {

    private CompactDisc compactDisc;

    public void play() {
        compactDisc.play();
    }

    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }
}