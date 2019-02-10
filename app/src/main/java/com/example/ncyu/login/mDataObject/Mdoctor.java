package com.example.ncyu.login.mDataObject;

/**
 * Created by Ncyu on 2017/8/7.
 */
public class Mdoctor {
    String doctor_account,doctor_name,doctor_hospital;
    Integer doctor_gender;

    public String getDoctor_account() {
        return doctor_account;
    }

    public void setDoctor_account(String doctor_account) {
        this.doctor_account = doctor_account;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String dcotor_name) {
        this.doctor_name = dcotor_name;
    }

    public String getDoctor_hospital() {
        return doctor_hospital;
    }

    public void setDoctor_hospital(String doctor_hospital) {
        this.doctor_hospital = doctor_hospital;
    }

    public Integer getDoctor_gender() {
        return doctor_gender;
    }

    public void setDoctor_gender(Integer doctor_gender) {
        this.doctor_gender = doctor_gender;
    }

}
