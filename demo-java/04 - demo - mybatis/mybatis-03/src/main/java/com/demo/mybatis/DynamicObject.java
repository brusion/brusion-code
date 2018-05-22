package com.demo.mybatis;

/**
 * @author brusion
 * @date 2018/5/22
 */
public class DynamicObject {
    private Integer dynamicId;
    private String dynamicName;
    private String dynamicTitle;
    private String dynamicDesc;

    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getDynamicName() {
        return dynamicName;
    }

    public void setDynamicName(String dynamicName) {
        this.dynamicName = dynamicName;
    }

    public String getDynamicTitle() {
        return dynamicTitle;
    }

    public void setDynamicTitle(String dynamicTitle) {
        this.dynamicTitle = dynamicTitle;
    }

    public String getDynamicDesc() {
        return dynamicDesc;
    }

    public void setDynamicDesc(String dynamicDesc) {
        this.dynamicDesc = dynamicDesc;
    }

    @Override
    public String toString() {
        return "DynamicObject{" +
                "dynamicId=" + dynamicId +
                ", dynamicName='" + dynamicName + '\'' +
                ", dynamicTitle='" + dynamicTitle + '\'' +
                ", dynamicDesc='" + dynamicDesc + '\'' +
                '}';
    }
}
