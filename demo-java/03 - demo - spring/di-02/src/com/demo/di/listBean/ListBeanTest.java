package com.demo.di.listBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注入集合数据
 *
 * @author brusion
 * @date 2018/4/16
 */
public class ListBeanTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    @Test
    public void getListData() {
        ListBean bean = (ListBean) getContext().getBean("listBean");
        bean.getListData();
    }

    @Test
    public void geSetData() {
        SetBean bean = (SetBean) getContext().getBean("setBean");
        bean.getSetBean();
    }

    @Test
    public void getMapData(){
        MapBean bean = (MapBean) getContext().getBean("mapBean");
        bean.getMapData();
    }

    public ApplicationContext getContext() {
        return context;
    }
}