package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mmse extends AppCompatActivity {

    Button next;
    Bundle N_A_testID=null;
    Intent intent=null;
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmse);
        next = (Button) findViewById(R.id.next_main);
        N_A_testID = this.getIntent().getExtras();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_main:
                if(N_A_testID.getString("identity").equals("family")) {
                    bundle.putString("name", N_A_testID.getString("name"));
                    bundle.putString("account", N_A_testID.getString("account"));
                }
                intent = new Intent(this, quiz_1.class);
                bundle.putString("identity",N_A_testID.getString("identity"));
                bundle.putString("testID",N_A_testID.getString("testID"));
                intent.putExtras(bundle);
                startActivity(intent);
                mmse.this.finish();
                break;

            case R.id.over:
                if(N_A_testID.getString("identity").equals("family")) {
                    intent = new Intent(this, family_choose_test.class);
                    bundle.putString("name", N_A_testID.getString("name"));
                    bundle.putString("account", N_A_testID.getString("account"));
                }
                else if(N_A_testID.getString("identity").equals("guest")){
                    intent = new Intent(this, visitor_choose_test.class);
                }
                intent.putExtras(bundle);
                startActivity(intent);
                mmse.this.finish();
                break;
        }
    }
}
