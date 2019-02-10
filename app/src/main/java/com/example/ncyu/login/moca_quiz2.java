package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class moca_quiz2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz2);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.moca_q2_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz2.this, moca_quiz2_ask.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBoolean("quiz1_answer",bundle1.getBoolean("quiz1_answer"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz2.this.finish();
                break;
        }

    }
}
