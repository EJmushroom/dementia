package com.example.ncyu.login;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class npiq1 extends AppCompatActivity implements AsyncResponse {

    private Button btnUP, btnDOWN, btnY, btnN, btnCommit;
    private TextView title, content;
    private Spinner spinner;
    String EndTime;
    int[] clicked = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    String[] severity = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    String[] distress = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};

    int tmp_num = 0; //當前題目是第幾題

    final String[] NPIQ_title = {"1.妄想", "2.幻覺", "3.激動/攻擊性", "4.憂鬱/情緒不佳", "5.焦慮", "6.昂然自得/欣快感", "7.冷漠/豪不在意", "8.言行失控", "9.暴躁易怒/情緒易變", "10.怪異動作", "11.睡眠/夜間行為", "12.食慾及飲食行為改變"};
    final String[] NPIQ_content = {"病人是否認為有人企圖偷他/她的東西，或是企圖要傷害他/她 ?"
            , "病人是否表現得好像他/她在聽聲音? 他/她是否會與某一位不在場的人交談?"
            , "病人是否頑固，拒絕配合，不願讓別人幫助他/她?"
            , "病人是否表現憂傷或心情低落，他/她是否哭泣?"
            , "病人和您(或他/她的照顧者)分開時是否顯得緊張或生氣? 他/他是否有其他與緊張不安相關的症狀(表現)如:呼吸急促、嘆氣、不能放輕鬆、感到特別緊張等。"
            , "病人是否顯得心情太好了或太快樂了，或表現得極度愉悅?"
            , "病人是否對他/她平常的喜好或他人的計畫/活動失去興趣?"
            , "病人是否顯得做事衝動欠考慮? 例如:彷彿彼此熟識一般和陌生的人交談，或是與他人談話時是否不理會他人的感覺，或傷害他人的感覺?"
            , "病人是否失去耐性且暴躁不安，常無法忍受延誤或等待已經安排好的計劃?"
            , "病人是否有重複的動作? 例如:在屋內(無明顯目的)走來走去、重複扣釦子、纏繞線繩，不斷重複做某一件事?"
            , "病人是否半夜會吵醒你，或太早起床，或在白天睡得太多?"
            , "病人的體重是否減少或增加，他/她喜愛的食物是否有改變?"};

    private SQLiteDatabase db;
    private MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npiq1);
