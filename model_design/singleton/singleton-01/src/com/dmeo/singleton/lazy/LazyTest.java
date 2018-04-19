package com.dmeo.singleton.lazy;

/**
 * @author brusion
 * @date 2018/4/19
 */
public class LazyTest {

    public static void main(String[] args) {
        getLazy();

    }

    private static void getLazy() {
        for (int x =0; x <8; x++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LazyObject object = LazyObject.getInstance();
                    System.out.println(object.hashCode());
                }
            }).start();
        }
    }
}
