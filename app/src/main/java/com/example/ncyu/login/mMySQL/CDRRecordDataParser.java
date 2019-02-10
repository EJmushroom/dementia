package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.cdrRecord;
import com.example.ncyu.login.mListView.CDRRecordAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/9/26.
 */

public class CDRRecordDataParser extends AsyncTask<Void,Void,Integer> {
    Context c;
    ListView lv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<cdrRecord> cdrRecords=new ArrayList<>();
    static CDRRecordAdapter adapter;

    public CDRRecordDataParser(Context c, ListView lv, String jsonData) {
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
            adapter =new CDRRecordAdapter(c,cdrRecords);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            cdrRecords.clear();
            cdrRecord s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                double memory=jo.getDouble("memory");
                double orientation=jo.getDouble("orientation");
                double problem_solving_ability=jo.getDouble("problem_solving_ability");
                double community_activity=jo.getDouble("community_activity");
                double home_hobby=jo.getDouble("home_hobby");
                double self_care=jo.getDouble("self_care");
                double CDR_total_score=jo.getDouble("CDR_total_score");


                s=new cdrRecord();
                s.setMemory(memory);
                s.setOrientation(orientation);
                s.setProblem_solving_ability(problem_solving_ability);
                s.setCommunity_activity(community_activity);
                s.setHome_hobby(home_hobby);
                s.setSelf_care(self_care);
                s.setCDR_total_score(CDR_total_score);

                cdrRecords.add(s);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static CDRRecordAdapter getAdapter(){
        return adapter;
    }

}
