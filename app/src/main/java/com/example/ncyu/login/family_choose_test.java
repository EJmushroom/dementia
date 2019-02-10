package com.example.ncyu.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mListView.CustomAdapter;
import com.example.ncyu.login.mMySQL.Downloader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class family_choose_test extends AppCompatActivity {

    String urlAddress="http://ej30827.000webhostapp.com/scale_select.php";
    String php_ad8="http://ej30827.000webhostapp.com/test_Insert.php";
    ListView lv_family_test;
    Button btn_family_start,btn_family_cancel;
    int whichScale = -1;
    String StartTime;
    String testID;

    private SQLiteDatabase db;
    private MyDBHelper dbHelper;

    boolean skipMessage;
    AlertDialog.Builder alert;
    public CheckBox dontShowAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_choose_test);

        lv_family_test=(ListView)findViewById(R.id.lv_family_test);
        btn_family_start=(Button)findViewById(R.id.btn_family_start);
        btn_family_cancel=(Button)findViewById(R.id.btn_family_cancel);

        final Bundle name_account = this.getIntent().getExtras();

        Downloader d=new Downloader(family_choose_test.this,urlAddress,lv_family_test);
        d.execute();

        //修復android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // 宣告對話框
        CKDiagbox();

        // 如果沒有勾選"不再顯示",則顯示對話框 !isCheckboxStateEnabled()
        if (!isCheckboxStateEnabled()) {
            alert.show();
        }





        //按下開始測驗後
        btn_family_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomAdapter scaleID=new CustomAdapter();
                whichScale=scaleID.getI() + 1;

                //取得開始測驗時間
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                Calendar c = Calendar.getInstance();
                StartTime = df.format(c.getTime());

                if (whichScale == 1) {
                    //新增資料到test資料表
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/test_Insert.php");
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("FAccount",name_account.getString("account")));
                    nameValuePairs.add(new BasicNameValuePair("ScaleID","1"));
                    nameValuePairs.add(new BasicNameValuePair("StartTime",StartTime));
                    try {
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        if (response != null) {
                            HttpEntity entity = response.getEntity();
                            testID = EntityUtils.toString(entity);
                            Toast.makeText(family_choose_test.this,"量表編號："+testID, Toast.LENGTH_SHORT).show();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //new一個intent物件，並指定Activity切換的class
                    Intent in=new Intent(family_choose_test.this,ad8.class);
                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();
                    bundle.putString("identity","family");
                    bundle.putString("name",name_account.getString("name"));
                    bundle.putString("account",name_account.getString("account"));
                    bundle.putString("testID",testID);
                    //將Bundle物件assign給intent
                    in.putExtras(bundle);
                    startActivity(in);

                    //歸零
                    scaleID.setI(-1);
                    family_choose_test.this.finish();
                }
                else if (whichScale == 2) {
                    //新增資料到test資料表
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/test_Insert.php");
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("FAccount",name_account.getString("account")));
                    nameValuePairs.add(new BasicNameValuePair("ScaleID","2"));
                    nameValuePairs.add(new BasicNameValuePair("StartTime",StartTime));
                    try {
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        if (response != null) {
                            HttpEntity entity = response.getEntity();
                            testID = EntityUtils.toString(entity);
                            Toast.makeText(family_choose_test.this,"量表編號："+testID, Toast.LENGTH_SHORT).show();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //new一個intent物件，並指定Activity切換的class
                    Intent in=new Intent(family_choose_test.this,cdr.class);
                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();
                    bundle.putString("identity","family");
                    bundle.putString("name",name_account.getString("name"));
                    bundle.putString("account",name_account.getString("account"));
                    bundle.putString("testID",testID);
                    //將Bundle物件assign給intent
                    in.putExtras(bundle);
                    startActivity(in);

                    //歸零
                    scaleID.setI(-1);
                    family_choose_test.this.finish();

                }
                else if (whichScale == 3) {
                    //新增資料到test資料表
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/test_Insert.php");
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("FAccount",name_account.getString("account")));
                    nameValuePairs.add(new BasicNameValuePair("ScaleID","3"));
                    nameValuePairs.add(new BasicNameValuePair("StartTime",StartTime));
                    try {
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        if (response != null) {
                            HttpEntity entity = response.getEntity();
                            testID = EntityUtils.toString(entity);
                            Toast.makeText(family_choose_test.this,"量表編號："+testID, Toast.LENGTH_SHORT).show();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //new一個intent物件，並指定Activity切換的class
                    Intent in=new Intent(family_choose_test.this,mmse.class);
                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();
                    bundle.putString("identity","family");
                    bundle.putString("name",name_account.getString("name"));
                    bundle.putString("account",name_account.getString("account"));
                    bundle.putString("testID",testID);
                    //將Bundle物件assign給intent
                    in.putExtras(bundle);
                    startActivity(in);
                    //歸零
                    scaleID.setI(-1);
                    family_choose_test.this.finish();
                }
                else if (whichScale == 4) {
                    //新增資料到test資料表
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/test_Insert.php");
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("FAccount",name_account.getString("account")));
                    nameValuePairs.add(new BasicNameValuePair("ScaleID","4"));
                    nameValuePairs.add(new BasicNameValuePair("StartTime",StartTime));
                    try {
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        if (response != null) {
                            HttpEntity entity = response.getEntity();
                            testID = EntityUtils.toString(entity);
                            Toast.makeText(family_choose_test.this,"量表編號："+testID, Toast.LENGTH_SHORT).show();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //new一個intent物件，並指定Activity切換的class
                    Intent in=new Intent(family_choose_test.this,moca.class);
                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();
                    bundle.putString("identity","family");
                    bundle.putString("name",name_account.getString("name"));
                    bundle.putString("account",name_account.getString("account"));
                    bundle.putString("testID",testID);
                    //將Bundle物件assign給intent
                    in.putExtras(bundle);
                    startActivity(in);
                    //歸零
                    scaleID.setI(-1);
                    family_choose_test.this.finish();
                }
                else if (whichScale == 5) {
                    //新增資料到test資料表
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/test_Insert.php");
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("FAccount",name_account.getString("account")));
                    nameValuePairs.add(new BasicNameValuePair("ScaleID","5"));
                    nameValuePairs.add(new BasicNameValuePair("StartTime",StartTime));
                    try {
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        if (response != null) {
                            HttpEntity entity = response.getEntity();
                            testID = EntityUtils.toString(entity);
                            Toast.makeText(family_choose_test.this,"量表編號："+testID, Toast.LENGTH_SHORT).show();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //new一個intent物件，並指定Activity切換的class
                    Intent in=new Intent(family_choose_test.this,npiq1.class);
                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();
                    bundle.putString("identity","family");
                    bundle.putString("name",name_account.getString("name"));
                    bundle.putString("account",name_account.getString("account"));
                    bundle.putString("testID",testID);
                    //將Bundle物件assign給intent
                    in.putExtras(bundle);
                    startActivity(in);

                    //歸零
                    scaleID.setI(-1);
                    family_choose_test.this.finish();
                }
                else {
                    Toast.makeText(family_choose_test.this, "請先選擇量表種類!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //按下取消按鈕後
        btn_family_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //歸零
                CustomAdapter scaleID=new CustomAdapter();
                scaleID.setI(-1);
                //new一個intent物件，並指定Activity切換的class
                Intent in=new Intent(family_choose_test.this,family_function.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",name_account.getString("name"));
                bundle.putString("account",name_account.getString("account"));
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                family_choose_test.this.finish();
            }
        });
    }

    public void CKDiagbox() {

        alert = new AlertDialog.Builder(this);
        LayoutInflater adbInflater = LayoutInflater.from(this);
        View checkboxLayout = adbInflater.inflate(R.layout.checkbox, null);
        dontShowAgain = (CheckBox) checkboxLayout.findViewById(R.id.skip);
        alert.setView(checkboxLayout);
        alert.setIcon(R.drawable.information);
        alert.setTitle(R.string.settitle);
        alert.setIcon(android.R.drawable.ic_dialog_alert);
        alert.setMessage(R.string.advise);

        alert.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                boolean checkBoxResult = false;
                if (dontShowAgain.isChecked()) {
                    checkBoxResult = true;
                }
                setCheckboxState(checkBoxResult);

                // 關閉對話框
                // finish();
            }
        });
    }
    public void setCheckboxState(boolean chk) {
        // 記錄勾選方塊是否被打勾
        SharedPreferences settings = getSharedPreferences("family_showit", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("family_skipMessage", chk);
        editor.commit();
    }

    public boolean isCheckboxStateEnabled() {
        // 讀取勾選方塊是否被打勾,預設值是未打勾(fasle)
        SharedPreferences settings = getSharedPreferences("family_showit", 0);
        skipMessage = settings.getBoolean("family_skipMessage", false);

        return skipMessage;
    }
}
