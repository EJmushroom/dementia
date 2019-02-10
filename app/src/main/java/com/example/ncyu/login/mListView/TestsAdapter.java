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
import com.example.ncyu.login.doctor_one_kind_scale;
import com.example.ncyu.login.mDataObject.tests;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/20.
 */
public class TestsAdapter extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<tests> testses;
    LayoutInflater inflater;
    private ArrayList<tests> TOriginalvalues;
    private MyFilter filter;
    public static int testID = 0;

    public TestsAdapter(Context c, ArrayList<tests> testses) {
        this.c = c;
        this.testses = testses;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public TestsAdapter() {

    }

    @Override
    public int getCount() {
        return testses.size();
    }

    @Override
    public Object getItem(int position) {
        return testses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return testses.get(position).getTestID();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView =inflater.inflate(R.layout.test_time_model,parent,false);

        }


        TextView tv_testID=(TextView)convertView.findViewById(R.id.tv_testID);
        TextView tv_test_end_time=(TextView)convertView.findViewById(R.id.tv_test_end_time);
        tv_testID.setText(String.valueOf(testses.get(position).getTestID()));
        tv_test_end_time.setText(testses.get(position).getEnd_test_time());



        //ITEM CLICKS
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c,String.valueOf(testses.get(position).getTestID()),Toast.LENGTH_LONG).show();
                testID = testses.get(position).getTestID();
            }
        });

        return convertView;
    }
    public void setTestID(Integer X) {
        testID = X;
    }
    public int  getTestID() {
        return testID;
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
            if(TOriginalvalues == null){
                synchronized (this) {
                    TOriginalvalues = new ArrayList<tests>(testses);
                }
            }

            if(constraint !=null && constraint.toString().length() > 0){
                ArrayList<tests> filteredItems = new ArrayList<tests>();
                for(int i = 0, l = TOriginalvalues.size() ; i < l ; i ++){
                     tests t =TOriginalvalues.get(i);
                    if(t.getEnd_test_time().contains(constraint)){
                        filteredItems.add(t);
                    }
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }else{
                synchronized (this){
                    ArrayList<tests> list = new ArrayList<tests>(TOriginalvalues);
                    result.values = list;
                    result.count = list.size();
                }
            }
            return result;
        }

        //把篩選結果Publish的函式
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            testses = (ArrayList<tests>)filterResults.values;
            if(filterResults.count>0){
                notifyDataSetChanged();
            }
            else{
                notifyDataSetInvalidated();
            }
        }
    }
}
