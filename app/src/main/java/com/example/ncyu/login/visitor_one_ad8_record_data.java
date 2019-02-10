package com.example.ncyu.login;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.mListView.AD8SimpleCursorAdapter;

/**
 * Created by Ncyu on 2017/9/16.
 */

public class visitor_one_ad8_record_data extends AppCompatActivity {

    ListView lv_visitor_AD8;
    ImageButton btn_Back_Vrecord;
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_one_ad8_record_data);

        lv_visitor_AD8=(ListView)findViewById(R.id.lv_one_score_data);
        btn_Back_Vrecord=(ImageButton)findViewById(R.id.btn_Back_Frecord);
        final Bundle testID = this.getIntent().getExtras();

        String[] column={"_id","Q1","Q2","Q3","Q4","Q5","Q6","Q7","Q8","AD8_total_score"};
        MyDBHelper helper = new MyDBHelper(this);
        Toast.makeText(this,"量表編號："+testID.getString("testID"),Toast.LENGTH_SHORT).show();

        Cursor c = helper.getReadableDatabase().query("ad8",column,"_id = "+testID.get("testID"), null, null, null,null);
        c.moveToFirst();


        final AD8SimpleCursorAdapter Myadapter=new AD8SimpleCursorAdapter(this,R.layout.ad8_record_model,c,column, new int[] {}, 0); //R.id.tv_has_changed1, R.id.tv_has_changed2,R.id.tv_has_changed3,R.id.tv_has_changed4,R.id.tv_has_changed5,R.id.tv_has_changed6,R.id.tv_has_changed7,R.id.tv_has_changed8,R.id.tv_ad8_total_score,R.id.tv_ad8_comment
        lv_visitor_AD8.setAdapter(Myadapter);

       btn_Back_Vrecord.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //new一個intent物件，並指定Activity切換的class
               Intent in=new Intent(visitor_one_ad8_record_data.this,visitor_record.class);
               //new一個Bundle物件，並將要傳遞的資料傳入
               Bundle bundle = new Bundle();
               bundle.putString("scaleID","1");
               //將Bundle物件assign給intent
               in.putExtras(bundle);
               startActivity(in);
               visitor_one_ad8_record_data.this.finish();
           }
       });
    }
}
