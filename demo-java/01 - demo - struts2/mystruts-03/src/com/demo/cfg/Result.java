package com.demo.cfg;

/**
 * 配置文件中的result标签属性
 *
 * @author brusion
 * @date 2018/4/1
 */
public class Result {

    private String name;
    private String type;
    private String page;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", page='" + page + '\'' +
                '}';
    }
}
