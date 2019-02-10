package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class visitor_choose_scaleID extends AppCompatActivity {

    int scaleID = -1;
    ImageButton btn_scale_ad8,btn_scale_cdr,btn_scale_mmse,btn_scale_moca,btn_scale_npiq;
    TextView tv_which_scale;
    Button btn_determine_scale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_choose_scale_id);

        btn_scale_ad8=(ImageButton)findViewById(R.id.btn_scale_ad8);
        btn_scale_cdr=(ImageButton)findViewById(R.id.btn_scale_cdr);
        btn_scale_mmse=(ImageButton)findViewById(R.id.btn_scale_mmse);
        btn_scale_moca=(ImageButton)findViewById(R.id.btn_scale_moca);
        btn_scale_npiq=(ImageButton)findViewById(R.id.btn_scale_npiq);
        tv_which_scale=(TextView)findViewById(R.id.tv_which_scale);
        btn_determine_scale=(Button)findViewById(R.id.btn_determine_scale);

        btn_determine_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scaleID==-1){
                    Toast.makeText(visitor_choose_scaleID.this, "請先選擇欲查看得量表種類！", Toast.LENGTH_SHORT).show();
                }
                else{
                    //new一個intent物件，並指定Activity切換的class
                    Intent in=new Intent(visitor_choose_scaleID.this,visitor_record.class);
                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();
                    bundle.putString("scaleID",toString().valueOf(scaleID));
                    //將Bundle物件assign給intent
                    in.putExtras(bundle);
                    startActivity(in);
                    visitor_choose_scaleID.this.finish();
                }
            }
        });

        btn_scale_ad8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleID = 1;
                tv_which_scale.setText("AD-8 極早期失智症篩檢量表");
            }
        });

        btn_scale_cdr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleID = 2;
                tv_which_scale.setText("CDR  臨床失智評估量表");
            }
        });

        btn_scale_mmse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleID = 3;
                tv_which_scale.setText("MMSE  臨床失智評估量表");
            }
        });

        btn_scale_moca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleID = 4;
                tv_which_scale.setText("MOCA 蒙特利爾認知評估");
            }
        });

        btn_scale_npiq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleID = 5;
                tv_which_scale.setText("NPI-Q 腦精神科徵狀問卷");
            }
        });
    }
}
