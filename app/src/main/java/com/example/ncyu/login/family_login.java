package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class family_login extends AppCompatActivity implements AsyncResponse, View.OnClickListener {
    EditText et_Account, et_Password;
    ImageButton btn_Login,btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_login);

        et_Account =(EditText) findViewById(R.id.et_Account) ;
        et_Password =(EditText) findViewById(R.id.et_Password);
        btn_Login =(ImageButton) findViewById(R.id.btn_Login);
        btn_register =(ImageButton) findViewById(R.id.btn_Register);
        btn_Login.setOnClickListener(this);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),family_register.class));
            }
        }) ;

    }

    @Override
    public void processFinish(String result) {
        if(result.equals("failed")){
            Toast.makeText(this,"登入失敗", Toast.LENGTH_LONG).show();
        }
        else if(result!=null && !result.equals("")){
            Toast.makeText(this,"登入成功 "+result,Toast.LENGTH_LONG).show();
            //new一個intent物件，並指定Activity切換的class
            Intent in=new Intent(this,family_function.class);
            //new一個Bundle物件，並將要傳遞的資料傳入
            Bundle bundle = new Bundle();
            bundle.putString("name",result);
            bundle.putString("account",et_Account.getText().toString());
            //將Bundle物件assign給intent
            in.putExtras(bundle);
            startActivity(in);
            family_login.this.finish();
        }
        else{
            Toast.makeText(this,"登入失敗", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View view) {
        if(et_Account.getText().toString().equals("")||et_Password.getText().toString().equals("")){
            Toast.makeText(this,"帳號密碼不符合", Toast.LENGTH_LONG).show();
        }
        else {
            HashMap postData = new HashMap();
            postData.put("txtAccount", et_Account.getText().toString());
            postData.put("txtPassword", et_Password.getText().toString());

            PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
            task.execute("http://ej30827.000webhostapp.com/family_login.php");

        }
    }

    //返回鍵
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            //new一個intent物件，並指定Activity切換的class
            Intent in=new Intent(family_login.this,choose_identity.class);
            startActivity(in);
            family_login.this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
