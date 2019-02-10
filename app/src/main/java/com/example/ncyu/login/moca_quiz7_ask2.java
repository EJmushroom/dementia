package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class moca_quiz7_ask2 extends AppCompatActivity {
    String quiz7_ask_question[] = new String[3];
    String quiz7_ask_answer[] = new String[3];
    int quiz7_ask_quiz_current = 1;
    TextView quiz7_ask_quiz, quiz7_ask_ans, quiz7_ask_title;
    boolean quiz7_ask_quiz_isRight[] = new boolean[]{false,false, false};
    boolean quiz7_ask_quiz_isAnswer[] = new boolean[]{false,false, false};
    Button quiz7_ask_quiz_right, quiz7_ask_quiz_wrong, quiz7_ask_enter;
    boolean quiz7_answer[]=new boolean[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz7_ask2);
        quiz7_ask_question = getResources().getStringArray(R.array.moca_quiz7_ask_quiz);
        quiz7_ask_answer = getResources().getStringArray(R.array.moca_quiz7_ask_answer);

        quiz7_ask_quiz = (TextView) findViewById(R.id.quiz7_ask_quiz);
        quiz7_ask_ans = (TextView) findViewById(R.id.quiz7_ask_ans);
        quiz7_ask_title = (TextView) findViewById(R.id.quiz7_ask_title);
        quiz7_ask_quiz_right = (Button) findViewById(R.id.quiz7_ask_quiz_right);
        quiz7_ask_quiz_wrong = (Button) findViewById(R.id.quiz7_ask_quiz_wrong);
        quiz7_ask_enter = (Button) findViewById(R.id.quiz7_ask_enter);

        quiz7_ask_quiz.setText(quiz7_ask_question[quiz7_ask_quiz_current]);
        quiz7_ask_ans.setText(quiz7_ask_answer[quiz7_ask_quiz_current]);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quiz7_ask_quiz_right:
                quiz7_ask_quiz_isRight[quiz7_ask_quiz_current] = true;
                quiz7_ask_quiz_isAnswer[quiz7_ask_quiz_current] = true;
                quiz7_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorRed));
                quiz7_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                break;
            case R.id.quiz7_ask_quiz_wrong:
                quiz7_ask_quiz_isRight[quiz7_ask_quiz_current] = false;
                quiz7_ask_quiz_isAnswer[quiz7_ask_quiz_current] = true;
                quiz7_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorRed));
                quiz7_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                break;
            case R.id.quiz7_ask_enter:
                if (quiz7_ask_quiz_current == 1) {
                    quiz7_ask_quiz_current = 2;
                    quiz7_ask_quiz.setText(quiz7_ask_question[quiz7_ask_quiz_current]);
                    quiz7_ask_ans.setText(quiz7_ask_answer[quiz7_ask_quiz_current]);
                    if (quiz7_ask_quiz_isRight[quiz7_ask_quiz_current] == true) {
                        quiz7_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorRed));
                        quiz7_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    } else if (quiz7_ask_quiz_isRight[quiz7_ask_quiz_current] == false && quiz7_ask_quiz_isAnswer[quiz7_ask_quiz_current] == true) {
                        quiz7_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                        quiz7_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorRed));
                    }else {
                        quiz7_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                        quiz7_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    }
                    quiz7_ask_title.setText("第二題");
                    quiz7_ask_enter.setText("返回第一題");
                } else if (quiz7_ask_quiz_current == 2) {
                    quiz7_ask_quiz_current = 1;
                    quiz7_ask_quiz.setText(quiz7_ask_question[quiz7_ask_quiz_current]);
                    quiz7_ask_ans.setText(quiz7_ask_answer[quiz7_ask_quiz_current]);
                    quiz7_ask_title.setText("第一題");
                    quiz7_ask_enter.setText("進入第二題");
                    if (quiz7_ask_quiz_isRight[quiz7_ask_quiz_current] == true) {
                        quiz7_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorRed));
                        quiz7_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    } else if (quiz7_ask_quiz_isRight[quiz7_ask_quiz_current] == false && quiz7_ask_quiz_isAnswer[quiz7_ask_quiz_current] == true) {
                        quiz7_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                        quiz7_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorRed));
                    }else {
                        quiz7_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                        quiz7_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    }
                }
                break;
        }
    }

    public void onClick2(View v) {
        switch (v.getId()) {
            case R.id.moca_q7a2_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz7_ask2.this, moca_quiz8.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                quiz7_answer[0]=quiz7_ask_quiz_isRight[1];
                quiz7_answer[1]=quiz7_ask_quiz_isRight[2];
                bundle.putBooleanArray("quiz7_answer",quiz7_answer);


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

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz7_ask2.this.finish();
                break;
        }

    }
}
