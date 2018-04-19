package com.dmeo.singleton.emperor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 创建指定个数实体
 *
 * @author brusion
 * @date 2018/4/19
 */
public class Emperor {
    //创建最大数量
    private static int maxNum = 2;
    private static List<String> list = new ArrayList<>();
    private static List<Emperor> emperorList = new ArrayList<>();
    private static int index = 0;

    static {
        for (int x = 0; x < maxNum; x++) {
            emperorList.add(new Emperor(" 第 ：" + x + " 个 对象"));
        }
    }

    private Emperor() {
    }

    private Emperor(String name) {
        list.add(name);
    }

    public static Emperor getInstance() {
        Random random = new Random();
        index = random.nextInt(maxNum);
        return emperorList.get(index);
    }

    public void say() {
        System.out.println(list.get(index));
    }
}