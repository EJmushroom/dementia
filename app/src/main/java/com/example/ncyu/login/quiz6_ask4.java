package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class quiz6_ask4 extends AppCompatActivity {

    CheckBox disAnswer7;
    EditText quiz6_ask4_answer;
    String quiz6_ask4_ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6_ask4);
        disAnswer7=(CheckBox)findViewById(R.id.disanswer7);
        quiz6_ask4_answer=(EditText)findViewById(R.id.quiz6_ask4_answer);

        disAnswer7.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(disAnswer7.isChecked())
                {
                    quiz6_ask4_answer.setEnabled(false);
                }else{
                    quiz6_ask4_answer.setEnabled(true);
                }
            }

        });
    }

    public void onClick(View v){
        switch (v.getId()){

            case R.id.next:
                quiz6_ask4_ans=quiz6_ask4_answer.getText().toString();

                Intent intent=new Intent();
                intent.setClass(quiz6_ask4.this,quiz_7.class);
                Bundle bundle=new Bundle();
                bundle.putString("quiz6_ask4_answer",quiz6_ask4_ans);

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

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putString("identity",bundle1.getString("identity"));

                intent.putExtras(bundle);
                startActivity(intent);
                quiz6_ask4.this.finish();
                break;
        }
    }
}
