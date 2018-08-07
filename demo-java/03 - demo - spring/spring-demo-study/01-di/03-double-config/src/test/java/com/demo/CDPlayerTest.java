package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author brusion
 * @date 2018/8/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CDPlayerConfig cdPlayerConfig;
    @Autowired
    private CDConfig cdConfig;

    @Test
    public void getBean() {
        CompactDisc compactDisc = cdConfig.compactDisc();
        CDPlayer cdPlayer = cdPlayerConfig.cdPlayer(compactDisc);
        cdPlayer.play();
    }

}