package com.demo.cfg;

import java.util.Map;

/**
 * 配置文件中的Action标签
 *
 * @author brusion
 * @date 2018/4/1
 */
public class ActionMapping {
    private String name;
    private String className;
    private String method;
    private Map<String, Result> results;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Result> getResults() {
        return results;
    }

    public void setResults(Map<String, Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ActionMapping{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", method='" + method + '\'' +
                ", results=" + results +
                '}';
    }
}
