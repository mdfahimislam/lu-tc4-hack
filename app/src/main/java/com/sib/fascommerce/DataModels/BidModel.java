package com.sib.fascommerce.DataModels;

public class BidModel {
    private int tk,point;
    private String pNumber,email,name;

    public BidModel() {
    }

    public BidModel(int tk, int point, String pNumber, String email, String name) {
        this.tk = tk;
        this.point = point;
        this.pNumber = pNumber;
        this.email = email;
        this.name = name;
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
