package com.demo.aop.bean;

import org.junit.Test;

/**
 * 动态代理测试
 *
 * @author brusion
 * @date 2018/4/20
 */
public class BeanTest {

    @Test
    public void getBean() {
        BeanService service = new BeanServiceImp();
        BeanHandler handler = new BeanHandler(service);
        BeanService beanService = (BeanService) handler.getProxy();
        beanService.say();
    }
}