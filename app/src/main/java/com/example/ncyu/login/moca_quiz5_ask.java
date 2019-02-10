package com.example.ncyu.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class moca_quiz5_ask extends AppCompatActivity {
    Button yes1, yes2;
    Button wrong1, wrong2;
    Button next;
    Boolean quiz5_ask1_isRight = false, quiz5_ask2_isRight = false, quiz5_ask3_isRight = false;
    Boolean isSelectedY1 = false, isSelectedY2 = false;
    Boolean isSelectedN1 = false, isSelectedN2 = false;
    Button quiz5_part3_num[] = new Button[29];
    ScrollView quiz5_part1, quiz5_part2, quiz5_part3;
    int num[] = new int[29];
    int quiz5_ask3_right = 0, quiz5_ask3_wrong = 0;
    int quiz5_ask3_pick[] = new int[29];
    int quiz5_ask3_pick_num = 0;
    int num_one[] = new int[11];
    Toast toast;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz5_ask);
        context = this;

        yes1 = (Button) findViewById(R.id.yes);
        yes2 = (Button) findViewById(R.id.yes2);
        wrong1 = (Button) findViewById(R.id.wrong);
        wrong2 = (Button) findViewById(R.id.wrong2);
        quiz5_part1 = (ScrollView) findViewById(R.id.quiz5_part1);
        quiz5_part2 = (ScrollView) findViewById(R.id.quiz5_part2);
        quiz5_part3 = (ScrollView) findViewById(R.id.quiz5_part3);
        quiz5_part3_num[0] = (Button) findViewById(R.id.quiz5_part3_num1);
        quiz5_part3_num[1] = (Button) findViewById(R.id.quiz5_part3_num2);
        quiz5_part3_num[2] = (Button) findViewById(R.id.quiz5_part3_num3);
        quiz5_part3_num[3] = (Button) findViewById(R.id.quiz5_part3_num4);
        quiz5_part3_num[4] = (Button) findViewById(R.id.quiz5_part3_num5);
        quiz5_part3_num[5] = (Button) findViewById(R.id.quiz5_part3_num6);
        quiz5_part3_num[6] = (Button) findViewById(R.id.quiz5_part3_num7);
        quiz5_part3_num[7] = (Button) findViewById(R.id.quiz5_part3_num8);
        quiz5_part3_num[8] = (Button) findViewById(R.id.quiz5_part3_num9);
        quiz5_part3_num[9] = (Button) findViewById(R.id.quiz5_part3_num10);
        quiz5_part3_num[10] = (Button) findViewById(R.id.quiz5_part3_num11);
        quiz5_part3_num[11] = (Button) findViewById(R.id.quiz5_part3_num12);
        quiz5_part3_num[12] = (Button) findViewById(R.id.quiz5_part3_num13);
        quiz5_part3_num[13] = (Button) findViewById(R.id.quiz5_part3_num14);
        quiz5_part3_num[14] = (Button) findViewById(R.id.quiz5_part3_num15);
        quiz5_part3_num[15] = (Button) findViewById(R.id.quiz5_part3_num16);
        quiz5_part3_num[16] = (Button) findViewById(R.id.quiz5_part3_num17);
        quiz5_part3_num[17] = (Button) findViewById(R.id.quiz5_part3_num18);
        quiz5_part3_num[18] = (Button) findViewById(R.id.quiz5_part3_num19);
        quiz5_part3_num[19] = (Button) findViewById(R.id.quiz5_part3_num20);
        quiz5_part3_num[20] = (Button) findViewById(R.id.quiz5_part3_num21);
        quiz5_part3_num[21] = (Button) findViewById(R.id.quiz5_part3_num22);
        quiz5_part3_num[22] = (Button) findViewById(R.id.quiz5_part3_num23);
        quiz5_part3_num[23] = (Button) findViewById(R.id.quiz5_part3_num24);
        quiz5_part3_num[24] = (Button) findViewById(R.id.quiz5_part3_num25);
        quiz5_part3_num[25] = (Button) findViewById(R.id.quiz5_part3_num26);
        quiz5_part3_num[26] = (Button) findViewById(R.id.quiz5_part3_num27);
        quiz5_part3_num[27] = (Button) findViewById(R.id.quiz5_part3_num28);
        quiz5_part3_num[28] = (Button) findViewById(R.id.quiz5_part3_num29);

        next = (Button) findViewById(R.id.moca_q5a_next);

        for (int i = 0; i < 11; i++) {
            num_one[i] = (int) ((Math.random() * 29));
            for (int j = 0; j < i; j++) {
                if (num_one[j] == num_one[i]) {
                    i = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < 29; i++) {
            num[i] = (int) ((Math.random() * 10));
            quiz5_part3_num[i].setText("" + num[i]);
            if (num[i] != 1) {
                for (int j = 0; j < 11; j++) {
                    if (i == num_one[j]) {
                        quiz5_part3_num[i].setText(""+ 1);
                    }
                }
            } else {
                i = 0;
            }
        }
    }
    public void onClick(View v) {
        int result = v.getId();

        if ((result == R.id.yes) && (isSelectedN1 == false)) {
            yes1.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedY1 = true;
            quiz5_ask1_isRight = true;
        } else if ((result == R.id.wrong) && (isSelectedY1 == false)) {
            wrong1.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedN1 = true;
            quiz5_ask1_isRight = false;
        } else if ((result == R.id.yes) && (isSelectedN1 == true)) {
            yes1.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedY1 = true;
            wrong1.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            isSelectedN1 = false;
            quiz5_ask1_isRight = true;
        } else if (((result == R.id.wrong) && (isSelectedY1 == true))) {
            wrong1.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedN1 = true;
            yes1.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            isSelectedY1 = false;
            quiz5_ask2_isRight = false;
        } else if (result == R.id.enter) {
            quiz5_part1.setVisibility(View.GONE);
            quiz5_part2.setVisibility(View.VISIBLE);
        }

        if ((result == R.id.yes2) && (isSelectedN2 == false)) {
            yes2.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedY2 = true;
            quiz5_ask2_isRight = true;
        } else if ((result == R.id.wrong2) && (isSelectedY2 == false)) {
            wrong2.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedN2 = true;
            quiz5_ask2_isRight = false;
        } else if ((result == R.id.yes2) && (isSelectedN2 == true)) {
            yes2.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedY2 = true;
            wrong2.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            isSelectedN2 = false;
            quiz5_ask2_isRight = true;
        } else if (((result == R.id.wrong2) && (isSelectedY2 == true))) {
            wrong2.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedN2 = true;
            yes2.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            isSelectedY2 = false;
            quiz5_ask2_isRight = false;
        } else if (result == R.id.enter2) {
            quiz5_part2.setVisibility(View.GONE);
            quiz5_part3.setVisibility(View.VISIBLE);
        }
    }

    public void onClick3(View v) {

        for (int i = 0; i < 29; i++) {
            if (quiz5_ask3_pick[i] == v.getId()) {
                if (((Button) findViewById(v.getId())).getText().equals("1")) {
                    ((Button) findViewById(v.getId())).setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    quiz5_ask3_right = quiz5_ask3_right - 1;
                } else {
                    ((Button) findViewById(v.getId())).setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                    quiz5_ask3_wrong = quiz5_ask3_wrong - 1;

                    if (quiz5_ask3_right == 11 && quiz5_ask3_wrong == 0) {
                        for (int j = 0; j < 29; j++) {
                            quiz5_part3_num[j].setEnabled(false);
                        }
                        toast.makeText(context, "恭喜你答對了!", Toast.LENGTH_SHORT).show();
                        quiz5_ask3_isRight = true;
                        next.setText("下一題");
                    } else if (quiz5_ask3_right == 10 && quiz5_ask3_wrong == 0) {
                        toast.makeText(context, "你快接近答對了!", Toast.LENGTH_SHORT).show();
                        quiz5_ask3_isRight = true;
                        next.setText("下一題");
                    } else {
                        quiz5_ask3_isRight = false;
                    }
                }
                quiz5_ask3_pick[i] = -1;
                break;
            }
            if (i == 28) {
                quiz5_ask3_pick[quiz5_ask3_pick_num] = v.getId();
                quiz5_ask3_pick_num = quiz5_ask3_pick_num + 1;

                if (((Button) findViewById(v.getId())).getText().equals("1")) {
                    ((Button) findViewById(v.getId())).setBackgroundColor(getResources().getColor(R.color.colorGreen));
                    quiz5_ask3_right = quiz5_ask3_right + 1;

                    if (quiz5_ask3_right == 11 && quiz5_ask3_wrong == 0) {
                        for (int j = 0; j < 29; j++) {
                            quiz5_part3_num[j].setEnabled(false);
                        }
                        toast.makeText(context, "恭喜你答對了!", Toast.LENGTH_SHORT).show();
                        quiz5_ask3_isRight = true;
                        next.setText("下一題");
                    } else if (quiz5_ask3_right == 10 && quiz5_ask3_wrong == 0) {
                        toast.makeText(context, "你快接近答對了!", Toast.LENGTH_SHORT).show();
                        quiz5_ask3_isRight = true;
                        next.setText("下一題");
                    } else {
                        quiz5_ask3_isRight = false;
                    }
                } else {
                    ((Button) findViewById(v.getId())).setBackgroundColor(getResources().getColor(R.color.colorRed));
                    quiz5_ask3_wrong = quiz5_ask3_wrong + 1;
                }
            }
        }

    }

    public void onClick2(View v){
        switch (v.getId()){
            case R.id.moca_q5a_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz5_ask.this, moca_quiz5_ask2.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBoolean("quiz5_ask1_answer1",quiz5_ask1_isRight);
                bundle.putBoolean("quiz5_ask1_answer2",quiz5_ask2_isRight);
                bundle.putBoolean("quiz5_ask1_answer3",quiz5_ask3_isRight);

                bundle.putBoolean("quiz1_answer",bundle1.getBoolean("quiz1_answer"));
                bundle.putParcelable("quiz2_ask_bundle",bundle1.getParcelable("quiz2_ask_bundle"));
                bundle.putBoolean("quiz2_ask_answer", bundle1.getBoolean("quiz2_ask_answer"));
                bundle.putParcelable("quiz2_ask2_bundle",bundle1.getParcelable("quiz2_ask2_bundle"));
                bundle.putBooleanArray("quiz2_ask2_answer",  bundle1.getBooleanArray("quiz2_ask2_answer"));
                bundle.putBooleanArray("quiz3_answer",bundle1.getBooleanArray("quiz3_answer"));
                bundle.putBooleanArray("quiz4_answer_first", bundle1.getBooleanArray("quiz4_answer_first"));
                bundle.putBooleanArray("quiz4_answer_second", bundle1.getBooleanArray("quiz4_answer_second"));
                bundle.putStringArray("quiz4_word_bundle",bundle1.getStringArray("quiz4_word_bundle"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz5_ask.this.finish();
                break;
        }

    }
}
