package com.demo.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC容器就是bean包中的BeanFactory
 *
 * @author brusion
 * @date 2018/4/16
 */
public class BeanTest {

    @Test
    public void sayHello() {
        //简单使用ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Bean bean = (Bean) context.getBean("bean");
        bean.sayHello();
    }

    @Test
    public void getBean() {
        //使用不同方式获取到实体对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        Bean byName = (Bean) context.getBean("byName");
        Bean byClass = context.getBean(Bean.class);

        byClass.sayHello();
//        byName.sayHello();
    }

    @Test
    public void getTestData() {
        //使用构造器方式创建实体
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BeanData dataBean = (BeanData) context.getBean("dataBean");
        dataBean.getData();
    }

    @Test
    public void getStaticFactory() {
        //使用静态工厂类方式创建实体
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BeanData dataBean = (BeanData) context.getBean("staticFactory");
        dataBean.getData();
    }
}