package com.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author brusion
 * @date 2018/8/7
 */
@Configuration
@Import({CDConfig.class, CDPlayerConfig.class})
public class SystemConfig {
}
