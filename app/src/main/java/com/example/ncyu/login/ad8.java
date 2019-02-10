package com.example.ncyu.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.MyDBHelper;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class ad8 extends AppCompatActivity implements AsyncResponse{
    private Button btnUP, btnDOWN, btnCommit, btnY, btnN, btnNotSure;
    private Spinner spinner;
    private TextView txtTitle, txtContent;

    private SQLiteDatabase db;
    private MyDBHelper dbHelper;

    String EndTime;
    int tmp_num = 0; //當前題目是第幾題
    int score = 0;//總分
    int[] clicked = { -1, -1, -1, -1, -1, -1, -1, -1 }; //初始值=-1，有改變=1，無改變=0、不知道=2
    final String[] title ={ "1", "2", "3", "4", "5", "6", "7", "8"}; //題號
    final String[] content = { "判斷力上的困難:例如落入圈套或騙局、財務上不好的決定、買了對受禮者不合宜的禮物。"
            , "對活動和嗜好的興趣降低。"
            , "重複相同的問題、故事和陳述。"
            , "學習如何使用工具、設備、和小器具上有困難。例如:電視、音響、遙控器、冷氣機、洗衣機、熱水器、微波爐等。"
            , "忘記正確的月份和年份。"
            , "處理複雜的財務上有困難。例如:個人或家庭的收支平衡、繳費單、所得稅等。"
            , "記住約會的時間有困難。"
            , "有持續的思考和記憶方面的問題。"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad8);
        btnUP = (Button)findViewById(R.id.btnUP);
        btnDOWN = (Button)findViewById(R.id.btnDOWN);
        btnCommit = (Button)findViewById(R.id.btnCommit);
        btnY = (Button) findViewById(R.id.btnY);
        btnN = (Button)findViewById(R.id.btnN);
        btnNotSure = (Button)findViewById(R.id.btnNotSure);
        spinner = (Spinner)findViewById(R.id.spinner);
        txtTitle = (TextView)findViewById(R.id.txtTitle);
        txtContent = (TextView)findViewById(R.id.txtContent);



        //取得上個頁面的傳值
        final Bundle ANTestID =  this.getIntent().getExtras();

        //下拉選單的值從res\values\strings.xml取得
        ArrayAdapter<CharSequence> numList = ArrayAdapter.createFromResource(ad8.this,
                R.array.num8,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(numList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txtTitle.setText(title[i]);
                txtContent.setText(content[i]);
                tmp_num = i;

                checkColor(tmp_num);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //按下"上題"按鈕
        btnUP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (tmp_num > 0){
                    tmp_num = tmp_num -1;
                }
                spinner.setSelection(tmp_num);
                checkColor(tmp_num);
            }
        });

        //按下"下題"按鈕
        btnDOWN.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (tmp_num < 7){
                    tmp_num = tmp_num + 1;
                }
                spinner.setSelection(tmp_num);
                checkColor(tmp_num);
            }
        });

        //按下"有改變"按鈕
        btnY.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //檢查是否已經回答
                if(clicked[tmp_num]!=1){
                    //若尚未回答，或是已回答"有改變"之外其他的選項
                    clicked[tmp_num] = 1;
                    score = score + 1;
                }

                if (tmp_num < 7) {
                    tmp_num = tmp_num + 1;
                }
                spinner.setSelection(tmp_num);
                checkColor(tmp_num);
            }
        });

        //按下"無改變"按鈕
        btnN.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(clicked[tmp_num]==1){
                    //若是已回答有改變
                    score = score - 1;
                }
                clicked[tmp_num] = 0;
                if(tmp_num < 7) {
                    tmp_num = tmp_num + 1;
                }
                spinner.setSelection(tmp_num);
                checkColor(tmp_num);
            }
        });

        //按下"不知道/不適用"按鈕
        btnNotSure.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(clicked[tmp_num]==1){
                    //若是已回答有改變
                    score = score - 1;
                }
                clicked[tmp_num] = 2;
                if(tmp_num <7) {
                    tmp_num = tmp_num + 1;
                }
                spinner.setSelection(tmp_num);
                checkColor(tmp_num);
            }
        });

        //提交
        btnCommit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int flag=0;
                for(int i=0 ; i<clicked.length ; i++){
                    if(clicked[i]==-1) {
                        flag = 1;
                        break;
                    }
                    else
                        flag=0;
                }


                if(flag==0){
                    //取得結束測驗時間
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                    Calendar c = Calendar.getInstance();
                    EndTime = df.format(c.getTime());

                    if(ANTestID.getString("identity").equals("family")) {
                        HashMap postData = new HashMap();

//                        String test=ANTestID.getString("testID");  //經過php回傳的testID前面會有一個"在上方的'.' "位於字串首 ex: .168
//                        StringBuffer sb = new StringBuffer(test);
//                        Toast.makeText(ad8.this, sb.toString(), Toast.LENGTH_SHORT).show();
//                        sb.deleteCharAt(0);                        //刪除字串首的字元
//                        postData.put("testID",sb.toString());       //StringBuffer to String

                        postData.put("testID",ANTestID.getString("testID"));
                        postData.put("FAccount", ANTestID.getString("account"));
                        postData.put("EndTime", EndTime);
                        postData.put("Q1", toString().valueOf(clicked[0]));
                        postData.put("Q2", toString().valueOf(clicked[1]));
                        postData.put("Q3", toString().valueOf(clicked[2]));
                        postData.put("Q4", toString().valueOf(clicked[3]));
                        postData.put("Q5", toString().valueOf(clicked[4]));
                        postData.put("Q6", toString().valueOf(clicked[5]));
                        postData.put("Q7", toString().valueOf(clicked[6]));
                        postData.put("Q8", toString().valueOf(clicked[7]));
                        postData.put("score", toString().valueOf(score));

                        PostResponseAsyncTask task = new PostResponseAsyncTask(ad8.this,postData);
                        task.execute("http://ej30827.000webhostapp.com/AD8.php");
                    }
                    else if(ANTestID.getString("identity").equals("guest")){
                        //建立SQLiteOpenHelper 物件
                        dbHelper = new MyDBHelper(ad8.this);
                        db = dbHelper.getWritableDatabase();//開啟資料庫
                        ContentValues cv =new ContentValues();
                        cv.put("_id",ANTestID.getString("testID"));
                        cv.put("Q1", toString().valueOf(clicked[0]));
                        cv.put("Q2", toString().valueOf(clicked[1]));
                        cv.put("Q3", toString().valueOf(clicked[2]));
                        cv.put("Q4", toString().valueOf(clicked[3]));
                        cv.put("Q5", toString().valueOf(clicked[4]));
                        cv.put("Q6", toString().valueOf(clicked[5]));
                        cv.put("Q7", toString().valueOf(clicked[6]));
                        cv.put("Q8", toString().valueOf(clicked[7]));
                        cv.put("AD8_total_score", toString().valueOf(score));
                        long ad8Number =db.insert("ad8",null,cv);//新增AD8

                        ContentValues test =new ContentValues();
                        test.put("end_test_time",EndTime);
                        int count=db.update("test",test,"_id='"+ANTestID.getString("testID")+"' ",null);
                        Toast.makeText(ad8.this, "量表編號："+ANTestID.getString("testID"), Toast.LENGTH_SHORT).show();
                        //"test-count :"+count+"ad8Number: "+toString().valueOf(ad8Number)

                        startActivity(new Intent(ad8.this,visitor_function.class));
                        ad8.this.finish();
                    }

                } else{
                    Toast.makeText(ad8.this, "您尚有題目未作答!!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


    public void checkColor(int i){
        if(clicked[i] != -1) {
            if (clicked[i] == 1) {
                btnY.setTextColor(getResources().getColor(R.color.red));        //選過的按鈕字要變紅色
                btnN.setTextColor(getResources().getColor(R.color.white));
                btnNotSure.setTextColor(getResources().getColor(R.color.white));

            } else if (clicked[i] == 0) {
                btnY.setTextColor(getResources().getColor(R.color.white));
                btnN.setTextColor(getResources().getColor(R.color.red));        //選過的按鈕字要變紅色
                btnNotSure.setTextColor(getResources().getColor(R.color.white));
            } else if (clicked[i] == 2) {
                btnY.setTextColor(getResources().getColor(R.color.white));
                btnN.setTextColor(getResources().getColor(R.color.white));
                btnNotSure.setTextColor(getResources().getColor(R.color.red));    //選過的按鈕字要變紅色
            }
        } else {
            btnY.setTextColor(getResources().getColor(R.color.white));
            btnN.setTextColor(getResources().getColor(R.color.white));
            btnNotSure.setTextColor(getResources().getColor(R.color.white));
        }

    }

    @Override
    public void processFinish(String result) {
        if(result.equals("success")){
            Toast.makeText(this,"提交成功!", Toast.LENGTH_LONG).show();
            //取得上個頁面的傳值
            final Bundle ANTestID =  this.getIntent().getExtras();
            //new一個intent物件，並指定Activity切換的class
            Intent in = new Intent(ad8.this, family_function.class);
            //new一個Bundle物件，並將要傳遞的資料傳入
            Bundle bundle = new Bundle();
            bundle.putString("name", ANTestID.getString("name"));
            bundle.putString("account", ANTestID.getString("account"));
            //將Bundle物件assign給intent
            in.putExtras(bundle);
            startActivity(in);
            ad8.this.finish();
        }
        else {
            Toast.makeText(this,"錯誤！"+result, Toast.LENGTH_LONG).show();
        }

    }

    //返回鍵
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Bundle identity=this.getIntent().getExtras();
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {

            Intent in=null;
            if(identity.getString("identity").equals("guest")) {
                //new一個intent物件，並指定Activity切換的class
                in = new Intent(ad8.this, visitor_choose_test.class);
            }
            else if(identity.getString("identity").equals("family")){
                in = new Intent(ad8.this, family_choose_test.class);
            }
            startActivity(in);
            ad8.this.finish();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
