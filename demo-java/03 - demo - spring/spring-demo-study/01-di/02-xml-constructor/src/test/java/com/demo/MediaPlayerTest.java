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
public class MediaPlayerTest {


    @Autowired
    private MediaPlayer mediaPlayer;
    @Autowired
    private MediaPlayer mediaPlayer_c;
    @Autowired
    private MediaPlayer mediaPlayer_0;

    @Test
    public void getMediaPlayer() {
        mediaPlayer.play();
        mediaPlayer_0.play();
        mediaPlayer_c.play();
    }
}