package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Ncyu on 2017/8/15.
 */
public class PatientDownloader  extends AsyncTask<Void,Void,String> {

    Context c;
    String urlAddress;
    ListView lv;

    ProgressDialog pd;

    public PatientDownloader(Context c, String urlAddress, ListView lv) {
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
            PatientDataParser parser =new PatientDataParser(c,lv,s);
            parser.execute();
        }
    }

    private String downloadData(){
        HttpURLConnection con=Connector.connect(urlAddress);
        if(con==null){
            return null;
        }
        InputStream is=null;
        try {
            is=new BufferedInputStream(con.getInputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(is));

            String line = null;
            StringBuffer respons=new StringBuffer();

            if(br != null)
            {
                while((line=br.readLine()) != null)
                {
                    respons.append(line+"\n");
                }

                br.close();

            }else{
                return null;
            }
            return respons.toString();

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