package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class doctor_function extends AppCompatActivity {
    static String DAC;
    TextView tv_hello_doctor;
    ImageButton btn_doctor_logout,btn_doctor_modify,btn_doctor_result_control;
//    Button btn_make_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_function);

        tv_hello_doctor=(TextView)findViewById(R.id.tv_hello_doctor);
        btn_doctor_logout=(ImageButton)findViewById(R.id.btn_doctor_logout);
//        btn_make_link=(Button)findViewById(R.id.btn_make_link);
        btn_doctor_modify=(ImageButton)findViewById(R.id.btn_doctor_modify);
        btn_doctor_result_control=(ImageButton)findViewById(R.id.btn_doctor_result_control);

        final Bundle hello = this.getIntent().getExtras();
        if(hello==null) {
            tv_hello_doctor.setText("您好!");
        }else{
            tv_hello_doctor.setText("您好，" + hello.getString("name") + " 醫師！");
            setDAccount(hello.getString("account"));
        }
        //按下病患帳號綁定
//        btn_make_link.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //new一個intent物件，並指定Activity切換的class
//                Intent in=new Intent(doctor_function.this,doctor_make_link.class);
//                //new一個Bundle物件，並將要傳遞的資料傳入
//                Bundle bundle = new Bundle();
//                bundle.putString("name",hello.getString("name"));
//                bundle.putString("account",hello.getString("account"));
//                //將Bundle物件assign給intent
//                in.putExtras(bundle);
//                startActivity(in);
//                doctor_function.this.finish();
//            }
//        });

        //檢測結果管理
        btn_doctor_result_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(doctor_function.this,doctor_result_control.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",hello.getString("name"));
                bundle.putString("account",hello.getString("account"));
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                doctor_function.this.finish();
            }
        });

        //按下身份登出
        btn_doctor_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(doctor_function.this,choose_identity.class));
                doctor_function.this.finish();
            }
        });

        //個資修改
        btn_doctor_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(doctor_function.this,doctor_modify.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",hello.getString("name"));
                bundle.putString("account",hello.getString("account"));
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                doctor_function.this.finish();
            }
        });
    }
    public void setDAccount(String X) {
        DAC = X;
    }
    public static String  getDAccount() {
        return DAC;
    }

}
