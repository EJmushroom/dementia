package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.family_one_moca_record_data;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/12/18.
 */

public class MOCARecordDownloader extends AsyncTask<Void,Void,String> {
    Context c;
    String urlAddress;
    ListView lv;

    ProgressDialog pd;

    public MOCARecordDownloader(Context c, String urlAddress, ListView lv) {
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

            MOCARecordDataParser parser =new MOCARecordDataParser(c,lv,s);
            parser.execute();
        }
    }
    private String downloadData(){
        InputStream is=null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(urlAddress);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

            if(family_one_moca_record_data.getTestID()!=null){
                nameValuePairs.add(new BasicNameValuePair("txtTestID", family_one_moca_record_data.getTestID()));
            }
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
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
