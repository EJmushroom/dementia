package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quiz3_ask2 extends AppCompatActivity {

    Button quiz3_word1,quiz3_word2,quiz3_word3,quiz3_plus,quiz3_minus;
    boolean[]quiz3_word={false,false,false};
    String quiz3_word_bundle[]=new String[3];
    int num[]=new int[3];
    int count=0;
    TextView try_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3_ask2);
        quiz3_word1=(Button)findViewById(R.id.quiz3_word1);
        quiz3_word2=(Button)findViewById(R.id.quiz3_word2);
        quiz3_word3=(Button)findViewById(R.id.quiz3_word3);
        quiz3_plus=(Button)findViewById(R.id.quiz3_plus);
        quiz3_minus=(Button)findViewById(R.id.quiz3_minus);
        try_count=(TextView)findViewById(R.id.try_count);

        String[] quiz3_ask_quiz = getResources().getStringArray(R.array.quiz3_quiz);
        for(int i=0;i<3;i++){
        num[i]=(int)(Math.random()*quiz3_ask_quiz.length);
            for(int j=0;j<i;j++){
                if(num[i]==num[j]){
                    i=0;
                }
            }
        }
        quiz3_word1.setText(quiz3_ask_quiz[num[0]]);
        quiz3_word2.setText(quiz3_ask_quiz[num[1]]);
        quiz3_word3.setText(quiz3_ask_quiz[num[2]]);
        quiz3_word_bundle[0]=quiz3_ask_quiz[num[0]];
        quiz3_word_bundle[1]=quiz3_ask_quiz[num[1]];
        quiz3_word_bundle[2]=quiz3_ask_quiz[num[2]];
    }

    public void onClick2(View v){
        int result=v.getId();
        if(result==R.id.quiz3_word1){
            if(quiz3_word[0]==false) {
                quiz3_word1.setBackgroundColor(getColor(R.color.colorRed));
                quiz3_word[0]=true;
            }else{
                quiz3_word1.setBackgroundColor(getColor(R.color.colorButtomNormal));
                quiz3_word[0]=false;
            }
        }else if(result==R.id.quiz3_word2){
            if(quiz3_word[1]==false) {
                quiz3_word2.setBackgroundColor(getColor(R.color.colorRed));
                quiz3_word[1]=true;
            }else{
                quiz3_word2.setBackgroundColor(getColor(R.color.colorButtomNormal));
                quiz3_word[1]=false;
            }
        }else if(result==R.id.quiz3_word3){
            if(quiz3_word[2]==false) {
                quiz3_word3.setBackgroundColor(getColor(R.color.colorRed));
                quiz3_word[2]=true;
            }else{
                quiz3_word3.setBackgroundColor(getColor(R.color.colorButtomNormal));
                quiz3_word[2]=false;
            }
        }else if(result==R.id.quiz3_plus){
            if(count<5){
                count=count+1;
                try_count.setText(String.valueOf(count));
            }
        }else if(result==R.id.quiz3_minus){
            if(count>0){
                count=count-1;
                try_count.setText(String.valueOf(count));
            }
        }
    }

    public void onClick(View v){
        switch (v.getId()){
//            case R.id.previous:
//                Intent intent=new Intent(this,quiz3_ask.class);
//                startActivity(intent);
//                quiz3_ask2.this.finish();
//                break;
            case R.id.next:

                Intent intent=new Intent();
                intent.setClass(quiz3_ask2.this,quiz_4.class);
                Bundle bundle=new Bundle();
                bundle.putStringArray("quiz3_word_bundle",quiz3_word_bundle);
                bundle.putBooleanArray("quiz3_word",quiz3_word);
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

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putString("identity",bundle1.getString("identity"));

                intent.putExtras(bundle);
                startActivity(intent);
                quiz3_ask2.this.finish();
                break;
        }
    }
}
