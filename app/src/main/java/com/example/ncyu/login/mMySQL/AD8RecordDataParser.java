package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.ad8Record;
import com.example.ncyu.login.mListView.AD8RecordAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/9/6.
 */

public class AD8RecordDataParser extends AsyncTask<Void,Void,Integer> {
    Context c;
    ListView lv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<ad8Record> ad8Records=new ArrayList<>();
    static AD8RecordAdapter adapter;

    public AD8RecordDataParser(Context c, ListView lv, String jsonData) {
        this.c = c;
        this.lv = lv;
        this.jsonData = jsonData;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("載入中");
        pd.setMessage("載入中...請稍候...");
        pd.show();
    }
    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();
        if(result ==0)
        {
            Toast.makeText(c,"無資料 無法載入",Toast.LENGTH_SHORT).show();
        }else{
            //CALL ADAPTER TO BIND DATA
            adapter =new AD8RecordAdapter(c,ad8Records);
            lv.setAdapter(adapter);
        }
    }
    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            ad8Records.clear();
            ad8Record s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int Q1=jo.getInt("Q1");
                int Q2=jo.getInt("Q2");
                int Q3=jo.getInt("Q3");
                int Q4=jo.getInt("Q4");
                int Q5=jo.getInt("Q5");
                int Q6=jo.getInt("Q6");
                int Q7=jo.getInt("Q7");
                int Q8=jo.getInt("Q8");
                int AD8_total_score=jo.getInt("AD8_total_score");


                s=new ad8Record();
                s.setQ1(Q1);
                s.setQ2(Q2);
                s.setQ3(Q3);
                s.setQ4(Q4);
                s.setQ5(Q5);
                s.setQ6(Q6);
                s.setQ7(Q7);
                s.setQ8(Q8);
                s.setAD8_total_score(AD8_total_score);

                ad8Records.add(s);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static AD8RecordAdapter getAdapter(){
        return adapter;
    }
}
