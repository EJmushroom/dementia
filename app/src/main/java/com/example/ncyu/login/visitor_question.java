package com.example.ncyu.login;

/**
 * Created by Ncyu on 2017/10/2.
 */
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
public class visitor_question extends AppCompatActivity{
    RadioGroup rg_FQ1,rg_FQ2,rg_FQ3,rg_FQ4,rg_FQ5,rg_FQ6,rg_FQ7;
    TextView tv_FQ1,tv_FQ2,tv_FQ3,tv_FQ4,tv_FQ5,tv_FQ6,tv_FQ7;
    Button btn_FQ_back_FF,btn_ignore,btn_understand;

    private SQLiteDatabase db;
    private MyDBHelper dbHelper;

    int[] Answer={0,0,0,0,0,0,0};
    int[] CAnswer={2,1,2,1,2,1,1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_question);

        btn_FQ_back_FF=(Button)findViewById(R.id.btn_FQ_back_FF);
        btn_ignore=(Button)findViewById(R.id.btn_ignore);
        btn_understand=(Button)findViewById(R.id.btn_understand);

        rg_FQ1=(RadioGroup)findViewById(R.id.rg_FQ1);
        rg_FQ2=(RadioGroup)findViewById(R.id.rg_FQ2);
        rg_FQ3=(RadioGroup)findViewById(R.id.rg_FQ3);
        rg_FQ4=(RadioGroup)findViewById(R.id.rg_FQ4);
        rg_FQ5=(RadioGroup)findViewById(R.id.rg_FQ5);
        rg_FQ6=(RadioGroup)findViewById(R.id.rg_FQ6);
        rg_FQ7=(RadioGroup)findViewById(R.id.rg_FQ7);

        tv_FQ1=(TextView)findViewById(R.id.tv_FQ1);
        tv_FQ2=(TextView)findViewById(R.id.tv_FQ2);
        tv_FQ3=(TextView)findViewById(R.id.tv_FQ3);
        tv_FQ4=(TextView)findViewById(R.id.tv_FQ4);
        tv_FQ5=(TextView)findViewById(R.id.tv_FQ5);
        tv_FQ6=(TextView)findViewById(R.id.tv_FQ6);
        tv_FQ7=(TextView)findViewById(R.id.tv_FQ7);

        RadioGroup.OnCheckedChangeListener FQ1= new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbtn_FQ1_yes :
                        Answer[0] = 1;
                        break;

