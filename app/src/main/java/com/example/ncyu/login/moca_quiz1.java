package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class moca_quiz1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz1);
    }

    public void onClick(View v){
        Bundle bundle1=this.getIntent().getExtras();
        switch (v.getId()){
            case R.id.moca_q1_next:
                Intent intent=new Intent(this,moca_quiz1_ask.class);
                Bundle bundle=new Bundle();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                intent.putExtras(bundle);
                startActivity(intent);
                moca_quiz1.this.finish();
                break;
        }

    }
}
