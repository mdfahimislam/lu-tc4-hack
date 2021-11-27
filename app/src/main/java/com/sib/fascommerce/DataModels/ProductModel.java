package com.sib.fascommerce.DataModels;

public class ProductModel {
private String category,pUrl,id,title,des,method,expirydate,uid,email,name,url;
private long basePrice;
ProductModel()
{}

    public ProductModel(String category, String pUrl, String id, String title, String des, String method, String expirydate, String uid, String email, String name, String url, long basePrice) {
        this.category = category;
        this.pUrl = pUrl;
        this.id = id;
        this.title = title;
        this.des = des;
        this.method = method;
        this.expirydate = expirydate;
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.url = url;
        this.basePrice = basePrice;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }
}
