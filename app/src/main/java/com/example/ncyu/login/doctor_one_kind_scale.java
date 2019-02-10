package com.example.ncyu.login;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.mListView.TestsAdapter;
import com.example.ncyu.login.mMySQL.TestsDataParser;
import com.example.ncyu.login.mMySQL.TestsDownloader;

public class doctor_one_kind_scale extends AppCompatActivity {

    String urlAddress="http://ej30827.000webhostapp.com/tests_select.php";
    ListView lv_one_kind_scale;
    Button btn_test_checked,btn_test_cancel;
    EditText et_test_end_time;
    TextView tv_scale_type;
    static String account,name,PID,SID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_one_kind_scale);

        lv_one_kind_scale=(ListView)findViewById(R.id.lv_one_kind_scale);
        btn_test_checked=(Button)findViewById(R.id.btn_test_checked);
        btn_test_cancel=(Button)findViewById(R.id.btn_test_cancel);
        et_test_end_time=(EditText)findViewById(R.id.et_test_end_time);
        tv_scale_type=(TextView)findViewById(R.id.tv_scale_type);


        //修復android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        final Bundle name_account = this.getIntent().getExtras();

        setPID(name_account.get("PID").toString());
        setSID(name_account.get("SID").toString());
        setAccount(name_account.get("account").toString());
        setName(name_account.get("name").toString());

        if(doctor_one_kind_scale.getSID().equals("1")){
            tv_scale_type.setText("AD8");
        }
        else if(doctor_one_kind_scale.getSID().equals("2")){
            tv_scale_type.setText("CDR");
        }
        else if(doctor_one_kind_scale.getSID().equals("3")) {
            tv_scale_type.setText("MMSE");
        }
        else if(doctor_one_kind_scale.getSID().equals("4")){
            tv_scale_type.setText("MOCA");
        }
        else if(doctor_one_kind_scale.getSID().equals("5")){
            tv_scale_type.setText("NPI-Q");
        }
        else{
            tv_scale_type.setText("錯誤！");
        }

        TestsDownloader d=new TestsDownloader(doctor_one_kind_scale.this,urlAddress,lv_one_kind_scale);
        d.execute();

        //啟動按鍵過濾功能
        lv_one_kind_scale.setTextFilterEnabled(true);

        //建立TextWatcher監聽是否有輸入病患編號
        et_test_end_time.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                TestsDataParser.getAdapter().getFilter().filter(editable);
            }
        });

        //按下確定
        btn_test_checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestsAdapter test=new TestsAdapter();
                if(test.getTestID()==0){
                    Toast.makeText(doctor_one_kind_scale.this,"請先點選任一量表！",Toast.LENGTH_SHORT).show();
                }
                else {
                    //AD8
                    if(getSID().equals("1")){
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(doctor_one_kind_scale.this, family_one_ad8_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        setName(name_account.getString("name"));
                        setAccount(name_account.getString("account"));
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("PID", getPID());
                        bundle.putString("SID", getSID());
                        bundle.putString("identity","doctor");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        doctor_one_kind_scale.this.finish();
                    }
                    //CDR
                    else if(getSID().equals("2")){
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(doctor_one_kind_scale.this, family_one_cdr_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        setName(name_account.getString("name"));
                        setAccount(name_account.getString("account"));
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("PID", getPID());
                        bundle.putString("SID", getSID());
                        bundle.putString("identity","doctor");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        doctor_one_kind_scale.this.finish();

                    }
                    //MMSE
                    else if(getSID().equals("3")){
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(doctor_one_kind_scale.this, family_one_mmse_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        setName(name_account.getString("name"));
                        setAccount(name_account.getString("account"));
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("PID", getPID());
                        bundle.putString("SID", getSID());
                        bundle.putString("identity","doctor");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        doctor_one_kind_scale.this.finish();

                    }
                    //MOCA
                    else if(getSID().equals("4")){
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(doctor_one_kind_scale.this, family_one_moca_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        setName(name_account.getString("name"));
                        setAccount(name_account.getString("account"));
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("PID", getPID());
                        bundle.putString("SID", getSID());
                        bundle.putString("identity","doctor");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        doctor_one_kind_scale.this.finish();
                    }
                    //NPI-Q
                    else if(getSID().equals("5")){
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(doctor_one_kind_scale.this, family_one_npiq_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        setName(name_account.getString("name"));
                        setAccount(name_account.getString("account"));
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("PID", getPID());
                        bundle.putString("SID", getSID());
                        bundle.putString("identity","doctor");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        doctor_one_kind_scale.this.finish();

                    }
                }
            }
        });

        //按下返回
        btn_test_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(doctor_one_kind_scale.this,doctor_one_patient_data.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name_account.getString("name"));
                bundle.putString("account",name_account.getString("account"));
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                doctor_one_kind_scale.this.finish();
            }
        });
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
    public void setPID(String thisPID){
        PID=thisPID;
    }
    public static String getPID(){
        return PID;
    }
    public void setSID(String thisSID){
        SID=thisSID;
    }
    public static String getSID(){
        return SID;
    }

}
