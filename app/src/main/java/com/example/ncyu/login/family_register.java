package com.example.ncyu.login;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class family_register extends AppCompatActivity implements AsyncResponse, View.OnClickListener{
    EditText et_name,et_account,et_password,et_rpassword,et_patient_name;
    Button btn_registered;
    RadioGroup rg_gender,rg_patient_gender,rg_patient_blood;
    RadioButton rbtn_boy,rbtn_girl,rbtn_patient_boy,rbtn_patient_girl,rbtn_A,rbtn_B,rbtn_AB,rbtn_O;
    Integer gender,patient_gender;
    String patient_blood,cdate;

    DatePicker datePicker;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;

//    private Calendar m_Calendar = Calendar.getInstance();
//    private EditText et_date=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_register);

        et_name=(EditText)findViewById(R.id.et_name);
        et_account=(EditText)findViewById(R.id.et_account);
        et_password=(EditText)findViewById(R.id.et_password);
        et_rpassword=(EditText)findViewById(R.id.et_rpassword );
        et_patient_name=(EditText)findViewById(R.id.et_patient_name);
        btn_registered=(Button)findViewById(R.id.btn_rregister);
        rg_gender=(RadioGroup)findViewById(R.id.rg_gender);
        rg_patient_gender=(RadioGroup)findViewById(R.id.rg_patient_gender);
        rg_patient_blood=(RadioGroup)findViewById(R.id.rg_patient_blood);
        rbtn_patient_boy=(RadioButton)findViewById(R.id.rbtn_patient_boy);
        rbtn_patient_girl=(RadioButton)findViewById(R.id.rbtn_patient_girl);
        rbtn_A=(RadioButton)findViewById(R.id.rbtn_A);
        rbtn_B=(RadioButton)findViewById(R.id.rbtn_B);
        rbtn_AB=(RadioButton)findViewById(R.id.rbtn_AB);
        rbtn_O=(RadioButton)findViewById(R.id.rbtn_O);
        rbtn_boy=(RadioButton)findViewById(R.id.rbtn_boy);
        rbtn_girl=(RadioButton)findViewById(R.id.rbtn_girl);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        // 获取日历对象
        calendar = Calendar.getInstance();
        // 获取当前对应的年、月、日的信息
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);

//        et_date=(EditText)findViewById(R.id.et_date);


//        final DatePickerDialog.OnDateSetListener datepicker = new DatePickerDialog.OnDateSetListener()
//        {
//
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
//            {
//                m_Calendar.set(Calendar.YEAR, year);
//                m_Calendar.set(Calendar.MONTH, monthOfYear);
//                m_Calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                String myFormat = "yyyy-MM-dd"; //In which you need put here
//                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.TAIWAN);
//                et_date.setText(sdf.format(m_Calendar.getTime()));
//            }
//
//
//        };



//        et_date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatePickerDialog dialog = new DatePickerDialog(family_register.this,
//                        datepicker,
//                        m_Calendar.get(Calendar.YEAR),
//                        m_Calendar.get(Calendar.MONTH),
//                        m_Calendar.get(Calendar.DAY_OF_MONTH));
//                dialog.show();
//
//
//            }
//        });



        //註冊事件
        btn_registered.setOnClickListener(this);

        //選擇性別事件
        rbtn_boy.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //男性為 1
                gender=1;
            }
        });
        rbtn_girl.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //女性為 2
                gender=2;
            }
        });

        rbtn_patient_boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //男性為 1
                patient_gender=1;
            }
        });

        rbtn_patient_girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //女性為 2
                patient_gender=2;
            }
        });

        rbtn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patient_blood="A";
            }
        });

        rbtn_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patient_blood="B";
            }
        });

        rbtn_AB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patient_blood="AB";
            }
        });

        rbtn_O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patient_blood="O";
            }
        });


        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                cdate=year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            }
        });

    }

    //將手機上輸入的資料存到Hash Map 中 並執行php
    @Override
    public void onClick(View view) {
        //檢查是否空格都有填寫資料
        if(et_name.getText().toString().equals("")||et_account.getText().toString().equals("")||et_password.getText().toString().equals("")||gender.toString().equals("")
                ||et_patient_name.getText().toString().equals("")||patient_gender.toString().equals("")||patient_blood.equals("")||cdate.equals("")){
            Toast.makeText(this,"請填寫所有資料",Toast.LENGTH_LONG).show();
        }
        else {
            //檢查密碼是否一致
            if(et_password.getText().toString().equals(et_rpassword.getText().toString()))
            {
                HashMap postData = new HashMap();
                postData.put("mobile", "android");
                postData.put("txtPName", et_patient_name.getText().toString());
                postData.put("txtPGender", patient_gender.toString());
                postData.put("txtPBlood", patient_blood);
                postData.put("txtPBirthday",cdate);
                postData.put("txtName", et_name.getText().toString());
                postData.put("txtAccount", et_account.getText().toString());
                postData.put("txtPassword", et_password.getText().toString());
                postData.put("txtRPassword", et_rpassword.getText().toString());
                postData.put("txtGender", gender.toString());

                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData,"UTF-8");
                task.execute("http://ej30827.000webhostapp.com/family_register.php");
            }
            else {

                Toast.makeText(this,"密碼不一致",Toast.LENGTH_LONG).show();
                et_password.setText("");
                et_rpassword.setText("");
            }
        }
    }

    @Override
    public void processFinish(String result) {

        if(result.equals("account exist")){
            Toast.makeText(this,"帳號不得重複", Toast.LENGTH_LONG).show();
            et_account.setText("");
        }
        else if(result.equals("account failed")){
            Toast.makeText(this,"註冊失敗", Toast.LENGTH_LONG).show();
            et_name.setText("");
            et_account.setText("");
            et_password.setText("");
            et_rpassword.setText("");
        }
        else{
            Toast.makeText(this,"註冊成功",Toast.LENGTH_LONG).show();
            Intent in=new Intent(this,family_function.class);
            //new一個Bundle物件，並將要傳遞的資料傳入
            Bundle bundle = new Bundle();
            bundle.putString("name", result);
            bundle.putString("account",et_account.getText().toString());
            //將Bundle物件assign給intent
            in.putExtras(bundle);
            startActivity(in);
            family_register.this.finish();
        }
    }

}
