package com.demo.di.listBean;

import java.util.Map;

/**
 * 注入map数据
 *
 * @author brusion
 * @date 2018/4/16
 */
public class MapBean {
    private Map<String, String> mapData;

    public void getMapData() {
        System.out.println(" map bean data ");
        for (String string : mapData.keySet()) {
            String data = mapData.get(string);
            System.out.println(string + "  " + data);
        }
    }

    public void setMapData(Map<String, String> mapData) {
        this.mapData = mapData;
    }
}