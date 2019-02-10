package com.example.ncyu.login.mDataObject;

/**
 * Created by Ncyu on 2017/7/14.
 */
public class scale {
    String scale_name,scale_introduction;
    int scale_total_points,scale_passing_score,scale_estimated_time,scaleID;

    public int getScaleID() {
        return scaleID;
    }

    public void setScaleID(int scaleID) {
        this.scaleID = scaleID;
    }

    public String getScale_name() {
        return scale_name;
    }

    public void setScale_name(String scale_name) {
        this.scale_name = scale_name;
    }

    public String getScale_introduction() {
        return scale_introduction;
    }

    public void setScale_introduction(String scale_introduction) {
        this.scale_introduction = scale_introduction;
    }

    public int getScale_total_points() {
        return scale_total_points;
    }

    public void setScale_total_points(int scale_total_points) {
        this.scale_total_points = scale_total_points;
    }

    public int getScale_passing_score() {
        return scale_passing_score;
    }

    public void setScale_passing_score(int scale_passing_score) {
        this.scale_passing_score = scale_passing_score;
    }

    public int getScale_estimated_time() {
        return scale_estimated_time;
    }

    public void setScale_estimated_time(int scale_estimated_time) {
        this.scale_estimated_time = scale_estimated_time;
    }
}
