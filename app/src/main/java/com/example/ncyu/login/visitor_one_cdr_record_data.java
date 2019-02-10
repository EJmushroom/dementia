package com.example.ncyu.login;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mListView.CDRSimpleCursorAdapter;

/**
 * Created by Ncyu on 2017/9/27.
 */

public class visitor_one_cdr_record_data extends AppCompatActivity {
    ListView lv_visitor_CDR;
    ImageButton btn_cdr_Back_Vrecord;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_one_cdr_record_data);

        lv_visitor_CDR=(ListView)findViewById(R.id.lv_one_cdr_data);
        btn_cdr_Back_Vrecord=(ImageButton)findViewById(R.id.btn_cdr_Back_Frecord);
        final Bundle testID = this.getIntent().getExtras();

        String[] column={"_id","memory","orientation","problem_solving_ability","community_activity","home_hobby","self_care","CDR_total_score"};
        MyDBHelper helper = new MyDBHelper(this);
        Toast.makeText(this,"量表編號："+testID.getString("testID"),Toast.LENGTH_SHORT).show();

        Cursor c = helper.getReadableDatabase().query("cdr",column,"_id = "+testID.get("testID"), null, null, null,null);
        c.moveToFirst();


        final CDRSimpleCursorAdapter Myadapter=new CDRSimpleCursorAdapter(this,R.layout.cdr_record_model,c,column, new int[] {}, 0);
        lv_visitor_CDR.setAdapter(Myadapter);

        btn_cdr_Back_Vrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(visitor_one_cdr_record_data.this,visitor_record.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("scaleID","2");
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                visitor_one_cdr_record_data.this.finish();
            }
        });
    }
}
