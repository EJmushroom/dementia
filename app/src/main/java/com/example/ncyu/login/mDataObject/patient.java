package com.example.ncyu.login.mDataObject;

/**
 * Created by Ncyu on 2017/8/15.
 */
public class patient {

    String patient_name,patient_birthday;
    int patient_number,patient_gender;

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_birthday() {
        return patient_birthday;
    }

    public void setPatient_birthday(String patient_birthday) {
        this.patient_birthday = patient_birthday;
    }

    public int getPatient_gender() {
        return patient_gender;
    }

    public void setPatient_gender(int patient_gender) {
        this.patient_gender = patient_gender;
    }

    public int getPatient_number() {
        return patient_number;
    }

    public void setPatient_number(int patient_number) {
        this.patient_number = patient_number;
    }

}
