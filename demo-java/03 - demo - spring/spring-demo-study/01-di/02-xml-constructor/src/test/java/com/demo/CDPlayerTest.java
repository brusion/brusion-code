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
@ContextConfiguration({"file:src/main/resources/bean.xml"})
public class CDPlayerTest {

    @Autowired
    private CDPlayer cdPlayer;
    @Autowired
    private CDPlayer cdPlayer_c;
    @Autowired
    private CDPlayer cdPlayer_0;

    @Test
    public void getCDPlayer() {
        cdPlayer.play();
        cdPlayer_c.play();
        cdPlayer_0.play();
    }

}