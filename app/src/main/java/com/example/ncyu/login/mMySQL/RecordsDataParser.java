package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.records;
import com.example.ncyu.login.mListView.RecordsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/21.
 */
public class RecordsDataParser extends AsyncTask<Void,Void,Integer> {
    Context c;
    ListView lv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<records> recordses=new ArrayList<>();
    static RecordsAdapter adapter;

    public RecordsDataParser(Context c, ListView lv, String jsonData) {
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
            Toast.makeText(c,"無資料",Toast.LENGTH_SHORT).show();
        }else{
            //CALL ADAPTER TO BIND DATA
            adapter =new RecordsAdapter(c,recordses);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            recordses.clear();
            records s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int testID=jo.getInt("testID");
                int scaleID=jo.getInt("scaleID");
                String end_test_time=jo.getString("end_test_time");

                s=new records();
                s.setTestID(testID); ;
                s.setScaleID(scaleID);
                s.setEnd_test_time(end_test_time); ;

                recordses.add(s);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static RecordsAdapter getAdapter(){
        return adapter;
    }
}
