package com.zking.ssm.system.model;

import lombok.ToString;

import java.io.Serializable;
@ToString
public class Module implements Serializable{
    private String id;

    private String pid;

    private String mText;

    private String url;

    public Module(String id, String pid, String mText, String url) {
        this.id = id;
        this.pid = pid;
        this.mText = mText;
        this.url = url;
    }

    public Module() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}