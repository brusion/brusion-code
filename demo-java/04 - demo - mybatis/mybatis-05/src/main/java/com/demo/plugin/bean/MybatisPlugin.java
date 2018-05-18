package com.demo.plugin.bean;

public class MybatisPlugin {
    private Integer pluginId;

    private String pluginName;

    private String pluginAddress;

    private String pluginTitle;

    public Integer getPluginId() {
        return pluginId;
    }

    public void setPluginId(Integer pluginId) {
        this.pluginId = pluginId;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName == null ? null : pluginName.trim();
    }

    public String getPluginAddress() {
        return pluginAddress;
    }

    public void setPluginAddress(String pluginAddress) {
        this.pluginAddress = pluginAddress == null ? null : pluginAddress.trim();
    }

    public String getPluginTitle() {
        return pluginTitle;
    }

    public void setPluginTitle(String pluginTitle) {
        this.pluginTitle = pluginTitle == null ? null : pluginTitle.trim();
    }
}