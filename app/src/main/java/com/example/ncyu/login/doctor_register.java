package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class doctor_register extends AppCompatActivity implements AsyncResponse, View.OnClickListener{
    EditText et_Dname,et_Daccount,et_Dpassword,et_Drpassword,et_Dhospital;
    Button btn_Dregistered;
    RadioGroup rg_Dgender;
    RadioButton rbtn_Dboy,rbtn_Dgirl;
    Integer Dgender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        et_Dname=(EditText)findViewById(R.id.et_Dname);
        et_Daccount=(EditText)findViewById(R.id.et_Daccount);
        et_Dpassword=(EditText)findViewById(R.id.et_Dpassword);
        et_Drpassword=(EditText)findViewById(R.id.et_Drpassword );
        et_Dhospital=(EditText)findViewById(R.id.et_Dhospital);
        btn_Dregistered=(Button)findViewById(R.id.btn_Drregister);
        rg_Dgender=(RadioGroup)findViewById(R.id.rg_Dgender);
        rbtn_Dboy=(RadioButton)findViewById(R.id.rbtn_Dboy);
        rbtn_Dgirl=(RadioButton)findViewById(R.id.rbtn_Dgirl);

        //註冊事件
        btn_Dregistered.setOnClickListener(this);

        //選擇性別事件
        rbtn_Dboy.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //男性為 1
                Dgender=1;
            }
        });
        rbtn_Dgirl.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //女性為 2
                Dgender=2;
            }
        });


    }

    @Override
    public void processFinish(String result) {
        if(result.equals("account success")){
            Toast.makeText(this,"註冊成功",Toast.LENGTH_LONG).show();
            Intent in=new Intent(doctor_register.this,doctor_function.class);
            //new一個Bundle物件，並將要傳遞的資料傳入
            Bundle bundle = new Bundle();
            bundle.putString("name", et_Dname.getText().toString());
            bundle.putString("account", et_Daccount.getText().toString());
            //將Bundle物件assign給intent
            in.putExtras(bundle);
            startActivity(in);
        }
        else if(result.equals("account exist")){
            Toast.makeText(this,"帳號不得重複", Toast.LENGTH_LONG).show();
            et_Daccount.setText("");
        }
        else{
            Toast.makeText(this,"註冊失敗", Toast.LENGTH_LONG).show();
            et_Dname.setText("");
            et_Daccount.setText("");
            et_Dpassword.setText("");
            et_Drpassword.setText("");
            et_Dhospital.setText("");
        }
    }


    @Override
    public void onClick(View view) {
        //檢查是否空格都有填寫資料
        if(et_Dname.getText().toString().equals("")||et_Daccount.getText().toString().equals("")||et_Dpassword.getText().toString().equals("")||Dgender.toString().equals("")||et_Dhospital.getText().toString().equals("")){
            Toast.makeText(this,"請填寫所有資料",Toast.LENGTH_LONG).show();
        }
        else {
            //檢查密碼是否一致
            if(et_Dpassword.getText().toString().equals(et_Drpassword.getText().toString()))
            {
                HashMap postData = new HashMap();
                postData.put("mobile", "android");
                postData.put("txtName", et_Dname.getText().toString());
                postData.put("txtAccount", et_Daccount.getText().toString());
                postData.put("txtPassword", et_Dpassword.getText().toString());
                postData.put("txtRPassword", et_Drpassword.getText().toString());
                postData.put("txtGender", Dgender.toString());
                postData.put("txtDhospital", et_Dhospital.getText().toString());


                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                task.execute("http://ej30827.000webhostapp.com/doctor_register.php");
            }
            else {

                Toast.makeText(this,"密碼不一致",Toast.LENGTH_LONG).show();
                et_Dpassword.setText("");
                et_Drpassword.setText("");
            }
        }
    }
}
