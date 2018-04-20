package com.demo.di.listBean;

/**
 * 数组数据注入
 *
 * @author brusion
 * @date 2018/4/16
 */
public class ArrayBean {
    private String[] array;
    private String[][] arrayData;

    public void getArrayString() {
        System.out.print(" string[] array data :  ");
        for (String string : array) {
            System.out.print("   " + string);
        }

        System.out.println();
        System.out.println(" string[][] array data :  ");
        for (String[] arr : arrayData) {
            for (String string : arr) {
                System.out.print("   " + string);
            }
            System.out.println();
        }
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setArrayData(String[][] arrayData) {
        this.arrayData = arrayData;
    }
}
