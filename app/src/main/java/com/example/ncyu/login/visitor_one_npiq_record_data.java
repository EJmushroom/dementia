package com.example.ncyu.login;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mListView.NPIQSimpleCursorAdapter;

/**
 * Created by Ncyu on 2017/9/20.
 */

public class visitor_one_npiq_record_data extends AppCompatActivity {
    ListView lv_visitor_NPIQ;
    ImageButton btn_npiq_Back_Vrecord;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_one_npiq_record_data);

        lv_visitor_NPIQ=(ListView)findViewById(R.id.lv_one_npiq_data);
        btn_npiq_Back_Vrecord=(ImageButton)findViewById(R.id.btn_npiq_Back_Frecord);
        final Bundle testID = this.getIntent().getExtras();

        String[] column={"_id","if_wishful_thinking","wishful_thinking_severity","wishful_thinking_distress","if_illusion","illusion_severity","illusion_distress", "if_attack","attack_severity","attack_distress","if_melancholy","melancholy_severity","melancholy_distress","if_anxious","anxious_severity","anxious_distress","if_happy","happy_severity","happy_distress","if_cold","cold_severity","cold_distress","if_out_of_control","out_of_control_severity","out_of_control_distress","if_easy_angry","easy_angry_severity","easy_angry_distress","if_weird_action","weird_action_severity","weird_action_distress","if_nighttime_behavior","nighttime_behavior_severity","nighttime_behavior_distress","if_appetite_diet_changed","appetite_diet_changed_severity","appetite_diet_changed_distress"};
        MyDBHelper helper = new MyDBHelper(this);
        Toast.makeText(this,"量表編號："+testID.getString("testID"),Toast.LENGTH_SHORT).show();


        Cursor c = helper.getReadableDatabase().query("npiq",column,"_id = "+testID.get("testID"), null, null, null,null);
        c.moveToFirst();


        final NPIQSimpleCursorAdapter Myadapter=new NPIQSimpleCursorAdapter(this,R.layout.npiq_record_model,c,column, new int[] {}, 0);//R.id.tv_npiq_severity1,R.id.tv_npiq_severity2,R.id.tv_npiq_severity3,R.id.tv_npiq_severity4,R.id.tv_npiq_severity5,R.id.tv_npiq_severity6,R.id.tv_npiq_severity7,R.id.tv_npiq_severity8,R.id.tv_npiq_severity9,R.id.tv_npiq_severity10,R.id.tv_npiq_severity11,R.id.tv_npiq_severity12,R.id.tv_npiq_distress1,R.id.tv_npiq_distress2,R.id.tv_npiq_distress3,R.id.tv_npiq_distress4,R.id.tv_npiq_distress5,R.id.tv_npiq_distress6,R.id.tv_npiq_distress7,R.id.tv_npiq_distress8,R.id.tv_npiq_distress9,R.id.tv_npiq_distress10,R.id.tv_npiq_distress11,R.id.tv_npiq_distress12,
        lv_visitor_NPIQ.setAdapter(Myadapter);

        btn_npiq_Back_Vrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(visitor_one_npiq_record_data.this,visitor_record.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("scaleID","5");
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                visitor_one_npiq_record_data.this.finish();
            }
        });
    }
}
