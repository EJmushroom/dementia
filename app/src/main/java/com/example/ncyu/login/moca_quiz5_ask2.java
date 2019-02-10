package com.example.ncyu.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class moca_quiz5_ask2 extends AppCompatActivity {
    TextView quiz5_ask2_quiz,quiz5_ask2_notice;
    Button quiz5_ask2_right,wrong_submit;
    int turns=0;
    //String patient_answer[]=new String[5];
    String patient_answer[]={"0","0","0","0","0"};
    String quiz5_ask2_answer[]=new String[5];
    String quiz5_ask2_question[]=new String[5];
    String quiz5_ask2_warning[]=new String[2];
    EditText wrong_answer;
    int quiz5_ask2_isRight=0;
    Toast toast;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz5_ask2);
        context=this;

        quiz5_ask2_quiz=(TextView)findViewById(R.id.quiz5_ask2_quiz);
        quiz5_ask2_right=(Button)findViewById(R.id.quiz5_ask2_right);
        wrong_submit=(Button)findViewById(R.id.wrong_submit);
        wrong_answer=(EditText)findViewById(R.id.wrong_answer);
        quiz5_ask2_notice=(TextView)findViewById(R.id.quiz4_notice);

        quiz5_ask2_answer = getResources().getStringArray(R.array.moca_quiz5_ask2_answer);
        quiz5_ask2_question=getResources().getStringArray(R.array.moca_quiz5_ask2_question);
        quiz5_ask2_warning=getResources().getStringArray(R.array.moca_quiz5_ask2_warning);

        quiz5_ask2_right.setText(quiz5_ask2_answer[0]);
        quiz5_ask2_quiz.setText(quiz5_ask2_question[0]);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.quiz5_ask2_right:
                if(turns<=5){
                    patient_answer[turns]=quiz5_ask2_right.getText().toString();
                    quiz5_ask2_isRight=quiz5_ask2_isRight+1;
                    turns=turns+1;
                    if(turns<=4) {
                        quiz5_ask2_right.setText(quiz5_ask2_answer[turns]);
                        quiz5_ask2_quiz.setText(quiz5_ask2_question[turns]);
                    }
                }
                if(turns==5){
                    quiz5_ask2_right.setEnabled(false);
                    wrong_answer.setEnabled(false);
                    wrong_submit.setEnabled(false);
                }
                break;
            case R.id.wrong_submit:
                if(turns<=5){
                    patient_answer[turns]=wrong_answer.getText().toString();
                    wrong_answer.setText("");
                    turns=turns+1;
                    if(turns<=4) {
                        quiz5_ask2_right.setText(quiz5_ask2_answer[turns]);
                        quiz5_ask2_quiz.setText(quiz5_ask2_question[turns]);
                    }
                }
                if(turns==5){
                    quiz5_ask2_right.setEnabled(false);
                    wrong_answer.setEnabled(false);
                    wrong_submit.setEnabled(false);
                }
                if(turns<=4) {
                    if (patient_answer[turns - 1].equals(quiz5_ask2_answer[turns - 1])) {
                        quiz5_ask2_notice.setText(quiz5_ask2_warning[1]);
                    } else {
                        quiz5_ask2_notice.setText(quiz5_ask2_warning[0]);
                    }
                }
                break;
        }
    }
    public void onClick2(View v){
        switch (v.getId()){
            case R.id.moca_q5a2_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz5_ask2.this, moca_quiz6.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                //bundle.putStringArray("quiz5_ask2_answer",quiz5_ask2_answer);
                bundle.putStringArray("quiz5_ask2_answer",patient_answer);
                bundle.putInt("quiz5_ask2_isRight",quiz5_ask2_isRight);

                bundle.putBoolean("quiz1_answer",bundle1.getBoolean("quiz1_answer"));
                bundle.putParcelable("quiz2_ask_bundle",bundle1.getParcelable("quiz2_ask_bundle"));
                bundle.putBoolean("quiz2_ask_answer", bundle1.getBoolean("quiz2_ask_answer"));
                bundle.putParcelable("quiz2_ask2_bundle",bundle1.getParcelable("quiz2_ask2_bundle"));
                bundle.putBooleanArray("quiz2_ask2_answer",  bundle1.getBooleanArray("quiz2_ask2_answer"));
                bundle.putBooleanArray("quiz3_answer",bundle1.getBooleanArray("quiz3_answer"));
                bundle.putBooleanArray("quiz4_answer_first", bundle1.getBooleanArray("quiz4_answer_first"));
                bundle.putBooleanArray("quiz4_answer_second", bundle1.getBooleanArray("quiz4_answer_second"));
                bundle.putStringArray("quiz4_word_bundle",bundle1.getStringArray("quiz4_word_bundle"));
                bundle.putBoolean("quiz5_ask1_answer1",bundle1.getBoolean("quiz5_ask1_answer1"));
                bundle.putBoolean("quiz5_ask1_answer2",bundle1.getBoolean("quiz5_ask1_answer2"));
                bundle.putBoolean("quiz5_ask1_answer3",bundle1.getBoolean("quiz5_ask1_answer3"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz5_ask2.this.finish();
                break;
        }

    }
}
