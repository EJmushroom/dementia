package com.example.ncyu.login.mListView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.R;
import com.example.ncyu.login.doctor_one_kind_scale;
import com.example.ncyu.login.doctor_one_patient_data;
import com.example.ncyu.login.doctor_result_control;
import com.example.ncyu.login.mDataObject.one_patient;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/17.
 */
public class OnePatientAdapter extends BaseAdapter {
    Context c;
    ArrayList<one_patient> one_patients;
    LayoutInflater inflater;
    int whichScale=-1;

    public OnePatientAdapter(Context c, ArrayList<one_patient> one_patients) {
        this.c = c;
        this.one_patients = one_patients;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return one_patients.size();
    }

    @Override
    public Object getItem(int position) {
        return one_patients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return one_patients.get(position).getPatient_number();
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.one_patient_model, parent, false);

        }


        TextView tv_patient_number = (TextView) convertView.findViewById(R.id.tv_patient_number);
        TextView tv_patient_name = (TextView) convertView.findViewById(R.id.tv_patient_name);
        TextView tv_patient_gender = (TextView) convertView.findViewById(R.id.tv_patient_gender);
        TextView tv_patient_birthday = (TextView) convertView.findViewById(R.id.tv_patient_birthday);
        TextView tv_patient_blood = (TextView) convertView.findViewById(R.id.tv_patient_blood);
        final TextView tv_doctor_which_scale=(TextView)convertView.findViewById(R.id.tv_doctor_which_scale);

        ImageButton btn_back_DRC =(ImageButton)convertView.findViewById(R.id.btn_back_DRC);
        ImageButton btn_AD8=(ImageButton)convertView.findViewById(R.id.btn_AD8);
        ImageButton btn_CDR=(ImageButton)convertView.findViewById(R.id.btn_CDR);
        ImageButton btn_MMSE=(ImageButton)convertView.findViewById(R.id.btn_MMSE);
        ImageButton btn_MOCA=(ImageButton)convertView.findViewById(R.id.btn_MOCA);
        ImageButton btn_NPI_Q=(ImageButton)convertView.findViewById(R.id.btn_NPI_Q);
        ImageButton btn_enter_test_data=(ImageButton)convertView.findViewById(R.id.btn_enter_test_data);

        btn_enter_test_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(whichScale>=1 && whichScale<=5){
                    Intent intent=new Intent(c.getApplicationContext(),doctor_one_kind_scale.class);
                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();
                    bundle.putString("name",doctor_result_control.getName());
                    bundle.putString("account",doctor_result_control.getAccount());
                    bundle.putString("PID",String.valueOf(one_patients.get(position).getPatient_number()));
                    bundle.putString("SID",toString().valueOf(whichScale));
                    // /將Bundle物件assign給intent
                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    c.getApplicationContext().startActivity(intent);
                    doctor_one_patient_data.ActivityDOPD.finish();
                }
                else {
                    tv_doctor_which_scale.setText("請先選擇量表種類！");
                }
            }
        });

        //按下AD8後
        btn_AD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichScale =1;
                tv_doctor_which_scale.setText("AD-8 極早期失智症篩檢量表");
            }
        });

        //按下CDR後
        btn_CDR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichScale = 2;
                tv_doctor_which_scale.setText("CDR  臨床失智評估量表");
            }
        });

        //按下MMSE後
        btn_MMSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichScale = 3;
                tv_doctor_which_scale.setText("MMSE  臨床失智評估量表");
            }
        });

        //按下MOCA後
        btn_MOCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichScale = 4;
                tv_doctor_which_scale.setText("MOCA 蒙特利爾認知評估");
            }
        });

        //按下NPIQ後
        btn_NPI_Q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichScale = 5;
                tv_doctor_which_scale.setText("NPI-Q 腦精神科徵狀問卷");
            }
        });

        tv_patient_number.setText(String.valueOf(one_patients.get(position).getPatient_number()));
        tv_patient_name.setText(one_patients.get(position).getPatient_name());
        tv_patient_birthday.setText(one_patients.get(position).getPatient_birthday());
        tv_patient_blood.setText(one_patients.get(position).getPatient_blood());
        if (one_patients.get(position).getPatient_gender() == 1) {
            tv_patient_gender.setText("男");
        } else if (one_patients.get(position).getPatient_gender() == 2) {
            tv_patient_gender.setText("女");
        } else {
            tv_patient_gender.setText("");
        }

        btn_back_DRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //返回醫師量表管理頁面
                Intent intent=new Intent(c.getApplicationContext(),doctor_result_control.class);
                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("name",doctor_result_control.getName());
                bundle.putString("account",doctor_result_control.getAccount());
                // /將Bundle物件assign給intent
                intent.putExtras(bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.getApplicationContext().startActivity(intent);
                doctor_one_patient_data.ActivityDOPD.finish();
            }
        });


        return convertView;
    }
}
