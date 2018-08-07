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
public class ListCDPlayerTest {

    @Autowired
    private ListCDPlayer listCDPlayer;
    @Autowired
    private ListCDPlayer listCDPlayer_ref;
    @Autowired
    private ListCDPlayer listCDPlayer_util;

    @Test
    public void getList(){
        listCDPlayer.play();
    }

    @Test
    public void getListRef(){
        listCDPlayer_ref.play();
    }

    @Test
    public void getUtil(){
        listCDPlayer_util.play();
    }
}