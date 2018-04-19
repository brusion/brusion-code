package com.dmeo.singleton.bean;

/**
 * 简单实体对象
 *
 * @author brusion
 * @date 2018/4/19
 */
public class Bean {

    public void say() {
        System.out.println("bean say  && hashCode: " + Bean.class.hashCode());
    }
}
