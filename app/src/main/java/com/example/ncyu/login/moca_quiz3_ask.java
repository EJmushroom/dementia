package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class moca_quiz3_ask extends AppCompatActivity {
    Button quiz3_start;
    Button quiz3_quiz;
    Button next;
    boolean quiz3_isRight[]={false,false,false};
    LinearLayout quiz3_part1;
    ScrollView quiz3_part2;
    TextView quiz3_ask_introduce;
    int times = 0;
    LinearLayout quiz3_next;
    CheckBox quiz3_isRight1,quiz3_isRight2,quiz3_isRight3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz3_ask);
        quiz3_start = (Button) findViewById(R.id.quiz3_start);
        quiz3_quiz = (Button) findViewById(R.id.quiz3_quiz);
        quiz3_part1 = (LinearLayout) findViewById(R.id.quiz3_part1);
        quiz3_ask_introduce = (TextView) findViewById(R.id.quiz3_ask_introduce);
        quiz3_part2 = (ScrollView) findViewById(R.id.quiz3_part2);
        quiz3_next = (LinearLayout) findViewById(R.id.quiz3_next);
        next = (Button) findViewById(R.id.moca_q3a_next);

        quiz3_isRight1 = (CheckBox) findViewById(R.id.quiz3_isRight1);
        quiz3_isRight2 = (CheckBox) findViewById(R.id.quiz3_isRight2);
        quiz3_isRight3 = (CheckBox) findViewById(R.id.quiz3_isRight3);

        quiz3_isRight1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub

                if (quiz3_isRight1.isChecked()) {
                    quiz3_isRight[0]=true;
                } else {
                    quiz3_isRight[0]=false;
                }
            }
        });
        quiz3_isRight2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (quiz3_isRight2.isChecked()){
                    quiz3_isRight[1]=true;
                }else{
                    quiz3_isRight[1]=false;
                }
            }
        });

        quiz3_isRight3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(quiz3_isRight3.isChecked()){
                    quiz3_isRight[2]=true;
                }else{
                    quiz3_isRight[2]=false;
                }
            }
        });
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quiz3_start:
                quiz3_ask_introduce.setText("點選圖片可以進入下一題");
                quiz3_ask_introduce.setTextSize(20);
                quiz3_start.setVisibility(View.GONE);
                quiz3_next.setVisibility(View.INVISIBLE);
                quiz3_part1.setVisibility(View.VISIBLE);
                quiz3_quiz.setBackground(getResources().getDrawable(R.drawable.quiz3_lion));
                times = times + 1;
                break;

            case R.id.quiz3_quiz:
                if (times == 1) {
                    quiz3_quiz.setBackground(getResources().getDrawable(R.drawable.quiz3_rigno));
                    times = times + 1;
                } else if (times == 2) {
                    quiz3_quiz.setBackground(getResources().getDrawable(R.drawable.quiz3_camal));
                    times = times + 1;
                } else {
                    quiz3_ask_introduce.setVisibility(View.GONE);
                    quiz3_next.setVisibility(View.VISIBLE);
                    next.setText("下一題");
                    quiz3_part1.setVisibility(View.GONE);
                    quiz3_part2.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    public void onClick2(View v){
        switch (v.getId()){
            case R.id.moca_q3a_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz3_ask.this, moca_quiz4.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBooleanArray("quiz3_answer", quiz3_isRight);
                bundle.putBoolean("quiz1_answer",bundle1.getBoolean("quiz1_answer"));
                bundle.putParcelable("quiz2_ask_bundle",bundle1.getParcelable("quiz2_ask_bundle"));
                bundle.putBoolean("quiz2_ask_answer", bundle1.getBoolean("quiz2_ask_answer"));
                bundle.putParcelable("quiz2_ask2_bundle",bundle1.getParcelable("quiz2_ask2_bundle"));
                bundle.putBooleanArray("quiz2_ask2_answer",  bundle1.getBooleanArray("quiz2_ask2_answer"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz3_ask.this.finish();
                break;
        }

    }
}
