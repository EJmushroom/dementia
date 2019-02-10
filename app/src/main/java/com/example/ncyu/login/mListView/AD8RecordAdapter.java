package com.example.ncyu.login.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ncyu.login.R;
import com.example.ncyu.login.mDataObject.ad8Record;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/9/6.
 */

public class AD8RecordAdapter extends BaseAdapter {
    Context c;
    ArrayList<ad8Record> ad8Records;
    LayoutInflater inflater;

    public AD8RecordAdapter(Context c, ArrayList<ad8Record> ad8Records) {
        this.c = c;
        this.ad8Records = ad8Records;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return ad8Records.size();
    }

    @Override
    public Object getItem(int position) {
        return ad8Records.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.ad8_record_model, parent, false);
        }
        TextView tv_has_changed1=(TextView)convertView.findViewById(R.id.tv_has_changed1);
        TextView tv_has_changed2=(TextView)convertView.findViewById(R.id.tv_has_changed2);
        TextView tv_has_changed3=(TextView)convertView.findViewById(R.id.tv_has_changed3);
        TextView tv_has_changed4=(TextView)convertView.findViewById(R.id.tv_has_changed4);
        TextView tv_has_changed5=(TextView)convertView.findViewById(R.id.tv_has_changed5);
        TextView tv_has_changed6=(TextView)convertView.findViewById(R.id.tv_has_changed6);
        TextView tv_has_changed7=(TextView)convertView.findViewById(R.id.tv_has_changed7);
        TextView tv_has_changed8=(TextView)convertView.findViewById(R.id.tv_has_changed8);
        TextView tv_ad8_total_score=(TextView)convertView.findViewById(R.id.tv_ad8_total_score);
        TextView tv_ad8_comment=(TextView)convertView.findViewById(R.id.tv_ad8_comment);

        if(ad8Records.get(position).getQ1()==0){
            tv_has_changed1.setText("無改變");
        }
        else if(ad8Records.get(position).getQ1()==1){
            tv_has_changed1.setText("有改變");
        }
        else if(ad8Records.get(position).getQ1()==2){
            tv_has_changed1.setText("不知道");
        }
        else {
            tv_has_changed1.setText("錯誤!");
        }

        if(ad8Records.get(position).getQ2()==0){
            tv_has_changed2.setText("無改變");
        }
        else if(ad8Records.get(position).getQ2()==1){
            tv_has_changed2.setText("有改變");
        }
        else if(ad8Records.get(position).getQ2()==2){
            tv_has_changed2.setText("不知道");
        }
        else {
            tv_has_changed2.setText("錯誤!");
        }

        if(ad8Records.get(position).getQ3()==0){
            tv_has_changed3.setText("無改變");
        }
        else if(ad8Records.get(position).getQ3()==1){
            tv_has_changed3.setText("有改變");
        }
        else if(ad8Records.get(position).getQ3()==2){
            tv_has_changed3.setText("不知道");
        }
        else {
            tv_has_changed3.setText("錯誤!");
        }

        if(ad8Records.get(position).getQ4()==0){
            tv_has_changed4.setText("無改變");
        }
        else if(ad8Records.get(position).getQ4()==1){
            tv_has_changed4.setText("有改變");
        }
        else if(ad8Records.get(position).getQ4()==2){
            tv_has_changed4.setText("不知道");
        }
        else {
            tv_has_changed4.setText("錯誤!");
        }

        if(ad8Records.get(position).getQ5()==0){
            tv_has_changed5.setText("無改變");
        }
        else if(ad8Records.get(position).getQ5()==1){
            tv_has_changed5.setText("有改變");
        }
        else if(ad8Records.get(position).getQ5()==2){
            tv_has_changed5.setText("不知道");
        }
        else {
            tv_has_changed5.setText("錯誤!");
        }

        if(ad8Records.get(position).getQ6()==0){
            tv_has_changed6.setText("無改變");
        }
        else if(ad8Records.get(position).getQ6()==1){
            tv_has_changed6.setText("有改變");
        }
        else if(ad8Records.get(position).getQ6()==2){
            tv_has_changed6.setText("不知道");
        }
        else {
            tv_has_changed6.setText("錯誤!");
        }

        if(ad8Records.get(position).getQ7()==0){
            tv_has_changed7.setText("無改變");
        }
        else if(ad8Records.get(position).getQ7()==1){
            tv_has_changed7.setText("有改變");
        }
        else if(ad8Records.get(position).getQ7()==2){
            tv_has_changed7.setText("不知道");
        }
        else {
            tv_has_changed7.setText("錯誤!");
        }

        if(ad8Records.get(position).getQ8()==0){
            tv_has_changed8.setText("無改變");
        }
        else if(ad8Records.get(position).getQ8()==1){
            tv_has_changed8.setText("有改變");
        }
        else if(ad8Records.get(position).getQ8()==2){
            tv_has_changed8.setText("不知道");
        }
        else {
            tv_has_changed8.setText("錯誤!");
        }

        tv_ad8_total_score.setText(toString().valueOf(ad8Records.get(position).getAD8_total_score()));

        if(ad8Records.get(position).getAD8_total_score()>=2){
            tv_ad8_comment.setText("建議到鄰近醫院做更進一步的檢查！");
        }
        else{
            tv_ad8_comment.setText("恭喜你，你是個正常人！");
        }
        return convertView;
    }
}
