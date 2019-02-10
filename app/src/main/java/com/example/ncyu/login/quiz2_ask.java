package com.example.ncyu.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class quiz2_ask extends AppCompatActivity {

    Spinner quiz2_ask_spinner;
    String all_answer[] = {"", "", "", "", "", "", "", ""};
    boolean isDisAnswer[] = {false, false, false, false, false, false, false, false};
    boolean isAnswer[] = {false, false, false, false, false, false, false, false};
    EditText answer;
    String form_answer[] = {"", "", "", "", "", "", "", ""};
    Boolean showtoast;
    int quiz_num = 0;
    CheckBox disAnswer6;
    Button quiz2_enter;
    Context context;
    Toast toast;
    TextView new_answer;
    int quiz2_ask_remain = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_ask);
        context = this;


        quiz2_ask_spinner = (Spinner) findViewById(R.id.quiz2_ask_spinner);
        String[] quiz2_ask_quiz = getResources().getStringArray(R.array.quiz2_quiz);
        ArrayAdapter<String> quiz2_ask_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, quiz2_ask_quiz);
        quiz2_ask_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quiz2_ask_spinner.setAdapter(quiz2_ask_adapter);
        quiz2_ask_spinner.setOnItemSelectedListener(spinnerListener);

        answer = (EditText) findViewById(R.id.quiz2_answer);
        quiz2_enter = (Button) findViewById(R.id.quiz2_enter);
        new_answer = (TextView) findViewById(R.id.new_answer);

        disAnswer6 = (CheckBox) findViewById(R.id.disAnswer6);
        disAnswer6.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (disAnswer6.isChecked()) {
                    //紀錄撰寫答案
                    form_answer[quiz_num] = answer.getText().toString();

                    //製作受測者無法作答的無法輸入框
                    answer.setTextSize(20);
                    answer.setText("");
                    isDisAnswer[quiz_num] = true;
                    answer.setHint("受測者無法作答");
                    answer.setEnabled(false);
                    quiz2_enter.setEnabled(false);
                    quiz2_enter.setBackgroundColor(context.getResources().getColor(R.color.colorGreen));

                    //判斷是否以"有確定答案"為"已作答"(allanswer有沒有記錄答案)，如否，進行判斷
                    if (isAnswer[quiz_num] == false) {
                        isAnswer[quiz_num] = true;
                        quiz2_ask_remain = quiz2_ask_remain - 1;
                    }

                    //如作答題目達到5題
                    if (quiz2_ask_remain <= 0) {
                        Button next = (Button) findViewById(R.id.next);
                        next.setEnabled(true);
                        toast.makeText(context, "作答題目已達到5題，你可以修改剛才的答案，或者進入下一題", Toast.LENGTH_LONG).show();
                    } else {
                        toast.makeText(context, "題目" + (quiz_num + 1) + "答案已記錄(受試者無法作答)，還有" + quiz2_ask_remain + "題需要作答", Toast.LENGTH_SHORT).show();
                    }

                } else {//取消checkbox時

                    //恢復可輸入的輸入框
                    answer.setEnabled(true);
                    answer.setTextSize(30);
                    answer.setHint("");

                    //專用於checkbox切換用(避免跳題所造成的"選擇disanswer"跟"未作答"造成衝突的問題)
                    if (isDisAnswer[quiz_num] == true) {
                        isDisAnswer[quiz_num] = false;
                        //判斷使用者是否有確定的答案(是否不為空值)，如有，isAnswer就為true，必須回答問題數不變
                        if (!all_answer[quiz_num].toString().equals("")) {
                            isAnswer[quiz_num] = true;
                            answer.setText(all_answer[quiz_num]);
                            quiz2_enter.setEnabled(true);
                            quiz2_enter.setBackgroundColor(context.getResources().getColor(R.color.colorGreen));
                            toast.makeText(context, "這是你先前確定的答案", Toast.LENGTH_SHORT).show();
                        } else {//答案為空值，則放入先前紀錄的內容(尚未按下確定鍵)，必須回答問題數+1
                            isAnswer[quiz_num] = false;
                            quiz2_ask_remain = quiz2_ask_remain + 1;
                            answer.setText(form_answer[quiz_num]);
                            quiz2_enter.setEnabled(true);
                            quiz2_enter.setBackgroundColor(context.getResources().getColor(R.color.colorButtomNormal));
                            toast.makeText(context, "請確定你的答案", Toast.LENGTH_SHORT).show();
                        }
                    }else{//跳題至"未作答的題目"用
                        quiz2_enter.setEnabled(true);
                        quiz2_enter.setBackgroundColor(context.getResources().getColor(R.color.colorButtomNormal));
                    }

                    if (quiz2_ask_remain > 0) {//當必須回答問題數增加時，關閉"下一題"按鈕
                        Button next = (Button) findViewById(R.id.next);
                        next.setEnabled(false);
                    }

                }
            }

        });

    }

    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView adapterView, View view,
                                   int position, long id) {

            form_answer[quiz_num] = answer.getText().toString().trim();

            if (adapterView.getId() == R.id.quiz2_ask_spinner) {
                switch (adapterView.getSelectedItemPosition()) {
                    case 0:
                        quiz_num = 0;
                        answer.setText(form_answer[0]);
                        break;
                    case 1:
                        quiz_num = 1;
                        answer.setText(form_answer[1]);
                        break;
                    case 2:
                        quiz_num = 2;
                        answer.setText(form_answer[2]);
                        break;
                    case 3:
                        quiz_num = 3;
                        answer.setText(form_answer[3]);
                        break;
                    case 4:
                        quiz_num = 4;
                        answer.setText(form_answer[4]);
                        break;
                    case 5:
                        quiz_num = 5;
                        answer.setText(form_answer[5]);
                        break;
                    case 6:
                        quiz_num = 6;
                        answer.setText(form_answer[6]);
                        break;
                    case 7:
                        quiz_num = 7;
                        answer.setText(form_answer[7]);
                        break;
                }
                new_answer.setText(all_answer[quiz_num]);

                //是否無法回答
                if (isDisAnswer[quiz_num] == true) {
                    answer.setEnabled(false);
                    disAnswer6.setChecked(true);
                } else {
                    answer.setEnabled(true);
                    disAnswer6.setChecked(false);
                }

                //是否有確定答案(有回答或者無法回答)
                if (isAnswer[quiz_num] == true) {
                    quiz2_enter.setBackgroundColor(context.getResources().getColor(R.color.colorGreen));
                } else {
                    quiz2_enter.setBackgroundColor(context.getResources().getColor(R.color.colorButtomNormal));
                }

                //不用管他
                if (answer != null) {
                    setnameitem();
                }

            }
        }

        @Override
        public void onNothingSelected(AdapterView arg0) {
        }
    };

    private void setnameitem() {
        showtoast = false;

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:

                Intent intent = new Intent();
                intent.setClass(quiz2_ask.this, quiz_3.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();

                bundle.putBooleanArray("quiz1_ask1_disAnswer", bundle1.getBooleanArray("quiz1_ask1_disAnswer"));
                bundle.putString("quiz_ask1_answer_type", bundle1.getString("quiz_ask1_answer_type"));
                bundle.putString("quiz1_ask1_answer1", bundle1.getString("quiz1_ask1_answer1"));
                bundle.putString("quiz1_ask1_answer2", bundle1.getString("quiz1_ask1_answer2"));
                bundle.putString("quiz1_ask1_answer3", bundle1.getString("quiz1_ask1_answer3"));
                bundle.putString("quiz1_ask1_answer4", bundle1.getString("quiz1_ask1_answer4"));
                bundle.putString("quiz1_ask2_quiz", bundle1.getString("quiz1_ask2_quiz"));
                bundle.putString("quiz1_ask2_answer", bundle1.getString("quiz1_ask2_answer"));
                bundle.putBoolean("quiz1_ask2_disAnswer", bundle1.getBoolean("quiz1_ask2_disAnswer"));
                bundle.putBooleanArray("quiz2_ask_disAnswer", isDisAnswer);
                bundle.putStringArray("quiz2_answer", all_answer);
                bundle.putBooleanArray("quiz2_ask_isAnswer", isAnswer);

                if(bundle1.getString("identity").equals("family")) {
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));


                intent.putExtras(bundle);
                startActivity(intent);

                quiz2_ask.this.finish();
                break;
        }
    }

    public void onClick2(View v) {
        switch (v.getId()) {
            case R.id.quiz2_enter://按下確定
                if (answer.getText().toString().equals("")) {//輸入答案空白
                    all_answer[quiz_num] = answer.getText().toString().trim();
                    form_answer[quiz_num] = answer.getText().toString().trim();
                    toast.makeText(context, "請輸入答案或點選無法作答", Toast.LENGTH_SHORT).show();
                    quiz2_enter.setBackgroundColor(context.getResources().getColor(R.color.colorButtomNormal));

                    //判斷先前是否有確定答案或者無法解答
                    if (isAnswer[quiz_num] == true) {
                        isAnswer[quiz_num] = false;
                        quiz2_ask_remain = quiz2_ask_remain + 1;
                    }

                    if (quiz2_ask_remain > 0) {
                        toast.makeText(context, "你還需要再回答" + quiz2_ask_remain + "題才可進入下一頁", Toast.LENGTH_LONG).show();
                        Button next = (Button) findViewById(R.id.next);
                        next.setEnabled(false);
                    }

                } else {//輸入答案並非空白
                    all_answer[quiz_num] = answer.getText().toString().trim();
                    form_answer[quiz_num] = answer.getText().toString().trim();
                    new_answer.setText(all_answer[quiz_num]);//展示最新答案

                    if (isAnswer[quiz_num] == false) {//當你還沒有確定答案

                        //紀錄答案，回答數-1
                        isAnswer[quiz_num] = true;
                        quiz2_ask_remain = quiz2_ask_remain - 1;
                        quiz2_enter.setBackgroundColor(context.getResources().getColor(R.color.colorGreen));

                        if (quiz2_ask_remain > 0) {//當回答五題未達成
                            toast.makeText(context, "題目" + (quiz_num + 1) + "答案已記錄,還有" + quiz2_ask_remain + "題", Toast.LENGTH_SHORT).show();
                        } else {
                            toast.makeText(context, "作答題目已達到5題，你可以修改剛才的答案，或者進入下一題", Toast.LENGTH_LONG).show();
                            //開啟下一頁按鈕
                            Button next = (Button) findViewById(R.id.next);
                            next.setEnabled(true);
                        }
                    } else {//若已有確定答案("已確定的回答"或"無法回答")
                        all_answer[quiz_num] = answer.getText().toString().trim();
                        toast.makeText(context, "題目" + (quiz_num + 1) + "更新了答案", Toast.LENGTH_SHORT).show();

                    }
                }
                break;
        }


    }

}
