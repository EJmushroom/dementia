package com.example.ncyu.login;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class moca_quiz1_ask extends AppCompatActivity {

    Button quiz1_dot1, quiz1_dot2, quiz1_dot3, quiz1_dot4, quiz1_dot5, quiz1_dot6, quiz1_dot7, quiz1_dot8, quiz1_dot9, quiz1_dot10;
    int quiz1_word_num[] = new int[10];
    String[] quiz1_word;
    int quiz1_answer_num = 0;
    Boolean quiz1_answer = false;
    Toast toast;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz1_ask);

        context=this;

        quiz1_dot1 = (Button) findViewById(R.id.moca_quiz1_dot1);
        quiz1_dot2 = (Button) findViewById(R.id.moca_quiz1_dot2);
        quiz1_dot3 = (Button) findViewById(R.id.moca_quiz1_dot3);
        quiz1_dot4 = (Button) findViewById(R.id.moca_quiz1_dot4);
        quiz1_dot5 = (Button) findViewById(R.id.moca_quiz1_dot5);
        quiz1_dot6 = (Button) findViewById(R.id.moca_quiz1_dot6);
        quiz1_dot7 = (Button) findViewById(R.id.moca_quiz1_dot7);
        quiz1_dot8 = (Button) findViewById(R.id.moca_quiz1_dot8);
        quiz1_dot9 = (Button) findViewById(R.id.moca_quiz1_dot9);
        quiz1_dot10 = (Button) findViewById(R.id.moca_quiz1_dot10);

        quiz1_word = getResources().getStringArray(R.array.moca_quiz1_word);
        for (int i = 0; i < 10; i++) {
            quiz1_word_num[i] = (int) (Math.random() * quiz1_word.length);
            for (int j = 0; j < i; j++) {
                if (quiz1_word_num[i] == quiz1_word_num[j]) {
                    i = 0;
                }
            }
        }

        quiz1_dot1.setText(quiz1_word[quiz1_word_num[0]]);
        quiz1_dot2.setText(quiz1_word[quiz1_word_num[1]]);
        quiz1_dot3.setText(quiz1_word[quiz1_word_num[2]]);
        quiz1_dot4.setText(quiz1_word[quiz1_word_num[3]]);
        quiz1_dot5.setText(quiz1_word[quiz1_word_num[4]]);
        quiz1_dot6.setText(quiz1_word[quiz1_word_num[5]]);
        quiz1_dot7.setText(quiz1_word[quiz1_word_num[6]]);
        quiz1_dot8.setText(quiz1_word[quiz1_word_num[7]]);
        quiz1_dot9.setText(quiz1_word[quiz1_word_num[8]]);
        quiz1_dot10.setText(quiz1_word[quiz1_word_num[9]]);
    }
    public void onClick(View v) {
        if (((Button) findViewById(v.getId())).getText().equals(quiz1_word[quiz1_answer_num]) && quiz1_answer == false) {
            ((Button) findViewById(v.getId())).setBackgroundColor(getResources().getColor(R.color.colorGreen));
            if (quiz1_answer_num < 9) {
                quiz1_answer_num = quiz1_answer_num + 1;
            }else{
                quiz1_dot1.setEnabled(false);
                quiz1_dot2.setEnabled(false);
                quiz1_dot3.setEnabled(false);
                quiz1_dot4.setEnabled(false);
                quiz1_dot5.setEnabled(false);
                quiz1_dot6.setEnabled(false);
                quiz1_dot7.setEnabled(false);
                quiz1_dot8.setEnabled(false);
                quiz1_dot9.setEnabled(false);
                quiz1_dot10.setEnabled(false);
                toast.makeText(context,"你答對了!",Toast.LENGTH_SHORT).show();
                quiz1_answer=true;
            }
        } else {
            quiz1_answer = false;
            quiz1_dot1.setEnabled(false);
            quiz1_dot2.setEnabled(false);
            quiz1_dot3.setEnabled(false);
            quiz1_dot4.setEnabled(false);
            quiz1_dot5.setEnabled(false);
            quiz1_dot6.setEnabled(false);
            quiz1_dot7.setEnabled(false);
            quiz1_dot8.setEnabled(false);
            quiz1_dot9.setEnabled(false);
            quiz1_dot10.setEnabled(false);
            toast.makeText(context,"作答錯誤!",Toast.LENGTH_SHORT).show();
            ((Button) findViewById(v.getId())).setBackgroundColor(getResources().getColor(R.color.colorRed));
        }
    }

    public void onClick2(View v) {
        switch (v.getId()) {
            case R.id.reset:
                quiz1_answer_num = 0;
                quiz1_answer = false;
                quiz1_dot1.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot2.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot3.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot4.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot5.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot6.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot7.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot8.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot9.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot10.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                quiz1_dot1.setEnabled(true);
                quiz1_dot2.setEnabled(true);
                quiz1_dot3.setEnabled(true);
                quiz1_dot4.setEnabled(true);
                quiz1_dot5.setEnabled(true);
                quiz1_dot6.setEnabled(true);
                quiz1_dot7.setEnabled(true);
                quiz1_dot8.setEnabled(true);
                quiz1_dot9.setEnabled(true);
                quiz1_dot10.setEnabled(true);
                break;
            case R.id.moca_q1a_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz1_ask.this, moca_quiz2.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBoolean("quiz1_answer", quiz1_answer);
                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz1_ask.this.finish();
                break;
        }
    }
}
