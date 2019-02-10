package com.example.ncyu.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class npiq2 extends AppCompatActivity {

    private Button btnOK;
    private TextView title;
    private RadioGroup rGroup, rGroup2 ;
    private RadioButton rdo1, rdo2, rdo3, rdoA, rdoB, rdoC, rdoD, rdoE ;
    private String title_;
    private int tmp_num = 0 ;

    String[] severity = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    String[] distress = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npiq2);

        Bundle bundle = this.getIntent().getExtras();
        title_ = bundle.getString("title");
        tmp_num = bundle.getInt("tmp_num");
        severity = bundle.getStringArray("severity");
        distress = bundle.getStringArray("distress");

        btnOK = (Button)findViewById(R.id.btnOK);
        title = (TextView)findViewById(R.id.title);
        title.setText(title_);
        rGroup = (RadioGroup)findViewById(R.id.rGroup);
        rGroup2 = (RadioGroup)findViewById(R.id.rGroup2);
        rdo1 = (RadioButton)findViewById(R.id.rdo1);
        rdo2 = (RadioButton)findViewById(R.id.rdo2);
        rdo3 = (RadioButton)findViewById(R.id.rdo3);
        rdoA = (RadioButton)findViewById(R.id.rdoA);
        rdoB = (RadioButton)findViewById(R.id.rdoB);
        rdoC = (RadioButton)findViewById(R.id.rdoC);
        rdoD = (RadioButton)findViewById(R.id.rdoD);
        rdoE = (RadioButton)findViewById(R.id.rdoE);
        if(severity[tmp_num] == "1") rdo1.isChecked();
        if(severity[tmp_num] == "2") rdo2.isChecked();
        if(severity[tmp_num] == "3") rdo3.isChecked();
        if(distress[tmp_num] == "1") rdoA.isChecked();
        if(distress[tmp_num] == "2") rdoB.isChecked();
        if(distress[tmp_num] == "3") rdoC.isChecked();
        if(distress[tmp_num] == "4") rdoD.isChecked();
        if(distress[tmp_num] == "5") rdoE.isChecked();

        btnOK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if((rdo1.isChecked() || rdo2.isChecked() || rdo3.isChecked()) && (rdoA.isChecked() || rdoB.isChecked() || rdoC.isChecked() || rdoD.isChecked() || rdoE.isChecked()) ){
                    tmp_num = tmp_num+1;
                    Intent intent = new Intent();
                    intent.setClass(npiq2.this, npiq1.class);
                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();
                    bundle.putInt("tmp_num",tmp_num);
                    bundle.putStringArray("severity", severity);
                    bundle.putStringArray("distress", distress);
                    //將Bundle物件assign給intent
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }else{
                    Toast.makeText(npiq2.this, "必須選擇嚴重度與困擾程度!!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        rGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rdo1:
                        severity[tmp_num] = "1";
                        break;
                    case R.id.rdo2:
                        severity[tmp_num] = "2";
                        break;
                    case R.id.rdo3:
                        severity[tmp_num] = "3";
                        break;
                    default:
                        break;
                }
            }
        });

        rGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdoA:
                        distress[tmp_num] = "1" ;
                        break;
                    case R.id.rdoB:
                        distress[tmp_num] = "2" ;
                        break;
                    case R.id.rdoC:
                        distress[tmp_num] = "3" ;
                        break;
                    case R.id.rdoD:
                        distress[tmp_num] = "4" ;
                        break;
                    case R.id.rdoE:
                        distress[tmp_num] = "5" ;
                        break;
                    default:
                        break;
                }
            }
        }) ;

    }

//    }
}
