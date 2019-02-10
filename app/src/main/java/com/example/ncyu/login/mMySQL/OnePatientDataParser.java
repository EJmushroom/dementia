package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.one_patient;
import com.example.ncyu.login.mListView.OnePatientAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/17.
 */
public class OnePatientDataParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    ListView lv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<one_patient> one_patients=new ArrayList<>();


    public OnePatientDataParser(Context c, ListView lv, String jsonData) {
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
            OnePatientAdapter adapter =new OnePatientAdapter(c,one_patients);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            one_patients.clear();
            one_patient s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int patient_number=jo.getInt("patient_number");
                int patient_gender=jo.getInt("patient_gender");
                String patient_name=jo.getString("patient_name");
                String patient_birthday=jo.getString("patient_birthday");
                String patient_blood=jo.getString("patient_blood_type");

                s=new one_patient();
                s.setPatient_number(patient_number) ;
                s.setPatient_gender(patient_gender) ;
                s.setPatient_name(patient_name) ;
                s.setPatient_birthday(patient_birthday) ;
                s.setPatient_blood(patient_blood);

                one_patients.add(s);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
