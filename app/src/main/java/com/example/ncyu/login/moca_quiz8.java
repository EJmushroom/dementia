package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class moca_quiz8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz8);
    }

    public void onClick2(View v) {
        switch (v.getId()) {
            case R.id.moca_q8_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz8.this, moca_quiz8_ask.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBoolean("quiz1_answer", bundle1.getBoolean("quiz1_answer"));
                bundle.putParcelable("quiz2_ask_bundle", bundle1.getParcelable("quiz2_ask_bundle"));
                bundle.putBoolean("quiz2_ask_answer", bundle1.getBoolean("quiz2_ask_answer"));
                bundle.putParcelable("quiz2_ask2_bundle", bundle1.getParcelable("quiz2_ask2_bundle"));
                bundle.putBooleanArray("quiz2_ask2_answer",  bundle1.getBooleanArray("quiz2_ask2_answer"));
                bundle.putBooleanArray("quiz3_answer", bundle1.getBooleanArray("quiz3_answer"));
                bundle.putBooleanArray("quiz4_answer_first", bundle1.getBooleanArray("quiz4_answer_first"));
                bundle.putBooleanArray("quiz4_answer_second", bundle1.getBooleanArray("quiz4_answer_second"));
                bundle.putStringArray("quiz4_word_bundle",bundle1.getStringArray("quiz4_word_bundle"));
                bundle.putBoolean("quiz5_ask1_answer1", bundle1.getBoolean("quiz5_ask1_answer1"));
                bundle.putBoolean("quiz5_ask1_answer2", bundle1.getBoolean("quiz5_ask1_answer2"));
                bundle.putBoolean("quiz5_ask1_answer3", bundle1.getBoolean("quiz5_ask1_answer3"));
                bundle.putStringArray("quiz5_ask2_answer", bundle1.getStringArray("quiz5_ask2_answer"));
                bundle.putInt("quiz5_ask2_isRight", bundle1.getInt("quiz5_ask2_isRight"));
                bundle.putBooleanArray("quiz6_ask_quiz_isRight", bundle1.getBooleanArray("quiz6_ask_quiz_isRight"));
                bundle.putInt("quiz6_ask2_answer", bundle1.getInt("quiz6_ask2_answer"));
                bundle.putBooleanArray("quiz7_answer",bundle1.getBooleanArray("quiz7_answer"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz8.this.finish();
                break;
        }

    }
}
