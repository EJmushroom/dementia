package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class quiz_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_3);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.next:
                Intent intent=new Intent();
                intent.setClass(quiz_3.this,quiz3_ask.class);
                Bundle bundle=new Bundle();
                Bundle bundle1=getIntent().getExtras();

                bundle.putBooleanArray("quiz1_ask1_disAnswer",bundle1.getBooleanArray("quiz1_ask1_disAnswer"));
                bundle.putString("quiz_ask1_answer_type",bundle1.getString("quiz_ask1_answer_type"));
                bundle.putString("quiz1_ask1_answer1",bundle1.getString("quiz1_ask1_answer1"));
                bundle.putString("quiz1_ask1_answer2",bundle1.getString("quiz1_ask1_answer2"));
                bundle.putString("quiz1_ask1_answer3",bundle1.getString("quiz1_ask1_answer3"));
                bundle.putString("quiz1_ask1_answer4",bundle1.getString("quiz1_ask1_answer4"));
                bundle.putString("quiz1_ask2_quiz",bundle1.getString("quiz1_ask2_quiz"));
                bundle.putString("quiz1_ask2_answer",bundle1.getString("quiz1_ask2_answer"));
                bundle.putBoolean("quiz1_ask2_disAnswer",bundle1.getBoolean("quiz1_ask2_disAnswer"));
                bundle.putBooleanArray("quiz2_ask_disAnswer",bundle1.getBooleanArray("quiz2_ask_disAnswer"));
                bundle.putBooleanArray("quiz2_ask_isAnswer", bundle1.getBooleanArray("quiz2_ask_isAnswer"));
                bundle.putStringArray("quiz2_answer",bundle1.getStringArray("quiz2_answer"));

                if(bundle1.getString("identity").equals("family")) {
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));

                intent.putExtras(bundle);
                startActivity(intent);
                quiz_3.this.finish();
                break;
        }

    }
}
