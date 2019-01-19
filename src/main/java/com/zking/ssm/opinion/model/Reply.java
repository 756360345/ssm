package com.zking.ssm.opinion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@ToString
public class Reply implements Serializable{
    private Integer repid;

    private String repname;

    private String repdw;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date caidate;

    private String rephfnr;

    private String repdworr;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date repdate;

    public Reply(Integer repid, String repname, String repdw, Date caidate, String rephfnr, String repdworr, Date repdate) {
        this.repid = repid;
        this.repname = repname;
        this.repdw = repdw;
        this.caidate = caidate;
        this.rephfnr = rephfnr;
        this.repdworr = repdworr;
        this.repdate = repdate;
    }

    public Reply() {
        super();
    }

    public Integer getRepid() {
        return repid;
    }

    public void setRepid(Integer repid) {
        this.repid = repid;
    }

    public String getRepname() {
        return repname;
    }

    public void setRepname(String repname) {
        this.repname = repname;
    }

    public String getRepdw() {
        return repdw;
    }

    public void setRepdw(String repdw) {
        this.repdw = repdw;
    }

    public Date getCaidate() {
        return caidate;
    }

    public void setCaidate(Date caidate) {
        this.caidate = caidate;
    }

    public String getRephfnr() {
        return rephfnr;
    }

    public void setRephfnr(String rephfnr) {
        this.rephfnr = rephfnr;
    }

    public String getRepdworr() {
        return repdworr;
    }

    public void setRepdworr(String repdworr) {
        this.repdworr = repdworr;
    }

    public Date getRepdate() {
        return repdate;
    }

    public void setRepdate(Date repdate) {
        this.repdate = repdate;
    }
}