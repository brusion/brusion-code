package com.demo.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注入数据的几种方式
 *
 * @author brusion
 * @date 2018/4/16
 */
public class BeanTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    @Test
    public void getBeanById() {
        ApplicationContext context = getContext();
        Bean bean = (Bean) context.getBean("byId");
        bean.say();
    }

    @Test
    public void getBeanByType() {
        ApplicationContext context = getContext();
        Bean bean = (Bean) context.getBean("byType");
        bean.say();
    }

    @Test
    public void getBeanByName() {
        ApplicationContext context = getContext();
        Bean bean = (Bean) context.getBean("byName");
        bean.say();
    }

    @Test
    public void getBeanByFactory() {
        ApplicationContext context = getContext();
        Bean bean = (Bean) context.getBean("byFactory");
        bean.say();
    }

    @Test
    public void getBeanBySetter() {
        ApplicationContext context = getContext();
        BeanSetter bean = (BeanSetter) context.getBean("bySetter");
        bean.say();
    }

    public ApplicationContext getContext() {
        return context;
    }
}