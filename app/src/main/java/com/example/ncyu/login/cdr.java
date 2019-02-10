package com.example.ncyu.login;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class cdr extends AppCompatActivity implements AsyncResponse {

    EditText score1, score2, score3, score4, score5, score6, totalScore;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btnCommit,btnScore;
    String EndTime;


    private SQLiteDatabase db;
    private MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdr);

        score1 = (EditText)findViewById(R.id.editText);     //記憶力
        score2 = (EditText)findViewById(R.id.editText2);    //定向力
        score3 = (EditText)findViewById(R.id.editText3);    //判斷力與問題解決能力
        score4 = (EditText)findViewById(R.id.editText4);    //在家以外的活動
        score5 = (EditText)findViewById(R.id.editText5);    //家庭活動&嗜好
        score6 = (EditText)findViewById(R.id.editText6);    //自我照顧
        totalScore = (EditText)findViewById(R.id.editText7);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btnCommit = (Button) findViewById(R.id.btnCommit);
        btnScore = (Button) findViewById(R.id.btnScore);

        //取得上個頁面的傳值
        final Bundle ANTestID =  this.getIntent().getExtras();

        btnScore.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if((score1.getText().toString()).equals("") || (score2.getText().toString()).equals("") || (score3.getText().toString()).equals("") || (score4.getText().toString()).equals("") || (score5.toString()).equals("") || (score6.toString()).equals("")){
                    Toast.makeText(cdr.this, "尚有分數未輸入!!請確認是否每一格皆有輸入。(包含總分)", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean scoreRight=true; //各項能力分數輸入是否正確，預設為true

                    //若有輸入錯誤
                    if(!score1.getText().toString().equals("0") && !score1.getText().toString().equals("0.5") && !score1.getText().toString().equals("1") && !score1.getText().toString().equals("2") && !score1.getText().toString().equals("3")||
                            !score2.getText().toString().equals("0") && !score2.getText().toString().equals("0.5") && !score2.getText().toString().equals("1") && !score2.getText().toString().equals("2") && !score2.getText().toString().equals("3")||
                            !score3.getText().toString().equals("0") && !score3.getText().toString().equals("0.5") && !score3.getText().toString().equals("1") && !score3.getText().toString().equals("2") && !score3.getText().toString().equals("3")||
                            !score4.getText().toString().equals("0") && !score4.getText().toString().equals("0.5") && !score4.getText().toString().equals("1") && !score4.getText().toString().equals("2") && !score4.getText().toString().equals("3")||
                            !score5.getText().toString().equals("0") && !score5.getText().toString().equals("0.5") && !score5.getText().toString().equals("1") && !score5.getText().toString().equals("2") && !score5.getText().toString().equals("3")||
                            !score6.getText().toString().equals("0") && !score6.getText().toString().equals("0.5") && !score6.getText().toString().equals("1") && !score6.getText().toString().equals("2") && !score6.getText().toString().equals("3"))
                    {
                        scoreRight=false;
                        Toast.makeText(cdr.this, "輸入錯誤的分數！", Toast.LENGTH_SHORT).show();
                    }

                    //若分數輸入正確才計算CDR分數
                    if(scoreRight) {
                        int flag = 0;

                        final double M = Double.parseDouble(score1.getText().toString());
                        final double O = Double.parseDouble(score2.getText().toString());
                        final double JPS = Double.parseDouble(score3.getText().toString());
                        final double CA = Double.parseDouble(score4.getText().toString());
                        final double HF = Double.parseDouble(score5.getText().toString());
                        final double PC = Double.parseDouble(score6.getText().toString());


                        //-----------------------------------一般評分方式--------------------------------------------------------------------------
                        int equalM = 0;

                        if (O == M) equalM++;
                        if (JPS == M) equalM++;
                        if (CA == M) equalM++;
                        if (HF == M) equalM++;
                        if (PC == M) equalM++;

                        if (equalM >= 3) {
                            //有3個或以上的次要分數等於主要分數
                            Toast.makeText(cdr.this, "建議總分同記憶力之分數", Toast.LENGTH_SHORT).show();
                            totalScore.setText(score1.getText().toString());
                            flag++;
                        } else {
                            int bigerM = 0, smallerM = 0;

                            if (O > M) bigerM++;
                            if (JPS > M) bigerM++;
                            if (CA > M) bigerM++;
                            if (HF > M) bigerM++;
                            if (PC > M) bigerM++;

                            if (O < M) smallerM++;
                            if (JPS < M) smallerM++;
                            if (CA < M) smallerM++;
                            if (HF < M) smallerM++;
                            if (PC < M) smallerM++;

                            if ((bigerM == 3 && smallerM == 2) || (bigerM == 2 && smallerM == 3)) {
                                //有3個次要分數在M的一邊，而2個次要分數在M的另一邊
                                Toast.makeText(cdr.this, "建議總分同記憶力之分數", Toast.LENGTH_SHORT).show();
                                totalScore.setText(score1.getText().toString());
                                flag++;
                            } else {
                                int zero = 0, zero_five = 0, one = 0, two = 0, three = 0;

                                if (O == 0) zero++;
                                if (JPS == 0) zero++;
                                if (CA == 0) zero++;
                                if (HF == 0) zero++;
                                if (PC == 0) zero++;

                                if (O == 0.5) zero_five++;
                                if (JPS == 0.5) zero_five++;
                                if (CA == 0.5) zero_five++;
                                if (HF == 0.5) zero_five++;
                                if (PC == 0.5) zero_five++;

                                if (O == 1) one++;
                                if (JPS == 1) one++;
                                if (CA == 1) one++;
                                if (HF == 1) one++;
                                if (PC == 1) one++;

                                if (O == 2) two++;
                                if (JPS == 2) two++;
                                if (CA == 2) two++;
                                if (HF == 2) two++;
                                if (PC == 2) two++;

                                if (O == 3) three++;
                                if (JPS == 3) three++;
                                if (CA == 3) three++;
                                if (HF == 3) three++;
                                if (PC == 3) three++;

                                if (zero >= 3) {
                                    Toast.makeText(cdr.this, "建議總分等同過半數分數所在", Toast.LENGTH_SHORT).show();
                                    totalScore.setText("0");
                                    flag++;
                                } else if (zero_five >= 3) {
                                    Toast.makeText(cdr.this, "建議總分等同過半數分數所在", Toast.LENGTH_SHORT).show();
                                    totalScore.setText("0.5");
                                    flag++;
                                } else if (one >= 3) {
                                    Toast.makeText(cdr.this, "建議總分等同過半數分數所在", Toast.LENGTH_SHORT).show();
                                    totalScore.setText("1");
                                    flag++;
                                } else if (two >= 3) {
                                    Toast.makeText(cdr.this, "建議總分等同過半數分數所在", Toast.LENGTH_SHORT).show();
                                    totalScore.setText("2");
                                    flag++;
                                } else if (three >= 3) {
                                    Toast.makeText(cdr.this, "建議總分等同過半數分數所在", Toast.LENGTH_SHORT).show();
                                    totalScore.setText("3");
                                    flag++;
                                } else {
                                    //CDR=最近M的分數
                                    Toast.makeText(cdr.this, "建議總分同記憶力之分數", Toast.LENGTH_SHORT).show();
                                    totalScore.setText(score1.getText().toString());
                                    flag++;
                                }
                            }
                        }

                        //--------------------------------以下是特殊案例--------------------------------------------------------------------------

                        if (M == 0) {
                            //2個或以上次要分數大於0
                            int k = 0;

                            if (O > 0) k++;
                            if (JPS > 0) k++;
                            if (CA > 0) k++;
                            if (HF > 0) k++;
                            if (PC > 0) k++;

                            if (k >= 2) {
                                Toast.makeText(cdr.this, "建議總分為：0.5", Toast.LENGTH_SHORT).show();
                                totalScore.setText("0.5");
                                flag++;
                            }
                        } else if (M > 0) {

                            if (M == 0.5) {
                                //3個或以上次要分數大於等於1
                                int bigerOrEqual1 = 0;

                                if (O >= 1) bigerOrEqual1++;
                                if (JPS >= 1) bigerOrEqual1++;
                                if (CA >= 1) bigerOrEqual1++;
                                if (HF >= 1) bigerOrEqual1++;
                                if (PC >= 1) bigerOrEqual1++;

                                if (bigerOrEqual1 >= 3) {
                                    Toast.makeText(cdr.this, "建議總分為：1", Toast.LENGTH_SHORT).show();
                                    totalScore.setText("1");
                                    flag++;
                                }
                            }

                            //尚未打分數
                            if (flag == 0) {
                                // 過半數分數等於0
                                int k = 0;

                                if (O == 0) k++;
                                if (JPS == 0) k++;
                                if (CA == 0) k++;
                                if (HF == 0) k++;
                                if (PC == 0) k++;

                                if (k >= 3) {
                                    Toast.makeText(cdr.this, "建議總分同記憶力之分數", Toast.LENGTH_SHORT).show();
                                    totalScore.setText(score1.getText().toString());
                                    flag++;
                                }
                            }

                            //尚未打分數
                            if (flag == 0) {
                                //2個次要分數大於M，2個小於M，1個等於M
                                int k = 0, j = 0, m = 0;

                                if (O > M) k++;
                                if (JPS > M) k++;
                                if (CA > M) k++;
                                if (HF > M) k++;
                                if (PC > M) k++;

                                if (O < M) j++;
                                if (JPS < M) j++;
                                if (CA < M) j++;
                                if (HF < M) j++;
                                if (PC < M) j++;

                                if (O == M) m++;
                                if (JPS == M) m++;
                                if (CA == M) m++;
                                if (HF == M) m++;
                                if (PC == M) m++;

                                if (k == 2 && j == 2 && m == 1) {
                                    Toast.makeText(cdr.this, "建議總分同記憶力之分數", Toast.LENGTH_SHORT).show();
                                    totalScore.setText(score1.getText().toString());
                                    flag++;
                                }
                            }
                        }

                        if (flag == 0) {
                            Toast.makeText(cdr.this, "病患之CDR分數可能為4或5，請您參考上方圖片說明並在總分的欄位輸入分數。", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        btnCommit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if((score1.getText().toString()).equals("") || (score2.getText().toString()).equals("") || (score3.getText().toString()).equals("") || (score4.getText().toString()).equals("") || (score5.toString()).equals("") || (score6.toString()).equals("") || (totalScore.getText().toString()).equals("")){
                    Toast.makeText(cdr.this, "尚有分數未輸入!!請確認是否每一格皆有輸入。(包含總分)", Toast.LENGTH_SHORT).show();
                }else {
                    //取得結束測驗時間
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                    Calendar c = Calendar.getInstance();
                    EndTime = df.format(c.getTime());
                    if(ANTestID.getString("identity").equals("family")) {
                        HashMap postData = new HashMap();

//                        String test=ANTestID.getString("testID");  //經過php回傳的testID前面會有一個"在上方的'.' "位於字串首 ex: .168
//                        StringBuffer sb = new StringBuffer(test);
//                        sb.deleteCharAt(0);                        //刪除字串首的字元

                        postData.put("testID", ANTestID.getString("testID"));
                        postData.put("FAccount", ANTestID.getString("account"));
                        postData.put("EndTime", EndTime);
                        postData.put("score1", score1.getText().toString());
                        postData.put("score2", score2.getText().toString());
                        postData.put("score3", score3.getText().toString());
                        postData.put("score4", score4.getText().toString());
                        postData.put("score5", score5.getText().toString());
                        postData.put("score6", score6.getText().toString());
                        postData.put("totalScore", totalScore.getText().toString());
                        PostResponseAsyncTask task = new PostResponseAsyncTask(cdr.this, postData, cdr.this);
                        task.execute("http://ej30827.000webhostapp.com/CDR.php");
                    }
                    else if(ANTestID.getString("identity").equals("guest")){
                        //建立SQLiteOpenHelper 物件
                        dbHelper = new MyDBHelper(cdr.this);
                        db = dbHelper.getWritableDatabase();//開啟資料庫
                        ContentValues cv =new ContentValues();
                        cv.put("_id",ANTestID.getString("testID"));
                        cv.put("memory", score1.getText().toString());
                        cv.put("orientation", score2.getText().toString());
                        cv.put("problem_solving_ability", score3.getText().toString());
                        cv.put("community_activity", score4.getText().toString());
                        cv.put("home_hobby", score5.getText().toString());
                        cv.put("self_care", score6.getText().toString());
                        cv.put("CDR_total_score", totalScore.getText().toString());
                        long cdrNumber =db.insert("cdr",null,cv);//新增AD8

                        ContentValues test =new ContentValues();
                        test.put("end_test_time",EndTime);
                        int count=db.update("test",test,"_id='"+ANTestID.getString("testID")+"' ",null);
                        Toast.makeText(cdr.this, "量表編號："+ANTestID.getString("testID"), Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(cdr.this,visitor_function.class));
                        cdr.this.finish();
                    }
                }
            }
        });



        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final AlertDialog.Builder builder1 = new AlertDialog.Builder(cdr.this);
                builder1.setTitle("記憶力評估標準");
                builder1.setMessage("0: 未喪失記憶力，或稍有前後不一致的健忘\n" +
                        "0.5: 持續性輕度健忘，事情只能部分記得；〝良性〞健忘\n" +
                        "1: 中度記憶力喪失；尤其是最近的事件；記憶不佳而影響日常活動\n" +
                        "2: 嚴重記憶力喪失，只記得高度重複學過的事物\n" +
                        "3: 嚴重記憶力喪失，只能記得片段事物");
                builder1.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                AlertDialog dialog = builder1.create();
                dialog.show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final AlertDialog.Builder builder2 = new AlertDialog.Builder(cdr.this);
                builder2.setTitle("定向力評估標準");
                builder2.setMessage("0: 有完整定位感\n" +
                        "0.5: 有完整定位感，但涉及時間順序關連時，稍稍有困難\n" +
                        "1: 涉及時間順序關連時，有中度困難； 測驗時對地點有定位感；但在別處可能對地理失去定位能力\n" +
                        "2: 涉及時間順序關連時，有嚴重困難；經常對時間失去定位能力，且往往對地點失去定位感\n" +
                        "3: 只認得自己");
                builder2.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                AlertDialog dialog = builder2.create();
                dialog.show();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final AlertDialog.Builder builder3 = new AlertDialog.Builder(cdr.this);
                builder3.setTitle("判斷力與問題解決能力評估標準");
                builder3.setMessage("0: 能良好解決日常問題與處理好商業及財務問題；對於過去表現的判斷力佳\n" +
                        "0.5: 在解決問題、及相似性和差異性的問題上有些許障礙\n" +
                        "1: 在處理問題、及相似性和差異性的問題上有中度困難；但通常還能維持社會價值的判斷力\n" +
                        "2: 在處理問題、及相似性和差異性的問題上有嚴重困難；社會價值的判斷力通常有障礙\n" +
                        "3: 無法做出判斷或解決問題");
                builder3.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                AlertDialog dialog = builder3.create();
                dialog.show();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final AlertDialog.Builder builder4 = new AlertDialog.Builder(cdr.this);
                builder4.setTitle("在家裡以外的活動評估標準");
                builder4.setMessage("0: 在工作、購物、參與義工和社團組織上皆能獨立進行，並有一般水準\n" +
                        "0.5: 在這些活動上有輕微的障礙\n" +
                        "1: 雖然仍能持續某些活動，但沒有獨立進行的能力；乍看之下還算正常\n" +
                        "2: 在家以外沒有獨立的能力;外表看起來好到可以從事家以外的活動\n" +
                        "3: 在家以外沒有獨立的能力;外表看起來差到無法從事家以外的活動");
                builder4.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                AlertDialog dialog = builder4.create();
                dialog.show();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final AlertDialog.Builder builder5 = new AlertDialog.Builder(cdr.this);
                builder5.setTitle("家庭活動及嗜好評估標準");
                builder5.setMessage("0: 在工作、購物、參與義工和社團組織上皆能獨立進行，並有一般水準\n" +
                        "0.5: 在這些活動上有輕微的障礙\n" +
                        "1: 雖然仍能持續某些活動，但沒有獨立進行的能力；乍看之下還算正常\n" +
                        "2: 在家以外沒有獨立的能力;外表看起來好到可以從事家以外的活動\n" +
                        "3: 在家以外沒有獨立的能力;外表看起來差到無法從事家以外的活動");
                builder5.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                AlertDialog dialog = builder5.create();
                dialog.show();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final AlertDialog.Builder builder6 = new AlertDialog.Builder(cdr.this);
                builder6.setTitle("自我照顧能力評估標準");
                builder6.setMessage("0: 具備能完整自我照顧的能力\n" +
                        "0.5: 具備能完整自我照顧的能力\n" +
                        "1: 需旁人的提醒\n" +
                        "2: 在穿衣、衛生及維護個人物品需要協助\n" +
                        "3: 在自我照顧時需要很多協助；時常失禁");
                builder6.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                AlertDialog dialog = builder6.create();
                dialog.show();
            }
        });
    }

    @Override
    public void processFinish(String s) {
        //8="success".length()+1
        if(s.equals("success")){
            Toast.makeText(this, "提交成功!!", Toast.LENGTH_LONG).show();
            //取得上個頁面的傳值
            final Bundle ANTestID =  this.getIntent().getExtras();
            //new一個intent物件，並指定Activity切換的class
            Intent in = new Intent(cdr.this, family_function.class);
            //new一個Bundle物件，並將要傳遞的資料傳入
            Bundle bundle = new Bundle();
            bundle.putString("name", ANTestID.getString("name"));
            bundle.putString("account", ANTestID.getString("account"));
            //將Bundle物件assign給intent
            in.putExtras(bundle);
            startActivity(in);
            cdr.this.finish();
        }
        else {
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }
    }
}
