package com.demo.di.listBean;

import java.util.Set;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class SetBean {
    private Set<String> setData;

    public void getSetBean() {
        for (String string : setData) {
            System.out.print(string + "   ");
        }
    }

    public void setSetData(Set<String> setData) {
        this.setData = setData;
    }
}