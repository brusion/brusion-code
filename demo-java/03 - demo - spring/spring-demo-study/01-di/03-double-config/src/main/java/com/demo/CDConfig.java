package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author brusion
 * @date 2018/8/7
 */
@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc() {
        return new SgtPepper();
    }
}
