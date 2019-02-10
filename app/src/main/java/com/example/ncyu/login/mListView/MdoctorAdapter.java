package com.example.ncyu.login.mListView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.R;
import com.example.ncyu.login.doctor_function;
import com.example.ncyu.login.doctor_modify;
import com.example.ncyu.login.mDataObject.Mdoctor;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/7.
 */
public class MdoctorAdapter extends BaseAdapter {

    Context c;
    ArrayList<Mdoctor> Mdoctors;
    LayoutInflater inflater;
    int doctor_gender;
    boolean DpasswordChanged=false;
    String result;

    public MdoctorAdapter(Context c, ArrayList<Mdoctor> Mdoctors) {
        this.c = c;
        this.Mdoctors = Mdoctors;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Mdoctors.size();
    }

    @Override
    public Object getItem(int position) {
        return Mdoctors.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.doctor_modify_model, parent, false);
        }

        final EditText doctor_nameTxt=(EditText)convertView.findViewById(R.id.et_Mdoctor_name);
        EditText doctor_accountTxt=(EditText)convertView.findViewById(R.id.et_Mdocotor_account);
        final EditText doctor_hospitalTxt=(EditText)convertView.findViewById(R.id.et_Mdoctor_hospital);
        RadioButton rbtn_Dboy=(RadioButton)convertView.findViewById(R.id.rbtn_Mdoctor_boy);
        RadioButton rbtn_Dgirl=(RadioButton)convertView.findViewById(R.id.rbtn_Mdoctor_girl);
        RadioButton rbtn_MDpassword_yes=(RadioButton)convertView.findViewById(R.id.rbtn_MDpassword_yes);
        RadioButton rbtn_MDpassword_no=(RadioButton)convertView.findViewById(R.id.rbtn_MDpassword_no);
        RadioGroup rg_MDpasswrod=(RadioGroup)convertView.findViewById(R.id.rg_Mdoctor_password);
        RadioGroup rg_MDgender=(RadioGroup)convertView.findViewById(R.id.rg_Mdoctor_gender);

        final TextView new_Dpassword=(TextView)convertView.findViewById(R.id.textView36);
        final TextView new_Drpassword=(TextView)convertView.findViewById(R.id.textView37);
        final EditText et_MDpassword=(EditText)convertView.findViewById(R.id.et_Mdoctor_password);
        final EditText et_MDrpassword=(EditText)convertView.findViewById(R.id.et_Mdoctor_rpassword);

        Button btn_Dmodify=(Button)convertView.findViewById(R.id.btn_Dmodify);

        doctor_nameTxt.setText(Mdoctors.get(position).getDoctor_name());
        doctor_accountTxt.setText(Mdoctors.get(position).getDoctor_account());
        doctor_hospitalTxt.setText(Mdoctors.get(position).getDoctor_hospital());
        doctor_gender=Mdoctors.get(position).getDoctor_gender();

        //歸零
        DpasswordChanged=false;

        //醫師性別
        if(doctor_gender==1){
            rbtn_Dboy.setChecked(true);
        }else if(doctor_gender==2){
            rbtn_Dgirl.setChecked(true);
        }

        //更改醫師性別
        RadioGroup.OnCheckedChangeListener isDoctorGenderCheckedChange =
                new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {
                        switch (checkedId)
                        {
                            case R.id.rbtn_Mdoctor_boy :
                                doctor_gender=1;
                                break;

                            case R.id.rbtn_Mdoctor_girl :
                                doctor_gender=2;
                                break;


                        }
                    }
                };
        rg_MDgender.setOnCheckedChangeListener(isDoctorGenderCheckedChange);

        //更改密碼
        RadioGroup.OnCheckedChangeListener isDPasswordCheckedChange =
                new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {


                        switch (checkedId)
                        {
                            case R.id.rbtn_MDpassword_yes :
                                new_Dpassword.setVisibility(View.VISIBLE);
                                new_Drpassword.setVisibility(View.VISIBLE);
                                et_MDpassword.setVisibility(View.VISIBLE);
                                et_MDrpassword.setVisibility(View.VISIBLE);
                                DpasswordChanged=true;
                                break;

                            case R.id.rbtn_MDpassword_no :
                                new_Dpassword.setVisibility(View.GONE);
                                new_Drpassword.setVisibility(View.GONE);
                                et_MDpassword.setVisibility(View.GONE);
                                et_MDrpassword.setVisibility(View.GONE);
                                DpasswordChanged=false;
                                break;


                        }
                    }
                };
        rg_MDpasswrod.setOnCheckedChangeListener(isDPasswordCheckedChange);

        //按下確定修改
        btn_Dmodify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HttpClient httpclient = new DefaultHttpClient();

                //有更改密碼
                if(DpasswordChanged==true){

                    //檢查密碼是否輸入
                    if (et_MDpassword.getText().toString().equals("") || et_MDrpassword.getText().toString().equals("")) {
                        Toast.makeText(c, "請輸入欲修改的密碼！", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        //檢查密碼輸入是否一致
                        if (et_MDpassword.getText().toString().equals(et_MDrpassword.getText().toString())){
                            HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/doctor_D_M_P_YES.php");
                            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                            nameValuePairs.add(new BasicNameValuePair("txtAccount", Mdoctors.get(position).getDoctor_account()));
                            nameValuePairs.add(new BasicNameValuePair("txtName", doctor_nameTxt.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtDHospital", doctor_hospitalTxt.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtGender", toString().valueOf(doctor_gender)));
                            nameValuePairs.add(new BasicNameValuePair("txtPassword", et_MDpassword.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtRPassword", et_MDrpassword.getText().toString()));

                            try {
                                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            HttpResponse response = null;
                            try {
                                response = httpclient.execute(httppost);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (response != null) {
                                HttpEntity entity = response.getEntity();
                                try {
                                    result = EntityUtils.toString(entity);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            if(result.equals("success")) {
                                //返回功能頁面
                                Intent intent = new Intent(c.getApplicationContext(), doctor_function.class);
                                //new一個Bundle物件，並將要傳遞的資料傳入
                                Bundle bundle = new Bundle();
                                bundle.putString("name", doctor_nameTxt.getText().toString());
                                bundle.putString("account", Mdoctors.get(position).getDoctor_account());
                                //將Bundle物件assign給intent
                                intent.putExtras(bundle);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                c.getApplicationContext().startActivity(intent);
                                doctor_modify.ActivityB.finish();
                                Toast.makeText(c, "資料修改成功", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(c, "資料修改失敗", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(c, "密碼輸入錯誤！", Toast.LENGTH_SHORT).show();
                            et_MDpassword.setText("");
                            et_MDrpassword.setText("");
                        }
                    }
                }
                //無更改密碼
                else{
                    HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/doctor_D_M_P_NO.php");
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("txtAccount", Mdoctors.get(position).getDoctor_account()));
                    nameValuePairs.add(new BasicNameValuePair("txtName", doctor_nameTxt.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("txtDHospital", doctor_hospitalTxt.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("txtGender", toString().valueOf(doctor_gender)));
                    try {
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    HttpResponse response = null;
                    try {
                        response = httpclient.execute(httppost);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (response != null) {
                        HttpEntity entity = response.getEntity();
                        try {
                            result = EntityUtils.toString(entity);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if(result.equals("success")) {
                        //返回功能頁面
                        Intent intent = new Intent(c.getApplicationContext(), doctor_function.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("name", doctor_nameTxt.getText().toString());
                        bundle.putString("account", Mdoctors.get(position).getDoctor_account());
                        //將Bundle物件assign給intent
                        intent.putExtras(bundle);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        c.getApplicationContext().startActivity(intent);
                        doctor_modify.ActivityB.finish();
                        Toast.makeText(c,"資料修改成功", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(c,"資料修改失敗", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        return convertView;
    }
}
