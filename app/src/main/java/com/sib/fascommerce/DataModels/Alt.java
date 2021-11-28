package com.sib.fascommerce.DataModels;

public class Alt {

    String name, email, tk;

    public Alt(String name, String email, String tk) {
        this.name = name;
        this.email = email;
        this.tk = tk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }
}
