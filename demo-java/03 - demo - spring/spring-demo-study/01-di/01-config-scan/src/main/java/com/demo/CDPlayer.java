package com.demo;

import org.springframework.stereotype.Component;

/**
 * @author brusion
 * @date 2018/8/6
 */
@Component
public class CDPlayer implements CompactDisc {

    public void play() {
        System.out.println("CD-Player  playing ... ... ");
    }
}
