package com.dmeo.singleton.student;

/**
 * 定义单例对象
 *
 * @author brusion
 * @date 2018/4/19
 */
public class Student {
    private static final Student student = new Student();

    private Student() {
    }

    public static Student getInstance() {
        return student;
    }

    public void say() {
        System.out.println("student say say ");
    }
}