package com.example.lee;

public class HelperClass {
    String name, mail, mobile, password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return mail;
    }
    public void setEmail(String mail) {
        this.mail = mail;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public HelperClass(String name, String mail, String mobile, String password) {
        this.name = name;
        this.mail = mail;
        this.mobile = mobile;
        this.password = password;
    }
    public HelperClass() {
    }
}

