package com.example.ncyu.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class quiz4_ask extends AppCompatActivity {

    TextView quiz,quiz4_notice;
    Button right,wrong_submit;
    int turns=0;
    String patient_answer[]=new String[5];
    String quiz4_answer[]={"","","","",""};
    String quiz4_quiz[]=new String[5];
    String quiz4_warning[]=new String[2];
    EditText wrong_answer;
    Toast toast;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4_ask);

        context=this;

        quiz=(TextView)findViewById(R.id.quiz);
        right=(Button)findViewById(R.id.right);
        wrong_submit=(Button)findViewById(R.id.wrong_submit);
        wrong_answer=(EditText)findViewById(R.id.wrong_answer);
        quiz4_notice=(TextView)findViewById(R.id.quiz4_notice);

        quiz4_answer = getResources().getStringArray(R.array.quiz4_answer);
        quiz4_quiz=getResources().getStringArray(R.array.quiz4_quiz);
        quiz4_warning=getResources().getStringArray(R.array.quiz4_warning);

        right.setText(quiz4_answer[0]);
        quiz.setText(quiz4_quiz[0]);

    }

    public void onClick2(View v){
        switch (v.getId()){
            case R.id.right:
                if(turns<=5){
                    patient_answer[turns]=right.getText().toString();
                    turns=turns+1;
                    if(turns<=4) {
                        right.setText(quiz4_answer[turns]);
                        quiz.setText(quiz4_quiz[turns]);
                    }
                }
                if(turns==5){
                    right.setEnabled(false);
                    wrong_answer.setEnabled(false);
                    wrong_submit.setEnabled(false);
                }
                break;
            case R.id.wrong_submit:
                if(turns<=5){
                    patient_answer[turns]=wrong_answer.getText().toString();
                    turns=turns+1;
                    if(turns<=4) {
                        right.setText(quiz4_answer[turns]);
                        quiz.setText(quiz4_quiz[turns]);
                    }
                }
                if(turns==5){
                    right.setEnabled(false);
                    wrong_answer.setEnabled(false);
                    wrong_submit.setEnabled(false);
                }
                if(turns<=4) {
                    if (patient_answer[turns - 1].equals(quiz4_answer[turns - 1])) {
                        quiz4_notice.setText(quiz4_warning[1]);
                    } else {
                        quiz4_notice.setText(quiz4_warning[0]);
                    }
                }
                break;
        }
    }

    public void onClick(View v){
        switch (v.getId()){

            case R.id.next:
                Intent intent=new Intent();
                intent.setClass(quiz4_ask.this,quiz_5.class);
                Bundle bundle=new Bundle();
                bundle.putStringArray("quiz4_answer",patient_answer);

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

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putString("identity",bundle1.getString("identity"));

                intent.putExtras(bundle);
                startActivity(intent);
                quiz4_ask.this.finish();
                break;
        }
    }
}
