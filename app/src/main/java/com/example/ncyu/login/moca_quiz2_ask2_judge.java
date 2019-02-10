package com.example.ncyu.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class moca_quiz2_ask2_judge extends AppCompatActivity {
    ImageView quiz2_ask2_answer;
    Button next;
    boolean quiz2_ask2_isRight[] = {false, false, false};
    CheckBox quiz2_ask2_answer1, quiz2_ask2_answer2, quiz2_ask2_answer3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz2_ask2_judge);
        next = (Button) findViewById(R.id.next);
        quiz2_ask2_answer = (ImageView) findViewById(R.id.quiz2_ask2_answer);
        quiz2_ask2_answer1 = (CheckBox) findViewById(R.id.quiz2_ask2_answer1);
        quiz2_ask2_answer2 = (CheckBox) findViewById(R.id.quiz2_ask2_answer2);
        quiz2_ask2_answer3 = (CheckBox) findViewById(R.id.quiz2_ask2_answer3);

        Bundle bundle = getIntent().getExtras();
        Bitmap bitmap = bundle.getParcelable("quiz2_ask2_bundle");

        quiz2_ask2_answer.setImageBitmap(bitmap);

        quiz2_ask2_answer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (quiz2_ask2_answer1.isChecked()) {
                    quiz2_ask2_isRight[0] = true;
                } else {
                    quiz2_ask2_isRight[0] = false;
                }
            }
        });

        quiz2_ask2_answer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (quiz2_ask2_answer2.isChecked()) {
                    quiz2_ask2_isRight[1] = true;
                } else {
                    quiz2_ask2_isRight[1] = false;
                }
            }
        });

        quiz2_ask2_answer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (quiz2_ask2_answer3.isChecked()) {
                    quiz2_ask2_isRight[2] = true;
                } else {
                    quiz2_ask2_isRight[2] = false;
                }
            }
        });
    }
    public void onClick2(View v) {
        switch (v.getId()) {
            case R.id.moca_q2a2j_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz2_ask2_judge.this, moca_quiz3.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBooleanArray("quiz2_ask2_answer", quiz2_ask2_isRight);
                bundle.putBoolean("quiz1_answer", bundle1.getBoolean("quiz1_answer"));
                bundle.putParcelable("quiz2_ask_bundle", bundle1.getParcelable("quiz2_ask_bundle"));
                bundle.putBoolean("quiz2_ask_answer", bundle1.getBoolean("quiz2_ask_answer"));
                bundle.putParcelable("quiz2_ask2_bundle", bundle1.getParcelable("quiz2_ask2_bundle"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz2_ask2_judge.this.finish();
                break;
        }
    }
}
