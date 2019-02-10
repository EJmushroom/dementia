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

public class quiz1_ask extends AppCompatActivity {

    Spinner ask1_quiz1_spinner,ask1_quiz1_day_spinner;
    CheckBox disAnswer1, disAnswer2, disAnswer3, disAnswer4;
    EditText year, month, date;
    boolean isDisAnswer[]={false,false,false,false};
    String form_answer1,form_answer2,form_answer3,form_answer4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1_ask);

        ask1_quiz1_spinner = (Spinner) findViewById(R.id.quiz1_ask1_spinner);
        String[] quiz1_ask1_quiz = getResources().getStringArray(R.array.quiz1_ask1_quiz);
        ArrayAdapter<String> quiz1_ask1_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, quiz1_ask1_quiz);
        quiz1_ask1_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ask1_quiz1_spinner.setAdapter(quiz1_ask1_adapter);

        ask1_quiz1_day_spinner = (Spinner) findViewById(R.id.quiz1_ask1_day_spinner);
        String[] quiz1_ask1_day_quiz = getResources().getStringArray(R.array.quiz1_ask1_day_quiz);
        ArrayAdapter<String> quiz1_ask1_day_adapter = new ArrayAdapter<String>(this,R.layout.spinner_item, quiz1_ask1_day_quiz);
        quiz1_ask1_day_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ask1_quiz1_day_spinner.setAdapter(quiz1_ask1_day_adapter);


        disAnswer1 = (CheckBox) findViewById(R.id.disAnswer);
        disAnswer2 = (CheckBox) findViewById(R.id.disAnswer2);
        disAnswer3 = (CheckBox) findViewById(R.id.disAnswer3);
        disAnswer4 = (CheckBox) findViewById(R.id.disAnswer4);
        month = (EditText) findViewById(R.id.month);
        year = (EditText) findViewById(R.id.year);
        date = (EditText) findViewById(R.id.date);
        ask1_quiz1_day_spinner = (Spinner) findViewById(R.id.quiz1_ask1_day_spinner);


        disAnswer1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(disAnswer1.isChecked())
                {
                    form_answer1=year.getText().toString();
                    year.setTextSize(15);
                    year.setText("");
                    isDisAnswer[0]=true;
                    year.setHint("受測者無法作答");
                    year.setEnabled(false);
                    ask1_quiz1_spinner.setEnabled(false);
                }else{
                    year.setEnabled(true);
                    ask1_quiz1_spinner.setEnabled(true);
                    year.setTextSize(30);
                    year.setHint("");
                    if(form_answer1==null){
                        form_answer1=null;
                    }
                    year.setText(form_answer1);
                    isDisAnswer[0]=false;
                }
            }

        });
        disAnswer2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(disAnswer2.isChecked())
                {
                    form_answer2=month.getText().toString();
                    month.setTextSize(15);
                    month.setText("");
                    isDisAnswer[1]=true;
                    month.setHint("受測者無法作答");
                    month.setEnabled(false);
                }else{
                   month.setEnabled(true);
                    month.setTextSize(30);
                    month.setHint("");
                    if(form_answer2==null){
                        form_answer2=null;
                    }
                    month.setText(form_answer2);
                    isDisAnswer[1]=false;
                }
            }

        });
        disAnswer3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(disAnswer3.isChecked())
                {
                    form_answer3=date.getText().toString();
                    date.setTextSize(15);
                    date.setText("");
                    isDisAnswer[2]=true;
                    date.setHint("受測者無法作答");
                    date.setEnabled(false);
                }else{
                   date.setEnabled(true);
                    date.setTextSize(30);
                    date.setHint("");
                    if(form_answer3==null){
                        form_answer3=null;
                    }
                   date.setText(form_answer3);
                    isDisAnswer[2]=false;
                }
            }

        });
        disAnswer4.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(disAnswer4.isChecked())
                {
                   ask1_quiz1_day_spinner.setEnabled(false);
                    isDisAnswer[3]=true;
                }else{
                    ask1_quiz1_day_spinner.setEnabled(true);
                    isDisAnswer[3]=false;
                }
            }

        });
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.next:
                Intent intent1=new Intent();
                intent1.setClass(quiz1_ask.this,quiz1_ask2.class);
                Bundle bundle=new Bundle();
                bundle.putBooleanArray("quiz1_ask1_disAnswer",isDisAnswer);
                bundle.putString("quiz_ask1_answer_type",ask1_quiz1_spinner.getSelectedItem().toString());
                bundle.putString("quiz1_ask1_answer1",year.getText().toString());
                bundle.putString("quiz1_ask1_answer2",month.getText().toString());
                bundle.putString("quiz1_ask1_answer3",date.getText().toString());
                bundle.putString("quiz1_ask1_answer4",ask1_quiz1_day_spinner.getSelectedItem().toString());

                Bundle bundle1=getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                intent1.putExtras(bundle);
                startActivity(intent1);

                quiz1_ask.this.finish();
                break;
        }
    }



}
