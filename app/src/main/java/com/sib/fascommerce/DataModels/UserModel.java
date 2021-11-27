package com.sib.fascommerce.DataModels;

public class UserModel {
    private String fName , lName , pNumber , email , type , token ;
    private int point;
    private boolean isVerified;

    public UserModel() {
    }

    public UserModel(String fName, String lName, String pNumber, String email, String type, String token, int point, boolean isVerified) {
        this.fName = fName;
        this.lName = lName;
        this.pNumber = pNumber;
        this.email = email;
        this.type = type;
        this.token = token;
        this.point = point;
        this.isVerified = isVerified;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}
