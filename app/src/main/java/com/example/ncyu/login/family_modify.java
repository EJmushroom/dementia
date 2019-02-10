package com.example.ncyu.login;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ncyu.login.mMySQL.MfamilyDownloader;

public class family_modify extends AppCompatActivity {
    String urlAddress="http://ej30827.000webhostapp.com/family_data_modify.php";
    ListView lv_Fmodify_data;

    public static Activity ActivityA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_modify);
        lv_Fmodify_data=(ListView)findViewById(R.id.lv_Fmodify_data);

        ActivityA=this;

        final Bundle name_account = this.getIntent().getExtras();

        //修復android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Button btn_Cmodify=(Button)findViewById(R.id.btn_Cmodify);

        //顯示內容
        MfamilyDownloader d=new MfamilyDownloader(family_modify.this,urlAddress,lv_Fmodify_data);
        d.execute();

        //        取消修改
        btn_Cmodify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(family_modify.this,family_function.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name_account.getString("name"));
                bundle.putString("account",name_account.getString("account"));
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                family_modify.this.finish();
            }
        });



    }
}
