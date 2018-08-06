package com.demo;

import org.springframework.stereotype.Component;

/**
 * @author brusion
 * @date 2018/8/6
 */
@Component
public class SgtPepper implements CompactDisc {
    public void play() {
        System.out.println(" sgt-pepper play ... ... ");
    }
}
