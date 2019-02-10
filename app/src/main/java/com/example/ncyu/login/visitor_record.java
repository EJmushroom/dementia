package com.example.ncyu.login;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.ncyu.login.MyDBHelper;
import com.example.ncyu.login.mListView.MySimpleCursorAdapter;


public class visitor_record extends AppCompatActivity {

    ListView lv_visitor_tests;
    ImageButton btn_visitor_record_enter,btn_Back_VChooseSID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_record);
        lv_visitor_tests=(ListView)findViewById(R.id.lv_visitor_tests);
        btn_Back_VChooseSID=(ImageButton)findViewById(R.id.btn_Back_VChooseSID);
        btn_visitor_record_enter=(ImageButton)findViewById(R.id.btn_visitor_record_enter);

        final Bundle scaleID = this.getIntent().getExtras();

        btn_Back_VChooseSID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),visitor_choose_scaleID.class));
                visitor_record.this.finish();
            }
        });



        String[] column={"_id","scaleID","end_test_time"};
        MyDBHelper helper = new MyDBHelper(this);


        Cursor c = helper.getReadableDatabase().query("test",column,"scaleID = "+scaleID.get("scaleID"), null, null, null,"end_test_time DESC");
        final MySimpleCursorAdapter Myadapter=new MySimpleCursorAdapter(this,R.layout.visitor_records_model, c, new String[] {"_id","end_test_time"}, new int[] {R.id.tv_visitor_id,R.id.tv_visitor_end_test_time}, 0);
        lv_visitor_tests.setAdapter(Myadapter);

        btn_visitor_record_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Myadapter.getId()<=0){
                    Toast.makeText(visitor_record.this,"請先點選量表！",Toast.LENGTH_SHORT).show();
                }
                else{
                    //AD8
                    if(scaleID.getString("scaleID").equals("1")){
                        Toast.makeText(visitor_record.this,"量表編號："+toString().valueOf(Myadapter.getId()),Toast.LENGTH_SHORT).show();
                        //new一個intent物件，並指定Activity切換的class
                        Intent in=new Intent(visitor_record.this,visitor_one_ad8_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("testID",toString().valueOf(Myadapter.getId()));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        visitor_record.this.finish();
                    }
                    //CDR
                    else if(scaleID.getString("scaleID").equals("2")){
                        Toast.makeText(visitor_record.this,"量表編號："+toString().valueOf(Myadapter.getId()),Toast.LENGTH_SHORT).show();
                        //new一個intent物件，並指定Activity切換的class
                        Intent in=new Intent(visitor_record.this,visitor_one_cdr_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("testID",toString().valueOf(Myadapter.getId()));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        visitor_record.this.finish();

                    }
                    //MMSE
                    else if(scaleID.getString("scaleID").equals("3")){
                        Toast.makeText(visitor_record.this,"量表編號："+toString().valueOf(Myadapter.getId()),Toast.LENGTH_SHORT).show();
                        //new一個intent物件，並指定Activity切換的class
                        Intent in=new Intent(visitor_record.this,visitor_one_mmse_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("testID",toString().valueOf(Myadapter.getId()));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        visitor_record.this.finish();
                    }
                    //MOCA
                    else if(scaleID.getString("scaleID").equals("4")){
                        Toast.makeText(visitor_record.this,"量表編號："+toString().valueOf(Myadapter.getId()),Toast.LENGTH_SHORT).show();
                        //new一個intent物件，並指定Activity切換的class
                        Intent in=new Intent(visitor_record.this,visitor_one_moca_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("testID",toString().valueOf(Myadapter.getId()));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        visitor_record.this.finish();
                    }
                    //NPIQ
                    else if(scaleID.getString("scaleID").equals("5")){
                        Toast.makeText(visitor_record.this,"量表編號："+toString().valueOf(Myadapter.getId()),Toast.LENGTH_SHORT).show();
                        //new一個intent物件，並指定Activity切換的class
                        Intent in=new Intent(visitor_record.this,visitor_one_npiq_record_data.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("testID",toString().valueOf(Myadapter.getId()));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        visitor_record.this.finish();

                    }
                    //其他錯誤
                    else{

                    }
                }

            }
        });

    }
}
