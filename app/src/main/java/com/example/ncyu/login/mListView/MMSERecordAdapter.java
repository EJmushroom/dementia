package com.example.ncyu.login.mListView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ncyu.login.R;
import com.example.ncyu.login.mDataObject.mmseRecord;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/10/22.
 */

public class MMSERecordAdapter extends BaseAdapter {
    Context c;
    ArrayList<mmseRecord> mmseRecords;
    LayoutInflater inflater;

    public MMSERecordAdapter(Context c, ArrayList<mmseRecord> mmseRecords) {
        this.c = c;
        this.mmseRecords = mmseRecords;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mmseRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return mmseRecords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.mmse_record_model, parent, false);
        }

        ImageView img_Pdraw=(ImageView)convertView.findViewById(R.id.img_Pdraw);
        TextView tv_q1score=(TextView)convertView.findViewById(R.id.tv_q1score);
        TextView tv_q1YearType=(TextView)convertView.findViewById(R.id.tv_q1YearType);
        TextView tv_q1Year=(TextView)convertView.findViewById(R.id.tv_q1Year);
        TextView tv_q1Month=(TextView)convertView.findViewById(R.id.tv_q1Month);
        TextView tv_q1Monthtxt=(TextView)convertView.findViewById(R.id.tv_q1Monthtxt);
        TextView tv_q1Day=(TextView)convertView.findViewById(R.id.tv_q1Day);
        TextView tv_q1Daytxt=(TextView)convertView.findViewById(R.id.tv_q1Daytxt);
        TextView tv_q1Weekdaytxt=(TextView)convertView.findViewById(R.id.tv_q1Weekdaytxt);
        TextView tv_q1Weekday=(TextView)convertView.findViewById(R.id.tv_q1Weekday);
        TextView tv_q1a2quiz=(TextView)convertView.findViewById(R.id.tv_q1a2quiz);
        TextView tv_q1a2answer=(TextView)convertView.findViewById(R.id.tv_q1a2answer);
        TextView tv_q2score=(TextView)convertView.findViewById(R.id.tv_q2score);
        TextView tv_q2quiz1=(TextView)convertView.findViewById(R.id.tv_q2quiz1);
        TextView tv_q2quiz1A=(TextView)convertView.findViewById(R.id.tv_q2quiz1A);
        TextView tv_q2quiz2=(TextView)convertView.findViewById(R.id.tv_q2quiz2);
        TextView tv_q2quiz2A=(TextView)convertView.findViewById(R.id.tv_q2quiz2A);
        TextView tv_q2quiz3=(TextView)convertView.findViewById(R.id.tv_q2quiz3);
        TextView tv_q2quiz3A=(TextView)convertView.findViewById(R.id.tv_q2quiz3A);
        TextView tv_q2quiz4=(TextView)convertView.findViewById(R.id.tv_q2quiz4);
        TextView tv_q2quiz4A=(TextView)convertView.findViewById(R.id.tv_q2quiz4A);
        TextView tv_q2quiz5=(TextView)convertView.findViewById(R.id.tv_q2quiz5);
        TextView tv_q2quiz5A=(TextView)convertView.findViewById(R.id.tv_q2quiz5A);
        TextView tv_q3score=(TextView)convertView.findViewById(R.id.tv_q3score);
        TextView tv_q3word1=(TextView)convertView.findViewById(R.id.tv_q3word1);
        TextView tv_q3A1=(TextView)convertView.findViewById(R.id.tv_q3A1);
        TextView tv_q3word2=(TextView)convertView.findViewById(R.id.tv_q3word2);
        TextView tv_q3A2=(TextView)convertView.findViewById(R.id.tv_q3A2);
        TextView tv_q3word3=(TextView)convertView.findViewById(R.id.tv_q3word3);
        TextView tv_q3A3=(TextView)convertView.findViewById(R.id.tv_q3A3);
        TextView tv_q4score=(TextView)convertView.findViewById(R.id.tv_q4score);
        TextView q4A1=(TextView)convertView.findViewById(R.id.q4A1);
        TextView q4A2=(TextView)convertView.findViewById(R.id.q4A2);
        TextView q4A3=(TextView)convertView.findViewById(R.id.q4A3);
        TextView q4A4=(TextView)convertView.findViewById(R.id.q4A4);
        TextView q4A5=(TextView)convertView.findViewById(R.id.q4A5);
        TextView tv_q5score=(TextView)convertView.findViewById(R.id.tv_q5score);
        TextView q5W1=(TextView)convertView.findViewById(R.id.q5W1);
        TextView tv_q5A1=(TextView)convertView.findViewById(R.id.tv_q5A1);
        TextView q5W2=(TextView)convertView.findViewById(R.id.q5W2);
        TextView tv_q5A2=(TextView)convertView.findViewById(R.id.tv_q5A2);
        TextView q5W3=(TextView)convertView.findViewById(R.id.q5W3);
        TextView tv_q5A3=(TextView)convertView.findViewById(R.id.tv_q5A3);
        TextView tv_q6score=(TextView)convertView.findViewById(R.id.tv_q6score);
        TextView tv_q6a1W1=(TextView)convertView.findViewById(R.id.tv_q6a1W1);
        TextView tv_q6a1W2=(TextView)convertView.findViewById(R.id.tv_q6a1W2);
        TextView tv_q6a2W=(TextView)convertView.findViewById(R.id.tv_q6a2W);
        TextView tv_q6a2A=(TextView)convertView.findViewById(R.id.tv_q6a2A);
        TextView tv_q6a3Q=(TextView)convertView.findViewById(R.id.tv_q6a3Q);
        TextView tv_q6a3A=(TextView)convertView.findViewById(R.id.tv_q6a3A);
        TextView tv_q6a4A=(TextView)convertView.findViewById(R.id.tv_q6a4A);
        TextView tv_q7score=(TextView)convertView.findViewById(R.id.tv_q7score);
        TextView tv_q7A=(TextView)convertView.findViewById(R.id.tv_q7A);
        TextView tv_q8score=(TextView)convertView.findViewById(R.id.tv_q8score);
        TextView tv_q8W1=(TextView)convertView.findViewById(R.id.tv_q8W1);
        TextView tv_q8W2=(TextView)convertView.findViewById(R.id.tv_q8W2);
        TextView tv_q8W3=(TextView)convertView.findViewById(R.id.tv_q8W3);
        TextView tv_MMSE_total_score=(TextView)convertView.findViewById(R.id.tv_MMSE_total_score);
        TextView tv_MMSE_comment=(TextView)convertView.findViewById(R.id.tv_MMSE_comment);


        //一、定向感
        tv_q1score.setText(toString().valueOf((mmseRecords.get(position).getQ1a1score()+mmseRecords.get(position).getQ1a2score())));
        //年
        if(mmseRecords.get(position).getQ1a1dAyear()==0 && !mmseRecords.get(position).getQ1a1A1().equals("")){
            tv_q1YearType.setText(mmseRecords.get(position).getQ1a1atype());
            tv_q1Year.setText(mmseRecords.get(position).getQ1a1A1());
        }
        else{
            tv_q1YearType.setVisibility(View.GONE);
            tv_q1Year.setText("受測者無法回答");
        }

        //月
        if(mmseRecords.get(position).getQ1a1dAmonth()==0 && !mmseRecords.get(position).getQ1a1A2().equals("")){
            tv_q1Month.setText(mmseRecords.get(position).getQ1a1A2());
        }
        else{

            tv_q1Month.setText("X");
            tv_q1Month.setTextColor(convertView.getResources().getColor(R.color.red));
        }

        //號
        if(mmseRecords.get(position).getQ1a1dAday()==0 && !mmseRecords.get(position).getQ1a1A3().equals("")){
            tv_q1Day.setText(mmseRecords.get(position).getQ1a1A3());
        }
        else{
            tv_q1Day.setText("X");
            tv_q1Day.setTextColor(convertView.getResources().getColor(R.color.red));
        }

        //星期幾
        if(mmseRecords.get(position).getQ1a1dAweekday()==0 && !mmseRecords.get(position).getQ1a1A4().equals("")){
            tv_q1Weekday.setText(mmseRecords.get(position).getQ1a1A4());
        }
        else{
            tv_q1Weekday.setText("X");
            tv_q1Weekday.setTextColor(convertView.getResources().getColor(R.color.red));
        }

        //1.2
        tv_q1a2quiz.setText("3."+mmseRecords.get(position).getQ1a2quiz());
        if(mmseRecords.get(position).getQ1a2dA()==0 && !mmseRecords.get(position).getQ1a2A().equals("")){
           tv_q1a2answer.setText(mmseRecords.get(position).getQ1a2A());
        }
        else{
            tv_q1a2answer.setText("受測者無法回答");
        }

        //地點定向力
        tv_q2score.setText(toString().valueOf(mmseRecords.get(position).getQ2score()));

        //五個題目
        String q2quiz[]=convertView.getResources().getStringArray(R.array.quiz2_quiz);

        for(int i=1,j=1;i<=5;i++){ // i 是顯示在手機上的第?題 ， j 是目前要輪到的題目號
            //第1題
            if(i==1){
                //1
                if(mmseRecords.get(position).getQ2aisA1()==1){
                    tv_q2quiz1.setText(q2quiz[0]);
                    if(mmseRecords.get(position).getQ2adA1()==0){
                        tv_q2quiz1A.setText(mmseRecords.get(position).getQ2A1());
                    }
                    else{
                        tv_q2quiz1A.setText("受測者無法回答");
                    }
                    j=2;
                    continue;
                }
                //2
                if(mmseRecords.get(position).getQ2aisA2()==1){
                    tv_q2quiz1.setText(q2quiz[1]);
                    if(mmseRecords.get(position).getQ2adA2()==0){
                        tv_q2quiz1A.setText(mmseRecords.get(position).getQ2A2());
                    }
                    else{
                        tv_q2quiz1A.setText("受測者無法回答");
                    }
                    j=3;
                    continue;
                }
                //3
                if(mmseRecords.get(position).getQ2aisA3()==1){
                    tv_q2quiz1.setText(q2quiz[2]);
                    if(mmseRecords.get(position).getQ2adA3()==0){
                        tv_q2quiz1A.setText(mmseRecords.get(position).getQ2A3());
                    }
                    else{
                        tv_q2quiz1A.setText("受測者無法回答");
                    }
                    j=4;
                    continue;
                }
                //4
                if(mmseRecords.get(position).getQ2aisA4()==1){
                    tv_q2quiz1.setText(q2quiz[3]);
                    if(mmseRecords.get(position).getQ2adA4()==0){
                        tv_q2quiz1A.setText(mmseRecords.get(position).getQ2A4());
                    }
                    else{
                        tv_q2quiz1A.setText("受測者無法回答");
                    }
                    j=5;
                    continue;
                }
            }
            //第2題
            if(i==2){
                //從第2題開始試
                if(j==2){
                    if(mmseRecords.get(position).getQ2aisA2()==1){
                        tv_q2quiz2.setText(q2quiz[1]);
                        if(mmseRecords.get(position).getQ2adA2()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A2());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=3;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA3()==1){
                        tv_q2quiz2.setText(q2quiz[2]);
                        if(mmseRecords.get(position).getQ2adA3()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A3());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=4;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA4()==1){
                        tv_q2quiz2.setText(q2quiz[3]);
                        if(mmseRecords.get(position).getQ2adA4()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A4());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz2.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                }
                if(j==3){
                    if(mmseRecords.get(position).getQ2aisA3()==1){
                        tv_q2quiz2.setText(q2quiz[2]);
                        if(mmseRecords.get(position).getQ2adA3()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A3());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=4;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA4()==1){
                        tv_q2quiz2.setText(q2quiz[3]);
                        if(mmseRecords.get(position).getQ2adA4()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A4());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz2.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                }
                if(j==4){
                    if(mmseRecords.get(position).getQ2aisA4()==1){
                        tv_q2quiz2.setText(q2quiz[3]);
                        if(mmseRecords.get(position).getQ2adA4()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A4());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz2.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                }
                if(j==5){
                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz2.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz2A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                }
            }
            //第3題
            if(i==3){
                //從第3題開始試
                if(j==3){
                    if(mmseRecords.get(position).getQ2aisA3()==1){
                        tv_q2quiz3.setText(q2quiz[2]);
                        if(mmseRecords.get(position).getQ2adA3()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A3());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=4;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA4()==1){
                        tv_q2quiz3.setText(q2quiz[3]);
                        if(mmseRecords.get(position).getQ2adA4()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A4());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz3.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA6()==1){
                        tv_q2quiz3.setText(q2quiz[5]);
                        if(mmseRecords.get(position).getQ2adA6()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A6());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                }
                if(j==4){
                    if(mmseRecords.get(position).getQ2aisA4()==1){
                        tv_q2quiz3.setText(q2quiz[3]);
                        if(mmseRecords.get(position).getQ2adA4()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A4());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz3.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA6()==1){
                        tv_q2quiz3.setText(q2quiz[5]);
                        if(mmseRecords.get(position).getQ2adA6()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A6());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                }
                if(j==5){
                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz3.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA6()==1){
                        tv_q2quiz3.setText(q2quiz[5]);
                        if(mmseRecords.get(position).getQ2adA6()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A6());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                }
                if(j==6){
                    if(mmseRecords.get(position).getQ2aisA6()==1){
                        tv_q2quiz3.setText(q2quiz[5]);
                        if(mmseRecords.get(position).getQ2adA6()==0){
                            tv_q2quiz3A.setText(mmseRecords.get(position).getQ2A6());
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                }
            }
            //第4題
            if(i==4){
                //從第4題開始試
                if(j==4){
                    if(mmseRecords.get(position).getQ2aisA4()==1){
                        tv_q2quiz4.setText(q2quiz[3]);
                        if(mmseRecords.get(position).getQ2adA4()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A4());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }

                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz4.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA6()==1){
                        tv_q2quiz4.setText(q2quiz[5]);
                        if(mmseRecords.get(position).getQ2adA6()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A6());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA7()==1){
                        tv_q2quiz4.setText(q2quiz[6]);
                        if(mmseRecords.get(position).getQ2adA7()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A7());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=8;
                        continue;
                    }
                }
                if(j==5){
                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz4.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA6()==1){
                        tv_q2quiz4.setText(q2quiz[5]);
                        if(mmseRecords.get(position).getQ2adA6()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A6());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA7()==1){
                        tv_q2quiz4.setText(q2quiz[6]);
                        if(mmseRecords.get(position).getQ2adA7()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A7());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=8;
                        continue;
                    }
                }
                if(j==6){
                    if(mmseRecords.get(position).getQ2aisA6()==1){
                        tv_q2quiz4.setText(q2quiz[5]);
                        if(mmseRecords.get(position).getQ2adA6()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A6());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA7()==1){
                        tv_q2quiz4.setText(q2quiz[6]);
                        if(mmseRecords.get(position).getQ2adA7()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A7());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=8;
                        continue;
                    }
                }
                if(j==7){
                    if(mmseRecords.get(position).getQ2aisA7()==1){
                        tv_q2quiz4.setText(q2quiz[6]);
                        if(mmseRecords.get(position).getQ2adA7()==0){
                            tv_q2quiz4A.setText(mmseRecords.get(position).getQ2A7());
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=8;
                        continue;
                    }
                }
            }
            //第5題
            if(i==5){
                //從第5題開始試
                if(j==5){
                    if(mmseRecords.get(position).getQ2aisA5()==1){
                        tv_q2quiz5.setText(q2quiz[4]);
                        if(mmseRecords.get(position).getQ2adA5()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A5());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA6()==1){
                        tv_q2quiz5.setText(q2quiz[5]);
                        if(mmseRecords.get(position).getQ2adA6()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A6());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA7()==1){
                        tv_q2quiz5.setText(q2quiz[6]);
                        if(mmseRecords.get(position).getQ2adA7()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A7());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA8()==1){
                        tv_q2quiz5.setText(q2quiz[7]);
                        if(mmseRecords.get(position).getQ2adA8()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A8());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                }
                if(j==6){
                    if(mmseRecords.get(position).getQ2aisA6()==1){
                        tv_q2quiz5.setText(q2quiz[5]);
                        if(mmseRecords.get(position).getQ2adA6()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A6());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA7()==1){
                        tv_q2quiz5.setText(q2quiz[6]);
                        if(mmseRecords.get(position).getQ2adA7()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A7());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA8()==1){
                        tv_q2quiz5.setText(q2quiz[7]);
                        if(mmseRecords.get(position).getQ2adA8()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A8());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                }
                if(j==7){
                    if(mmseRecords.get(position).getQ2aisA7()==1){
                        tv_q2quiz5.setText(q2quiz[6]);
                        if(mmseRecords.get(position).getQ2adA7()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A7());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(mmseRecords.get(position).getQ2aisA8()==1){
                        tv_q2quiz5.setText(q2quiz[7]);
                        if(mmseRecords.get(position).getQ2adA8()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A8());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                }
                if(j==8){
                    if(mmseRecords.get(position).getQ2aisA8()==1){
                        tv_q2quiz5.setText(q2quiz[7]);
                        if(mmseRecords.get(position).getQ2adA8()==0){
                            tv_q2quiz5A.setText(mmseRecords.get(position).getQ2A8());
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                }
            }
        }

        //訊息登入
        tv_q3score.setText(toString().valueOf(mmseRecords.get(position).getQ3score()));
        tv_q3word1.setText(mmseRecords.get(position).getQ3wB1());
        tv_q3word2.setText(mmseRecords.get(position).getQ3wB2());
        tv_q3word3.setText(mmseRecords.get(position).getQ3wB3());
        if(mmseRecords.get(position).getQ3w1()==0){
            tv_q3A1.setText("(O)");
        }
        else{
            tv_q3A1.setText("(X)");
        }
        if(mmseRecords.get(position).getQ3w2()==0){
            tv_q3A2.setText("(O)");
        }
        else{
            tv_q3A2.setText("(X)");
        }
        if(mmseRecords.get(position).getQ3w3()==0){
            tv_q3A3.setText("(O)");
        }
        else{
            tv_q3A3.setText("(X)");
        }

        //注意力及計算能力
        tv_q4score.setText(toString().valueOf(mmseRecords.get(position).getQ4score()));
        q4A1.setText(mmseRecords.get(position).getQ4A1());
        q4A2.setText(mmseRecords.get(position).getQ4A2());
        q4A3.setText(mmseRecords.get(position).getQ4A3());
        q4A4.setText(mmseRecords.get(position).getQ4A4());
        q4A5.setText(mmseRecords.get(position).getQ4A5());

        //記憶力
        tv_q5score.setText(toString().valueOf(mmseRecords.get(position).getQ5score()));
        q5W1.setText(mmseRecords.get(position).getQ3wB1());
        q5W2.setText(mmseRecords.get(position).getQ3wB2());
        q5W3.setText(mmseRecords.get(position).getQ3wB3());

        if(mmseRecords.get(position).getQ5w1()==0){
            tv_q5A1.setText("(O)");
        }
        else{
            tv_q5A1.setText("(X)");
        }
        if(mmseRecords.get(position).getQ5w2()==0){
            tv_q5A2.setText("(O)");
        }
        else{
            tv_q5A2.setText("(X)");
        }
        if(mmseRecords.get(position).getQ5w3()==0){
            tv_q5A3.setText("(O)");
        }
        else{
            tv_q5A3.setText("(X)");
        }

        //語言理解
        tv_q6score.setText(toString().valueOf(mmseRecords.get(position).getQ6score()));
        if(!mmseRecords.get(position).getQ6a1w1().equals("")){
            tv_q6a1W1.setText(mmseRecords.get(position).getQ6a1w1());
        }
        else{
            tv_q6a1W1.setText("受測者無法回答");
        }
        if(!mmseRecords.get(position).getQ6a1w2().equals("")){
            tv_q6a1W2.setText(mmseRecords.get(position).getQ6a1w2());
        }
        else{
            tv_q6a1W2.setText("受測者無法回答");
        }

        tv_q6a2W.setText(mmseRecords.get(position).getQ6a2w());
        if(mmseRecords.get(position).getQ6a2A()==0){
            tv_q6a2A.setText("(O)");
        }
        else{
            tv_q6a2A.setText("(X)");
        }

        tv_q6a3Q.setText(mmseRecords.get(position).getQ6a3quiz());
        if(mmseRecords.get(position).getQ6a3A()==0){
            tv_q6a3A.setText("(O)");
        }
        else{
            tv_q6a3A.setText("(X)");
        }

        if(!mmseRecords.get(position).getQ6a4A().equals("")) {
            tv_q6a4A.setText(mmseRecords.get(position).getQ6a4A());
        }
        else{
            tv_q6a4A.setText("受測者無法回答");
        }

        //空間概念


        //顯示受測者所繪圖片
        byte[] bytearrayImage= Base64.decode(mmseRecords.get(position).getPdraw(), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytearrayImage, 0, bytearrayImage.length);
        // 受測者的图片的宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        // 设置想要的大小
        //取得原本圖片寬高
        Bitmap originalBmp = BitmapFactory.decodeResource(convertView.getResources(), R.drawable.quiz9_draw);
        int oHeight = originalBmp.getHeight();
        int oWidth = originalBmp.getWidth();

        // 计算缩放比例
        float scaleWidth = ((float) oWidth) / width;
        float scaleHeight = ((float) oHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

        img_Pdraw.setImageBitmap(newbitmap);

        tv_q7score.setText(toString().valueOf(mmseRecords.get(position).getQ7score()));
        if(mmseRecords.get(position).getQ7A()==0){
            tv_q7A.setText("(O)");
        }
        else{
            tv_q7A.setText("(X)");
        }

        //操作能力
        tv_q8score.setText(toString().valueOf(mmseRecords.get(position).getQ8score()));
        if(mmseRecords.get(position).getQ8w1()==0) {
            tv_q8W1.setText("(O)");
        }
        else{
            tv_q8W1.setText("(X)");
        }
        if(mmseRecords.get(position).getQ8w2()==0) {
            tv_q8W2.setText("(O)");
        }
        else{
            tv_q8W2.setText("(X)");
        }
        if(mmseRecords.get(position).getQ8w3()==0) {
            tv_q8W3.setText("(O)");
        }
        else{
            tv_q8W3.setText("(X)");
        }

        tv_MMSE_total_score.setText(toString().valueOf(mmseRecords.get(position).getMMSE_total_score()));

        if(mmseRecords.get(position).getMMSE_total_score()<=30 && mmseRecords.get(position).getMMSE_total_score()>=24) {
            tv_MMSE_comment.setText("認知功能正常");
        }
        else if(mmseRecords.get(position).getMMSE_total_score()<=23 && mmseRecords.get(position).getMMSE_total_score()>=18) {
            tv_MMSE_comment.setText("輕度認知功能障礙\n建議至鄰近醫院做更進一步的診療");
        }
        else if(mmseRecords.get(position).getMMSE_total_score()<=17 && mmseRecords.get(position).getMMSE_total_score()>=0) {
            tv_MMSE_comment.setText("重度認知功能障礙\n建議至鄰近醫院做更進一步的診療！");
        }
        else{
            tv_MMSE_comment.setText("系統錯誤！");
        }










        return convertView;
    }

}
