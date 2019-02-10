package com.example.ncyu.login.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ncyu.login.R;
import com.example.ncyu.login.mDataObject.npiqRecord;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/9/18.
 */

public class NPIQRecordAdapter extends BaseAdapter {

    Context c;
    ArrayList<npiqRecord> npiqRecords;
    LayoutInflater inflater;

    public NPIQRecordAdapter(Context c, ArrayList<npiqRecord> npiqRecords) {
        this.c = c;
        this.npiqRecords = npiqRecords;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return npiqRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return npiqRecords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.npiq_record_model, parent, false);

            TextView tv_npiq_severity1=(TextView)convertView.findViewById(R.id.tv_npiq_severity1);
            TextView tv_npiq_severity2=(TextView)convertView.findViewById(R.id.tv_npiq_severity2);
            TextView tv_npiq_severity3=(TextView)convertView.findViewById(R.id.tv_npiq_severity3);
            TextView tv_npiq_severity4=(TextView)convertView.findViewById(R.id.tv_npiq_severity4);
            TextView tv_npiq_severity5=(TextView)convertView.findViewById(R.id.tv_npiq_severity5);
            TextView tv_npiq_severity6=(TextView)convertView.findViewById(R.id.tv_npiq_severity6);
            TextView tv_npiq_severity7=(TextView)convertView.findViewById(R.id.tv_npiq_severity7);
            TextView tv_npiq_severity8=(TextView)convertView.findViewById(R.id.tv_npiq_severity8);
            TextView tv_npiq_severity9=(TextView)convertView.findViewById(R.id.tv_npiq_severity9);
            TextView tv_npiq_severity10=(TextView)convertView.findViewById(R.id.tv_npiq_severity10);
            TextView tv_npiq_severity11=(TextView)convertView.findViewById(R.id.tv_npiq_severity11);
            TextView tv_npiq_severity12=(TextView)convertView.findViewById(R.id.tv_npiq_severity12);

            TextView tv_npiq_distress1=(TextView)convertView.findViewById(R.id.tv_npiq_distress1);
            TextView tv_npiq_distress2=(TextView)convertView.findViewById(R.id.tv_npiq_distress2);
            TextView tv_npiq_distress3=(TextView)convertView.findViewById(R.id.tv_npiq_distress3);
            TextView tv_npiq_distress4=(TextView)convertView.findViewById(R.id.tv_npiq_distress4);
            TextView tv_npiq_distress5=(TextView)convertView.findViewById(R.id.tv_npiq_distress5);
            TextView tv_npiq_distress6=(TextView)convertView.findViewById(R.id.tv_npiq_distress6);
            TextView tv_npiq_distress7=(TextView)convertView.findViewById(R.id.tv_npiq_distress7);
            TextView tv_npiq_distress8=(TextView)convertView.findViewById(R.id.tv_npiq_distress8);
            TextView tv_npiq_distress9=(TextView)convertView.findViewById(R.id.tv_npiq_distress9);
            TextView tv_npiq_distress10=(TextView)convertView.findViewById(R.id.tv_npiq_distress10);
            TextView tv_npiq_distress11=(TextView)convertView.findViewById(R.id.tv_npiq_distress11);
            TextView tv_npiq_distress12=(TextView)convertView.findViewById(R.id.tv_npiq_distress12);

            if(npiqRecords.get(position).getIf_wishful_thinking()){
                tv_npiq_severity1.setText(toString().valueOf(npiqRecords.get(position).getWishful_thinking_severity()));
                tv_npiq_distress1.setText(toString().valueOf(npiqRecords.get(position).getWishful_thinking_distress()));
            }
            else{
                tv_npiq_severity1.setText("無");
                tv_npiq_distress1.setText("無");
            }

            if(npiqRecords.get(position).getIf_illusion()){
                tv_npiq_severity2.setText(toString().valueOf(npiqRecords.get(position).getIllusion_severity()));
                tv_npiq_distress2.setText(toString().valueOf(npiqRecords.get(position).getIllusion_distress()));
            }
            else{
                tv_npiq_severity2.setText("無");
                tv_npiq_distress2.setText("無");
            }

