package com.example.ncyu.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class quiz1_ask2 extends AppCompatActivity {

    Spinner quiz1_ask2_spinner;
    Spinner quiz1_ask2_spinner_answer;
    //TextView quiz1_ask2_spinner_hint;
    String[] answer;
    Boolean showtoast = false;
    CheckBox disAnswer5;
    boolean quiz1_ask2_disAnswer=false;

    String quiz_ask1_answer1_type,quiz1_ask1_answer1,quiz1_ask1_answer2,quiz1_ask1_answer3,quiz1_ask1_answer4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1_ask2);

        quiz1_ask2_spinner_answer = (Spinner) findViewById(R.id.quiz1_ask2_spinner_answer);

        quiz1_ask2_spinner = (Spinner) findViewById(R.id.quiz1_ask2_spinner);
        String[] quiz1_ask2_quiz = getResources().getStringArray(R.array.quiz1_ask2_quiz);
        ArrayAdapter<String> quiz1_ask2_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, quiz1_ask2_quiz);
        quiz1_ask2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quiz1_ask2_spinner.setAdapter(quiz1_ask2_adapter);
        quiz1_ask2_spinner.setOnItemSelectedListener(spinnerListener);

        disAnswer5=(CheckBox)findViewById(R.id.disAnswer5);
        disAnswer5.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(disAnswer5.isChecked())
                {
                    quiz1_ask2_spinner.setEnabled(false);
                    quiz1_ask2_spinner_answer.setEnabled(false);
                    quiz1_ask2_disAnswer=true;
                }else{
                    quiz1_ask2_spinner.setEnabled(true);
                    quiz1_ask2_spinner_answer.setEnabled(true);
                    quiz1_ask2_disAnswer=false;
                }
            }

        });
    }

    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView adapterView, View view,
                                   int position, long id) {
            //當選取的spinner是kind時
            if (adapterView.getId() == R.id.quiz1_ask2_spinner) {
                //判斷選取的種類是何種，設定相對應的字串陣列內容
                switch (adapterView.getSelectedItemPosition()) {
                    case 0:
                        //quiz1_ask2_spinner_hint.setText("春、夏、秋、冬");
                        answer = new String[]{"","春", "夏", "秋", "冬"};
                        break;
                    case 1:
                        //quiz1_ask2_spinner_hint.setText("上午、中文、下午、晚上");
                        answer=new String[]{"","上午", "中午", "下午", "晚上"};
                        break;
                    case 2:
                        //quiz1_ask2_spinner_hint.setText("早餐、午餐、晚餐、宵夜");
                        answer=new String[]{"","早餐", "午餐", "晚餐", "宵夜"};
                        break;
                    case 3:
                        //quiz1_ask2_spinner_hint.setText("時間");
                        answer=new String[]{"","深夜12點","深夜1點","深夜2點","深夜3點","深夜4點"
                                ,"早上5點","早上6點","早上7點","早上8點","早上9點","早上10點"
                                ,"早上11點","中午12點","下午1點","下午2點","下午3點","下午4點"
                                ,"下午5點","傍晚6點","傍晚7點","傍晚8點","晚上9點","晚上10點","晚上11點"};
                        break;
                }
                    if (answer != null) {
                        setnameitem();
                    }

            } else if (adapterView.getId() == R.id.quiz1_ask2_spinner_answer) {
                if (showtoast != false) {
                }
                showtoast = true;
            }
        }

        @Override
        public void onNothingSelected(AdapterView arg0) {
        }
    };



    private void setnameitem() {
        showtoast = false;
        ArrayAdapter<String> quiz1_ask2_adapter_answer = new ArrayAdapter<String>(this,R.layout.spinner_item_answer,
                answer);
        quiz1_ask2_spinner_answer.setAdapter(quiz1_ask2_adapter_answer);
        quiz1_ask2_spinner_answer.setOnItemSelectedListener(spinnerListener);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.next:

                Intent intent=new Intent();
                intent.setClass(quiz1_ask2.this,quiz_2.class);
                Bundle bundle=new Bundle();
                bundle.putBoolean("quiz1_ask2_disAnswer",quiz1_ask2_disAnswer);
                bundle.putString("quiz1_ask2_quiz",quiz1_ask2_spinner.getSelectedItem().toString());
                bundle.putString("quiz1_ask2_answer",quiz1_ask2_spinner_answer.getSelectedItem().toString());

                Bundle bundle1=getIntent().getExtras();

                bundle.putBooleanArray("quiz1_ask1_disAnswer",bundle1.getBooleanArray("quiz1_ask1_disAnswer"));
                bundle.putString("quiz_ask1_answer_type",bundle1.getString("quiz_ask1_answer_type"));
                bundle.putString("quiz1_ask1_answer1",bundle1.getString("quiz1_ask1_answer1"));
                bundle.putString("quiz1_ask1_answer2",bundle1.getString("quiz1_ask1_answer2"));
                bundle.putString("quiz1_ask1_answer3",bundle1.getString("quiz1_ask1_answer3"));
                bundle.putString("quiz1_ask1_answer4",bundle1.getString("quiz1_ask1_answer4"));

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putString("identity",bundle1.getString("identity"));

                intent.putExtras(bundle);
                startActivity(intent);

                quiz1_ask2.this.finish();
                break;
        }
    }
}
