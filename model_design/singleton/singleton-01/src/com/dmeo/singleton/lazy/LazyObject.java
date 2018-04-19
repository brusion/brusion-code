package com.dmeo.singleton.lazy;

/**
 * 懒加载方式:非线程安全
 *
 * @author brusion
 * @date 2018/4/19
 */
public class LazyObject {

    private static LazyObject INSTANCE;

    private LazyObject() {
    }

    public static LazyObject getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyObject();
        }
        return INSTANCE;
    }
}