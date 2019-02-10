package com.example.ncyu.login;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mListView.MMSESimpleCursorAdapter;

/**
 * Created by Ncyu on 2017/10/25.
 */

public class visitor_one_mmse_record_data extends AppCompatActivity {
    ListView lv_visitor_MMSE;
    ImageButton btn_mmse_Back_Frecord;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_one_mmse_record_data);

        lv_visitor_MMSE=(ListView)findViewById(R.id.lv_one_mmse_data);
        btn_mmse_Back_Frecord=(ImageButton)findViewById(R.id.btn_mmse_Back_Frecord);
        final Bundle testID = this.getIntent().getExtras();

        String[] column={"_id","quiz1_ask1_disAnswer_year","quiz1_ask1_disAnswer_month","quiz1_ask1_disAnswer_day","quiz1_ask1_disAnswer_weekday","quiz_ask1_answer_type","quiz1_ask1_answer1","quiz1_ask1_answer2","quiz1_ask1_answer3","quiz1_ask1_answer4","quiz1_ask1_score","quiz1_ask2_quiz","quiz1_ask2_answer","quiz1_ask2_disAnswer","quiz1_ask2_score","quiz2_ask_isAnswer1","quiz2_ask_isAnswer2","quiz2_ask_isAnswer3","quiz2_ask_isAnswer4","quiz2_ask_isAnswer5","quiz2_ask_isAnswer6","quiz2_ask_isAnswer7","quiz2_ask_isAnswer8","quiz2_ask_disAnswer1","quiz2_ask_disAnswer2","quiz2_ask_disAnswer3","quiz2_ask_disAnswer4","quiz2_ask_disAnswer5","quiz2_ask_disAnswer6","quiz2_ask_disAnswer7","quiz2_ask_disAnswer8","quiz2_answer1","quiz2_answer2","quiz2_answer3","quiz2_answer4","quiz2_answer5","quiz2_answer6","quiz2_answer7","quiz2_answer8","quiz2_score","quiz3_word_bundle1","quiz3_word_bundle2","quiz3_word_bundle3","quiz3_word1","quiz3_word2","quiz3_word3","quiz3_score","quiz4_answer1","quiz4_answer2","quiz4_answer3","quiz4_answer4","quiz4_answer5","quiz4_score","quiz5_word1","quiz5_word2","quiz5_word3","quiz5_score","quiz6_ask1_word1","quiz6_ask1_word2","quiz6_ask2_word","quiz6_ask2_answer","quiz6_ask3_quiz","quiz6_ask3_answer","quiz6_ask4_answer","quiz6_score","quiz7_bundle","quiz7_answer","quiz7_score","quiz8_word1","quiz8_word2","quiz8_word3","quiz8_score","MMSE_total_score"};
        MyDBHelper helper = new MyDBHelper(this);
        Toast.makeText(this,"量表編號："+testID.getString("testID"),Toast.LENGTH_SHORT).show();

        Cursor c = helper.getReadableDatabase().query("mmse",column,"_id = "+testID.get("testID"), null, null, null,null);
        c.moveToFirst();


        final MMSESimpleCursorAdapter Myadapter=new MMSESimpleCursorAdapter(this,R.layout.mmse_record_model,c,column, new int[] {}, 0); //R.id.tv_has_changed1, R.id.tv_has_changed2,R.id.tv_has_changed3,R.id.tv_has_changed4,R.id.tv_has_changed5,R.id.tv_has_changed6,R.id.tv_has_changed7,R.id.tv_has_changed8,R.id.tv_ad8_total_score,R.id.tv_ad8_comment
        lv_visitor_MMSE.setAdapter(Myadapter);

        btn_mmse_Back_Frecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(visitor_one_mmse_record_data.this,visitor_record.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("scaleID","3");
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                visitor_one_mmse_record_data.this.finish();
            }
        });
    }
}
