package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.Mdoctor;
import com.example.ncyu.login.mListView.MdoctorAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/7.
 */
public class MdoctorDataParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    ListView lv;
    ProgressDialog pd;
    ArrayList<Mdoctor> Mdoctors=new ArrayList<>();

    public MdoctorDataParser(Context c,ListView lv,String jsonData) {
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
            MdoctorAdapter adapter =new MdoctorAdapter(c,Mdoctors) ;
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            Mdoctors.clear();
            Mdoctor s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int doctor_gender=jo.getInt("doctor_gender");
                String doctor_name=jo.getString("doctor_name") ;
                String doctor_hospital=jo.getString("doctor_hospital");
                String doctor_account=jo.getString("doctor_account");

                s=new Mdoctor();
                s.setDoctor_gender(doctor_gender);
                s.setDoctor_name(doctor_name) ;
                s.setDoctor_hospital(doctor_hospital);
                s.setDoctor_account(doctor_account);

                Mdoctors.add(s);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
