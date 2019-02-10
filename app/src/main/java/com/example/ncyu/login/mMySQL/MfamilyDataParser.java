package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.Mfamily;
import com.example.ncyu.login.mListView.MfamilyAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/7/27.
 */
public class MfamilyDataParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    ListView lv;
    ProgressDialog pd;
    ArrayList<Mfamily> Mfamilys=new ArrayList<>();

    public MfamilyDataParser(Context c,ListView lv,String jsonData) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv=lv;
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
            Toast.makeText(c,"無資料!",Toast.LENGTH_SHORT).show();
        }else{
            //CALL ADAPTER TO BIND DATA
            MfamilyAdapter adapter =new MfamilyAdapter(c,Mfamilys) ;
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            Mfamilys.clear();
            Mfamily s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int patient_gender=jo.getInt("Pgender");
                int family_gender=jo.getInt("Fgender");
                String patient_blood=jo.getString("Pblood");
                String patient_name=jo.getString("Pname") ;
                String family_name=jo.getString("Fname") ;
                String patient_birthday=jo.getString("Pbirthday");
                String family_account=jo.getString("Faccount");

                s=new Mfamily();
                s.setPatient_gender(patient_gender);
                s.setPatient_blood(patient_blood);
                s.setFamily_gender(family_gender);
                s.setPatient_name(patient_name) ;
                s.setFamily_name(family_name);
                s.setPatient_bitrhday(patient_birthday);
                s.setFamily_account(family_account);

                Mfamilys.add(s);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
