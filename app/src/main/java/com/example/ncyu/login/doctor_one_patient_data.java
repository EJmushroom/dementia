package com.example.ncyu.login;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ncyu.login.mMySQL.OnePatientDownloader;

public class doctor_one_patient_data extends AppCompatActivity {

    String urlAddress="http://ej30827.000webhostapp.com/one_patient_data.php";
    ListView lv_one_patient_data;
    public static Activity ActivityDOPD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_one_patient_data);

        ActivityDOPD=this;
        final Bundle name_account = this.getIntent().getExtras();

        lv_one_patient_data=(ListView)findViewById(R.id.lv_one_patient_data);

        //修復android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        OnePatientDownloader d=new OnePatientDownloader(doctor_one_patient_data.this,urlAddress,lv_one_patient_data);
        d.execute();
    }
}
