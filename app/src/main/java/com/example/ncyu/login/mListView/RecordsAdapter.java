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
import com.example.ncyu.login.mDataObject.records;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/8/21.
 */
public class RecordsAdapter extends BaseAdapter implements Filterable {
    Context c;
    ArrayList<records> scoreses;
    LayoutInflater inflater;
    private ArrayList<records> SOriginalvalues;
    private MyFilter filter;
    public static int testID = 0;
    public static int scaleID = 0;

    public RecordsAdapter(Context c, ArrayList<records> scoreses) {
        this.c = c;
        this.scoreses = scoreses;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public RecordsAdapter() {

    }

    @Override
    public int getCount() {
        return scoreses.size();
    }

    @Override
    public Object getItem(int position) {
        return scoreses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return scoreses.get(position).getTestID();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView =inflater.inflate(R.layout.records_model,parent,false);

        }

            TextView tv_test_number=(TextView)convertView.findViewById(R.id.tv_test_number);
            TextView tv_end_test_time=(TextView)convertView.findViewById(R.id.tv_end_test_time);
            TextView tv_scale_name=(TextView)convertView.findViewById(R.id.tv_scale_name);



        tv_test_number.setText(String.valueOf(scoreses.get(position).getTestID()));
        tv_end_test_time.setText(scoreses.get(position).getEnd_test_time());

        if(scoreses.get(position).getScaleID() == 1){
            tv_scale_name.setText("AD-8");
        }
        else if(scoreses.get(position).getScaleID() == 2){
            tv_scale_name.setText("CDR");
        }
        else if(scoreses.get(position).getScaleID() == 3){
            tv_scale_name.setText("MMSE");
        }
        else if(scoreses.get(position).getScaleID()== 4){
            tv_scale_name.setText("MOCA");
        }
        else if(scoreses.get(position).getScaleID() == 5){
            tv_scale_name.setText("NPI-Q");
        }else{
            tv_scale_name.setText("錯誤");
        }



        //ITEM CLICKS
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testID= scoreses.get(position).getTestID();
                scaleID=scoreses.get(position).getScaleID();
                Toast.makeText(c,"量表編號："+testID,Toast.LENGTH_SHORT).show();
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
    public void setScaleID(Integer X) {
         scaleID = X ;
    }
    public int  getScaleID() {
        return scaleID;
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
            if(SOriginalvalues == null){
                synchronized (this) {
                    SOriginalvalues = new ArrayList<records>(scoreses);
                }
            }

            if(constraint !=null && constraint.toString().length() > 0){
                ArrayList<records> filteredItems = new ArrayList<records>();
                for(int i = 0, l = SOriginalvalues.size() ; i < l ; i ++){
                    records s =SOriginalvalues.get(i);
                    if(s.getEnd_test_time().contains(constraint)){
                        filteredItems.add(s);
                    }
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }else{
                synchronized (this){
                    ArrayList<records> list = new ArrayList<records>(SOriginalvalues);
                    result.values = list;
                    result.count = list.size();
                }
            }
            return result;
        }

        //把篩選結果Publish的函式
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            scoreses = (ArrayList<records>)filterResults.values;
            if(filterResults.count>0){
                notifyDataSetChanged();
            }
            else{
                notifyDataSetInvalidated();
            }
        }
    }
}
