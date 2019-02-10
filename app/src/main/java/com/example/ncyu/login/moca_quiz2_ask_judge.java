package com.example.ncyu.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class moca_quiz2_ask_judge extends AppCompatActivity {

    ImageView quiz2_ask_answer;
    Button yes;
    Button wrong;
    Button next;
    Boolean quiz2_ask_isRight=false;
    Boolean isAnswered = false;
    Boolean isSelectedY = false;
    Boolean isSelectedN = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz2_ask_judge);
        yes = (Button) findViewById(R.id.yes);
        wrong = (Button) findViewById(R.id.wrong);
        next = (Button) findViewById(R.id.next);
        quiz2_ask_answer=(ImageView)findViewById(R.id.quiz2_ask_answer);

        Bundle bundle=getIntent().getExtras();
        Bitmap bitmap=bundle.getParcelable("quiz2_ask_bundle");

        quiz2_ask_answer.setImageBitmap(bitmap);
    }
    public void onClick(View v) {
        int result = v.getId();

        if ((result == R.id.yes) && (isSelectedN == false)) {
            yes.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedY = true;
            isAnswered = true;
            quiz2_ask_isRight=true;
        } else if ((result == R.id.wrong) && (isSelectedY == false)) {
            wrong.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedN = true;
            isAnswered = true;
            quiz2_ask_isRight=false;
        } else if ((result == R.id.yes) && (isSelectedN == true)) {
            yes.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedY = true;
            wrong.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            isSelectedN = false;
            quiz2_ask_isRight=true;
        } else {
            wrong.setBackgroundColor(getResources().getColor(R.color.colorRed));
            isSelectedN = true;
            yes.setBackgroundColor(getResources().getColor(R.color.colorButtomNormal));
            isSelectedY = false;
            quiz2_ask_isRight=false;
        }
    }
    public void onClick2(View v) {
        switch (v.getId()) {
            case R.id.moca_q2aj_next:
                Intent intent = new Intent();
                intent.setClass(moca_quiz2_ask_judge.this, moca_quiz2_ask2.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putBoolean("quiz2_ask_answer", quiz2_ask_isRight);
                bundle.putBoolean("quiz1_answer",bundle1.getBoolean("quiz1_answer"));
                bundle.putParcelable("quiz2_ask_bundle",bundle1.getParcelable("quiz2_ask_bundle"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz2_ask_judge.this.finish();
                break;
        }
    }
}
