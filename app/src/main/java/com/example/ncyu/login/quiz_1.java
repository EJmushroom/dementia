package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class quiz_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_1);

    }

    public void onClick(View v){
        Bundle bundle1=this.getIntent().getExtras();
        switch (v.getId()){
            case R.id.next:
                Intent intent=new Intent(this,quiz1_ask.class);
                Bundle bundle=new Bundle();
                if(bundle1.getString("identity").equals("family")) {
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                intent.putExtras(bundle);
                startActivity(intent);
                quiz_1.this.finish();
                break;
        }

    }
}
