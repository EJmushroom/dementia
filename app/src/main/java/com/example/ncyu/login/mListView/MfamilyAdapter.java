package com.example.ncyu.login.mListView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.R;
import com.example.ncyu.login.family_function;
import com.example.ncyu.login.family_modify;
import com.example.ncyu.login.mDataObject.Mfamily;
import com.kosalgeek.asynctask.PostResponseAsyncTask;


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
import java.util.Calendar;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Ncyu on 2017/7/27.
 */
public class MfamilyAdapter extends BaseAdapter  {
    Context c;
    ArrayList<Mfamily> Mfamilys;
    LayoutInflater inflater;

    String patient_blood,cdate;
    int patient_gender,family_gender;
    DatePicker datePicker;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    public static boolean birthdayChanged=false,passwordChanged=false;
    String result;

    public MfamilyAdapter(Context c, ArrayList<Mfamily> Mfamilys) {
        this.c = c;
        this.Mfamilys = Mfamilys;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public MfamilyAdapter() {

    }

    @Override
    public int getCount() {
        return Mfamilys.size();
    }

    @Override
    public Object getItem(int position) {
        return Mfamilys.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView =inflater.inflate(R.layout.family_modify_model,parent,false);

        }


        final EditText patient_nameTxt=(EditText)convertView.findViewById(R.id.et_Mpatient_name);
        TextView patient_birthdayTxt=(TextView)convertView.findViewById(R.id.tv_patient_birthday);
        final EditText family_nameTxt=(EditText)convertView.findViewById(R.id.et_Mname);
        EditText family_accountTxt=(EditText)convertView.findViewById(R.id.et_Maccount);
        RadioButton rbtn_Pboy=(RadioButton)convertView.findViewById(R.id.rbtn_Mpatient_boy);
        RadioButton rbtn_Pgirl=(RadioButton)convertView.findViewById(R.id.rbtn_Mpatient_girl);
        RadioButton rbtn_Fboy=(RadioButton)convertView.findViewById(R.id.rbtn_Mboy);
        RadioButton rbtn_Fgirl=(RadioButton)convertView.findViewById(R.id.rbtn_Mgirl);
        RadioButton rbtn_PA=(RadioButton)convertView.findViewById(R.id.rbtn_MA);
        RadioButton rbtn_PB=(RadioButton)convertView.findViewById(R.id.rbtn_MB);
        RadioButton rbtn_PAB=(RadioButton)convertView.findViewById(R.id.rbtn_MAB);
        RadioButton rbtn_PO=(RadioButton)convertView.findViewById(R.id.rbtn_MO);
        //RadioButton rbtn_Pother=(RadioButton)convertView.findViewById(R.id.rbtn_Mother);
        RadioGroup rg_Mpatient_birthday=(RadioGroup)convertView.findViewById(R.id.rg_Mpatient_birthday);
        RadioGroup rg_Mpasswrod=(RadioGroup)convertView.findViewById(R.id.rg_Mpassword);
        RadioGroup rg_Mpatient_blood=(RadioGroup)convertView.findViewById(R.id.rg_Mpatient_blood);
        RadioGroup rg_Mpatient_gender=(RadioGroup)convertView.findViewById(R.id.rg_Mpatient_gender);
        RadioGroup rg_Mfamily_gender=(RadioGroup)convertView.findViewById(R.id.rg_Mgender);


        RadioButton rbtn_Mbirthday_yes=(RadioButton)convertView.findViewById(R.id.rbtn_Mbirthday_yes);
        RadioButton rbtn_Mbirthday_no=(RadioButton)convertView.findViewById(R.id.rbtn_Mbirthday_no);
        final TextView choose_Pbirthday=(TextView)convertView.findViewById(R.id.textView27);
        RadioButton rbtn_Mpassword_yes=(RadioButton)convertView.findViewById(R.id.rbtn_Mpassword_yes);
        RadioButton rbtn_Mpassword_no=(RadioButton)convertView.findViewById(R.id.rbtn_Mpassword_no);
        final TextView new_password=(TextView)convertView.findViewById(R.id.textView25);
        final TextView new_rpassword=(TextView)convertView.findViewById(R.id.textView26);
        final EditText et_Mpassword=(EditText)convertView.findViewById(R.id.et_Mpassword);
        final EditText et_Mrpassword=(EditText)convertView.findViewById(R.id.et_Mrpassword);

        datePicker = (DatePicker)convertView.findViewById(R.id.MdatePicker);




        Button btn_modify=(Button)convertView.findViewById(R.id.btn_modify);


        patient_nameTxt.setText(Mfamilys.get(position).getPatient_name());
        patient_birthdayTxt.setText(Mfamilys.get(position).getPatient_bitrhday());
        family_nameTxt.setText(Mfamilys.get(position).getFamily_name());
        family_accountTxt.setText(Mfamilys.get(position).getFamily_account());
        patient_gender=Mfamilys.get(position).getPatient_gender();
        patient_blood=Mfamilys.get(position).getPatient_blood();
        family_gender=Mfamilys.get(position).getFamily_gender();

        //歸零
        birthdayChanged=false;
        passwordChanged=false;

        //病患性別
        if(patient_gender==1){
            rbtn_Pboy.setChecked(true);
        }else if(patient_gender==2){
            rbtn_Pgirl.setChecked(true);
        }

        //更改病患性別
        RadioGroup.OnCheckedChangeListener isPatientGenderCheckedChange =
                new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {
                        switch (checkedId)
                        {
                            case R.id.rbtn_Mpatient_boy :
                                patient_gender=1;
                                break;

                            case R.id.rbtn_Mpatient_girl :
                                patient_gender=2;
                                break;


                        }
                    }
                };
        rg_Mpatient_gender.setOnCheckedChangeListener(isPatientGenderCheckedChange);

