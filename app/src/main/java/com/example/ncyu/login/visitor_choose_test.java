package com.example.ncyu.login;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.scale;
import com.example.ncyu.login.mListView.CustomAdapter;
import com.example.ncyu.login.mMySQL.Downloader;
import com.example.ncyu.login.MyDBHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class visitor_choose_test extends AppCompatActivity{

    String urlAddress="http://ej30827.000webhostapp.com/scale_select.php";
    ListView lv_visitor_test;
    Button btn_Vstart,btn_Vcancel;
    int whichScale=-1;
    String StartTime;

    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    Cursor c;

    boolean skipMessage;
    AlertDialog.Builder alert;
    public CheckBox dontShowAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_choose_test);

        lv_visitor_test=(ListView)findViewById(R.id.lv_visitor_test);
        btn_Vstart=(Button)findViewById(R.id.btn_Vstart);
        btn_Vcancel=(Button)findViewById(R.id.btn_Vcancel);

        Downloader d=new Downloader(visitor_choose_test.this,urlAddress,lv_visitor_test);
        d.execute();

        //建立SQLiteOpenHelper 物件
        dbHelper = new MyDBHelper(this);
        db = dbHelper.getWritableDatabase();//開啟資料庫
        dbHelper.onCreate(db);
        //db.execSQL("DROP TABLE IF EXISTS moca");

        // 宣告對話框
        CKDiagbox();

        // 如果沒有勾選"不再顯示",則顯示對話框 !isCheckboxStateEnabled()
        if (!isCheckboxStateEnabled()) {
            alert.show();
        }



        //按下開始測驗後
        btn_Vstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomAdapter test=new CustomAdapter();
                whichScale=test.getI()+1;

                if(whichScale>=1 && whichScale<=5) {
                    //取得開始測驗時間
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                    Calendar c = Calendar.getInstance();
                    StartTime = df.format(c.getTime());
                    ContentValues cv = new ContentValues();
                    cv.put("scaleID", whichScale);
                    cv.put("start_test_time", StartTime);
                    long testID = db.insert("test", null, cv);
                    Toast.makeText(visitor_choose_test.this, "量表編號："+ toString().valueOf(testID), Toast.LENGTH_SHORT).show();
                    if (whichScale == 1) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(visitor_choose_test.this, ad8.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("identity", "guest");
                        bundle.putString("testID", toString().valueOf(testID));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        //歸零
                        test.setI(-1);
                        visitor_choose_test.this.finish();
                    } else if (whichScale == 2) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(visitor_choose_test.this, cdr.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("identity", "guest");
                        bundle.putString("testID", toString().valueOf(testID));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        //歸零
                        test.setI(-1);
                        visitor_choose_test.this.finish();
                    } else if (whichScale == 3) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(visitor_choose_test.this, mmse.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("identity", "guest");
                        bundle.putString("testID", toString().valueOf(testID));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        //歸零
                        test.setI(-1);
                        visitor_choose_test.this.finish();
                    }
                    else if (whichScale == 4) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(visitor_choose_test.this, moca.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("identity", "guest");
                        bundle.putString("testID", toString().valueOf(testID));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        //歸零
                        test.setI(-1);
                        visitor_choose_test.this.finish();
                    }
                    else if (whichScale == 5) {
                        //new一個intent物件，並指定Activity切換的class
                        Intent in = new Intent(visitor_choose_test.this, npiq1.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("identity", "guest");
                        bundle.putString("testID", toString().valueOf(testID));
                        //將Bundle物件assign給intent
                        in.putExtras(bundle);
                        startActivity(in);
                        //歸零
                        test.setI(-1);
                        visitor_choose_test.this.finish();
                    }
                }
                else {
                    Toast.makeText(visitor_choose_test.this, "請先選擇量表種類!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //按下取消按鈕後
        btn_Vcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(visitor_choose_test.this,visitor_function.class));
                visitor_choose_test.this.finish();
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
        SharedPreferences settings = getSharedPreferences("visitor_showit", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("visitor_skipMessage", chk);
        editor.commit();
    }

    public boolean isCheckboxStateEnabled() {
        // 讀取勾選方塊是否被打勾,預設值是未打勾(fasle)
        SharedPreferences settings = getSharedPreferences("visitor_showit", 0);
        skipMessage = settings.getBoolean("visitor_skipMessage", false);

        return skipMessage;
    }

    //返回鍵
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            String[] column={"_id","frequency"};
            c = dbHelper.getReadableDatabase().query("guest", column, "_id = 1", null, null, null, null);
            c.moveToFirst();
            //訪客已有經驗
            Intent in;
            if(c.getInt(1)==1) {
                //new一個intent物件，並指定Activity切換的class
                in = new Intent(visitor_choose_test.this, visitor_function.class);
            }
            else {
                in = new Intent(visitor_choose_test.this, visitor_question.class);
            }
            startActivity(in);
            visitor_choose_test.this.finish();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }



}
