package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class about_system extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_system);
    }

    //返回鍵
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Bundle identity = this.getIntent().getExtras();
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if(identity.getString("identity").equals("guest")){
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(about_system.this,visitor_function.class);
                startActivity(in);
                about_system.this.finish();
            }
            else if(identity.getString("identity").equals("family"))
            {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(about_system.this,family_function.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",identity.getString("name"));
                bundle.putString("account",identity.getString("account"));
                bundle.putString("identity","family");
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                about_system.this.finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
