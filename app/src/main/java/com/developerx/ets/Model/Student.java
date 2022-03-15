package com.developerx.ets.Model;

public class Student {
    private  String CNIC;
    private  String Name;
    private  String F_name;
    private String DOB;
    private String Gender;
    private String Institute;

    public Student(String CNIC, String name, String f_name, String DOB, String gender, String institute) {
        this.CNIC = CNIC;
        Name = name;
        F_name = f_name;
        this.DOB = DOB;
        Gender = gender;
        Institute = institute;
    }

    public Student() {
        this.CNIC =null;
        Name =null;
        F_name =null;
        this.DOB =null;
        Gender =null;
        Institute =null;
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

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getInstitute() {
        return Institute;
    }

    public void setInstitute(String institute) {
        Institute = institute;
    }
}