            if(npiqRecords.get(position).getIf_attack()){
                tv_npiq_severity3.setText(toString().valueOf(npiqRecords.get(position).getAttack_severity()));
                tv_npiq_distress3.setText(toString().valueOf(npiqRecords.get(position).getAttack_distress()));
            }
            else{
                tv_npiq_severity3.setText("無");
                tv_npiq_distress3.setText("無");
            }

            if(npiqRecords.get(position).getIf_melancholy()){
                tv_npiq_severity4.setText(toString().valueOf(npiqRecords.get(position).getMelancholy_severity()));
                tv_npiq_distress4.setText(toString().valueOf(npiqRecords.get(position).getMelancholy_distress()));
            }
            else{
                tv_npiq_severity4.setText("無");
                tv_npiq_distress4.setText("無");
            }

            if(npiqRecords.get(position).getIf_anxious()){
                tv_npiq_severity5.setText(toString().valueOf(npiqRecords.get(position).getAnxious_severity()));
                tv_npiq_distress5.setText(toString().valueOf(npiqRecords.get(position).getAnxious_distress()));
            }
            else{
                tv_npiq_severity5.setText("無");
                tv_npiq_distress5.setText("無");
            }

            if(npiqRecords.get(position).getIf_happy()){
                tv_npiq_severity6.setText(toString().valueOf(npiqRecords.get(position).getHappy_severity()));
                tv_npiq_distress6.setText(toString().valueOf(npiqRecords.get(position).getHappy_distress()));
            }
            else{
                tv_npiq_severity6.setText("無");
                tv_npiq_distress6.setText("無");
            }

            if(npiqRecords.get(position).getIf_cold()){
                tv_npiq_severity7.setText(toString().valueOf(npiqRecords.get(position).getCold_severity()));
                tv_npiq_distress7.setText(toString().valueOf(npiqRecords.get(position).getCold_distress()));
            }
            else{
                tv_npiq_severity7.setText("無");
                tv_npiq_distress7.setText("無");
            }

            if(npiqRecords.get(position).getIf_out_of_control()){
                tv_npiq_severity8.setText(toString().valueOf(npiqRecords.get(position).getOut_of_control_severity()));
                tv_npiq_distress8.setText(toString().valueOf(npiqRecords.get(position).getOut_of_control_distress()));
            }
            else{
                tv_npiq_severity8.setText("無");
                tv_npiq_distress8.setText("無");
            }

            if(npiqRecords.get(position).getIf_easy_angry()){
                tv_npiq_severity9.setText(toString().valueOf(npiqRecords.get(position).getEasy_angry_severity()));
                tv_npiq_distress9.setText(toString().valueOf(npiqRecords.get(position).getEasy_angry_distress()));
            }
            else{
                tv_npiq_severity9.setText("無");
                tv_npiq_distress9.setText("無");
            }

            if(npiqRecords.get(position).getIf_weird_action()){
                tv_npiq_severity10.setText(toString().valueOf(npiqRecords.get(position).getWeird_action_severity()));
                tv_npiq_distress10.setText(toString().valueOf(npiqRecords.get(position).getWeird_action_distress()));
            }
            else{
                tv_npiq_severity10.setText("無");
                tv_npiq_distress10.setText("無");
            }

            if(npiqRecords.get(position).getIf_nighttime_behavior()){
                tv_npiq_severity11.setText(toString().valueOf(npiqRecords.get(position).getNighttime_behavior_severity()));
                tv_npiq_distress11.setText(toString().valueOf(npiqRecords.get(position).getNighttime_behavior_distress()));
            }
            else{
                tv_npiq_severity11.setText("無");
                tv_npiq_distress11.setText("無");
            }

            if(npiqRecords.get(position).getIf_appetite_diet_changed()){
                tv_npiq_severity12.setText(toString().valueOf(npiqRecords.get(position).getAppetite_diet_changed_severity()));
                tv_npiq_distress12.setText(toString().valueOf(npiqRecords.get(position).getAppetite_diet_changed_distress()));
            }
            else{
                tv_npiq_severity12.setText("無");
                tv_npiq_distress12.setText("無");
            }
        }

        return convertView;
    }

}

