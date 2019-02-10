package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class moca_quiz4_ask2 extends AppCompatActivity {
    Button quiz4_first, quiz4_second;
    Button quiz4_word_button[] = new Button[5];
    boolean[] quiz4_word_first = {false, false, false, false, false};
    boolean[] quiz4_word_second = {false, false, false, false, false};
    boolean[] quiz4_part = {true, false};
    String quiz4_word_bundle[] = new String[5];
    int num[] = new int[5];
    int quiz4_part_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz4_ask2);

        quiz4_word_button[0] = (Button) findViewById(R.id.quiz4_word1);
        quiz4_word_button[1] = (Button) findViewById(R.id.quiz4_word2);
        quiz4_word_button[2] = (Button) findViewById(R.id.quiz4_word3);
        quiz4_word_button[3] = (Button) findViewById(R.id.quiz4_word4);
        quiz4_word_button[4] = (Button) findViewById(R.id.quiz4_word5);
        quiz4_first = (Button) findViewById(R.id.quiz4_first);
        quiz4_second = (Button) findViewById(R.id.quiz4_second);

        String[] quiz3_ask_quiz = getResources().getStringArray(R.array.moca_quiz4_quiz);
        for (int i = 0; i < quiz4_word_bundle.length; i++) {
            num[i] = (int) (Math.random() * quiz3_ask_quiz.length);
            for (int j = 0; j < i; j++) {
                if (num[i] == num[j]) {
                    i = 0;
                }
            }
        }
        quiz4_word_button[0].setText(quiz3_ask_quiz[num[0]]);
        quiz4_word_button[1].setText(quiz3_ask_quiz[num[1]]);
        quiz4_word_button[2].setText(quiz3_ask_quiz[num[2]]);
        quiz4_word_button[3].setText(quiz3_ask_quiz[num[3]]);
        quiz4_word_button[4].setText(quiz3_ask_quiz[num[4]]);
        quiz4_word_bundle[0] = quiz3_ask_quiz[num[0]];
        quiz4_word_bundle[1] = quiz3_ask_quiz[num[1]];
        quiz4_word_bundle[2] = quiz3_ask_quiz[num[2]];
        quiz4_word_bundle[3] = quiz3_ask_quiz[num[3]];
        quiz4_word_bundle[4] = quiz3_ask_quiz[num[4]];

        quiz4_first.setBackgroundColor(getResources().getColor(R.color.colorGreen));
        quiz4_part[0] = true;
        quiz4_part_num = 0;
    }
    public void onClick2(View v) {
        int result = v.getId();
        if (result == R.id.quiz4_second && quiz4_part[1] == false) {
            quiz4_part[0] = false;
            quiz4_first.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            quiz4_part[1] = true;
            quiz4_second.setBackgroundColor(getResources().getColor(R.color.colorRed));
            quiz4_part_num = 1;

            for (int i = 0; i <= 4; i++) {
                if (quiz4_word_second[i] == true) {
                    quiz4_word_button[i].setBackgroundColor(getResources().getColor(R.color.colorRed));
                } else {
                    quiz4_word_button[i].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                }

            }

        } else if (result == R.id.quiz4_first && quiz4_part[0] == false) {
            quiz4_part[1] = false;
            quiz4_second.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            quiz4_part[0] = true;
            quiz4_first.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            quiz4_part_num = 0;

            for (int i = 0; i <= 4; i++) {
                if (quiz4_word_first[i] == true) {
                    quiz4_word_button[i].setBackgroundColor(getResources().getColor(R.color.colorGreen));
                } else {
                    quiz4_word_button[i].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                }
            }
        } else if (result == R.id.quiz4_word1) {
            if (quiz4_part_num == 0) {
                if (quiz4_word_first[0] == true) {
                    quiz4_word_first[0] = false;
                    quiz4_word_button[0].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_first[0] = true;
                    quiz4_word_button[0].setBackgroundColor(getResources().getColor(R.color.colorGreen));
                }
            } else {
                if (quiz4_word_second[0] == true) {
                    quiz4_word_second[0] = false;
                    quiz4_word_button[0].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_second[0] = true;
                    quiz4_word_button[0].setBackgroundColor(getResources().getColor(R.color.colorRed));
                }

            }
        } else if (result == R.id.quiz4_word2) {
            if (quiz4_part_num == 0) {
                if (quiz4_word_first[1] == true) {
                    quiz4_word_first[1] = false;
                    quiz4_word_button[1].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_first[1] = true;
                    quiz4_word_button[1].setBackgroundColor(getResources().getColor(R.color.colorGreen));
                }
            } else {
                if (quiz4_word_second[1] == true) {
                    quiz4_word_second[1] = false;
                    quiz4_word_button[1].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_second[1] = true;
                    quiz4_word_button[1].setBackgroundColor(getResources().getColor(R.color.colorRed));
                }

            }
        } else if (result == R.id.quiz4_word3) {
            if (quiz4_part_num == 0) {
                if (quiz4_word_first[2] == true) {
                    quiz4_word_first[2] = false;
                    quiz4_word_button[2].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_first[2] = true;
                    quiz4_word_button[2].setBackgroundColor(getResources().getColor(R.color.colorGreen));
                }
            } else {
                if (quiz4_word_second[2] == true) {
                    quiz4_word_second[2] = false;
                    quiz4_word_button[2].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_second[2] = true;
                    quiz4_word_button[2].setBackgroundColor(getResources().getColor(R.color.colorRed));
                }

            }
        } else if (result == R.id.quiz4_word4) {
            if (quiz4_part_num == 0) {
                if (quiz4_word_first[3] == true) {
                    quiz4_word_first[3] = false;
                    quiz4_word_button[3].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_first[3] = true;
                    quiz4_word_button[3].setBackgroundColor(getResources().getColor(R.color.colorGreen));
                }
            } else {
                if (quiz4_word_second[3] == true) {
                    quiz4_word_second[3] = false;
                    quiz4_word_button[3].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_second[3] = true;
                    quiz4_word_button[3].setBackgroundColor(getResources().getColor(R.color.colorRed));
                }

            }
        } else if (result == R.id.quiz4_word5) {
            if (quiz4_part_num == 0) {
                if (quiz4_word_first[4] == true) {
                    quiz4_word_first[4] = false;
                    quiz4_word_button[4].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_first[4] = true;
                    quiz4_word_button[4].setBackgroundColor(getResources().getColor(R.color.colorGreen));
                }
            } else {
                if (quiz4_word_second[4] == true) {
                    quiz4_word_second[4] = false;
                    quiz4_word_button[4].setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
                } else {
                    quiz4_word_second[4] = true;
                    quiz4_word_button[4].setBackgroundColor(getResources().getColor(R.color.colorRed));
                }

            }
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.moca_q4a2_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz4_ask2.this, moca_quiz5.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBooleanArray("quiz4_answer_first", quiz4_word_first);
                bundle.putBooleanArray("quiz4_answer_second", quiz4_word_second);
                bundle.putStringArray("quiz4_word_bundle",quiz4_word_bundle);

                bundle.putBoolean("quiz1_answer", bundle1.getBoolean("quiz1_answer"));
                bundle.putParcelable("quiz2_ask_bundle", bundle1.getParcelable("quiz2_ask_bundle"));
                bundle.putBoolean("quiz2_ask_answer", bundle1.getBoolean("quiz2_ask_answer"));
                bundle.putParcelable("quiz2_ask2_bundle", bundle1.getParcelable("quiz2_ask2_bundle"));
                bundle.putBooleanArray("quiz2_ask2_answer",  bundle1.getBooleanArray("quiz2_ask2_answer"));
                bundle.putBooleanArray("quiz3_answer", bundle1.getBooleanArray("quiz3_answer"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz4_ask2.this.finish();
                break;
        }

    }
}
