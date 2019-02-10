package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.scale;
import com.example.ncyu.login.mListView.CustomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/7/14.
 */
public class DataParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    ListView lv;
    String jsonData;

    ProgressDialog pd;
    ArrayList<scale>scales=new ArrayList<>();

    public DataParser(Context c, ListView lv, String jsonData) {
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
            CustomAdapter adapter =new CustomAdapter(c,scales);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            scales.clear();
            scale s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int scaleID=jo.getInt("scaleID");
                int scale_total_points=jo.getInt("scale_total_points");
                int scale_passing_score=jo.getInt("scale_passing_score");
                int scale_estimated_time=jo.getInt("scale_estimated_time");
                String scale_name=jo.getString("scale_name");
                String scale_introduction=jo.getString("scale_introduction");

                s=new scale();
                s.setScaleID(scaleID);
                s.setScale_name(scale_name);
                s.setScale_introduction(scale_introduction);
                s.setScale_total_points(scale_total_points);
                s.setScale_passing_score(scale_passing_score);
                s.setScale_estimated_time(scale_estimated_time);

                scales.add(s);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
