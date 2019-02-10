package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class moca_quiz6_ask extends AppCompatActivity {
    TextView quiz6_ask_quiz;
    TextView quiz6_ask_title;
    Button quiz6_ask_quiz_right, quiz6_ask_quiz_wrong, quiz6_ask_enter;
    boolean quiz6_ask_quiz_isRight[] = new boolean[]{false, false};
    boolean quiz6_ask_quiz_isAnswer[]=new boolean[]{false,false};
    String quiz6_ask_word[] = new String[2];
    int quiz6_ask_quiz_current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz6_ask);
        quiz6_ask_quiz = (TextView) findViewById(R.id.quiz6_ask_quiz);
        quiz6_ask_quiz_right = (Button) findViewById(R.id.quiz6_ask_quiz_right);
        quiz6_ask_quiz_wrong = (Button) findViewById(R.id.quiz6_ask_quiz_wrong);
        quiz6_ask_title = (TextView) findViewById(R.id.quiz6_ask_title);
        quiz6_ask_enter = (Button) findViewById(R.id.quiz6_ask_enter);

        quiz6_ask_word = getResources().getStringArray(R.array.moca_quiz6_ask_word);

        quiz6_ask_quiz.setText(quiz6_ask_word[quiz6_ask_quiz_current]);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quiz6_ask_quiz_right:
                quiz6_ask_quiz_isRight[quiz6_ask_quiz_current] = true;
                quiz6_ask_quiz_isAnswer[quiz6_ask_quiz_current]=true;
                quiz6_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorRed));
                quiz6_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                break;
            case R.id.quiz6_ask_quiz_wrong:
                quiz6_ask_quiz_isRight[quiz6_ask_quiz_current] = false;
                quiz6_ask_quiz_isAnswer[quiz6_ask_quiz_current]=true;
                quiz6_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorRed));
                quiz6_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                break;
            case R.id.quiz6_ask_enter:
                if (quiz6_ask_quiz_current == 0) {
                    quiz6_ask_quiz_current = 1;
                    quiz6_ask_quiz.setText(quiz6_ask_word[quiz6_ask_quiz_current]);
                    quiz6_ask_title.setText("第二題");
                    if(quiz6_ask_quiz_isRight[quiz6_ask_quiz_current]==true){
                        quiz6_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorRed));
                        quiz6_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    }else if(quiz6_ask_quiz_isRight[quiz6_ask_quiz_current]==false){
                        quiz6_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                        quiz6_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorRed));
                    }
                    if(quiz6_ask_quiz_isAnswer[quiz6_ask_quiz_current]==false){
                        quiz6_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                        quiz6_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    }
                    quiz6_ask_enter.setText("返回第一題");
                }else if(quiz6_ask_quiz_current == 1){
                    quiz6_ask_quiz_current = 0;
                    quiz6_ask_quiz.setText(quiz6_ask_word[quiz6_ask_quiz_current]);
                    quiz6_ask_title.setText("第一題");
                    if(quiz6_ask_quiz_isRight[quiz6_ask_quiz_current]==true){
                        quiz6_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorRed));
                        quiz6_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    }else if(quiz6_ask_quiz_isRight[quiz6_ask_quiz_current]==false){
                        quiz6_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                        quiz6_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorRed));
                    }
                    if(quiz6_ask_quiz_isAnswer[quiz6_ask_quiz_current]==false){
                        quiz6_ask_quiz_right.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                        quiz6_ask_quiz_wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    }
                    quiz6_ask_enter.setText("進入第二題");
                }
                break;
        }
    }

    public void onClick2(View v) {
        switch (v.getId()) {
            case R.id.moca_q6a_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz6_ask.this, moca_quiz6_ask2.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBooleanArray("quiz6_ask_quiz_isRight", quiz6_ask_quiz_isRight);

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

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz6_ask.this.finish();
                break;
        }

    }
}
