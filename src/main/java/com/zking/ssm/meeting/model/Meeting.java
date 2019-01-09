package com.zking.ssm.meeting.model;

import java.util.Date;

public class Meeting {
    private String meeid;

    private String meename;

    private String meezt;

    private String meecc;


    private String meecbz;

    private Date meezksj;

    private String meeaddress;

    private String meecjry;

    private String meelxr;

    private String meetel;

    private Integer meebmrs;

    public Meeting(String meeid, String meename, String meezt, String meecc,  String meecbz, Date meezksj, String meeaddress, String meecjry, String meelxr, String meetel, Integer meebmrs) {
        this.meeid = meeid;
        this.meename = meename;
        this.meezt = meezt;
        this.meecc = meecc;

        this.meecbz = meecbz;
        this.meezksj = meezksj;
        this.meeaddress = meeaddress;
        this.meecjry = meecjry;
        this.meelxr = meelxr;
        this.meetel = meetel;
        this.meebmrs = meebmrs;
    }

    public Meeting() {
        super();
    }

    public String getMeeid() {
        return meeid;
    }

    public void setMeeid(String meeid) {
        this.meeid = meeid;
    }

    public String getMeename() {
        return meename;
    }

    public void setMeename(String meename) {
        this.meename = meename;
    }

    public String getMeezt() {
        return meezt;
    }

    public void setMeezt(String meezt) {
        this.meezt = meezt;
    }

    public String getMeecc() {
        return meecc;
    }

    public void setMeecc(String meecc) {
        this.meecc = meecc;
    }



    public String getMeecbz() {
        return meecbz;
    }

    public void setMeecbz(String meecbz) {
        this.meecbz = meecbz;
    }

    public Date getMeezksj() {
        return meezksj;
    }

    public void setMeezksj(Date meezksj) {
        this.meezksj = meezksj;
    }

    public String getMeeaddress() {
        return meeaddress;
    }

    public void setMeeaddress(String meeaddress) {
        this.meeaddress = meeaddress;
    }

    public String getMeecjry() {
        return meecjry;
    }

    public void setMeecjry(String meecjry) {
        this.meecjry = meecjry;
    }

    public String getMeelxr() {
        return meelxr;
    }

    public void setMeelxr(String meelxr) {
        this.meelxr = meelxr;
    }

    public String getMeetel() {
        return meetel;
    }

    public void setMeetel(String meetel) {
        this.meetel = meetel;
    }

    public Integer getMeebmrs() {
        return meebmrs;
    }

    public void setMeebmrs(Integer meebmrs) {
        this.meebmrs = meebmrs;
    }
}