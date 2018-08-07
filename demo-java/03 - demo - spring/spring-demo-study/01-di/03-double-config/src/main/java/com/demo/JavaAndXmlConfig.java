package com.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author brusion
 * @date 2018/8/7
 */
@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:bean.xml")
public class JavaAndXmlConfig {
}
