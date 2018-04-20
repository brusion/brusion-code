package com.demo.di.constant;

import com.demo.di.listBean.ArrayBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注入常量数据
 *
 * @author brusion
 * @date 2018/4/16
 */
public class ConstantBeanTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    @Test
    public void getIntBean() {

        IntBean bean = (IntBean) getContext().getBean("intBean");
        bean.getData();
    }

    @Test
    public void getBoolean() {
        BooleanBean bean = (BooleanBean) getContext().getBean("booleanBean");
        bean.getData();
    }

    @Test
    public void getArrayData() {
        ArrayBean bean = (ArrayBean) getContext().getBean("arrayBean");
        bean.getArrayString();
    }

    public ApplicationContext getContext() {
        return context;
    }
}
