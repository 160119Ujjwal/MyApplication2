package com.example.myapplication.module;

import java.io.Serializable;

public class User implements Serializable {
    private String Name;
    private String gender;
    private String dob;
    private String country;
    private String phone;
    private String email;
    public User(String Name, String gender, String dob, String country, String phone, String email){

        this.Name  = Name;
        this.gender = gender;
        this.dob = dob;
        this.country  = country;
        this.email  = email;
        this.phone  = phone;

    }

    public String getName() {
        return Name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

