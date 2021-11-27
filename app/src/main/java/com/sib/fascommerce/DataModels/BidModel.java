package com.sib.fascommerce.DataModels;

public class BidModel {
    private int tk,point;
    private String pNumber,email,name,url,pId,uid,hasBid;

    public BidModel() {
    }

    public String getHasBid() {
        return hasBid;
    }

    public void setHasBid(String hasBid) {
        this.hasBid = hasBid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public BidModel(int tk, int point, String pNumber, String email, String name, String url, String uid, String pId,String hasBid) {
        this.tk = tk;
        this.point = point;
        this.pNumber = pNumber;
        this.email = email;
        this.name = name;
        this.url = url;
        this.uid = uid;
        this.pId = pId;
        this.hasBid = hasBid;
    }


    public int getTk() {
        return tk;
    }

    public void setTk(int tk) {
        this.tk = tk;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
