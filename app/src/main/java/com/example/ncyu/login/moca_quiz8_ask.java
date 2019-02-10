package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class moca_quiz8_ask extends AppCompatActivity {
    Button quiz8_word1, quiz8_word2, quiz8_word3, quiz8_word4, quiz8_word5;
    Button quiz8_clue[] = new Button[5];
    String quiz8_word_bundle[] = new String[5];
    boolean quiz8_word[] = {false, false, false, false, false};
    boolean quiz8_cluechoose[] = {false, false, false, false, false};
    String[] quiz8_ask_quiz = new String[5];
    String[] quiz8_quiz_clue1 = new String[5];
    String[] quiz8_quiz_clue2 = new String[5];
    TextView quiz8_getclue1, quiz8_getclue2;
    Bundle bundle;
    int quiz8_quiznum = -1;
    boolean quiz8_showclue = false;
    LinearLayout quiz8_OpenClue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz8_ask);
        quiz8_ask_quiz = getResources().getStringArray(R.array.moca_quiz4_quiz);
        quiz8_quiz_clue1 = getResources().getStringArray(R.array.moca_quiz8_quiz_clue1);
        quiz8_quiz_clue2 = getResources().getStringArray(R.array.moca_quiz8_quiz_clue2);
        quiz8_getclue1 = (TextView) findViewById(R.id.quiz8_getclue1);
        quiz8_getclue2 = (TextView) findViewById(R.id.quiz8_getclue2);
        quiz8_OpenClue = (LinearLayout) findViewById(R.id.quiz8_showClue);
        quiz8_word1 = (Button) findViewById(R.id.quiz8_word1);
        quiz8_word2 = (Button) findViewById(R.id.quiz8_word2);
        quiz8_word3 = (Button) findViewById(R.id.quiz8_word3);
        quiz8_word4 = (Button) findViewById(R.id.quiz8_word4);
        quiz8_word5 = (Button) findViewById(R.id.quiz8_word5);
        quiz8_clue[0] = (Button) findViewById(R.id.quiz8_clue1);
        quiz8_clue[1] = (Button) findViewById(R.id.quiz8_clue2);
        quiz8_clue[2] = (Button) findViewById(R.id.quiz8_clue3);
        quiz8_clue[3] = (Button) findViewById(R.id.quiz8_clue4);
        quiz8_clue[4] = (Button) findViewById(R.id.quiz8_clue5);

        bundle = this.getIntent().getExtras();
        if (bundle != null) {
            quiz8_word_bundle = bundle.getStringArray("quiz4_word_bundle");
            if (quiz8_word_bundle != null) {
                quiz8_word1.setText(quiz8_word_bundle[0]);
                quiz8_word2.setText(quiz8_word_bundle[1]);
                quiz8_word3.setText(quiz8_word_bundle[2]);
                quiz8_word4.setText(quiz8_word_bundle[3]);
                quiz8_word5.setText(quiz8_word_bundle[4]);
                for (int i = 0; i < 5; i++) {
                    quiz8_clue[i].setText(quiz8_word_bundle[i]);
                }
            }
        }
    }
    public void onClick2(View v) {
        int result = v.getId();
        if (result == R.id.quiz8_word1) {
            if (quiz8_word[0] == true) {
                quiz8_word[0] = false;
                quiz8_word1.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            } else {
                quiz8_word[0] = true;
                quiz8_word1.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            }
        } else if (result == R.id.quiz8_word2) {
            if (quiz8_word[1] == true) {
                quiz8_word[1] = false;
                quiz8_word2.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            } else {
                quiz8_word[1] = true;
                quiz8_word2.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            }
        } else if (result == R.id.quiz8_word3) {
            if (quiz8_word[2] == true) {
                quiz8_word[2] = false;
                quiz8_word3.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            } else {
                quiz8_word[2] = true;
                quiz8_word3.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            }
        } else if (result == R.id.quiz8_word4) {
            if (quiz8_word[3] == true) {
                quiz8_word[3] = false;
                quiz8_word4.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            } else {
                quiz8_word[3] = true;
                quiz8_word4.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            }
        } else if (result == R.id.quiz8_word5) {
            if (quiz8_word[4] == true) {
                quiz8_word[4] = false;
                quiz8_word5.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            } else {
                quiz8_word[4] = true;
                quiz8_word5.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            }
        }
    }

    public void onClick3(View v) {
        int result = v.getId();

        if (result == R.id.quiz8_clue1) {
            quiz8_quiznum = 0;
        } else if (result == R.id.quiz8_clue2) {
            quiz8_quiznum = 1;
        } else if (result == R.id.quiz8_clue3) {
            quiz8_quiznum = 2;
        } else if (result == R.id.quiz8_clue4) {
            quiz8_quiznum = 3;
        } else if (result == R.id.quiz8_clue5) {
            quiz8_quiznum = 4;
        }

        if (quiz8_cluechoose[quiz8_quiznum] == false) {
            quiz8_showclue = true;
            for (int i = 0; i < 5; i++) {
                if (i != quiz8_quiznum) {
                    quiz8_cluechoose[i] = false;
                    quiz8_clue[i].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz8_cluechoose[i] = true;
                    quiz8_clue[i].setBackgroundColor(getResources().getColor(R.color.colorDarkGreen));
                }
            }
        } else {
            quiz8_cluechoose[quiz8_quiznum] = false;
            quiz8_clue[quiz8_quiznum].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            quiz8_showclue = false;
        }

        for (int i = 0; i < 5; i++) {
            if (quiz8_clue[quiz8_quiznum].getText().toString().equals(quiz8_ask_quiz[i])) {
                quiz8_getclue1.setText(quiz8_quiz_clue1[i]);
                quiz8_getclue2.setText(quiz8_quiz_clue2[i]);
                break;
            }
        }

        if (quiz8_showclue == false) {
            quiz8_OpenClue.setVisibility(View.GONE);
        } else {
            quiz8_OpenClue.setVisibility(View.VISIBLE);
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.moca_q8a_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz8_ask.this, moca_quiz9.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBooleanArray("quiz8_answer", quiz8_word);

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
                bundle.putBooleanArray("quiz7_answer",bundle1.getBooleanArray("quiz7_answer"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz8_ask.this.finish();
                break;
        }

    }

}
