package com.zking.ssm.dict.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Dict implements Serializable{
    private Integer dicid;

    private String dicname;

    private String dictype;

    private String dicvalue;

    public Dict(Integer dicid, String dicname, String dictype, String dicvalue) {
        this.dicid = dicid;
        this.dicname = dicname;
        this.dictype = dictype;
        this.dicvalue = dicvalue;
    }

    public Dict() {
        super();
    }

    public Integer getDicid() {
        return dicid;
    }

    public void setDicid(Integer dicid) {
        this.dicid = dicid;
    }

    public String getDicname() {
        return dicname;
    }

    public void setDicname(String dicname) {
        this.dicname = dicname;
    }

    public String getDictype() {
        return dictype;
    }

    public void setDictype(String dictype) {
        this.dictype = dictype;
    }

    public String getDicvalue() {
        return dicvalue;
    }

    public void setDicvalue(String dicvalue) {
        this.dicvalue = dicvalue;
    }
}