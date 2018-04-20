package com.demo.aop.bean;

/**
 * @author brusion
 * @date 2018/4/20
 */
public class BeanServiceImp implements BeanService {
    @Override
    public void say() {
        System.out.println("bean service say ... ... ");
    }
}
