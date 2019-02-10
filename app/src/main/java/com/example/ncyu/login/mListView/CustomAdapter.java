package com.example.ncyu.login.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.R;
import com.example.ncyu.login.mDataObject.scale;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/7/14.
 */
public class CustomAdapter extends BaseAdapter  {

    Context c;
    ArrayList<scale> scales;
    LayoutInflater inflater;
    public static int i = -1 ;

    public CustomAdapter(Context c, ArrayList<scale> scales) {
        this.c = c;
        this.scales = scales;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public CustomAdapter() {

    }

    @Override
    public int getCount() {
        return scales.size();
    }

    @Override
    public Object getItem(int position) {
        return scales.get(position);
    }

    @Override
    public long getItemId(int position) {
        return scales.get(position).getScaleID();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView =inflater.inflate(R.layout.scale_model,parent,false);

        }


        TextView scale_nameTxt=(TextView)convertView.findViewById(R.id.patient_nameTxt);
        TextView scale_estimated_timeTxt=(TextView)convertView.findViewById(R.id.family_nameTxt);
        TextView scale_total_pointsTxt=(TextView)convertView.findViewById(R.id.application_timeTxt);
        TextView scale_passing_scoreTxt=(TextView)convertView.findViewById(R.id.scale_passing_scoreTxt);

        scale_nameTxt.setText(scales.get(position).getScale_name());
        scale_estimated_timeTxt.setText(String.valueOf(scales.get(position).getScale_estimated_time())+" 分鐘");
        scale_total_pointsTxt.setText(String.valueOf(scales.get(position).getScale_total_points())+" 分");
        scale_passing_scoreTxt.setText(String.valueOf(scales.get(position).getScale_passing_score())+" 分");

        if((position+1)==5){
            scale_total_pointsTxt.setText("無");
            scale_passing_scoreTxt.setText("無");
        }


        //ITEM CLICKS
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c,scales.get(position).getScale_introduction(),Toast.LENGTH_LONG).show();
                i = position;
            }
        });

        return convertView;
    }
    public void setI(Integer X) {
        i = X;
    }
    public int  getI() {
        return i;
    }
}


