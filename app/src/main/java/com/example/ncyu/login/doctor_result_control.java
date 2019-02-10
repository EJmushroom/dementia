package com.example.ncyu.login;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mListView.PatientAdapter;
import com.example.ncyu.login.mMySQL.PatientDataParser;
import com.example.ncyu.login.mMySQL.PatientDownloader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class doctor_result_control extends AppCompatActivity {

    String urlAddress="http://ej30827.000webhostapp.com/patient_select.php";
    ListView lv_patient_data;
    ImageButton btn_patient_enter,btn_patient_cancel;
    EditText et_patient_name;
    static int whichPatient;
    static String account,name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_result_control);

        lv_patient_data=(ListView)findViewById(R.id.lv_patient_data);
        btn_patient_enter=(ImageButton)findViewById(R.id.btn_patient_enter);
        btn_patient_cancel=(ImageButton)findViewById(R.id.btn_patient_cancel);
        et_patient_name=(EditText)findViewById(R.id.et_patient_name);

        final Bundle name_account = this.getIntent().getExtras();

//        //修復android.os.NetworkOnMainThreadException
//        if (android.os.Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }
        //把整个Layout顶上去露出获得焦点的EditText,不压缩多余空间.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);



        PatientDownloader d=new PatientDownloader(doctor_result_control.this,urlAddress,lv_patient_data);
        d.execute();

        //啟動按鍵過濾功能
        lv_patient_data.setTextFilterEnabled(true);

        //建立TextWatcher監聽是否有輸入病患編號
        et_patient_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                PatientDataParser.getAdapter().getFilter().filter(editable);
            }
        });


        //按下確定
        btn_patient_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PatientAdapter test=new PatientAdapter();
                if(test.getI()==0){
                    Toast.makeText(doctor_result_control.this,"請先點選病患！",Toast.LENGTH_SHORT).show();
                }
                else {
                    setWhichPatient(test.getI());
                    //new一個intent物件，並指定Activity切換的class
                    Intent in = new Intent(doctor_result_control.this, doctor_one_patient_data.class);
                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();
                    setName(name_account.getString("name"));
                    setAccount(name_account.getString("account"));
                    bundle.putString("name", name_account.getString("name"));
                    bundle.putString("account", name_account.getString("account"));
                    //將Bundle物件assign給intent
                    in.putExtras(bundle);
                    startActivity(in);
                    doctor_result_control.this.finish();
                }
            }
        });

        //按下返回
        btn_patient_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(doctor_result_control.this,doctor_function.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name_account.getString("name"));
                bundle.putString("account",name_account.getString("account"));
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                doctor_result_control.this.finish();
            }
        });
    }

    public void setWhichPatient(int PID){
        whichPatient=PID;
    }
    public static int getWhichPatient(){
        return whichPatient;
    }
    public void setName(String thisName){
        name = thisName;
    }
    public static String getName(){
        return name;
    }
    public void setAccount(String thisAccount){
        account = thisAccount;
    }
    public static String getAccount(){
        return account;
    }
}
