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
    private MediaPlayer mediaPlay;

    @Autowired
    private MediaPlayer mediaPlay_ref;

    @Test
    public void getMedia(){
        mediaPlay.play();
    }

    @Test
    public void getMediaRef(){
        mediaPlay_ref.play();
    }

}