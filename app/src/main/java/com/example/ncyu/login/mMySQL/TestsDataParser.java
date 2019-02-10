package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.tests;
import com.example.ncyu.login.mListView.TestsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/20.
 */
public class TestsDataParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    ListView lv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<tests> testses=new ArrayList<>();
    static TestsAdapter adapter;

    public TestsDataParser(Context c, ListView lv, String jsonData) {
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
            adapter =new TestsAdapter(c,testses);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            testses.clear();
            tests s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int testID=jo.getInt("testID");
                String end_test_time=jo.getString("end_test_time");

                s=new tests();
                s.setTestID(testID); ;
                s.setEnd_test_time(end_test_time); ;

                testses.add(s);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static TestsAdapter getAdapter(){
        return adapter;
    }


}
