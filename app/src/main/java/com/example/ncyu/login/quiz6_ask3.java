package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quiz6_ask3 extends AppCompatActivity {

    boolean quiz6_ask3_quiz_isRight=false,quiz6_ask3_quiz_isStarted=false;
    Button quiz6_ask3_quiz_right,quiz6_ask3_quiz_wrong,quiz6_ask3_quiz,quiz6_ask3_quiz_next;
    TextView quiz6_ask3_quiz_judge,quiz6_ask3_quiz_introduce;
    String[] quiz6_ask3_allquiz;
    String quiz6_ask3_goal;
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6_ask3);

        quiz6_ask3_allquiz = getResources().getStringArray(R.array.quiz6_ask3_quiz);
        num=(int)(Math.random()*quiz6_ask3_allquiz.length);

        quiz6_ask3_quiz_right=(Button)findViewById(R.id.quiz6_ask3_quiz_right);
        quiz6_ask3_quiz_wrong=(Button)findViewById(R.id.quiz6_ask3_quiz_wrong);
        quiz6_ask3_quiz=(Button)findViewById(R.id.quiz6_ask3_quiz);
        quiz6_ask3_quiz_judge=(TextView)findViewById(R.id.quiz6_ask3_quiz_judge);
        quiz6_ask3_quiz_introduce=(TextView)findViewById(R.id.quiz6_ask3_quiz_introduce);
//        quiz6_ask3_quiz_previous=(Button)findViewById(R.id.previous);
        quiz6_ask3_quiz_next=(Button)findViewById(R.id.next);
    }

    public void onClick2(View v){
        switch (v.getId()){
            case R.id.quiz6_ask3_quiz_right:
                quiz6_ask3_quiz_isRight=true;
                quiz6_ask3_quiz_right.setBackgroundColor(getColor(R.color.colorRed));
                quiz6_ask3_quiz_wrong.setBackgroundColor(getColor(R.color.colorButtomNormal));
                break;
            case R.id.quiz6_ask3_quiz_wrong:
                quiz6_ask3_quiz_isRight=false;
                quiz6_ask3_quiz_wrong.setBackgroundColor(getColor(R.color.colorRed));
                quiz6_ask3_quiz_right.setBackgroundColor(getColor(R.color.colorButtomNormal));
                break;
            case R.id.quiz6_ask3_quiz:
                if(quiz6_ask3_quiz_isStarted==false){
                    quiz6_ask3_quiz_isStarted=true;
                    quiz6_ask3_quiz.setText(quiz6_ask3_allquiz[num]);

//                    quiz6_ask3_quiz_previous.setEnabled(false);
                    quiz6_ask3_quiz_next.setEnabled(false);
//                    quiz6_ask3_quiz_previous.setVisibility(View.INVISIBLE);
                    quiz6_ask3_quiz_next.setVisibility(View.INVISIBLE);
                    quiz6_ask3_quiz_introduce.setEnabled(false);
                    quiz6_ask3_quiz_introduce.setVisibility(View.INVISIBLE);
                }else if(quiz6_ask3_quiz_isStarted==true){
                    quiz6_ask3_quiz.setText("結束");
                    quiz6_ask3_quiz.setEnabled(false);
                    quiz6_ask3_quiz_judge.setVisibility(View.VISIBLE);
                    quiz6_ask3_quiz_right.setVisibility(View.VISIBLE);
                    quiz6_ask3_quiz_wrong.setVisibility(View.VISIBLE);
                    quiz6_ask3_quiz_judge.setEnabled(true);
                    quiz6_ask3_quiz_right.setEnabled(true);
                    quiz6_ask3_quiz_wrong.setEnabled(true);

//                    quiz6_ask3_quiz_previous.setEnabled(true);
                    quiz6_ask3_quiz_next.setEnabled(true);
//                    quiz6_ask3_quiz_previous.setVisibility(View.VISIBLE);
                    quiz6_ask3_quiz_next.setVisibility(View.VISIBLE);

                }

        }
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.next:
                quiz6_ask3_goal=quiz6_ask3_allquiz[num];

                Intent intent=new Intent();
                intent.setClass(quiz6_ask3.this,quiz6_ask4.class);
                Bundle bundle=new Bundle();
                bundle.putString("quiz6_ask3_quiz",quiz6_ask3_goal);
                bundle.putBoolean("quiz6_ask3_answer",quiz6_ask3_quiz_isRight);

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
                bundle.putBooleanArray("quiz2_ask_isAnswer", bundle1.getBooleanArray("quiz2_ask_isAnswer"));
                bundle.putBooleanArray("quiz2_ask_disAnswer",bundle1.getBooleanArray("quiz2_ask_disAnswer"));
                bundle.putStringArray("quiz2_answer",bundle1.getStringArray("quiz2_answer"));
                bundle.putStringArray("quiz3_word_bundle",bundle1.getStringArray("quiz3_word_bundle"));
                bundle.putBooleanArray("quiz3_word",bundle1.getBooleanArray("quiz3_word"));
                bundle.putStringArray("quiz4_answer",bundle1.getStringArray("quiz4_answer"));
                bundle.putBooleanArray("quiz5_word",bundle1.getBooleanArray("quiz5_word"));
                bundle.putStringArray("quiz6_ask1_word",bundle1.getStringArray("quiz6_ask1_word"));
                bundle.putString("quiz6_ask2_word",bundle1.getString("quiz6_ask2_word"));
                bundle.putBoolean("quiz6_ask2_answer",bundle1.getBoolean("quiz6_ask2_answer"));

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putString("identity",bundle1.getString("identity"));

                intent.putExtras(bundle);
                startActivity(intent);
                quiz6_ask3.this.finish();
                break;
        }
    }
}
