package com.dmeo.singleton.student;

/**
 * 单例设计模式
 *
 * @author brusion
 * @date 2018/4/19
 */
public class StudentTest {

    public static void main(String[] args) {
        for (int x = 0; x < 4; x++) {
            Student student = Student.getInstance();
            student.say();
        }
    }
}