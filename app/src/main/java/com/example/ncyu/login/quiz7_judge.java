package com.example.ncyu.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class quiz7_judge extends AppCompatActivity {

    ImageView quiz7_answer;
    Button yes;
    Button wrong;
    Button next;
    Boolean quiz7_isRight=false;
    Boolean isAnswered = false;
    Boolean isSelectedY = false;
    Boolean isSelectedN = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz7_judge);
        yes = (Button) findViewById(R.id.yes);
        wrong = (Button) findViewById(R.id.wrong);
        next = (Button) findViewById(R.id.next);
        quiz7_answer=(ImageView)findViewById(R.id.quiz7_answer);

        Bundle bundle=getIntent().getExtras();
        Bitmap bitmap=bundle.getParcelable("quiz7_bundle");

        quiz7_answer.setImageBitmap(bitmap);
    }

    public void onClick(View v) {
        int result = v.getId();

        if ((result == R.id.yes) && (isSelectedN == false)) {
            yes.setBackgroundColor(getColor(R.color.colorRed));
            isSelectedY = true;
            isAnswered = true;
            quiz7_isRight=true;
        } else if ((result == R.id.wrong) && (isSelectedY == false)) {
            wrong.setBackgroundColor(getColor(R.color.colorRed));
            isSelectedN = true;
            isAnswered = true;
            quiz7_isRight=false;
        } else if ((result == R.id.yes) && (isSelectedN == true)) {
            yes.setBackgroundColor(getColor(R.color.colorRed));
            isSelectedY = true;
            wrong.setBackgroundColor(getColor(R.color.colorButtomNormal));
            isSelectedN = false;
            quiz7_isRight=true;
        } else {
            wrong.setBackgroundColor(getColor(R.color.colorRed));
            isSelectedN = true;
            yes.setBackgroundColor(getColor(R.color.colorButtomNormal));
            isSelectedY = false;
            quiz7_isRight=false;
        }
    }

    public void onClick2(View v){
        switch (v.getId()){
            case R.id.next:
                Intent intent=new Intent();
                intent.setClass(quiz7_judge.this,quiz_8.class);
                Bundle bundle=new Bundle();
                bundle.putBoolean("quiz7_answer",quiz7_isRight);

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
                bundle.putString("quiz6_ask3_quiz",bundle1.getString("quiz6_ask3_quiz"));
                bundle.putBoolean("quiz6_ask3_answer",bundle1.getBoolean("quiz6_ask3_answer"));
                bundle.putString("quiz6_ask4_answer",bundle1.getString("quiz6_ask4_answer"));
                bundle.putParcelable("quiz7_bundle",bundle1.getParcelable("quiz7_bundle"));

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putString("identity",bundle1.getString("identity"));

                intent.putExtras(bundle);
                startActivity(intent);
                quiz7_judge.this.finish();
                break;
        }
    }


}
