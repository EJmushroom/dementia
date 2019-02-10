package com.example.ncyu.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class quiz5_ask extends AppCompatActivity {
    Button quiz5_word1,quiz5_word2,quiz5_word3;
    String quiz3_word_bundle[] = new String[3];
    boolean quiz5_word[]={false,false,false};
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5_ask);

        quiz5_word1=(Button)findViewById(R.id.quiz5_word1);
        quiz5_word2=(Button)findViewById(R.id.quiz5_word2);
        quiz5_word3=(Button)findViewById(R.id.quiz5_word3);

        String[] quiz3_ask_quiz = getResources().getStringArray(R.array.quiz3_quiz);

       bundle=this.getIntent().getExtras();
        if(bundle!=null) {
            quiz3_word_bundle = bundle.getStringArray("quiz3_word_bundle");
            if(quiz3_word_bundle!=null) {
                quiz5_word1.setText(quiz3_word_bundle[0]);
                quiz5_word2.setText(quiz3_word_bundle[1]);
                quiz5_word3.setText(quiz3_word_bundle[2]);
            }
        }
    }

    public void onClick2(View v){
        int result=v.getId();
        if(result==R.id.quiz5_word1){
            if(quiz5_word[0]==false) {
                quiz5_word1.setBackgroundColor(getColor(R.color.colorRed));
                quiz5_word[0]=true;
            }else{
                quiz5_word1.setBackgroundColor(getColor(R.color.colorButtomNormal));
                quiz5_word[0]=false;
            }
        }else if(result==R.id.quiz5_word2){
            if(quiz5_word[1]==false) {
                quiz5_word2.setBackgroundColor(getColor(R.color.colorRed));
                quiz5_word[1]=true;
            }else{
                quiz5_word2.setBackgroundColor(getColor(R.color.colorButtomNormal));
                quiz5_word[1]=false;
            }
        }else if(result==R.id.quiz5_word3){
            if(quiz5_word[2]==false) {
                quiz5_word3.setBackgroundColor(getColor(R.color.colorRed));
                quiz5_word[2]=true;
            }else{
                quiz5_word3.setBackgroundColor(getColor(R.color.colorButtomNormal));
                quiz5_word[2]=false;
            }
        }
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.next:

                Intent intent=new Intent();
                intent.setClass(quiz5_ask.this,quiz_6.class);
                Bundle bundle=new Bundle();
                bundle.putBooleanArray("quiz5_word",quiz5_word);

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

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putString("identity",bundle1.getString("identity"));

                intent.putExtras(bundle);
                startActivity(intent);

                quiz5_ask.this.finish();
                break;
        }
    }
}
