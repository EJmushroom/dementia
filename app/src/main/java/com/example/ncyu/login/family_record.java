package com.example.ncyu.login;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mListView.RecordsAdapter;
import com.example.ncyu.login.mMySQL.RecordsDataParser;
import com.example.ncyu.login.mMySQL.RecordsDownloader;

public class family_record extends AppCompatActivity {

    String urlAddress="http://ej30827.000webhostapp.com/records_select.php";
    EditText et_EndTestTime;
    ListView lv_has_scored;
    ImageButton btn_Back_Ffunction,btn_record_enter;
    static String account,name;
    static int whichTestID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_record);

        et_EndTestTime=(EditText)findViewById(R.id.et_EndTestTime);
        lv_has_scored=(ListView)findViewById(R.id.lv_has_scored);
        btn_Back_Ffunction=(ImageButton)findViewById(R.id.btn_Back_Ffunction);
        btn_record_enter=(ImageButton)findViewById(R.id.btn_record_enter);

        //把整个Layout顶上去露出获得焦点的EditText,不压缩多余空间.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //修復android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        final Bundle name_account = this.getIntent().getExtras();
        setAccount(name_account.get("account").toString());
        setName(name_account.get("name").toString());

        RecordsDownloader d=new RecordsDownloader(family_record.this,urlAddress,lv_has_scored);
        d.execute();

        //啟動按鍵過濾功能
        lv_has_scored.setTextFilterEnabled(true);

        //建立TextWatcher監聽是否有輸入檢測結束時間
        et_EndTestTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                RecordsDataParser.getAdapter().getFilter().filter(editable);
            }
        });


        //按下確定
        btn_record_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecordsAdapter test=new RecordsAdapter();
                if(test.getTestID()==0){
                    Toast.makeText(family_record.this,"請先點選量表！",Toast.LENGTH_SHORT).show();
                }
                else {
                    //若是AD8
                    if(test.getScaleID()==1) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(family_record.this, family_one_ad8_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("identity", "family");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        family_record.this.finish();
                    }
                    //若是CDR
                    else if(test.getScaleID()==2) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(family_record.this, family_one_cdr_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("identity", "family");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        family_record.this.finish();
                    }
                    //若是MMSE
                    else if(test.getScaleID()==3) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(family_record.this, family_one_mmse_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("identity", "family");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        family_record.this.finish();
                    }
                    //若是MOCA
                    else if(test.getScaleID()==4) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(family_record.this, family_one_moca_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("identity", "family");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        family_record.this.finish();
                    }
                    //若是NPIQ
                    else if(test.getScaleID()==5) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(family_record.this, family_one_npiq_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name_account.getString("name"));
                        bundle.putString("account", name_account.getString("account"));
                        bundle.putString("testID", toString().valueOf(test.getTestID()));
                        bundle.putString("identity", "family");
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        family_record.this.finish();
                    }
                }
            }
        });

        //按下返回
        btn_Back_Ffunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(family_record.this,family_function.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name_account.getString("name"));
                bundle.putString("account",name_account.getString("account"));
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                family_record.this.finish();
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
}