        //家屬性別
        if(family_gender==1){
            rbtn_Fboy.setChecked(true);
        }else if(family_gender==2){
            rbtn_Fgirl.setChecked(true);
        }

        //更改家屬性別
        RadioGroup.OnCheckedChangeListener isFamilyGenderCheckedChange =
                new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {
                        switch (checkedId)
                        {
                            case R.id.rbtn_Mboy :
                                family_gender=1;
                                break;

                            case R.id.rbtn_Mgirl :
                                family_gender=2;
                                break;


                        }
                    }
                };
        rg_Mfamily_gender.setOnCheckedChangeListener(isFamilyGenderCheckedChange);

        //病人血型
        switch (patient_blood){
            case "A":
                rbtn_PA.setChecked(true);
                break;
            case "B":
                rbtn_PB.setChecked(true);
                break;
            case "AB":
                rbtn_PAB.setChecked(true);
                break;
            case "O":
                rbtn_PO.setChecked(true);
                break;
//            case "other":
//                rbtn_Pother.setChecked(true);
//                break;
        }

        //更改病患血型
        RadioGroup.OnCheckedChangeListener isPatientBloodCheckedChange =
                new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {
                        switch (checkedId)
                        {
                            case R.id.rbtn_MA :
                                patient_blood="A";
                                break;

                            case R.id.rbtn_MB :
                                patient_blood="B";
                                break;

                            case R.id.rbtn_MAB :
                                patient_blood="AB";
                                break;

                            case R.id.rbtn_MO :
                                patient_blood="O";
                                break;

//                            case R.id.rbtn_Mother :
//                                patient_blood="other";
//                                break;


                        }
                    }
                };
        rg_Mpatient_blood.setOnCheckedChangeListener(isPatientBloodCheckedChange);


        //更改病患生日
        RadioGroup.OnCheckedChangeListener isBirthdayCheckedChange =
                new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {


                        switch (checkedId)
                        {
                            case R.id.rbtn_Mbirthday_yes :
                                choose_Pbirthday.setVisibility(View.VISIBLE);
                                datePicker.setVisibility(View.VISIBLE);
                                birthdayChanged=true;
                                break;

                            case R.id.rbtn_Mbirthday_no :
                                choose_Pbirthday.setVisibility(View.GONE);
                                datePicker.setVisibility(View.GONE);
                                birthdayChanged=false;
                                break;


                        }
                    }
                };
        rg_Mpatient_birthday.setOnCheckedChangeListener(isBirthdayCheckedChange);


        //更改密碼
        RadioGroup.OnCheckedChangeListener isPasswordCheckedChange =
                new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {


                        switch (checkedId)
                        {
                            case R.id.rbtn_Mpassword_yes :
                                new_password.setVisibility(View.VISIBLE);
                                new_rpassword.setVisibility(View.VISIBLE);
                                et_Mpassword.setVisibility(View.VISIBLE);
                                et_Mrpassword.setVisibility(View.VISIBLE);
                                passwordChanged=true;
                                break;

                            case R.id.rbtn_Mpassword_no :
                                new_password.setVisibility(View.GONE);
                                new_rpassword.setVisibility(View.GONE);
                                et_Mpassword.setVisibility(View.GONE);
                                et_Mrpassword.setVisibility(View.GONE);
                                passwordChanged=false;
                                break;


                        }
                    }
                };
        rg_Mpasswrod.setOnCheckedChangeListener(isPasswordCheckedChange);

        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HttpClient httpclient = new DefaultHttpClient();

                if(birthdayChanged&&passwordChanged) {

                    //取得病患生日
                    // 获取日历对象
                    calendar = Calendar.getInstance();
                    // 获取当前对应的年、月、日的信息
                    year = calendar.get(Calendar.YEAR);
                    month = calendar.get(Calendar.MONTH) + 1;
                    day = calendar.get(Calendar.DAY_OF_MONTH);
                    datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
                        @Override
                        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            cdate = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        }
                    });


                    if (et_Mpassword.getText().toString().equals("") || et_Mrpassword.getText().toString().equals("")) {
                        Toast.makeText(c, "請輸入欲修改的密碼！", Toast.LENGTH_SHORT).show();
                    }
                    else if(cdate==null) {
                        Toast.makeText(c, "請輸選擇要修改的病患生日！", Toast.LENGTH_SHORT).show();
                    }
                    else
                     {
                        //檢查密碼輸入是否一致
                        if (et_Mpassword.getText().toString().equals(et_Mrpassword.getText().toString())) {

                            HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/family_D_M_PB_YES_P_YES.php");
                            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                            nameValuePairs.add(new BasicNameValuePair("txtAccount", Mfamilys.get(position).getFamily_account()));
                            nameValuePairs.add(new BasicNameValuePair("txtName", family_nameTxt.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtPName", patient_nameTxt.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtGender", toString().valueOf(family_gender)));
                            nameValuePairs.add(new BasicNameValuePair("txtPGender", toString().valueOf(patient_gender)));
                            nameValuePairs.add(new BasicNameValuePair("txtPBlood", patient_blood));
                            nameValuePairs.add(new BasicNameValuePair("txtPassword", et_Mpassword.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtRPassword", et_Mrpassword.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtPBirthday", cdate));


                            try {
                                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8")); //加上UTF-8嘗試
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
                                Intent intent = new Intent(c.getApplicationContext(), family_function.class);
                                //new一個Bundle物件，並將要傳遞的資料傳入
                                Bundle bundle = new Bundle();
                                bundle.putString("name", family_nameTxt.getText().toString());
                                bundle.putString("account", Mfamilys.get(position).getFamily_account());
                                //將Bundle物件assign給intent
                                intent.putExtras(bundle);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                c.getApplicationContext().startActivity(intent);
                                family_modify.ActivityA.finish();
                                Toast.makeText(c, "資料修改成功", Toast.LENGTH_SHORT).show();
                            }
                            else if(result.equals("familyfailed")){
                                Toast.makeText(c, "家屬資料修改失敗", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(c, "資料修改失敗", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                                Toast.makeText(c, "密碼輸入錯誤！", Toast.LENGTH_SHORT).show();
                                et_Mpassword.setText("");
                                et_Mrpassword.setText("");
                            }

                    }
                }else if(birthdayChanged){
                    //取得病患生日
                    // 获取日历对象
                    calendar = Calendar.getInstance();
                    // 获取当前对应的年、月、日的信息
                    year = calendar.get(Calendar.YEAR);
                    month = calendar.get(Calendar.MONTH) + 1;
                    day = calendar.get(Calendar.DAY_OF_MONTH);
                    datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
                        @Override
                        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            cdate = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        }
                    });

                    if(cdate==null) {
                        Toast.makeText(c, "請輸選擇要修改的病患生日！", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/family_D_M_PB_YES_P_NO.php");
                        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                        nameValuePairs.add(new BasicNameValuePair("txtAccount", Mfamilys.get(position).getFamily_account()));
                        nameValuePairs.add(new BasicNameValuePair("txtName", family_nameTxt.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("txtPName", patient_nameTxt.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("txtGender", toString().valueOf(family_gender)));
                        nameValuePairs.add(new BasicNameValuePair("txtPGender", toString().valueOf(patient_gender)));
                        nameValuePairs.add(new BasicNameValuePair("txtPBlood", patient_blood));
                        nameValuePairs.add(new BasicNameValuePair("txtPBirthday", cdate));


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
                            Intent intent = new Intent(c.getApplicationContext(), family_function.class);
                            //new一個Bundle物件，並將要傳遞的資料傳入
                            Bundle bundle = new Bundle();
                            bundle.putString("name", family_nameTxt.getText().toString());
                            bundle.putString("account", Mfamilys.get(position).getFamily_account());
                            //將Bundle物件assign給intent
                            intent.putExtras(bundle);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            c.getApplicationContext().startActivity(intent);
                            family_modify.ActivityA.finish();
                            Toast.makeText(c, "資料修改成功", Toast.LENGTH_SHORT).show();
                        }
                        else if(result.equals("familyfailed")){
                            Toast.makeText(c, "家屬資料修改失敗", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(c, "資料修改失敗", Toast.LENGTH_SHORT).show();
                        }

                    }
                }else if(passwordChanged){

                    if (et_Mpassword.getText().toString().equals("") || et_Mrpassword.getText().toString().equals("")) {
                        Toast.makeText(c, "請輸入欲修改的密碼！", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        //檢查密碼輸入是否一致
                        if (et_Mpassword.getText().toString().equals(et_Mrpassword.getText().toString())) {

                            HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/family_D_M_PB_NO_P_YES.php");
                            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                            nameValuePairs.add(new BasicNameValuePair("txtAccount", Mfamilys.get(position).getFamily_account()));
                            nameValuePairs.add(new BasicNameValuePair("txtName", family_nameTxt.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtPName", patient_nameTxt.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtGender", toString().valueOf(family_gender)));
                            nameValuePairs.add(new BasicNameValuePair("txtPGender", toString().valueOf(patient_gender)));
                            nameValuePairs.add(new BasicNameValuePair("txtPBlood", patient_blood));
                            nameValuePairs.add(new BasicNameValuePair("txtPassword", et_Mpassword.getText().toString()));
                            nameValuePairs.add(new BasicNameValuePair("txtRPassword", et_Mrpassword.getText().toString()));

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
                                Intent intent = new Intent(c.getApplicationContext(), family_function.class);
                                //new一個Bundle物件，並將要傳遞的資料傳入
                                Bundle bundle = new Bundle();
                                bundle.putString("name", family_nameTxt.getText().toString());
                                bundle.putString("account", Mfamilys.get(position).getFamily_account());
                                //將Bundle物件assign給intent
                                intent.putExtras(bundle);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                c.getApplicationContext().startActivity(intent);
                                family_modify.ActivityA.finish();
                                Toast.makeText(c, "資料修改成功", Toast.LENGTH_SHORT).show();
                            }
                            else if(result.equals("familyfailed")){
                                Toast.makeText(c, "家屬資料修改失敗", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(c, "資料修改失敗", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(c, "密碼輸入錯誤！", Toast.LENGTH_SHORT).show();
                            et_Mpassword.setText("");
                            et_Mrpassword.setText("");
                        }
                    }


                }else {


                    HttpPost httppost = new HttpPost("http://ej30827.000webhostapp.com/family_D_M_PB_NO_P_NO.php");
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("txtAccount", Mfamilys.get(position).getFamily_account()));
                    nameValuePairs.add(new BasicNameValuePair("txtName", family_nameTxt.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("txtPName", patient_nameTxt.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("txtGender", toString().valueOf(family_gender)));
                    nameValuePairs.add(new BasicNameValuePair("txtPGender", toString().valueOf(patient_gender)));
                    nameValuePairs.add(new BasicNameValuePair("txtPBlood", patient_blood));
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
                        Toast.makeText(c, "資料修改成功", Toast.LENGTH_SHORT).show();
                        //返回功能頁面
                        Intent intent = new Intent(c.getApplicationContext(), family_function.class);
                        //new一個Bundle物件，並將要傳遞的資料傳入
                        Bundle bundle = new Bundle();
                        bundle.putString("name", family_nameTxt.getText().toString());
                        bundle.putString("account", Mfamilys.get(position).getFamily_account());
                        //將Bundle物件assign給intent
                        intent.putExtras(bundle);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        c.getApplicationContext().startActivity(intent);
                        family_modify.ActivityA.finish();
                    }
                    else if(result.equals("familyfailed")){
                        Toast.makeText(c, "家屬資料修改失敗", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(c, "資料修改失敗", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });



        return convertView;
    }


}
