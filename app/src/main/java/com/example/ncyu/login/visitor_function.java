package com.example.ncyu.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class visitor_function extends AppCompatActivity {
    ImageButton btn_Vlogout,btn_Vtest,btn_Vtest_result,btn_about_system;
    ImageButton btn_VMap;

    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_function);

        btn_Vtest=(ImageButton)findViewById(R.id.btn_Vtest);
        btn_Vlogout=(ImageButton)findViewById(R.id.btn_Vlogout);
        btn_Vtest_result=(ImageButton)findViewById(R.id.btn_Vtest_result);
        btn_about_system=(ImageButton)findViewById(R.id.btn_about_system);
        btn_VMap=(ImageButton)findViewById(R.id.btn_VMap);

        //建立SQLiteOpenHelper 物件
        dbHelper = new MyDBHelper(this);
        db = dbHelper.getWritableDatabase();//開啟資料庫
        dbHelper.onCreate(db);


        //回主畫面
        btn_Vlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),choose_identity.class));
                visitor_function.this.finish();
            }
        });

        btn_VMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(visitor_function.this,map.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("identity","guest");
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                visitor_function.this.finish();
            }
        });

        //開始測驗
        btn_Vtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(visitor_function.this,visitor_question.class);
                String[] column={"_id","frequency"};
                c = dbHelper.getReadableDatabase().query("guest", column, "_id = 1", null, null, null, null);
                c.moveToFirst();
                try{
                    //訪客已有經驗
                    if(c.getInt(1)==1){
                        //new一個intent物件，並指定Activity切換的class
                        in=new Intent(visitor_function.this,visitor_choose_test.class);
                    }
                    //訪客已有經驗，但仍需再次測驗
                    else if(c.getInt(1)==0){
                        in=new Intent(visitor_function.this,visitor_question.class);
                    }
                }
                catch (CursorIndexOutOfBoundsException e){
                    //訪客端第一次使用此程式
                    ContentValues cv =new ContentValues();
                    cv.put("_id",1);
                    cv.put("frequency",0);
                    long guest =db.insert("guest",null,cv);
                    c = dbHelper.getReadableDatabase().query("guest", column, "_id = 1", null, null, null, null);
                    c.moveToFirst();
                    int test=c.getInt(1);
                }
                startActivity(in);
                visitor_function.this.finish();
            }
        });

        //歷次測驗結果
        btn_Vtest_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),visitor_choose_scaleID.class));
                visitor_function.this.finish();
            }
        });

        //關於我們
        btn_about_system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(visitor_function.this,about_system.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("identity","guest");
                //將Bundle物件assign給intent
                in.putExtras(bundle);
                startActivity(in);
                visitor_function.this.finish();
            }
        });
    }

    //返回鍵
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {

            //new一個intent物件，並指定Activity切換的class
            Intent in=new Intent(visitor_function.this,choose_identity.class);
            startActivity(in);
            visitor_function.this.finish();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
