package com.example.ncyu.login.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.R;
import com.example.ncyu.login.mDataObject.patient;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/15.
 */
public class PatientAdapter extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<patient> patients;
    LayoutInflater inflater;
    private ArrayList<patient> POriginalvalues;
    private MyFilter filter;
    public static int i = 0;

    public PatientAdapter(Context c, ArrayList<patient> patients) {
        this.c = c;
        this.patients = patients;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public PatientAdapter() {

    }

    @Override
    public int getCount() {
        return patients.size();
    }

    @Override
    public Object getItem(int position) {
        return patients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return patients.get(position).getPatient_number();
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView =inflater.inflate(R.layout.patients_model,parent,false);

        }


        TextView tv_patient_number=(TextView)convertView.findViewById(R.id.tv_patient_number);
        TextView tv_patient_name=(TextView)convertView.findViewById(R.id.tv_patient_name);
        TextView tv_patient_gender=(TextView)convertView.findViewById(R.id.tv_patient_gender);
        TextView tv_patient_birthday=(TextView)convertView.findViewById(R.id.tv_patient_birthday);




        tv_patient_number.setText(String.valueOf(patients.get(position).getPatient_number()));
        tv_patient_name.setText(patients.get(position).getPatient_name());
        tv_patient_birthday.setText(patients.get(position).getPatient_birthday());
        if(patients.get(position).getPatient_gender()==1){
            tv_patient_gender.setText("男");
        }
        else if(patients.get(position).getPatient_gender()==2){
            tv_patient_gender.setText("女");
        }
        else{
            tv_patient_gender.setText("");
        }


        //ITEM CLICKS
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c,String.valueOf(patients.get(position).getPatient_number()),Toast.LENGTH_LONG).show();
                i = patients.get(position).getPatient_number();
            }
        });

        return convertView;
    }
    public void setI(Integer X) {
        X = i;
    }
    public int  getI() {
        return i;
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new MyFilter();
        }
        return filter;
    }

    private class MyFilter extends Filter{

        //實際做篩選的code(應是在不同thread進行)
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            constraint = constraint.toString();
            FilterResults result = new FilterResults();
            if(POriginalvalues == null){
                synchronized (this) {
                    POriginalvalues = new ArrayList<patient>(patients);
                }
            }

            if(constraint !=null && constraint.toString().length() > 0){
                ArrayList<patient> filteredItems = new ArrayList<patient>();
                for(int i = 0, l = POriginalvalues.size() ; i < l ; i ++){
                    patient p =POriginalvalues.get(i);
                    if(p.getPatient_name().contains(constraint)){
                        filteredItems.add(p);
                    }
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }else{
                synchronized (this){
                    ArrayList<patient> list = new ArrayList<patient>(POriginalvalues);
                    result.values = list;
                    result.count = list.size();
                }
            }
            return result;
        }

        //把篩選結果Publish的函式
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            patients = (ArrayList<patient>)filterResults.values;
            if(filterResults.count>0){
                notifyDataSetChanged();
            }
            else{
                notifyDataSetInvalidated();
            }
        }
    }
}
