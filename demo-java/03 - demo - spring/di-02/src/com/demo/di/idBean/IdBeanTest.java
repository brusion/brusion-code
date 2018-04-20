package com.demo.di.idBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过BeanId的方式注入数据
 *
 * @author brusion
 * @date 2018/4/16
 */
public class IdBeanTest {

    @Test
    public void getIdBean1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        IdBean bean = (IdBean) context.getBean("idBean");
        bean.getIdData();
    }
}
