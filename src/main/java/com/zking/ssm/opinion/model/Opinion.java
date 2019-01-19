package com.zking.ssm.opinion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@ToString
public class Opinion implements Serializable{
    private Integer opid;

    private String oplgbt;

    private Integer userid;

    private String opltype;

    private String opdwtype;


    private String oplgrordw;

    private String optel;

    private String opbsrsf;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date opbssj;

    private String opbsr;

    private String opqfld;

    private String pub;

    private String opjtnr;

    private String fileid;

    private Integer proid;

    private String optjr;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date optjtime;

    private String start;
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }



    public Opinion() {
        super();
    }

    public Integer getOpid() {
        return opid;
    }

    public void setOpid(Integer opid) {
        this.opid = opid;
    }

    public String getOplgbt() {
        return oplgbt;
    }

    public void setOplgbt(String oplgbt) {
        this.oplgbt = oplgbt;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOpltype() {
        return opltype;
    }

    public void setOpltype(String opltype) {
        this.opltype = opltype;
    }

    public String getOpdwtype() {
        return opdwtype;
    }

    public void setOpdwtype(String opdwtype) {
        this.opdwtype = opdwtype;
    }

    public Opinion(Integer opid, String oplgbt, Integer userid, String opltype, String opdwtype, String oplgrordw, String optel, String opbsrsf, Date opbssj, String opbsr, String opqfld, String pub, String opjtnr, String fileid, Integer proid, String optjr, Date optjtime, String start, String end) {

        this.opid = opid;
        this.oplgbt = oplgbt;
        this.userid = userid;
        this.opltype = opltype;
        this.opdwtype = opdwtype;
        this.oplgrordw = oplgrordw;
        this.optel = optel;
        this.opbsrsf = opbsrsf;
        this.opbssj = opbssj;
        this.opbsr = opbsr;
        this.opqfld = opqfld;
        this.pub = pub;
        this.opjtnr = opjtnr;
        this.fileid = fileid;
        this.proid = proid;
        this.optjr = optjr;
        this.optjtime = optjtime;
        this.start = start;
        this.end = end;
    }

    public String getOplgrordw() {
        return oplgrordw;
    }

    public void setOplgrordw(String oplgrordw) {
        this.oplgrordw = oplgrordw;
    }

    public String getOptel() {
        return optel;
    }

    public void setOptel(String optel) {
        this.optel = optel;
    }

    public String getOpbsrsf() {
        return opbsrsf;
    }

    public void setOpbsrsf(String opbsrsf) {
        this.opbsrsf = opbsrsf;
    }

    public Date getOpbssj() {
        return opbssj;
    }

    public void setOpbssj(Date opbssj) {
        this.opbssj = opbssj;
    }

    public String getOpbsr() {
        return opbsr;
    }

    public void setOpbsr(String opbsr) {
        this.opbsr = opbsr;
    }

    public String getOpqfld() {
        return opqfld;
    }

    public void setOpqfld(String opqfld) {
        this.opqfld = opqfld;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getOpjtnr() {
        return opjtnr;
    }

    public void setOpjtnr(String opjtnr) {
        this.opjtnr = opjtnr;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getOptjr() {
        return optjr;
    }

    public void setOptjr(String optjr) {
        this.optjr = optjr;
    }

    public Date getOptjtime() {
        return optjtime;
    }

    public void setOptjtime(Date optjtime) {
        this.optjtime = optjtime;
    }
}