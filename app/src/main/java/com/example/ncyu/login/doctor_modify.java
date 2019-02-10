package com.example.ncyu.login;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ncyu.login.mMySQL.MdoctorDownloader;

public class doctor_modify extends AppCompatActivity {
    String urlAddress="http://ej30827.000webhostapp.com/doctor_data_modify.php";
    ListView lv_Dmodify_data;
    public static Activity ActivityB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_modify);

        ActivityB=this;

        lv_Dmodify_data=(ListView)findViewById(R.id.lv_Dmodify_data);
        final Bundle nameAccount = this.getIntent().getExtras();

        //修復android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Button btn_CDmodify=(Button)findViewById(R.id.btn_CDmodify);

        //顯示內容
        MdoctorDownloader d=new MdoctorDownloader(doctor_modify.this,urlAddress,lv_Dmodify_data);
        d.execute();

        //        取消修改
        btn_CDmodify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(doctor_modify.this,doctor_function.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",nameAccount.getString("name"));
                bundle.putString("account",nameAccount.getString("account"));
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                doctor_modify.this.finish();
            }
        });
    }





}
