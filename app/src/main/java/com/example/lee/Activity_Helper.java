package com.example.lee;

public class Activity_Helper {
    private String name;
    private String age;
    private String mobile;
    private String email;
    private String address;
    private String activity;
    private String gender;

    public Activity_Helper() {
        // Default constructor required for Firebase
    }

    public Activity_Helper(String name, String age, String mobile, String email, String address, String activity, String gender) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.activity = activity;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getActivity() {
        return activity;
    }

    public String getGender() {
        return gender;
    }
}
