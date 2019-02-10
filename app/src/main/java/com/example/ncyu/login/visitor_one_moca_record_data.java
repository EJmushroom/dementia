package com.example.ncyu.login;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mListView.MOCASimpleCursorAdapter;

public class visitor_one_moca_record_data extends AppCompatActivity {

    ListView lv_visitor_MOCA;
    ImageButton btn_moca_Back_Frecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_one_moca_record_data);

        lv_visitor_MOCA=(ListView)findViewById(R.id.lv_one_moca_data);
        btn_moca_Back_Frecord=(ImageButton)findViewById(R.id.btn_moca_Back_Frecord);
        final Bundle testID = this.getIntent().getExtras();

        String[] column={"_id","quiz1_answer","quiz1_score","quiz2_ask_bundle","quiz2_ask_answer","quiz2_ask2_bundle","quiz2_ask2_answer1","quiz2_ask2_answer2","quiz2_ask2_answer3","quiz2_score","quiz3_answer1","quiz3_answer2","quiz3_answer3","quiz3_score","quiz4_answer_first1","quiz4_answer_first2","quiz4_answer_first3","quiz4_answer_first4","quiz4_answer_first5","quiz4_answer_second1","quiz4_answer_second2","quiz4_answer_second3","quiz4_answer_second4","quiz4_answer_second5","quiz4_word_bundle1","quiz4_word_bundle2","quiz4_word_bundle3","quiz4_word_bundle4","quiz4_word_bundle5","quiz4_score","quiz5_ask1_answer1","quiz5_ask1_answer2","quiz5_ask1_answer3","quiz5_ask2_answer1","quiz5_ask2_answer2","quiz5_ask2_answer3","quiz5_ask2_answer4","quiz5_ask2_answer5","quiz5_ask2_isRight","quiz5_score","quiz6_ask_quiz_isRight1","quiz6_ask_quiz_isRight2","quiz6_ask2_answer","quiz6_score","quiz7_answer1","quiz7_answer2","quiz7_score","quiz8_answer1","quiz8_answer2","quiz8_answer3","quiz8_answer4","quiz8_answer5","quiz8_score","quiz9_answer1","quiz9_answer2","quiz9_answer3","quiz9_answer4","quiz9_answer5","quiz9_answer6","quiz9_answer7","quiz9_isAnswer1","quiz9_isAnswer2","quiz9_isAnswer3","quiz9_isAnswer4","quiz9_isAnswer5","quiz9_isAnswer6","quiz9_score","MOCA_total_score"};
        MyDBHelper helper = new MyDBHelper(this);
        Toast.makeText(this,"量表編號："+testID.getString("testID"),Toast.LENGTH_SHORT).show();

        Cursor c = helper.getReadableDatabase().query("moca",column,"_id = "+testID.get("testID"), null, null, null,null);
        c.moveToFirst();


        final MOCASimpleCursorAdapter Myadapter=new MOCASimpleCursorAdapter(this,R.layout.moca_record_model,c,column, new int[] {}, 0);
        lv_visitor_MOCA.setAdapter(Myadapter);

        btn_moca_Back_Frecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(visitor_one_moca_record_data.this,visitor_record.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("scaleID","4");
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                visitor_one_moca_record_data.this.finish();
            }
        });

    }
}
