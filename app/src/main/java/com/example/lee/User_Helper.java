package com.example.lee;

public class User_Helper {
    String  Name,Phone, Mail,Password;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getMail() {
        return Mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public User_Helper(String name,String phone,String mail,  String password) {
        this.Name = name;
        this.Phone =phone;
        this.Mail  = mail;
        this.Password =password;
    }
    public User_Helper(){

    }
}
