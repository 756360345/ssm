package com.zking.ssm.opinion.model;

import lombok.ToString;

import java.io.Serializable;
@ToString
public class File implements Serializable{
//文件ID
    private Integer fileid;
    //提案词
    private String filename;
    //附件1
    private String filename1;
    //附件2
    private String filename2;
    //附件3
    private String filename3;

    public File(Integer fileid, String filename, String filename1, String filename2, String filename3) {
        this.fileid = fileid;
        this.filename = filename;
        this.filename1 = filename1;
        this.filename2 = filename2;
        this.filename3 = filename3;
    }

    public File() {
        super();
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename1() {
        return filename1;
    }

    public void setFilename1(String filename1) {
        this.filename1 = filename1;
    }

    public String getFilename2() {
        return filename2;
    }

    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    public String getFilename3() {
        return filename3;
    }

    public void setFilename3(String filename3) {
        this.filename3 = filename3;
    }
}