//        if(tmp_num>0) {
//            Bundle bundle = this.getIntent().getExtras();
//            tmp_num = bundle.getInt("tmp_num");
//            severity[tmp_num-1] = bundle.getString("severity");
//            distress[tmp_num-1] = bundle.getString("distress");
//        }
        btnUP = (Button) findViewById(R.id.btnUP);
        btnDOWN = (Button) findViewById(R.id.btnDOWN);
        btnY = (Button) findViewById(R.id.btnY);
        btnN = (Button) findViewById(R.id.btnN);
        btnCommit = (Button) findViewById(R.id.btnCommit);

        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        title.setText(NPIQ_title[0]);
        content.setText(NPIQ_content[0]);

        spinner = (Spinner) findViewById(R.id.spinner);

        //取得上個頁面的傳值
        final Bundle ANTestID =  this.getIntent().getExtras();



        //下拉選單的值從res\values\strings.xml取得
        ArrayAdapter<CharSequence> numList = ArrayAdapter.createFromResource(npiq1.this,
                R.array.num12,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(numList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                title.setText(NPIQ_title[i]);
                content.setText(NPIQ_content[i]);
                tmp_num = i;
                checkColor(tmp_num);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //按下"上題"按鈕
        btnUP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tmp_num > 0) {
                    tmp_num = tmp_num - 1;
                }
                spinner.setSelection(tmp_num);
                checkColor(tmp_num);
            }
        });

        //按下"下題"按鈕
        btnDOWN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (tmp_num < 11) {
                    tmp_num = tmp_num + 1;
                }
                spinner.setSelection(tmp_num);
                checkColor(tmp_num);
            }
        });

        //按下"是"按鈕
        btnY.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicked[tmp_num] = 1;
                Intent intent = new Intent();
                intent.setClass(npiq1.this, npiq2.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putStringArray("severity", severity);
                bundle.putStringArray("distress", distress);
                bundle.putString("title", NPIQ_title[tmp_num]);
                bundle.putInt("tmp_num", tmp_num);
                //將Bundle物件assign給intent
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
                if (tmp_num < 11) {
                    tmp_num = tmp_num + 1;
                }
//                spinner.setSelection(tmp_num);
                checkColor(tmp_num);
            }
        });

        //按下"否"按鈕
        btnN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicked[tmp_num] = 0;
                if (tmp_num < 11) {
                    tmp_num = tmp_num + 1;
                }
                spinner.setSelection(tmp_num);
                checkColor(tmp_num);
            }
        });


        //提交
        btnCommit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int flag = 0;
                for (int i = 0; i < clicked.length; i++) {
                    if (clicked[i] == -1) {
                        flag = 1;
                        break;
                    }
                    else
                        flag = 0;
                }

                if (flag == 0) {
                    //取得結束測驗時間
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                    Calendar c = Calendar.getInstance();
                    EndTime = df.format(c.getTime());
                    if(ANTestID.getString("identity").equals("family")) {
                        HashMap postData = new HashMap();
                        final Bundle ANTestID = npiq1.this.getIntent().getExtras();

//                        String test=ANTestID.getString("testID");  //經過php回傳的testID前面會有一個"在上方的'.' "位於字串首 ex: .168
//                        StringBuffer sb = new StringBuffer(test);
//                        sb.deleteCharAt(0);                        //刪除字串首的字元

                        postData.put("testID", ANTestID.getString("testID"));
                        postData.put("FAccount", ANTestID.getString("account"));
                        postData.put("EndTime", EndTime);
                        postData.put("yesNo1", toString().valueOf(clicked[0]));
                        postData.put("yesNo2", toString().valueOf(clicked[1]));
                        postData.put("yesNo3", toString().valueOf(clicked[2]));
                        postData.put("yesNo4", toString().valueOf(clicked[3]));
                        postData.put("yesNo5", toString().valueOf(clicked[4]));
                        postData.put("yesNo6", toString().valueOf(clicked[5]));
                        postData.put("yesNo7", toString().valueOf(clicked[6]));
                        postData.put("yesNo8", toString().valueOf(clicked[7]));
                        postData.put("yesNo9", toString().valueOf(clicked[8]));
                        postData.put("yesNo10", toString().valueOf(clicked[9]));
                        postData.put("yesNo11", toString().valueOf(clicked[10]));
                        postData.put("yesNo12", toString().valueOf(clicked[11]));
                        postData.put("severity1", severity[0]);
                        postData.put("severity2", severity[1]);
                        postData.put("severity3", severity[2]);
                        postData.put("severity4", severity[3]);
                        postData.put("severity5", severity[4]);
                        postData.put("severity6", severity[5]);
                        postData.put("severity7", severity[6]);
                        postData.put("severity8", severity[7]);
                        postData.put("severity9", severity[8]);
                        postData.put("severity10", severity[9]);
                        postData.put("severity11", severity[10]);
                        postData.put("severity12", severity[11]);
                        postData.put("distress1", distress[0]);
                        postData.put("distress2", distress[1]);
                        postData.put("distress3", distress[2]);
                        postData.put("distress4", distress[3]);
                        postData.put("distress5", distress[4]);
                        postData.put("distress6", distress[5]);
                        postData.put("distress7", distress[6]);
                        postData.put("distress8", distress[7]);
                        postData.put("distress9", distress[8]);
                        postData.put("distress10", distress[9]);
                        postData.put("distress11", distress[10]);
                        postData.put("distress12", distress[11]);
                        PostResponseAsyncTask task = new PostResponseAsyncTask(npiq1.this, postData);
                        task.execute("http://ej30827.000webhostapp.com/NPIQ.php");
                    }
                    else if(ANTestID.getString("identity").equals("guest")){
                        //建立SQLiteOpenHelper 物件
                        dbHelper = new MyDBHelper(npiq1.this);
                        db = dbHelper.getWritableDatabase();//開啟資料庫
                        ContentValues cv =new ContentValues();
                        cv.put("_id",ANTestID.getString("testID"));
                        cv.put("if_wishful_thinking", toString().valueOf(clicked[0]));
                        cv.put("if_illusion", toString().valueOf(clicked[1]));
                        cv.put("if_attack", toString().valueOf(clicked[2]));
                        cv.put("if_melancholy", toString().valueOf(clicked[3]));
                        cv.put("if_anxious", toString().valueOf(clicked[4]));
                        cv.put("if_happy", toString().valueOf(clicked[5]));
                        cv.put("if_cold", toString().valueOf(clicked[6]));
                        cv.put("if_out_of_control", toString().valueOf(clicked[7]));
                        cv.put("if_easy_angry", toString().valueOf(clicked[8]));
                        cv.put("if_weird_action", toString().valueOf(clicked[9]));
                        cv.put("if_nighttime_behavior", toString().valueOf(clicked[10]));
                        cv.put("if_appetite_diet_changed", toString().valueOf(clicked[11]));
                        cv.put("wishful_thinking_severity", severity[0]);
                        cv.put("illusion_severity", severity[1]);
                        cv.put("attack_severity", severity[2]);
                        cv.put("melancholy_severity", severity[3]);
                        cv.put("anxious_severity", severity[4]);
                        cv.put("happy_severity", severity[5]);
                        cv.put("cold_severity", severity[6]);
                        cv.put("out_of_control_severity", severity[7]);
                        cv.put("easy_angry_severity", severity[8]);
                        cv.put("weird_action_severity", severity[9]);
                        cv.put("nighttime_behavior_severity", severity[10]);
                        cv.put("appetite_diet_changed_severity", severity[11]);
                        cv.put("wishful_thinking_distress", distress[0]);
                        cv.put("illusion_distress", distress[1]);
                        cv.put("attack_distress", distress[2]);
                        cv.put("melancholy_distress", distress[3]);
                        cv.put("anxious_distress", distress[4]);
                        cv.put("happy_distress", distress[5]);
                        cv.put("cold_distress", distress[6]);
                        cv.put("out_of_control_distress", distress[7]);
                        cv.put("easy_angry_distress", distress[8]);
                        cv.put("weird_action_distress", distress[9]);
                        cv.put("nighttime_behavior_distress", distress[10]);
                        cv.put("appetite_diet_changed_distress", distress[11]);

                        long npiqNumber =db.insert("npiq",null,cv);//新增NPIQ
                        ContentValues test =new ContentValues();
                        test.put("end_test_time",EndTime);
                        int count=db.update("test",test,"_id='"+ANTestID.getString("testID")+"' ",null);
                        Toast.makeText(npiq1.this, "量表編號："+ANTestID.getString("testID"), Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(npiq1.this,visitor_function.class));
                        npiq1.this.finish();
                    }
                } else {
                    Toast.makeText(npiq1.this, "尚有題目未作答!!請確認每一題皆有作答。", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundleResult = data.getExtras();
            severity = bundleResult.getStringArray("severity");
            distress = bundleResult.getStringArray("distress");
            tmp_num = bundleResult.getInt("tmp_num");
            if (tmp_num < 12) {
                spinner.setSelection(tmp_num);
            } else if (tmp_num == 12) {
                tmp_num = 11;
            }
        }
    }

    public void checkColor(int i) {
        if (clicked[i] != -1) {
            if (clicked[i] == 1) {
                btnY.setTextColor(Color.rgb(255, 0, 0));
                btnN.setTextColor(Color.rgb(0, 0, 0));
            } else if (clicked[i] == 0) {
                btnY.setTextColor(Color.rgb(0, 0, 0));
                btnN.setTextColor(Color.rgb(255, 0, 0));
            }
        } else {
            btnY.setTextColor(Color.rgb(0, 0, 0));
            btnN.setTextColor(Color.rgb(0, 0, 0));
        }

    }

    @Override
    public void processFinish(String result) {
        //8="success"+1
        if (result.equals("success")) {
            Toast.makeText(this, "提交成功!", Toast.LENGTH_LONG).show();
            //取得上個頁面的傳值
            final Bundle ANTestID =  this.getIntent().getExtras();
            //new一個intent物件，並指定Activity切換的class
            Intent in = new Intent(npiq1.this, family_function.class);
            //new一個Bundle物件，並將要傳遞的資料傳入
            Bundle bundle = new Bundle();
            bundle.putString("name", ANTestID.getString("name"));
            bundle.putString("account", ANTestID.getString("account"));
            //將Bundle物件assign給intent
            in.putExtras(bundle);
            startActivity(in);
            finish();
        } else {
            Toast.makeText(this,"錯誤！ "+result, Toast.LENGTH_LONG).show();
        }
    }

}
