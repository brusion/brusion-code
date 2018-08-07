package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author brusion
 * @date 2018/8/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDConfig.class)
public class CDPlayerTest {

    @Autowired
    private CDConfig cdConfig;

    @Test
    public void getBean() {
        CompactDisc compactDisc = cdConfig.sgtPepper();
        compactDisc.play();
    }

    @Test
    public void getCDPlayer(){
        CDPlayer cdPlayer = cdConfig.cdPlayer();
        cdPlayer.play();
    }

    @Test
    public void equalsBean() {
        CompactDisc compactDisc = cdConfig.sgtPepper();
        CDPlayer cdPlayer = cdConfig.anotherPlayer();
        CompactDisc compactDisc1 = cdPlayer.getCompactDisc();
        if (compactDisc.equals(compactDisc1)) {
            System.out.println("对象相等");
        }
    }

    @Test
    public void equalsCDPlayer() {
        CDPlayer cdPlayer = cdConfig.cdPlayer(cdConfig.sgtPepper());
        CompactDisc compactDisc = cdPlayer.getCompactDisc();
        cdPlayer.play();

        CDPlayer cdPlayer1 = cdConfig.cdPlayer();
        CompactDisc compactDisc1 = cdPlayer1.getCompactDisc();
        cdPlayer1.play();
        if (compactDisc.equals(compactDisc1)) {
            System.out.println("对象相等");
        }
    }

}