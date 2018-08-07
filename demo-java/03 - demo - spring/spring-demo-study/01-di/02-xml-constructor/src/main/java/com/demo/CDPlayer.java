package com.demo;

/**
 * @author brusion
 * @date 2018/8/7
 */
public class CDPlayer {

    private CompactDisc compactDisc;

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }

}
