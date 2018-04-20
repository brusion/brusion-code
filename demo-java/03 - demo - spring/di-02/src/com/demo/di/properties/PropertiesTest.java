package com.demo.di.properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class PropertiesTest {

    @Test
    public void getData(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        PropertiesBean bean = (PropertiesBean) context.getBean("proBean");
        bean.getData();
    }
}