                    case R.id.rbtn_FQ1_no :
                        Answer[0] = 2;
                        break;


                }
            }
        };
        rg_FQ1.setOnCheckedChangeListener(FQ1);

        RadioGroup.OnCheckedChangeListener FQ2= new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbtn_FQ2_yes :
                        Answer[1] = 1;
                        break;

                    case R.id.rbtn_FQ2_no :
                        Answer[1] = 2;
                        break;


                }
            }
        };
        rg_FQ2.setOnCheckedChangeListener(FQ2);

        RadioGroup.OnCheckedChangeListener FQ3= new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbtn_FQ3_yes :
                        Answer[2] = 1;
                        break;

                    case R.id.rbtn_FQ3_no :
                        Answer[2] = 2;
                        break;


                }
            }
        };
        rg_FQ3.setOnCheckedChangeListener(FQ3);

        RadioGroup.OnCheckedChangeListener FQ4= new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbtn_FQ4_yes :
                        Answer[3] = 1;
                        break;

                    case R.id.rbtn_FQ4_no :
                        Answer[3] = 2;
                        break;


                }
            }
        };
        rg_FQ4.setOnCheckedChangeListener(FQ4);

        RadioGroup.OnCheckedChangeListener FQ5= new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbtn_FQ5_yes :
                        Answer[4] = 1;
                        break;

                    case R.id.rbtn_FQ5_no :
                        Answer[4] = 2;
                        break;


                }
            }
        };
        rg_FQ5.setOnCheckedChangeListener(FQ5);

        RadioGroup.OnCheckedChangeListener FQ6= new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbtn_FQ6_yes :
                        Answer[5] = 1;
                        break;

                    case R.id.rbtn_FQ6_no :
                        Answer[5] = 2;
                        break;


                }
            }
        };
        rg_FQ6.setOnCheckedChangeListener(FQ6);

        RadioGroup.OnCheckedChangeListener FQ7= new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbtn_FQ7_yes :
                        Answer[6] = 1;
                        break;

                    case R.id.rbtn_FQ7_no :
                        Answer[6] = 2;
                        break;


                }
            }
        };
        rg_FQ7.setOnCheckedChangeListener(FQ7);

        //按下確定後
        btn_understand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //皆有回答
                int flag=0;
                String advise="";

                for(int i=0;i<7;i++){
                    if(Answer[i]==0){
                        Toast.makeText(visitor_question.this, "尚有題目未回答", Toast.LENGTH_SHORT).show();
                        flag=1; //尚有題目未答
                        break;
                    }
                }

                if(flag==0){
                    //皆有回答
                    //先恢復顏色
                    tv_FQ1.setTextColor(visitor_question.this.getResources().getColor(R.color.black));
                    tv_FQ2.setTextColor(visitor_question.this.getResources().getColor(R.color.black));
                    tv_FQ3.setTextColor(visitor_question.this.getResources().getColor(R.color.black));
                    tv_FQ4.setTextColor(visitor_question.this.getResources().getColor(R.color.black));
                    tv_FQ5.setTextColor(visitor_question.this.getResources().getColor(R.color.black));
                    tv_FQ6.setTextColor(visitor_question.this.getResources().getColor(R.color.black));
                    tv_FQ7.setTextColor(visitor_question.this.getResources().getColor(R.color.black));

                    for(int i=0;i<7;i++){
                        if(Answer[i]!=CAnswer[i]){
                            flag = 2; //題目皆答 但有錯
                            switch(i){
                                case 0:
                                    tv_FQ1.setTextColor(visitor_question.this.getResources().getColor(R.color.red));
                                    advise+="1 ";
                                    break;
                                case 1:
                                    tv_FQ2.setTextColor(visitor_question.this.getResources().getColor(R.color.red));
                                    advise+="2 ";
                                    break;
                                case 2:
                                    tv_FQ3.setTextColor(visitor_question.this.getResources().getColor(R.color.red));
                                    advise+="3 ";
                                    break;
                                case 3:
                                    tv_FQ4.setTextColor(visitor_question.this.getResources().getColor(R.color.red));
                                    advise+="4 ";
                                    break;
                                case 4:
                                    tv_FQ5.setTextColor(visitor_question.this.getResources().getColor(R.color.red));
                                    advise+="5 ";
                                    break;
                                case 5:
                                    tv_FQ6.setTextColor(visitor_question.this.getResources().getColor(R.color.red));
                                    advise+="6 ";
                                    break;
                                case 6:
                                    tv_FQ7.setTextColor(visitor_question.this.getResources().getColor(R.color.red));
                                    advise+="7 ";
                                    break;
                            }
                        }
                    }

                    if(flag==2) {
                        Toast.makeText(visitor_question.this, "題目 " + advise + "有誤(題號紅色)\n" +"請修正後再來", Toast.LENGTH_SHORT).show();
                    }
                    else if(flag==0){
                        //建立對話方框
                        AlertDialog.Builder builder = new AlertDialog.Builder(visitor_question.this);
                        builder.setTitle("是否保留");
                        builder.setMessage("想保留區分正常老化和失智症的問題嗎?\n" +
                                "(若選擇 '是' 來保留此問題再次出現)");

                        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //直接切換到量表種類選擇頁面

                                //頁面切換
                                //new一個intent物件，並指定Activity切換的class
                                Intent in=new Intent(visitor_question.this,visitor_choose_test.class);
                                startActivity(in);
                                visitor_question.this.finish();

                            }
                        });

                        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //建立SQLite物件
                                dbHelper = new MyDBHelper(visitor_question.this);
                                db = dbHelper.getWritableDatabase(); //開啟資料庫

                                //將SQLite資料庫family 資料表的 frequency屬性值改為1
                                ContentValues cv = new ContentValues();
                                cv.put("frequency",1);
                                int count = db.update("guest",cv,"_id = 1",null);
                                db.close(); //關閉資料庫

                                //頁面切換
                                //new一個intent物件，並指定Activity切換的class
                                Intent in=new Intent(visitor_question.this,visitor_choose_test.class);
                                startActivity(in);
                                visitor_question.this.finish();
                            }
                        });
                        builder.show();

                    }
                }

            }
        });

        btn_ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(visitor_question.this,visitor_choose_test.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                startActivity(in);
                visitor_question.this.finish();
            }
        });

        btn_FQ_back_FF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(visitor_question.this,visitor_function.class);
                startActivity(in);
                visitor_question.this.finish();
            }
        });
    }
    //返回鍵
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {

            //new一個intent物件，並指定Activity切換的class
            Intent in=new Intent(visitor_question.this,visitor_function.class);
            startActivity(in);
            visitor_question.this.finish();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
