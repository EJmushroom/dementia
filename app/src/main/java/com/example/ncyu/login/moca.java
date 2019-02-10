package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class moca extends AppCompatActivity {
    Bundle name_account = null;
    Bundle bundle = new Bundle();
    Intent intent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca);

        name_account=this.getIntent().getExtras();

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_next_main:
                if(name_account.getString("identity").equals("family")){
                    bundle.putString("name",name_account.getString("name"));
                    bundle.putString("account",name_account.getString("account"));
                }
                intent = new Intent(this, moca_quiz1.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                bundle.putString("identity",name_account.getString("identity"));
                bundle.putString("testID",name_account.getString("testID"));
                //將Bundle物件assign給intent
                intent.putExtras(bundle);
                startActivity(intent);
                moca.this.finish();
                break;
            case R.id.btn_over:
                if(name_account.getString("identity").equals("family")){
                    intent = new Intent(this, family_choose_test.class);
                    bundle.putString("name", name_account.getString("name"));
                    bundle.putString("account", name_account.getString("account"));
                }
                else if(name_account.getString("identity").equals("guest")){
                    intent = new Intent(this, visitor_choose_test.class);
                }
                startActivity(intent);
                moca.this.finish();
                break;
        }
    }
}
