package com.example.ncyu.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class moca_quiz9_ask extends AppCompatActivity implements AsyncResponse{
    CheckBox disAnswer1, disAnswer2, disAnswer3, disAnswer4, disAnswer5, disAnswer6;
    Spinner quiz9_day_spinner, quiz9_yeartype_spinner;
    EditText quiz9_month, quiz9_date, quiz9_site, quiz9_city, quiz9_year;
    String quiz9_answer[] = new String[7];
    boolean isDisAnswer[] = {false, false, false, false, false, false};
    boolean isAnswer[] = {false, false, false, false, false, false};
    String form_answer[] = new String[6];
    Bundle bundle1;
    String EndTime;
    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz9_ask);

        quiz9_day_spinner = (Spinner) findViewById(R.id.quiz9_day_spinner);
        String[] quiz9_day_quiz = getResources().getStringArray(R.array.moca_quiz9_day_quiz);
        ArrayAdapter<String> quiz9_day_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, quiz9_day_quiz);
        quiz9_day_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quiz9_day_spinner.setAdapter(quiz9_day_adapter);

        quiz9_yeartype_spinner = (Spinner) findViewById(R.id.quiz9_yeartype_spinner);
        String[] quiz9_yeartype_quiz = getResources().getStringArray(R.array.moca_quiz9_yeartype_quiz);
        final ArrayAdapter<String> quiz9_yeartype_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, quiz9_yeartype_quiz);
        quiz9_yeartype_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quiz9_yeartype_spinner.setAdapter(quiz9_yeartype_adapter);

        disAnswer1 = (CheckBox) findViewById(R.id.disAnswer1);
        disAnswer2 = (CheckBox) findViewById(R.id.disAnswer2);
        disAnswer3 = (CheckBox) findViewById(R.id.disAnswer3);
        disAnswer4 = (CheckBox) findViewById(R.id.disAnswer4);
        disAnswer5 = (CheckBox) findViewById(R.id.disAnswer5);
        disAnswer6 = (CheckBox) findViewById(R.id.disAnswer6);
        quiz9_month = (EditText) findViewById(R.id.quiz9_month);
        quiz9_date = (EditText) findViewById(R.id.quiz9_date);
        quiz9_site = (EditText) findViewById(R.id.quiz9_site);
        quiz9_city = (EditText) findViewById(R.id.quiz9_city);
        quiz9_year = (EditText) findViewById(R.id.quiz9_year);
        bundle1=getIntent().getExtras();

        disAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (disAnswer1.isChecked()) {
                    form_answer[0] = quiz9_year.getText().toString();
                    quiz9_year.setTextSize(15);
                    quiz9_year.setText("");
                    isDisAnswer[0] = true;
                    quiz9_year.setHint("受測者無法作答");
                    quiz9_year.setEnabled(false);
                    quiz9_yeartype_spinner.setEnabled(false);
                    isAnswer[0] = true;
                } else {
                    quiz9_year.setEnabled(true);
                    quiz9_yeartype_spinner.setEnabled(true);
                    quiz9_year.setTextSize(30);
                    quiz9_year.setHint("");
                    if (form_answer[0] == null) {
                        form_answer[0] = null;
                    }
                    quiz9_year.setText(form_answer[0]);
                    isDisAnswer[0] = false;
                    isAnswer[0] = false;
                }
            }
        });

        disAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (disAnswer2.isChecked()) {
                    form_answer[1] = quiz9_month.getText().toString();
                    quiz9_month.setTextSize(15);
                    quiz9_month.setText("");
                    isDisAnswer[1] = true;
                    quiz9_month.setHint("受測者無法作答");
                    quiz9_month.setEnabled(false);
                    isAnswer[1] = true;
                } else {
                    quiz9_month.setEnabled(true);
                    quiz9_month.setTextSize(30);
                    quiz9_month.setHint("");
                    if (form_answer[1] == null) {
                        form_answer[1] = null;
                    }
                    quiz9_month.setText(form_answer[1]);
                    isDisAnswer[1] = false;
                    isAnswer[1] = false;
                }
            }
        });

        disAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (disAnswer3.isChecked()) {
                    form_answer[2] = quiz9_date.getText().toString();
                    quiz9_date.setTextSize(15);
                    quiz9_date.setText("");
                    isDisAnswer[2] = true;
                    quiz9_date.setHint("受測者無法作答");
                    quiz9_date.setEnabled(false);
                    isAnswer[2] = true;
                } else {
                    quiz9_date.setEnabled(true);
                    quiz9_date.setTextSize(30);
                    quiz9_date.setHint("");
                    if (form_answer[2] == null) {
                        form_answer[2] = null;
                    }
                    quiz9_date.setText(form_answer[2]);
                    isDisAnswer[2] = false;
                    isAnswer[2] = false;
                }
            }
        });

        disAnswer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (disAnswer4.isChecked()) {
                    quiz9_day_spinner.setEnabled(false);
                    isDisAnswer[3] = true;
                    isAnswer[3] = true;
                } else {
                    quiz9_day_spinner.setEnabled(true);
                    isDisAnswer[3] = false;
                    isAnswer[3] = false;
                }
            }
        });

        disAnswer5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (disAnswer5.isChecked()) {
                    form_answer[4] = quiz9_site.getText().toString();
                    quiz9_site.setTextSize(15);
                    quiz9_site.setText("");
                    isDisAnswer[4] = true;
                    quiz9_site.setHint("受測者無法作答");
                    quiz9_site.setEnabled(false);
                    isAnswer[4] = true;
                } else {
                    quiz9_site.setEnabled(true);
                    quiz9_site.setTextSize(30);
                    quiz9_site.setHint("");
                    if (form_answer[4] == null) {
                        form_answer[4] = null;
                    }
                    quiz9_site.setText(form_answer[4]);
                    isDisAnswer[4] = false;
                    isAnswer[4] = false;
                }
            }
        });

        disAnswer6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (disAnswer6.isChecked()) {
                    form_answer[5] = quiz9_city.getText().toString();
                    quiz9_city.setTextSize(15);
                    quiz9_city.setText("");
                    isDisAnswer[5] = true;
                    quiz9_city.setHint("受測者無法作答");
                    quiz9_city.setEnabled(false);
                    isAnswer[5] = true;
                } else {
                    quiz9_city.setEnabled(true);
                    quiz9_city.setTextSize(30);
                    quiz9_city.setHint("");
                    if (form_answer[5] == null) {
                        form_answer[5] = null;
                    }
                    quiz9_city.setText(form_answer[5]);
                    isDisAnswer[5] = false;
                    isAnswer[5] = false;
                }
            }
        });
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.moca_q9a_next:

                for (int i = 0; i < 6; i++) {
                    if (isDisAnswer[i] == false) {
                        if (i == 0) {
                            quiz9_answer[0] = quiz9_yeartype_spinner.getSelectedItem().toString();
                            quiz9_answer[1] = quiz9_year.getText().toString();
                            isAnswer[i]=true;
                        } else if (i == 1) {
                            quiz9_answer[2] = quiz9_month.getText().toString();
                            isAnswer[i]=true;
                        } else if (i == 2) {
                            quiz9_answer[3] = quiz9_date.getText().toString();
                            isAnswer[i]=true;
                        } else if (i == 3) {
                            quiz9_answer[4] = quiz9_day_spinner.getSelectedItem().toString();
                            isAnswer[i]=true;
                        } else if (i == 4) {
                            quiz9_answer[5] = quiz9_site.getText().toString();
                            isAnswer[i]=true;
                        } else if (i == 5) {
                            quiz9_answer[6] = quiz9_city.getText().toString();
                            isAnswer[i]=true;
                        }
                    }
                }

                for (int i = 0; i < 7; i++) {
                    if (i == 0||i==1) {
                        if (quiz9_answer[i]==null||quiz9_answer[i].equals("")){
                            isAnswer[0] = false;
                        }
                    }else {
                        if(i==4){
                            if(quiz9_answer[4].equals("")){
                                isAnswer[4]=false;
                            }
                        }
                        if(quiz9_answer[i]==null||quiz9_answer[i].equals("")){
                            isAnswer[i-1]=false;
                        }
                    }
                }




                //取得結束測驗時間
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                Calendar c = Calendar.getInstance();
                EndTime = df.format(c.getTime());

                int Q1A=0;
                if(bundle1.getBoolean("quiz1_answer")==true){
                    Q1A=1;
                }

                Bitmap bitmap1 = bundle1.getParcelable("quiz2_ask_bundle");
                // 1.先將 Bitmap 轉換成 byte[]
                ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
                bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, bos1);
                byte[] vByteArray1 = bos1.toByteArray();
                // 2.透過 byte[] 儲存到 blob 欄位
                String strImage1 = Base64.encodeToString(vByteArray1, Base64.DEFAULT);

                int Q2A=0;
                if(bundle1.getBoolean("quiz2_ask_answer")==true){
                    Q2A=1;
                }

                Bitmap bitmap2 = bundle1.getParcelable("quiz2_ask2_bundle");
                // 1.先將 Bitmap 轉換成 byte[]
                ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, bos2);
                byte[] vByteArray2 = bos2.toByteArray();
                // 2.透過 byte[] 儲存到 blob 欄位
                String strImage2 = Base64.encodeToString(vByteArray2, Base64.DEFAULT);

                int Q2A2[]={0,0,0};
                for(int i=0;i<Q2A2.length;i++){
                    if(bundle1.getBooleanArray("quiz2_ask2_answer")[i]==true){
                        Q2A2[i]=1;
                    }
                }

                int Q3A[]={0,0,0};
                for(int i=0;i<Q3A.length;i++){
                    if(bundle1.getBooleanArray("quiz3_answer")[i]==true){
                        Q3A[i]=1;
                    }
                }

                int Q4AF[]={0,0,0,0,0};
                for(int i=0;i<Q4AF.length;i++){
                    if (bundle1.getBooleanArray("quiz4_answer_first")[i] == true) {
                        Q4AF[i]=1;
                    }
                }

                int Q4AS[]={0,0,0,0,0};
                for(int i=0;i<Q4AS.length;i++){
                    if (bundle1.getBooleanArray("quiz4_answer_second")[i] == true) {
                        Q4AS[i]=1;
                    }
                }

                int Q5A1A1=0;
                if(bundle1.getBoolean("quiz5_ask1_answer1")==true){
                    Q5A1A1=1;
                }

                int Q5A1A2=0;
                if(bundle1.getBoolean("quiz5_ask1_answer2")==true){
                    Q5A1A2=1;
                }

                int Q5A1A3=0;
                if(bundle1.getBoolean("quiz5_ask1_answer3")==true){
                    Q5A1A3=1;
                }

                int Q5A2=0;
                if(bundle1.getInt("quiz5_ask2_isRight")==5){
                    Q5A2=1;
                }

                int Q6AQIR1[]={0,0};
                for(int i=0;i<Q6AQIR1.length;i++){
                    if(bundle1.getBooleanArray("quiz6_ask_quiz_isRight")[i]==true){
                        Q6AQIR1[i]=1;
                    }
                }

                int Q7A[]={0,0};
                for(int i=0;i<Q7A.length;i++){
                    if(bundle1.getBooleanArray("quiz7_answer")[i]==true){
                        Q7A[i]=1;
                    }
                }

                int Q8A[]={0,0,0,0,0};
                for(int i=0;i<Q8A.length;i++){
                    if(bundle1.getBooleanArray("quiz8_answer")[i]==true){
                        Q8A[i]=1;
                    }
                }

                int Q9IsA[]={0,0,0,0,0,0};
                for(int i=0;i<Q9IsA.length;i++){
                    if(isAnswer[i]==true){
                        Q9IsA[i]=1;
                    }
                }




                if(bundle1.getString("identity").equals("family")) {
                    HashMap postData = new HashMap();
                    postData.put("testID", bundle1.getString("testID"));       //StringBuffer to String
                    postData.put("FAccount", bundle1.getString("account"));
                    postData.put("EndTime", EndTime);


                    postData.put("quiz1_answer", toString().valueOf(Q1A));
                    postData.put("quiz1_score", toString().valueOf(quiz1_score()));
                    postData.put("quiz2_ask_bundle", strImage1);
                    postData.put("quiz2_ask_answer", toString().valueOf(Q2A));
                    postData.put("quiz2_ask2_bundle", strImage2);
                    postData.put("quiz2_ask2_answer1", toString().valueOf(Q2A2[0]));
                    postData.put("quiz2_ask2_answer2", toString().valueOf(Q2A2[1]));
                    postData.put("quiz2_ask2_answer3", toString().valueOf(Q2A2[2]));
                    postData.put("quiz2_score", toString().valueOf(quiz2_score()));

                    postData.put("quiz3_answer1", toString().valueOf(Q3A[0]));
                    postData.put("quiz3_answer2", toString().valueOf(Q3A[1]));
                    postData.put("quiz3_answer3", toString().valueOf(Q3A[2]));
                    postData.put("quiz3_score", toString().valueOf(quiz3_score()));
                    postData.put("quiz4_answer_first1",toString().valueOf(Q4AF[0]));
                    postData.put("quiz4_answer_first2",toString().valueOf(Q4AF[1]));
                    postData.put("quiz4_answer_first3",toString().valueOf(Q4AF[2]));
                    postData.put("quiz4_answer_first4",toString().valueOf(Q4AF[3]));
                    postData.put("quiz4_answer_first5",toString().valueOf(Q4AF[4]));
                    postData.put("quiz4_answer_second1",toString().valueOf(Q4AS[0]));
                    postData.put("quiz4_answer_second2",toString().valueOf(Q4AS[1]));
                    postData.put("quiz4_answer_second3",toString().valueOf(Q4AS[2]));
                    postData.put("quiz4_answer_second4",toString().valueOf(Q4AS[3]));
                    postData.put("quiz4_answer_second5",toString().valueOf(Q4AS[4]));
                    postData.put("quiz4_word_bundle1", bundle1.getStringArray("quiz4_word_bundle")[0]);
                    postData.put("quiz4_word_bundle2", bundle1.getStringArray("quiz4_word_bundle")[1]);
                    postData.put("quiz4_word_bundle3", bundle1.getStringArray("quiz4_word_bundle")[2]);
                    postData.put("quiz4_word_bundle4", bundle1.getStringArray("quiz4_word_bundle")[3]);
                    postData.put("quiz4_word_bundle5", bundle1.getStringArray("quiz4_word_bundle")[4]);
                    postData.put("quiz4_score", toString().valueOf(quiz4_score()));
                    postData.put("quiz5_ask1_answer1", toString().valueOf(Q5A1A1));
                    postData.put("quiz5_ask1_answer2", toString().valueOf(Q5A1A2));
                    postData.put("quiz5_ask1_answer3", toString().valueOf(Q5A1A3));
                    postData.put("quiz5_ask2_answer1", bundle1.getStringArray("quiz5_ask2_answer")[0]);
                    postData.put("quiz5_ask2_answer2", bundle1.getStringArray("quiz5_ask2_answer")[1]);
                    postData.put("quiz5_ask2_answer3", bundle1.getStringArray("quiz5_ask2_answer")[2]);
                    postData.put("quiz5_ask2_answer4", bundle1.getStringArray("quiz5_ask2_answer")[3]);
                    postData.put("quiz5_ask2_answer5", bundle1.getStringArray("quiz5_ask2_answer")[4]);
                    postData.put("quiz5_ask2_isRight", toString().valueOf(Q5A2));
                    postData.put("quiz5_score", toString().valueOf(quiz5_score()));
                    postData.put("quiz6_ask_quiz_isRight1", toString().valueOf(Q6AQIR1[0]));
                    postData.put("quiz6_ask_quiz_isRight2", toString().valueOf(Q6AQIR1[1]));
                    postData.put("quiz6_ask2_answer", toString().valueOf(bundle1.getInt("quiz6_ask2_answer")));
                    postData.put("quiz6_score", toString().valueOf(quiz6_score()));
                    postData.put("quiz7_answer1", toString().valueOf(Q7A[0]));
                    postData.put("quiz7_answer2", toString().valueOf(Q7A[1]));
                    postData.put("quiz7_score", toString().valueOf(quiz7_score()));
                    postData.put("quiz8_answer1", toString().valueOf(Q8A[0]));
                    postData.put("quiz8_answer2", toString().valueOf(Q8A[1]));
                    postData.put("quiz8_answer3", toString().valueOf(Q8A[2]));
                    postData.put("quiz8_answer4", toString().valueOf(Q8A[3]));
                    postData.put("quiz8_answer5", toString().valueOf(Q8A[4]));
                    postData.put("quiz8_score", toString().valueOf(quiz8_score()));
                    postData.put("quiz9_answer1", quiz9_answer[0]);
                    postData.put("quiz9_answer2", quiz9_answer[1]);
                    postData.put("quiz9_answer3", quiz9_answer[2]);
                    postData.put("quiz9_answer4", quiz9_answer[3]);
                    postData.put("quiz9_answer5", quiz9_answer[4]);
                    postData.put("quiz9_answer6", quiz9_answer[5]);
                    postData.put("quiz9_answer7", quiz9_answer[6]);
                    postData.put("quiz9_isAnswer1",toString().valueOf(Q9IsA[0]));
                    postData.put("quiz9_isAnswer2",toString().valueOf(Q9IsA[1]));
                    postData.put("quiz9_isAnswer3",toString().valueOf(Q9IsA[2]));
                    postData.put("quiz9_isAnswer4",toString().valueOf(Q9IsA[3]));
                    postData.put("quiz9_isAnswer5",toString().valueOf(Q9IsA[4]));
                    postData.put("quiz9_isAnswer6",toString().valueOf(Q9IsA[5]));
                    postData.put("quiz9_score", toString().valueOf(quiz9_score()));
                    postData.put("MOCA_total_score", toString().valueOf(quiz1_score() + quiz2_score() + quiz3_score() + quiz4_score() + quiz5_score() + quiz6_score() + quiz7_score() + quiz8_score() + quiz9_score()));

                    PostResponseAsyncTask task = new PostResponseAsyncTask(moca_quiz9_ask.this, postData);
                    task.execute("http://ej30827.000webhostapp.com/MOCA.php");
                    break;
                }
                else if(bundle1.getString("identity").equals("guest")) {
                    //建立SQLiteOpenHelper 物件
                    dbHelper = new MyDBHelper(moca_quiz9_ask.this);
                    db = dbHelper.getWritableDatabase();//開啟資料庫
                    ContentValues cv = new ContentValues();
                    cv.put("_id", bundle1.getString("testID"));
                    cv.put("quiz1_answer", toString().valueOf(Q1A));
                    cv.put("quiz1_score", toString().valueOf(quiz1_score()));

                    cv.put("quiz2_ask_bundle", strImage1);
                    cv.put("quiz2_ask_answer", toString().valueOf(Q2A));
                    cv.put("quiz2_ask2_bundle", strImage2);
                    cv.put("quiz2_ask2_answer1", toString().valueOf(Q2A2[0]));
                    cv.put("quiz2_ask2_answer2", toString().valueOf(Q2A2[1]));
                    cv.put("quiz2_ask2_answer3", toString().valueOf(Q2A2[2]));
                    cv.put("quiz2_score", toString().valueOf(quiz2_score()));

                    cv.put("quiz3_answer1", toString().valueOf(Q3A[0]));
                    cv.put("quiz3_answer2", toString().valueOf(Q3A[1]));
                    cv.put("quiz3_answer3", toString().valueOf(Q3A[2]));
                    cv.put("quiz3_score", toString().valueOf(quiz3_score()));

                    cv.put("quiz4_answer_first1",toString().valueOf(Q4AF[0]));
                    cv.put("quiz4_answer_first2",toString().valueOf(Q4AF[1]));
                    cv.put("quiz4_answer_first3",toString().valueOf(Q4AF[2]));
                    cv.put("quiz4_answer_first4",toString().valueOf(Q4AF[3]));
                    cv.put("quiz4_answer_first5",toString().valueOf(Q4AF[4]));
                    cv.put("quiz4_answer_second1",toString().valueOf(Q4AS[0]));
                    cv.put("quiz4_answer_second2",toString().valueOf(Q4AS[1]));
                    cv.put("quiz4_answer_second3",toString().valueOf(Q4AS[2]));
                    cv.put("quiz4_answer_second4",toString().valueOf(Q4AS[3]));
                    cv.put("quiz4_answer_second5",toString().valueOf(Q4AS[4]));
                    cv.put("quiz4_word_bundle1", bundle1.getStringArray("quiz4_word_bundle")[0]);
                    cv.put("quiz4_word_bundle2", bundle1.getStringArray("quiz4_word_bundle")[1]);
                    cv.put("quiz4_word_bundle3", bundle1.getStringArray("quiz4_word_bundle")[2]);
                    cv.put("quiz4_word_bundle4", bundle1.getStringArray("quiz4_word_bundle")[3]);
                    cv.put("quiz4_word_bundle5", bundle1.getStringArray("quiz4_word_bundle")[4]);
                    cv.put("quiz4_score", toString().valueOf(quiz4_score()));

                    cv.put("quiz5_ask1_answer1", toString().valueOf(Q5A1A1));
                    cv.put("quiz5_ask1_answer2", toString().valueOf(Q5A1A2));
                    cv.put("quiz5_ask1_answer3", toString().valueOf(Q5A1A3));
                    cv.put("quiz5_ask2_answer1", bundle1.getStringArray("quiz5_ask2_answer")[0]);
                    cv.put("quiz5_ask2_answer2", bundle1.getStringArray("quiz5_ask2_answer")[1]);
                    cv.put("quiz5_ask2_answer3", bundle1.getStringArray("quiz5_ask2_answer")[2]);
                    cv.put("quiz5_ask2_answer4", bundle1.getStringArray("quiz5_ask2_answer")[3]);
                    cv.put("quiz5_ask2_answer5", bundle1.getStringArray("quiz5_ask2_answer")[4]);
                    cv.put("quiz5_ask2_isRight", toString().valueOf(bundle1.getInt("quiz5_ask2_isRight")));
                    cv.put("quiz5_score", toString().valueOf(quiz5_score()));

                    cv.put("quiz6_ask_quiz_isRight1", toString().valueOf(Q6AQIR1[0]));
                    cv.put("quiz6_ask_quiz_isRight2", toString().valueOf(Q6AQIR1[1]));
                    cv.put("quiz6_ask2_answer", toString().valueOf(bundle1.getInt("quiz6_ask2_answer")));
                    cv.put("quiz6_score", toString().valueOf(quiz6_score()));

                    cv.put("quiz7_answer1", toString().valueOf(Q7A[0]));
                    cv.put("quiz7_answer2", toString().valueOf(Q7A[1]));


                    cv.put("quiz8_answer1", toString().valueOf(Q8A[0]));
                    cv.put("quiz8_answer2", toString().valueOf(Q8A[1]));
                    cv.put("quiz8_answer3", toString().valueOf(Q8A[2]));
                    cv.put("quiz8_answer4", toString().valueOf(Q8A[3]));
                    cv.put("quiz8_answer5", toString().valueOf(Q8A[4]));
                    cv.put("quiz8_score", toString().valueOf(quiz8_score()));

                    cv.put("quiz9_answer1", quiz9_answer[0]);
                    cv.put("quiz9_answer2", quiz9_answer[1]);
                    cv.put("quiz9_answer3", quiz9_answer[2]);
                    cv.put("quiz9_answer4", quiz9_answer[3]);
                    cv.put("quiz9_answer5", quiz9_answer[4]);
                    cv.put("quiz9_answer6", quiz9_answer[5]);
                    cv.put("quiz9_answer7", quiz9_answer[6]);
                    cv.put("quiz9_isAnswer1",toString().valueOf(Q9IsA[0]));
                    cv.put("quiz9_isAnswer2",toString().valueOf(Q9IsA[1]));
                    cv.put("quiz9_isAnswer3",toString().valueOf(Q9IsA[2]));
                    cv.put("quiz9_isAnswer4",toString().valueOf(Q9IsA[3]));
                    cv.put("quiz9_isAnswer5",toString().valueOf(Q9IsA[4]));
                    cv.put("quiz9_isAnswer6",toString().valueOf(Q9IsA[5]));
                    cv.put("quiz9_score", toString().valueOf(quiz9_score()));
                    cv.put("MOCA_total_score", toString().valueOf(quiz1_score() + quiz2_score() + quiz3_score() + quiz4_score() + quiz5_score() + quiz6_score() + quiz7_score() + quiz8_score() + quiz9_score()));


                    long mocaNumber =db.insert("moca",null,cv);//新增MOCA
                    ContentValues test =new ContentValues();
                    test.put("end_test_time",EndTime);
                    int count=db.update("test",test,"_id='"+bundle1.getString("testID")+"' ",null);
                    Toast.makeText(moca_quiz9_ask.this, "量表編號："+bundle1.getString("testID"), Toast.LENGTH_SHORT).show();
                    //"test-count :"+count+"mmseNumber: "+toString().valueOf(mmseNumber)
                    startActivity(new Intent(moca_quiz9_ask.this,visitor_function.class));
                    moca_quiz9_ask.this.finish();
                }

        }
    }

    public int quiz1_score() {
        int score=0;
        if((bundle1.getBoolean("quiz1_answer"))==true){
            score=1;
        }
        return score;
    }
    public int quiz2_score() {
        int score=0;
        if((bundle1.getBoolean("quiz2_ask_answer"))==true){
            score=score+1;
        }
        for(int i=0;i<( bundle1.getBooleanArray("quiz2_ask2_answer").length);i++){
            if((bundle1.getBooleanArray("quiz2_ask2_answer"))[i]==true){
                score=score+1;
            }
        }
        return score;
    }
    public int quiz3_score() {
        int score=0;
        for(int i=0;i<( bundle1.getBooleanArray("quiz3_answer").length);i++){
            if((bundle1.getBooleanArray("quiz3_answer"))[i]==true){
                score=score+1;
            }
        }
        return score;
    }
    public int quiz4_score() {
        //不計分
        return 0;
    }
    public int quiz5_score() {
        int score=0;
        int quiz5_ask2_isright=bundle1.getInt("quiz5_ask2_isRight");
        if((bundle1.getBoolean("quiz5_ask1_answer1"))==true){
            score=score+1;
        }
        if((bundle1.getBoolean("quiz5_ask1_answer2"))==true){
            score=score+1;
        }

        if((bundle1.getBoolean("quiz5_ask1_answer3"))==true){
            score=score+1;
        }

        if(quiz5_ask2_isright>=4){
            score=score+3;
        }else if(quiz5_ask2_isright==2||quiz5_ask2_isright==3){
            score=score+2;
        }else if(quiz5_ask2_isright==1){
            score=score+1;
        }

        return score;
    }
    public int quiz6_score() {
        int score=0;
        for(int i=0;i<( bundle1.getBooleanArray("quiz6_ask_quiz_isRight").length);i++){
            if((bundle1.getBooleanArray("quiz6_ask_quiz_isRight"))[i]==true){
                score=score+1;
            }
        }

        if(bundle1.getInt("quiz6_ask2_answer")>11){
            score=score+1;
        }
        return score;
    }
    public int quiz7_score() {
        int score=0;
        for(int i=0;i<(bundle1.getBooleanArray("quiz7_answer").length);i++){
            if((bundle1.getBooleanArray("quiz7_answer"))[i]==true){
                score=score+1;
            }
        }

        return score;
    }
    public int quiz8_score() {
        int score=0;

        for(int i=0;i<(bundle1.getBooleanArray("quiz8_answer").length);i++){
            if((bundle1.getBooleanArray("quiz8_answer"))[i]==true){
                score=score+1;
            }
        }
        return score;
    }
    public int quiz9_score() {
        int score=0;

        for(int i=0;i<(isAnswer.length);i++){
            if(isAnswer[i]==true){
                score=score+1;
            }
        }
        return score;
    }


    @Override
    public void processFinish(String result) {
        if(result.equals("success")){
            Toast.makeText(this,"提交成功!", Toast.LENGTH_LONG).show();
            //取得上個頁面的傳值
            final Bundle ANTestID =  this.getIntent().getExtras();
            Intent in=null;
            Bundle bundle = new Bundle();
            if(ANTestID.getString("identity").equals("family")) {
                //new一個intent物件，並指定Activity切換的class
                in = new Intent(moca_quiz9_ask.this, family_function.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                bundle.putString("name", ANTestID.getString("name"));
                bundle.putString("account", ANTestID.getString("account"));
                //將Bundle物件assign給intent
            }
            else if(ANTestID.getString("identity").equals("guest")){
                in = new Intent(moca_quiz9_ask.this, visitor_function.class);
            }
            in.putExtras(bundle);
            startActivity(in);
            moca_quiz9_ask.this.finish();
        }
        else {
            Toast.makeText(this,"錯誤！"+result, Toast.LENGTH_LONG).show();
            Log.v("error:",result);
        }
    }
}
