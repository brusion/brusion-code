package com.demo.di.idBean;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class IdBean {
    private String id;

    public String getId() {
        return id;
    }

    public void getIdData() {
        System.out.println("the id data is :" + id);
    }

    public void setId(String id) {
        this.id = id;
    }
}