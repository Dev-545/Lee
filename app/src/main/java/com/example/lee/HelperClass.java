package com.example.lee;

public class HelperClass {
    String Name, Age, Gender, Activity, Phone, Mail,Password;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public HelperClass(String name, String age, String gender, String activity, String phone, String mail, String password) {
        Name = name;
        Mail = mail;
        Phone = phone;
        Password = password;
        Gender = gender;
        Activity = activity;
        Age = age;
    }
}
