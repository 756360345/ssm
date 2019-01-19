package com.zking.ssm.system.model;

public class User {
    private Integer uid;

    private String uname;
    private String realname;

    private String password;

    public User(Integer uid, String uname, String realname, String password) {
        this.uid = uid;
        this.uname = uname;
        this.realname = realname;
        this.password = password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        super();
    }
}