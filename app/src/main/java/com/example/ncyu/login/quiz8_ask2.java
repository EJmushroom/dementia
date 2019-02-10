package com.example.ncyu.login;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import com.kosalgeek.asynctask.AsyncResponse;
//import com.kosalgeek.asynctask.PostResponseAsyncTask;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.io.ByteArrayOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class quiz8_ask2 extends AppCompatActivity implements AsyncResponse {

    Button quiz8_ask2_word1, quiz8_ask2_word2, quiz8_ask2_word3;
    boolean[] quiz8_word = {false, false, false};
    Bundle bundle1;
    String EndTime;
    private SQLiteDatabase db;
    private MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz8_ask2);
        quiz8_ask2_word1 = (Button) findViewById(R.id.quiz8_word1);
        quiz8_ask2_word2 = (Button) findViewById(R.id.quiz8_word2);
        quiz8_ask2_word3 = (Button) findViewById(R.id.quiz8_word3);
        bundle1=getIntent().getExtras();

    }

    public void onClick2(View v) {
        int result = v.getId();
        if (result == R.id.quiz8_word1) {
            if (quiz8_word[0] == false) {
                quiz8_ask2_word1.setBackgroundColor(this.getResources().getColor(R.color.colorRed));
                quiz8_word[0] = true;
            } else {
                quiz8_ask2_word1.setBackgroundColor(this.getResources().getColor(R.color.colorButtomNormal));
                quiz8_word[0] = false;
            }
        } else if (result == R.id.quiz8_word2) {
            if (quiz8_word[1] == false) {
                quiz8_ask2_word2.setBackgroundColor(this.getResources().getColor(R.color.colorRed));
                quiz8_word[1] = true;
            } else {
                quiz8_ask2_word2.setBackgroundColor(this.getResources().getColor(R.color.colorButtomNormal));
                quiz8_word[1] = false;
            }
        } else if (result == R.id.quiz8_word3) {
            if (quiz8_word[2] == false) {
                quiz8_ask2_word3.setBackgroundColor(this.getResources().getColor(R.color.colorRed));
                quiz8_word[2] = true;
            } else {
                quiz8_ask2_word3.setBackgroundColor(this.getResources().getColor(R.color.colorButtomNormal));
                quiz8_word[2] = false;
            }
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:


                //取得結束測驗時間
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                Calendar c = Calendar.getInstance();
                EndTime = df.format(c.getTime());

                //布林 true , false 轉換 1 , 0
                boolean quiz1_ask1_disAnswer[] = bundle1.getBooleanArray("quiz1_ask1_disAnswer");
                int q1a1dA[] = {0, 0, 0, 0};
                //quiz1_ask1_disAnswer=bundle1.getBooleanArray("quiz1_ask1_disAnswer");
                for (int i = 0; i < 4; i++) {
                    if (quiz1_ask1_disAnswer[i] == true) {
                        q1a1dA[i] = 1;
                    }
                }

                int q1a2dA = 0;
                if (bundle1.getBoolean("quiz1_ask2_disAnswer") == true) {
                    q1a2dA = 1;
                }

                boolean quiz2_ask_isAnswer[] = bundle1.getBooleanArray("quiz2_ask_isAnswer");
                int q2aiA[] = {0, 0, 0, 0, 0, 0, 0, 0};
                for (int i = 0; i < 8; i++) {
                    if (quiz2_ask_isAnswer[i] == true) {
                        q2aiA[i] = 1;
                    }
                }

                boolean quiz2_ask_disAnswer[] = bundle1.getBooleanArray("quiz2_ask_disAnswer");
                int q2adA[] = {0, 0, 0, 0, 0, 0, 0, 0};
                for (int i = 0; i < 8; i++) {
                    if (quiz2_ask_disAnswer[i] == true) {
                        q2adA[i] = 1;
                    }
                }

                String quiz2_answer[] = bundle1.getStringArray("quiz2_answer");

                String quiz3_word_bundle[] = bundle1.getStringArray("quiz3_word_bundle");

                boolean quiz3_word[] = bundle1.getBooleanArray("quiz3_word");
                int q3w[] = {0, 0, 0};
                for (int i = 0; i < 3; i++) {
                    if (quiz3_word[i] == false) {
                        q3w[i] = 1;
                    }
                }

                String quiz4_answer[] = bundle1.getStringArray("quiz4_answer");

                boolean quiz5_word[] = bundle1.getBooleanArray("quiz5_word");
                int q5w[] = {0, 0, 0};
                for (int i = 0; i < 3; i++) {
                    if (quiz5_word[i] == false) {
                        q5w[i] = 1;
                    }
                }

                String quiz6_ask1_word[] = bundle1.getStringArray("quiz6_ask1_word");

                int q6a2a = 0;
                if (bundle1.getBoolean("quiz6_ask2_answer") == false) {
                    q6a2a = 1;
                }

                int q6a3a = 0;
                if (bundle1.getBoolean("quiz6_ask3_answer") == false) {
                    q6a3a = 1;
                }

                Bitmap bitmap = bundle1.getParcelable("quiz7_bundle");
                // 1.先將 Bitmap 轉換成 byte[]
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                byte[] vByteArray = bos.toByteArray();
                // 2.透過 byte[] 儲存到 blob 欄位
                String strImage = Base64.encodeToString(vByteArray, Base64.DEFAULT);

                int q7a = 0;
                if (bundle1.getBoolean("quiz7_answer") == false) {
                    q7a = 1;
                }

                int q8w[] = {0, 0, 0};
                for (int i = 0; i < 3; i++) {
                    if (quiz8_word[0] == false) {
                        q8w[i] = 1;
                    }
                }

                if(bundle1.getString("identity").equals("family")) {

                    HashMap postData = new HashMap();
//                    String test=bundle1.getString("testID");  //經過php回傳的testID前面會有一個"在上方的'.' "位於字串首 ex: .168
//                    StringBuffer sb = new StringBuffer(test);
//                    sb.deleteCharAt(0);                        //刪除字串首的字元
                    postData.put("testID", bundle1.getString("testID"));       //StringBuffer to String
                    postData.put("FAccount", bundle1.getString("account"));
                    postData.put("EndTime", EndTime);

                    postData.put("quiz1_ask1_disAnswer_year", toString().valueOf(q1a1dA[0]));
                    postData.put("quiz1_ask1_disAnswer_month", toString().valueOf(q1a1dA[1]));
                    postData.put("quiz1_ask1_disAnswer_day", toString().valueOf(q1a1dA[2]));
                    postData.put("quiz1_ask1_disAnswer_weekday", toString().valueOf(q1a1dA[3]));

                    postData.put("quiz_ask1_answer_type", bundle1.getString("quiz_ask1_answer_type"));
                    postData.put("quiz1_ask1_answer1", bundle1.getString("quiz1_ask1_answer1"));
                    postData.put("quiz1_ask1_answer2", bundle1.getString("quiz1_ask1_answer2"));
                    postData.put("quiz1_ask1_answer3", bundle1.getString("quiz1_ask1_answer3"));
                    postData.put("quiz1_ask1_answer4", bundle1.getString("quiz1_ask1_answer4"));
                    postData.put("quiz1_ask1_score", toString().valueOf(quiz1_ask1_score()));

                    postData.put("quiz1_ask2_quiz", bundle1.getString("quiz1_ask2_quiz"));
                    postData.put("quiz1_ask2_answer", bundle1.getString("quiz1_ask2_answer"));
                    postData.put("quiz1_ask2_disAnswer", toString().valueOf(q1a2dA));
                    postData.put("quiz1_ask2_score", toString().valueOf(quiz1_ask2_score()));

                    postData.put("quiz2_ask_isAnswer1", toString().valueOf(q2aiA[0]));
                    postData.put("quiz2_ask_isAnswer2", toString().valueOf(q2aiA[1]));
                    postData.put("quiz2_ask_isAnswer3", toString().valueOf(q2aiA[2]));
                    postData.put("quiz2_ask_isAnswer4", toString().valueOf(q2aiA[3]));
                    postData.put("quiz2_ask_isAnswer5", toString().valueOf(q2aiA[4]));
                    postData.put("quiz2_ask_isAnswer6", toString().valueOf(q2aiA[5]));
                    postData.put("quiz2_ask_isAnswer7", toString().valueOf(q2aiA[6]));
                    postData.put("quiz2_ask_isAnswer8", toString().valueOf(q2aiA[7]));

                    postData.put("quiz2_ask_disAnswer1", toString().valueOf(q2adA[0]));
                    postData.put("quiz2_ask_disAnswer2", toString().valueOf(q2adA[1]));
                    postData.put("quiz2_ask_disAnswer3", toString().valueOf(q2adA[2]));
                    postData.put("quiz2_ask_disAnswer4", toString().valueOf(q2adA[3]));
                    postData.put("quiz2_ask_disAnswer5", toString().valueOf(q2adA[4]));
                    postData.put("quiz2_ask_disAnswer6", toString().valueOf(q2adA[5]));
                    postData.put("quiz2_ask_disAnswer7", toString().valueOf(q2adA[6]));
                    postData.put("quiz2_ask_disAnswer8", toString().valueOf(q2adA[7]));

                    postData.put("quiz2_answer1", toString().valueOf(quiz2_answer[0]));
                    postData.put("quiz2_answer2", toString().valueOf(quiz2_answer[1]));
                    postData.put("quiz2_answer3", toString().valueOf(quiz2_answer[2]));
                    postData.put("quiz2_answer4", toString().valueOf(quiz2_answer[3]));
                    postData.put("quiz2_answer5", toString().valueOf(quiz2_answer[4]));
                    postData.put("quiz2_answer6", toString().valueOf(quiz2_answer[5]));
                    postData.put("quiz2_answer7", toString().valueOf(quiz2_answer[6]));
                    postData.put("quiz2_answer8", toString().valueOf(quiz2_answer[7]));

                    postData.put("quiz2_score", toString().valueOf(quiz2_score()));

                    postData.put("quiz3_word_bundle1", toString().valueOf(quiz3_word_bundle[0]));
                    postData.put("quiz3_word_bundle2", toString().valueOf(quiz3_word_bundle[1]));
                    postData.put("quiz3_word_bundle3", toString().valueOf(quiz3_word_bundle[2]));

                    postData.put("quiz3_word1", toString().valueOf(q3w[0]));
                    postData.put("quiz3_word2", toString().valueOf(q3w[1]));
                    postData.put("quiz3_word3", toString().valueOf(q3w[2]));

                    postData.put("quiz3_score", toString().valueOf(quiz3_score()));

                    postData.put("quiz4_answer1", toString().valueOf(quiz4_answer[0]));
                    postData.put("quiz4_answer2", toString().valueOf(quiz4_answer[1]));
                    postData.put("quiz4_answer3", toString().valueOf(quiz4_answer[2]));
                    postData.put("quiz4_answer4", toString().valueOf(quiz4_answer[3]));
                    postData.put("quiz4_answer5", toString().valueOf(quiz4_answer[4]));

                    postData.put("quiz4_score", toString().valueOf(quiz4_score()));

                    postData.put("quiz5_word1", toString().valueOf(q5w[0]));
                    postData.put("quiz5_word2", toString().valueOf(q5w[1]));
                    postData.put("quiz5_word3", toString().valueOf(q5w[2]));

                    postData.put("quiz5_score", toString().valueOf(quiz5_score()));

                    postData.put("quiz6_ask1_word1", toString().valueOf(quiz6_ask1_word[0]));
                    postData.put("quiz6_ask1_word2", toString().valueOf(quiz6_ask1_word[1]));

                    postData.put("quiz6_ask2_word", bundle1.getString("quiz6_ask2_word"));

                    postData.put("quiz6_ask2_answer", toString().valueOf(q6a2a));
                    postData.put("quiz6_ask3_quiz", bundle1.getString("quiz6_ask3_quiz"));

                    postData.put("quiz6_ask3_answer", toString().valueOf(q6a3a));
                    postData.put("quiz6_ask4_answer", bundle1.getString("quiz6_ask4_answer"));
                    postData.put("quiz6_score", toString().valueOf(quiz6_score()));

                    postData.put("quiz7_bundle", strImage);

                    postData.put("quiz7_answer", toString().valueOf(q7a));
                    postData.put("quiz7_score", toString().valueOf(quiz7_score()));

                    postData.put("quiz8_word1", toString().valueOf(q8w[0]));
                    postData.put("quiz8_word2", toString().valueOf(q8w[1]));
                    postData.put("quiz8_word3", toString().valueOf(q8w[2]));

                    postData.put("quiz8_score", toString().valueOf(quiz8_score()));
                    postData.put("MMSE_total_score", toString().valueOf(quiz1_ask1_score() + quiz1_ask2_score() + quiz2_score() + quiz3_score() + quiz4_score() + quiz5_score() + quiz6_score() + quiz7_score()
                            + quiz8_score()));

                    PostResponseAsyncTask task = new PostResponseAsyncTask(quiz8_ask2.this, postData);
                    task.execute("http://ej30827.000webhostapp.com/MMSE.php");
                    break;
                }
                else if(bundle1.getString("identity").equals("guest")){
                    //建立SQLiteOpenHelper 物件
                    dbHelper = new MyDBHelper(quiz8_ask2.this);
                    db = dbHelper.getWritableDatabase();//開啟資料庫
                    ContentValues cv =new ContentValues();
                    cv.put("_id",bundle1.getString("testID"));
                    cv.put("quiz1_ask1_disAnswer_year",bundle1.getString("testID"));
                    cv.put("quiz1_ask1_disAnswer_year", toString().valueOf(q1a1dA[0]));
                    cv.put("quiz1_ask1_disAnswer_month", toString().valueOf(q1a1dA[1]));
                    cv.put("quiz1_ask1_disAnswer_day", toString().valueOf(q1a1dA[2]));
                    cv.put("quiz1_ask1_disAnswer_weekday", toString().valueOf(q1a1dA[3]));

                    cv.put("quiz_ask1_answer_type", bundle1.getString("quiz_ask1_answer_type"));
                    cv.put("quiz1_ask1_answer1", bundle1.getString("quiz1_ask1_answer1"));
                    cv.put("quiz1_ask1_answer2", bundle1.getString("quiz1_ask1_answer2"));
                    cv.put("quiz1_ask1_answer3", bundle1.getString("quiz1_ask1_answer3"));
                    cv.put("quiz1_ask1_answer4", bundle1.getString("quiz1_ask1_answer4"));
                    cv.put("quiz1_ask1_score", toString().valueOf(quiz1_ask1_score()));

                    cv.put("quiz1_ask2_quiz", bundle1.getString("quiz1_ask2_quiz"));
                    cv.put("quiz1_ask2_answer", bundle1.getString("quiz1_ask2_answer"));
                    cv.put("quiz1_ask2_disAnswer", toString().valueOf(q1a2dA));
                    cv.put("quiz1_ask2_score", toString().valueOf(quiz1_ask2_score()));

                    cv.put("quiz2_ask_isAnswer1", toString().valueOf(q2aiA[0]));
                    cv.put("quiz2_ask_isAnswer2", toString().valueOf(q2aiA[1]));
                    cv.put("quiz2_ask_isAnswer3", toString().valueOf(q2aiA[2]));
                    cv.put("quiz2_ask_isAnswer4", toString().valueOf(q2aiA[3]));
                    cv.put("quiz2_ask_isAnswer5", toString().valueOf(q2aiA[4]));
                    cv.put("quiz2_ask_isAnswer6", toString().valueOf(q2aiA[5]));
                    cv.put("quiz2_ask_isAnswer7", toString().valueOf(q2aiA[6]));
                    cv.put("quiz2_ask_isAnswer8", toString().valueOf(q2aiA[7]));

                    cv.put("quiz2_ask_disAnswer1", toString().valueOf(q2adA[0]));
                    cv.put("quiz2_ask_disAnswer2", toString().valueOf(q2adA[1]));
                    cv.put("quiz2_ask_disAnswer3", toString().valueOf(q2adA[2]));
                    cv.put("quiz2_ask_disAnswer4", toString().valueOf(q2adA[3]));
                    cv.put("quiz2_ask_disAnswer5", toString().valueOf(q2adA[4]));
                    cv.put("quiz2_ask_disAnswer6", toString().valueOf(q2adA[5]));
                    cv.put("quiz2_ask_disAnswer7", toString().valueOf(q2adA[6]));
                    cv.put("quiz2_ask_disAnswer8", toString().valueOf(q2adA[7]));

                    cv.put("quiz2_answer1", toString().valueOf(quiz2_answer[0]));
                    cv.put("quiz2_answer2", toString().valueOf(quiz2_answer[1]));
                    cv.put("quiz2_answer3", toString().valueOf(quiz2_answer[2]));
                    cv.put("quiz2_answer4", toString().valueOf(quiz2_answer[3]));
                    cv.put("quiz2_answer5", toString().valueOf(quiz2_answer[4]));
                    cv.put("quiz2_answer6", toString().valueOf(quiz2_answer[5]));
                    cv.put("quiz2_answer7", toString().valueOf(quiz2_answer[6]));
                    cv.put("quiz2_answer8", toString().valueOf(quiz2_answer[7]));

                    cv.put("quiz2_score", toString().valueOf(quiz2_score()));

                    cv.put("quiz3_word_bundle1", toString().valueOf(quiz3_word_bundle[0]));
                    cv.put("quiz3_word_bundle2", toString().valueOf(quiz3_word_bundle[1]));
                    cv.put("quiz3_word_bundle3", toString().valueOf(quiz3_word_bundle[2]));

                    cv.put("quiz3_word1", toString().valueOf(q3w[0]));
                    cv.put("quiz3_word2", toString().valueOf(q3w[1]));
                    cv.put("quiz3_word3", toString().valueOf(q3w[2]));

                    cv.put("quiz3_score", toString().valueOf(quiz3_score()));

                    cv.put("quiz4_answer1", toString().valueOf(quiz4_answer[0]));
                    cv.put("quiz4_answer2", toString().valueOf(quiz4_answer[1]));
                    cv.put("quiz4_answer3", toString().valueOf(quiz4_answer[2]));
                    cv.put("quiz4_answer4", toString().valueOf(quiz4_answer[3]));
                    cv.put("quiz4_answer5", toString().valueOf(quiz4_answer[4]));

                    cv.put("quiz4_score", toString().valueOf(quiz4_score()));

                    cv.put("quiz5_word1", toString().valueOf(q5w[0]));
                    cv.put("quiz5_word2", toString().valueOf(q5w[1]));
                    cv.put("quiz5_word3", toString().valueOf(q5w[2]));

                    cv.put("quiz5_score", toString().valueOf(quiz5_score()));

                    cv.put("quiz6_ask1_word1", toString().valueOf(quiz6_ask1_word[0]));
                    cv.put("quiz6_ask1_word2", toString().valueOf(quiz6_ask1_word[1]));

                    cv.put("quiz6_ask2_word", bundle1.getString("quiz6_ask2_word"));

                    cv.put("quiz6_ask2_answer", toString().valueOf(q6a2a));
                    cv.put("quiz6_ask3_quiz", bundle1.getString("quiz6_ask3_quiz"));

                    cv.put("quiz6_ask3_answer", toString().valueOf(q6a3a));
                    cv.put("quiz6_ask4_answer", bundle1.getString("quiz6_ask4_answer"));
                    cv.put("quiz6_score", toString().valueOf(quiz6_score()));

                    cv.put("quiz7_bundle", strImage);

                    cv.put("quiz7_answer", toString().valueOf(q7a));
                    cv.put("quiz7_score", toString().valueOf(quiz7_score()));

                    cv.put("quiz8_word1", toString().valueOf(q8w[0]));
                    cv.put("quiz8_word2", toString().valueOf(q8w[1]));
                    cv.put("quiz8_word3", toString().valueOf(q8w[2]));

                    cv.put("quiz8_score", toString().valueOf(quiz8_score()));
                    cv.put("MMSE_total_score", toString().valueOf(quiz1_ask1_score() + quiz1_ask2_score() + quiz2_score() + quiz3_score() + quiz4_score() + quiz5_score() + quiz6_score() + quiz7_score()
                            + quiz8_score()));
                    long mmseNumber =db.insert("mmse",null,cv);//新增MMSE

                    ContentValues test =new ContentValues();
                    test.put("end_test_time",EndTime);
                    int count=db.update("test",test,"_id='"+bundle1.getString("testID")+"' ",null);
                    Toast.makeText(quiz8_ask2.this, "量表編號："+bundle1.getString("testID"), Toast.LENGTH_SHORT).show();
                    //"test-count :"+count+"mmseNumber: "+toString().valueOf(mmseNumber)
                    startActivity(new Intent(quiz8_ask2.this,visitor_function.class));
                    quiz8_ask2.this.finish();
                }
        }
    }

    public int quiz1_ask1_score() {
        int score = 0;
        for (int i = 0; i < bundle1.getBooleanArray("quiz1_ask1_disAnswer").length; i++) {
            if (bundle1.getBooleanArray("quiz1_ask1_disAnswer")[i] == false) {
                if (i == 0) {
                    if (!bundle1.getString("quiz1_ask1_answer1").equals("")) {
                        score = score + 1;
                    }
                } else if (i == 1) {
                    if (!bundle1.getString("quiz1_ask1_answer2").equals("")) {
                        score = score + 1;
                    }
                } else if (i == 2) {
                    if (!bundle1.getString("quiz1_ask1_answer3").equals("")) {
                        score = score + 1;
                    }
                } else if (i == 3) {
                    if (!bundle1.getString("quiz1_ask1_answer4").equals("")) {
                        score = score + 1;
                    }
                }
            }
        }
        return score;
    }

    public int quiz1_ask2_score() {
        int score = 0;
        if (bundle1.getBoolean("quiz1_ask2_disAnswer") == false) {
            if (!bundle1.getString("quiz1_ask2_answer").equals("")) {
                score = score + 1;
            }
        }
        return score;
    }

    public int quiz2_score() {
        int score = 0;
        for (int i = 0; i < bundle1.getBooleanArray("quiz2_ask_disAnswer").length; i++) {
            if (bundle1.getBooleanArray("quiz2_ask_disAnswer")[i] == false) {
                if (!bundle1.getStringArray("quiz2_answer")[i].equals("")) {
                    score = score + 1;
                }
            }
        }
        return score;
    }

    public int quiz3_score() {
        int score = 0;
        for (int i = 0; i < bundle1.getBooleanArray("quiz3_word").length; i++) {
            if (bundle1.getBooleanArray("quiz3_word")[i] == true) {
                score = score + 1;
            }
        }
        return score;
    }

    public int quiz4_score() {
        int score = 0;
        for (int i = 0; i < bundle1.getStringArray("quiz4_answer").length; i++) {
            if (i == 0) {
                if (bundle1.getStringArray("quiz4_answer")[i].equals("93")) {
                    score = score + 1;
                }
            } else if (i == 1) {
                if (bundle1.getStringArray("quiz4_answer")[i].equals("86")) {
                    score = score + 1;
                }
            } else if (i == 2) {
                if (bundle1.getStringArray("quiz4_answer")[i].equals("79")) {
                    score = score + 1;
                }
            } else if (i == 3) {
                if (bundle1.getStringArray("quiz4_answer")[i].equals("72")) {
                    score = score + 1;
                }
            } else if (i == 4) {
                if (bundle1.getStringArray("quiz4_answer")[i].equals("65")) {
                    score = score + 1;
                }
            }
        }
        return score;
    }

    public int quiz5_score() {
        int score = 0;
        for (int i = 0; i < bundle1.getBooleanArray("quiz5_word").length; i++) {
            if (bundle1.getBooleanArray("quiz5_word")[i] == true) {
                score = score + 1;
            }
        }
        return score;
    }

    public int quiz6_score() {
        int score = 0;
        for (int i = 0; i < bundle1.getStringArray("quiz6_ask1_word").length; i++) {
            if (!bundle1.getStringArray("quiz6_ask1_word")[i].equals("")) {
                score = score + 1;
            }
        }
        if (bundle1.getBoolean("quiz6_ask2_answer") == true) {
            score = score + 1;
        }
        if (bundle1.getBoolean("quiz6_ask3_answer") == true) {
            score = score + 1;
        }
        if (!bundle1.getString("quiz6_ask4_answer").equals("")) {
            score = score + 1;
        }
        return score;
    }

    public int quiz7_score(){
        int score = 0;
        if (bundle1.getBoolean("quiz7_answer")==true) {
            score = score + 1;
        }
        return score;
    }

    public int quiz8_score() {
        int score = 0;
        for (int i = 0; i < quiz8_word.length; i++) {
            if (quiz8_word[i] == true) {
                score = score + 1;
            }
        }
        return score;
    }

    @Override
    public void processFinish(String result) {
        //8="success"+1
        if(result.equals("success")){
            Toast.makeText(this,"提交成功!", Toast.LENGTH_LONG).show();
            //取得上個頁面的傳值
            final Bundle ANTestID =  this.getIntent().getExtras();
            Intent in=null;
            Bundle bundle = new Bundle();
            if(ANTestID.getString("identity").equals("family")) {
                //new一個intent物件，並指定Activity切換的class
                in = new Intent(quiz8_ask2.this, family_function.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                bundle.putString("name", ANTestID.getString("name"));
                bundle.putString("account", ANTestID.getString("account"));
                //將Bundle物件assign給intent
            }
            else if(ANTestID.getString("identity").equals("guest")){
                in = new Intent(quiz8_ask2.this, visitor_function.class);
            }
            in.putExtras(bundle);
            startActivity(in);
            quiz8_ask2.this.finish();
        }
        else {
            Toast.makeText(this,"錯誤！"+result, Toast.LENGTH_LONG).show();
        }
    }

}
