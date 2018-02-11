package com.demo.ioc;

import org.springframework.context.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring的ioc容器
 *
 * @author brusion
 * @date 2018/2/11
 */
public class DemoTest {

    @Test
    public void getBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Bean bean = (Bean) context.getBean("bean");
        bean.test();
    }
}