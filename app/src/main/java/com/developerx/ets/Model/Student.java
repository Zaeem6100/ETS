package com.developerx.ets.Model;

public class Student {
    private String CNIC;
    private String Name;
    private String Password;
    private  String Image;

    public Student(String CNIC, String name, String password , String image) {
        this.CNIC = CNIC;
        Name = name;
        Password = password;
        Image = image;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}