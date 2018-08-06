package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author brusion
 * @date 2018/8/6
 */
@Configuration
public class CDConfig {

    @Bean
    public CompactDisc sgtPepper() {
        return new SgtPepper();
    }

    @Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPepper());
    }

    @Bean
    public CDPlayer anotherPlayer() {
        return new CDPlayer(sgtPepper());
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }


    @Bean
    public CDPlayer anotherPlayer(CompactDisc compactDisc) {
        CDPlayer cdPlayer = new CDPlayer(compactDisc);
        cdPlayer.setCompactDisc(compactDisc);
        return cdPlayer;
    }

}
