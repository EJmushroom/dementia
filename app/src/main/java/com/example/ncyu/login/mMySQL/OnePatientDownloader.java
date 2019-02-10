package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.doctor_result_control;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/17.
 */
public class OnePatientDownloader extends AsyncTask<Void,Void,String> {

    Context c;
    String urlAddress;
    ListView lv;

    ProgressDialog pd;

    public OnePatientDownloader(Context c, String urlAddress, ListView lv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.lv = lv;

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
    protected String doInBackground(Void... params) {
        return this.downloadData();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        pd.dismiss();

        if(s==null)
        {
            Toast.makeText(c,"載入失敗！無資料",Toast.LENGTH_SHORT).show();
        }else
        {
            //CALL DATA PARSER TO PARSE
            OnePatientDataParser parser =new OnePatientDataParser(c,lv,s);
            parser.execute();
        }
    }

    private String downloadData(){
        InputStream is=null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(urlAddress);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("txtPNumber", toString().valueOf(doctor_result_control.getWhichPatient())));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

            BufferedReader reader=new BufferedReader(new InputStreamReader(is));


            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line=reader.readLine()) != null)
            {
                sb.append(line);
            }
            is.close();
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is !=null)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
