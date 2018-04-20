package com.demo.di.listBean;

import java.util.List;

/**
 * 注入List集合
 *
 * @author brusion
 * @date 2018/4/16
 */
public class ListBean {

    private List<String> list;

    public void getListData() {
        System.out.print(" list data is:  ");
        for (String string : list) {
            System.out.print("   " + string);
        }
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}