package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class quiz6_ask2 extends AppCompatActivity {

    Spinner quiz6_ask2_quiz_spinner;
    Button quiz6_ask2_quiz_right,quiz6_ask2_quiz_wrong;
    Boolean quiz6_ask2_quiz_isRight=false;
    String quiz6_ask2_word;
    int quiz6_ask2_quiz_current=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6_ask2);

        quiz6_ask2_quiz_spinner=(Spinner)findViewById(R.id.quiz6_ask2_quiz_spinner);
        quiz6_ask2_quiz_right=(Button)findViewById(R.id.quiz6_ask2_quiz_right);
        quiz6_ask2_quiz_wrong=(Button)findViewById(R.id.quiz6_ask2_quiz_wrong);

        String[] quiz6_ask2_quiz = getResources().getStringArray(R.array.quiz6_ask2_quiz);
        ArrayAdapter<String> quiz6_ask2_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, quiz6_ask2_quiz);
        quiz6_ask2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quiz6_ask2_quiz_spinner.setAdapter(quiz6_ask2_adapter);
        quiz6_ask2_quiz_spinner.setOnItemSelectedListener(spinnerListener);


    }
    public void onClick2(View v){
        switch (v.getId()){
            case R.id.quiz6_ask2_quiz_right:
                quiz6_ask2_quiz_isRight=true;
                quiz6_ask2_quiz_right.setBackgroundColor(getColor(R.color.colorRed));
                quiz6_ask2_quiz_wrong.setBackgroundColor(getColor(R.color.colorButtomNormal));
                break;
            case R.id.quiz6_ask2_quiz_wrong:
                quiz6_ask2_quiz_isRight=false;
                quiz6_ask2_quiz_wrong.setBackgroundColor(getColor(R.color.colorRed));
                quiz6_ask2_quiz_right.setBackgroundColor(getColor(R.color.colorButtomNormal));
                break;
        }
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.next:
                quiz6_ask2_word=quiz6_ask2_quiz_spinner.getSelectedItem().toString();

                Intent intent=new Intent();
                intent.setClass(quiz6_ask2.this,quiz6_ask3.class);
                Bundle bundle=new Bundle();
                bundle.putString("quiz6_ask2_word",quiz6_ask2_word);
                bundle.putBoolean("quiz6_ask2_answer",quiz6_ask2_quiz_isRight);

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

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putString("identity",bundle1.getString("identity"));

                intent.putExtras(bundle);
                startActivity(intent);
                quiz6_ask2.this.finish();
                break;
        }
    }

    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView adapterView, View view,
                                   int position, long id) {
            //當選取的spinner是kind時
            if (adapterView.getId() == R.id.quiz6_ask2_quiz_spinner) {
                //判斷選取的種類是何種，設定相對應的字串陣列內容
                if(adapterView.getSelectedItemPosition()!=quiz6_ask2_quiz_current) {
                    quiz6_ask2_quiz_isRight=false;
                    quiz6_ask2_quiz_current=adapterView.getSelectedItemPosition();
                    quiz6_ask2_quiz_wrong.setBackgroundColor(getColor(R.color.colorButtomNormal));
                    quiz6_ask2_quiz_right.setBackgroundColor(getColor(R.color.colorButtomNormal));
                }

            }
        }

        @Override
        public void onNothingSelected(AdapterView arg0) {
        }
    };
}
