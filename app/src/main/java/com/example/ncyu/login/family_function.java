package com.example.ncyu.login;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class family_function extends AppCompatActivity /*implements AsyncResponse View.OnClickListener*/{
    TextView tv_hello_family;
    ImageButton btn_family_logout,btn_family_modify,btn_family_test,btn_family_record,btn_FAboutUs;
    ImageButton btn_FMap;
    String str_time,str_account;
    String inputDoctorID;
    static String FAC;
    String name;
    Cursor c;

    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_function);

        //建立SQLiteOpenHelper 物件
        dbHelper = new MyDBHelper(this);
        db = dbHelper.getWritableDatabase();//開啟資料庫
        dbHelper.onCreate(db);


        //修復android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        tv_hello_family=(TextView)findViewById(R.id.tv_hello_family);
        btn_family_logout=(ImageButton)findViewById(R.id.btn_family_logout);
        btn_family_modify=(ImageButton)findViewById(R.id.btn_family_modify);
        btn_family_test=(ImageButton)findViewById(R.id.btn_family_test);
        btn_family_record=(ImageButton)findViewById(R.id.btn_family_record);
        btn_FMap=(ImageButton)findViewById(R.id.btn_FMap);
        btn_FAboutUs=(ImageButton)findViewById(R.id.btn_FAboutUs);

        //取得使用者姓名和帳號
        Bundle hello = this.getIntent().getExtras();
        if(hello==null)
        {
            tv_hello_family.setText("您好！");
        }else{
            tv_hello_family.setText("您好，"+hello.getString("name"));
            name=hello.getString("name");
            str_account=hello.getString("account");
            setFAccount(str_account);
        }


        //開始測驗
        btn_family_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] column={"_id","frequency"};
                c = dbHelper.getReadableDatabase().query("family", column, "_id = 1", null, null, null, null);
                c.moveToFirst();

                Intent in=new Intent(family_function.this,family_question.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("account",str_account);
                try{
                    //家屬端已有經驗
                    if(c.getInt(1)==1){
                        //new一個intent物件，並指定Activity切換的class
                        in=new Intent(family_function.this,family_choose_test.class);
                    }
                    //家屬端已有經驗，但仍需再次測驗
                    else if(c.getInt(1)==0){
                        in=new Intent(family_function.this,family_question.class);
                    }
                }
                catch (CursorIndexOutOfBoundsException e){
                    //家屬端第一次使用此程式
                    ContentValues cv =new ContentValues();
                    cv.put("_id",1);
                    cv.put("frequency",0);
                    long family =db.insert("family",null,cv);
                    c = dbHelper.getReadableDatabase().query("family", column, "_id = 1", null, null, null, null);
                    c.moveToFirst();
                    int test=c.getInt(1);
                }
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                family_function.this.finish();
            }
        });

        btn_FMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(family_function.this,map.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("account",str_account);
                bundle.putString("identity","family");
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                family_function.this.finish();
            }
        });

        btn_FAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(family_function.this,about_system.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("account",str_account);
                bundle.putString("identity","family");
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                family_function.this.finish();
            }
        });

        //按下檢測紀錄
        btn_family_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(family_function.this,family_record.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("account",str_account);
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                family_function.this.finish();
            }
        });
        //個資修改
        btn_family_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(family_function.this,family_modify.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("account",str_account);
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                family_function.this.finish();
            }
        });

        //登出按鈕
        btn_family_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),choose_identity.class));
                family_function.this.finish();
            }
        });

    }



    public void setFAccount(String X) {
        FAC = X;
    }
    public static String  getFAccount() {
        return FAC;
    }
}
