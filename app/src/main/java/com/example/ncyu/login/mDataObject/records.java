package com.example.ncyu.login.mDataObject;

/**
 * Created by Ncyu on 2017/8/21.
 */
public class records {
    int testID,scaleID,pass_or_not;
    String end_test_time;
    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public int getScaleID() {
        return scaleID;
    }

    public void setScaleID(int scaleID) {
        this.scaleID = scaleID;
    }

    public int getPass_or_not() {
        return pass_or_not;
    }

    public void setPass_or_not(int pass_or_not) {
        this.pass_or_not = pass_or_not;
    }

    public String getEnd_test_time() {
        return end_test_time;
    }

    public void setEnd_test_time(String end_test_time) {
        this.end_test_time = end_test_time;
    }

}
