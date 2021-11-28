package com.sib.fascommerce.DataModels;

public class BidO {

    String points,name, url;

    public BidO(String points, String name, String url) {
        this.points = points;
        this.name = name;
        this.url = url;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
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


}
