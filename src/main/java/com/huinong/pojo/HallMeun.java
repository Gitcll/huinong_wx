package com.huinong.pojo;

public class HallMeun {
    private Integer no;

    private String meunname;

    private Integer deleteflg;

    private String meunurl;

    private byte[] meunimage;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getMeunname() {
        return meunname;
    }

    public void setMeunname(String meunname) {
        this.meunname = meunname == null ? null : meunname.trim();
    }

    public Integer getDeleteflg() {
        return deleteflg;
    }

    public void setDeleteflg(Integer deleteflg) {
        this.deleteflg = deleteflg;
    }

    public String getMeunurl() {
        return meunurl;
    }

    public void setMeunurl(String meunurl) {
        this.meunurl = meunurl == null ? null : meunurl.trim();
    }

    public byte[] getMeunimage() {
        return meunimage;
    }

    public void setMeunimage(byte[] meunimage) {
        this.meunimage = meunimage;
    }
}