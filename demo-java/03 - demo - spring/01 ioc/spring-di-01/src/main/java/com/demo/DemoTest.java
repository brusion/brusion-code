package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * di构造器注入
 *
 * @author brusion
 * @date 2018/2/11
 */
public class DemoTest {

    @Test
    public void test(){
        BeanFactory factory = new ClassPathXmlApplicationContext("bean.xml");
        BeanApi index = (BeanApi) factory.getBean("byIndex",BeanApi.class);
        index.test();

        BeanApi type = (BeanApi) factory.getBean("byType",BeanApi.class);
        type.test();

        BeanApi name = (BeanApi) factory.getBean("byName",BeanApi.class);
        name.test();

    }
}
