package com.example.ncyu.login;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mMySQL.NPIQRecordDownloader;

public class family_one_npiq_record_data extends AppCompatActivity {
    String urlAddress="http://ej30827.000webhostapp.com/one_npiq_record_data_select.php";
    ListView lv_NPIQ;
    ImageButton btn_npiq_Back_Frecord;
    static String TestID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_one_npiq_record_data);

        lv_NPIQ=(ListView)findViewById(R.id.lv_one_npiq_data);
        btn_npiq_Back_Frecord=(ImageButton)findViewById(R.id.btn_npiq_Back_Frecord);

        final Bundle ANTestID = this.getIntent().getExtras();
        TestID=ANTestID.getString("testID");
        Toast.makeText(family_one_npiq_record_data.this,TestID,Toast.LENGTH_SHORT).show();
        //修復android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        NPIQRecordDownloader d=new NPIQRecordDownloader(family_one_npiq_record_data.this,urlAddress,lv_NPIQ);
        d.execute();

        btn_npiq_Back_Frecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new一個intent物件，並指定Activity切換的class
                Intent in = null;
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                if(ANTestID.get("identity").equals("family")){
                    in=new Intent(family_one_npiq_record_data.this,family_record.class);

                }else if(ANTestID.get("identity").equals("doctor")){
                    in=new Intent(family_one_npiq_record_data.this,doctor_one_kind_scale.class);
                    bundle.putString("PID",ANTestID.getString("PID"));
                    bundle.putString("SID",ANTestID.getString("SID"));
                }

                bundle.putString("name",ANTestID.getString("name"));
                bundle.putString("account",ANTestID.getString("account"));
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                family_one_npiq_record_data.this.finish();
            }
        });
    }
    public void setTestID(String TID){
        TestID = TID;
    }
    public static String getTestID(){
        return TestID;
    }
}
