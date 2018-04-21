package com.dmeo.singleton.bean;

/**
 * @author brusion
 * @date 2018/4/19
 */
public class BeanTest {

    public static void main(String[] args) {
        for (int x = 0; x < 10; x++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Bean bean = BeanUtils.getBean();
                    bean.say();

                }
            }).start();
        }
    }
}