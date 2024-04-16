package com.example.lee;

public class Activity_Helper {
    String  Name,Age, Gender, Activity,Phone, Mail;

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getActivity() {
        return Activity;
    }

    public void setActivity(String activity) {
        Activity = activity;
    }

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


    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }





    public Activity_Helper(String name, String age,String gender, String activity,String phone, String mail ) {
        this.Name = name;
        this.Age= age;
        this.Gender= gender;
        this.Activity= activity;
        this.Phone =phone;
        this.Mail  = mail;


    }
    public Activity_Helper(){

    }
}
