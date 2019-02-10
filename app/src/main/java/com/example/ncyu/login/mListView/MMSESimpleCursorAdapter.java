package com.example.ncyu.login.mListView;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.ncyu.login.R;

/**
 * Created by Ncyu on 2017/10/25.
 */

public class MMSESimpleCursorAdapter extends SimpleCursorAdapter {

    public MMSESimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    };

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);

        ImageView img_Pdraw=(ImageView)view.findViewById(R.id.img_Pdraw);
        TextView tv_q1score=(TextView)view.findViewById(R.id.tv_q1score);
        TextView tv_q1YearType=(TextView)view.findViewById(R.id.tv_q1YearType);
        TextView tv_q1Year=(TextView)view.findViewById(R.id.tv_q1Year);
        TextView tv_q1Month=(TextView)view.findViewById(R.id.tv_q1Month);
        TextView tv_q1Monthtxt=(TextView)view.findViewById(R.id.tv_q1Monthtxt);
        TextView tv_q1Day=(TextView)view.findViewById(R.id.tv_q1Day);
        TextView tv_q1Daytxt=(TextView)view.findViewById(R.id.tv_q1Daytxt);
        TextView tv_q1Weekdaytxt=(TextView)view.findViewById(R.id.tv_q1Weekdaytxt);
        TextView tv_q1Weekday=(TextView)view.findViewById(R.id.tv_q1Weekday);
        TextView tv_q1a2quiz=(TextView)view.findViewById(R.id.tv_q1a2quiz);
        TextView tv_q1a2answer=(TextView)view.findViewById(R.id.tv_q1a2answer);
        TextView tv_q2score=(TextView)view.findViewById(R.id.tv_q2score);
        TextView tv_q2quiz1=(TextView)view.findViewById(R.id.tv_q2quiz1);
        TextView tv_q2quiz1A=(TextView)view.findViewById(R.id.tv_q2quiz1A);
        TextView tv_q2quiz2=(TextView)view.findViewById(R.id.tv_q2quiz2);
        TextView tv_q2quiz2A=(TextView)view.findViewById(R.id.tv_q2quiz2A);
        TextView tv_q2quiz3=(TextView)view.findViewById(R.id.tv_q2quiz3);
        TextView tv_q2quiz3A=(TextView)view.findViewById(R.id.tv_q2quiz3A);
        TextView tv_q2quiz4=(TextView)view.findViewById(R.id.tv_q2quiz4);
        TextView tv_q2quiz4A=(TextView)view.findViewById(R.id.tv_q2quiz4A);
        TextView tv_q2quiz5=(TextView)view.findViewById(R.id.tv_q2quiz5);
        TextView tv_q2quiz5A=(TextView)view.findViewById(R.id.tv_q2quiz5A);
        TextView tv_q3score=(TextView)view.findViewById(R.id.tv_q3score);
        TextView tv_q3word1=(TextView)view.findViewById(R.id.tv_q3word1);
        TextView tv_q3A1=(TextView)view.findViewById(R.id.tv_q3A1);
        TextView tv_q3word2=(TextView)view.findViewById(R.id.tv_q3word2);
        TextView tv_q3A2=(TextView)view.findViewById(R.id.tv_q3A2);
        TextView tv_q3word3=(TextView)view.findViewById(R.id.tv_q3word3);
        TextView tv_q3A3=(TextView)view.findViewById(R.id.tv_q3A3);
        TextView tv_q4score=(TextView)view.findViewById(R.id.tv_q4score);
        TextView q4A1=(TextView)view.findViewById(R.id.q4A1);
        TextView q4A2=(TextView)view.findViewById(R.id.q4A2);
        TextView q4A3=(TextView)view.findViewById(R.id.q4A3);
        TextView q4A4=(TextView)view.findViewById(R.id.q4A4);
        TextView q4A5=(TextView)view.findViewById(R.id.q4A5);
        TextView tv_q5score=(TextView)view.findViewById(R.id.tv_q5score);
        TextView q5W1=(TextView)view.findViewById(R.id.q5W1);
        TextView tv_q5A1=(TextView)view.findViewById(R.id.tv_q5A1);
        TextView q5W2=(TextView)view.findViewById(R.id.q5W2);
        TextView tv_q5A2=(TextView)view.findViewById(R.id.tv_q5A2);
        TextView q5W3=(TextView)view.findViewById(R.id.q5W3);
        TextView tv_q5A3=(TextView)view.findViewById(R.id.tv_q5A3);
        TextView tv_q6score=(TextView)view.findViewById(R.id.tv_q6score);
        TextView tv_q6a1W1=(TextView)view.findViewById(R.id.tv_q6a1W1);
        TextView tv_q6a1W2=(TextView)view.findViewById(R.id.tv_q6a1W2);
        TextView tv_q6a2W=(TextView)view.findViewById(R.id.tv_q6a2W);
        TextView tv_q6a2A=(TextView)view.findViewById(R.id.tv_q6a2A);
        TextView tv_q6a3Q=(TextView)view.findViewById(R.id.tv_q6a3Q);
        TextView tv_q6a3A=(TextView)view.findViewById(R.id.tv_q6a3A);
        TextView tv_q6a4A=(TextView)view.findViewById(R.id.tv_q6a4A);
        TextView tv_q7score=(TextView)view.findViewById(R.id.tv_q7score);
        TextView tv_q7A=(TextView)view.findViewById(R.id.tv_q7A);
        TextView tv_q8score=(TextView)view.findViewById(R.id.tv_q8score);
        TextView tv_q8W1=(TextView)view.findViewById(R.id.tv_q8W1);
        TextView tv_q8W2=(TextView)view.findViewById(R.id.tv_q8W2);
        TextView tv_q8W3=(TextView)view.findViewById(R.id.tv_q8W3);
        TextView tv_MMSE_total_score=(TextView)view.findViewById(R.id.tv_MMSE_total_score);
        TextView tv_MMSE_comment=(TextView)view.findViewById(R.id.tv_MMSE_comment);

        //一、定向感
        tv_q1score.setText(toString().valueOf((cursor.getInt(10)+cursor.getInt(14))));
        //年
        if(cursor.getInt(1)==0){
            tv_q1YearType.setText(cursor.getString(5));
            tv_q1Year.setText(cursor.getString(6));
        }
        else{
            tv_q1YearType.setVisibility(View.GONE);
            tv_q1Year.setText("受測者無法回答");
        }

        //月
        if(cursor.getInt(2)==0 && !cursor.getString(7).equals("")){
            tv_q1Month.setText(cursor.getString(7));
        }
        else{
            tv_q1Month.setText("X");
            tv_q1Month.setTextColor(context.getResources().getColor(R.color.red));
        }

        //號
        if(cursor.getInt(3)==0 && !cursor.getString(8).equals("")){
            tv_q1Day.setText(cursor.getString(8));
        }
        else{
            tv_q1Day.setText("X");
            tv_q1Day.setTextColor(context.getResources().getColor(R.color.red));
        }

        //星期幾
        if(cursor.getInt(4)==0 && !cursor.getString(9).equals("")){
            tv_q1Weekday.setText(cursor.getString(9));
        }
        else{
            tv_q1Weekday.setText("X");
            tv_q1Weekday.setTextColor(context.getResources().getColor(R.color.red));
        }

        //1.2
        tv_q1a2quiz.setText("3."+cursor.getString(11));
        if(cursor.getInt(13)==0 && !cursor.getString(12).equals("")){
            tv_q1a2answer.setText(cursor.getString(12));
        }
        else{
            tv_q1a2answer.setText("受測者無法回答");
        }

        //地點定向力
        tv_q2score.setText(toString().valueOf(cursor.getInt(39)));

        //五個題目
        String q2quiz[]=context.getResources().getStringArray(R.array.quiz2_quiz);

        for(int i=1,j=1;i<=5;i++){ // i 是顯示在手機上的第?題 ， j 是目前要輪到的題目號
            //第1題
            if(i==1){
                //1
                if(cursor.getInt(15)==1){
                    tv_q2quiz1.setText(q2quiz[0]);
                    if(cursor.getInt(23)==0){
                        tv_q2quiz1A.setText(cursor.getString(31));
                    }
                    else{
                        tv_q2quiz1A.setText("受測者無法回答");
                    }
                    j=2;
                    continue;
                }
                //2
                if(cursor.getInt(16)==1){
                    tv_q2quiz1.setText(q2quiz[1]);
                    if(cursor.getInt(24)==0){
                        tv_q2quiz1A.setText(cursor.getString(32));
                    }
                    else{
                        tv_q2quiz1A.setText("受測者無法回答");
                    }
                    j=3;
                    continue;
                }
                //3
                if(cursor.getInt(17)==1){
                    tv_q2quiz1.setText(q2quiz[2]);
                    if(cursor.getInt(25)==0){
                        tv_q2quiz1A.setText(cursor.getString(33));
                    }
                    else{
                        tv_q2quiz1A.setText("受測者無法回答");
                    }
                    j=4;
                    continue;
                }
                //4
                if(cursor.getInt(18)==1){
                    tv_q2quiz1.setText(q2quiz[3]);
                    if(cursor.getInt(26)==0){
                        tv_q2quiz1A.setText(cursor.getString(34));
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
                    if(cursor.getInt(16)==1){
                        tv_q2quiz2.setText(q2quiz[1]);
                        if(cursor.getInt(24)==0){
                            tv_q2quiz2A.setText(cursor.getString(32));
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=3;
                        continue;
                    }
                    if(cursor.getInt(17)==1){
                        tv_q2quiz2.setText(q2quiz[2]);
                        if(cursor.getInt(25)==0){
                            tv_q2quiz2A.setText(cursor.getString(33));
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=4;
                        continue;
                    }
                    if(cursor.getInt(18)==1){
                        tv_q2quiz2.setText(q2quiz[3]);
                        if(cursor.getInt(26)==0){
                            tv_q2quiz2A.setText(cursor.getString(34));
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(cursor.getInt(19)==1){
                        tv_q2quiz2.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz2A.setText(cursor.getString(35));
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                }
                if(j==3){
                    if(cursor.getInt(17)==1){
                        tv_q2quiz2.setText(q2quiz[2]);
                        if(cursor.getInt(25)==0){
                            tv_q2quiz2A.setText(cursor.getString(33));
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=4;
                        continue;
                    }
                    if(cursor.getInt(18)==1){
                        tv_q2quiz2.setText(q2quiz[3]);
                        if(cursor.getInt(26)==0){
                            tv_q2quiz2A.setText(cursor.getString(34));
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(cursor.getInt(19)==1){
                        tv_q2quiz2.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz2A.setText(cursor.getString(35));
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                }
                if(j==4){
                    if(cursor.getInt(18)==1){
                        tv_q2quiz2.setText(q2quiz[3]);
                        if(cursor.getInt(26)==0){
                            tv_q2quiz2A.setText(cursor.getString(34));
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(cursor.getInt(19)==1){
                        tv_q2quiz2.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz2A.setText(cursor.getString(35));
                        }
                        else{
                            tv_q2quiz2A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                }
                if(j==5){
                    if(cursor.getInt(19)==1){
                        tv_q2quiz2.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz2A.setText(cursor.getString(35));
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
                    if(cursor.getInt(17)==1){
                        tv_q2quiz3.setText(q2quiz[2]);
                        if(cursor.getInt(25)==0){
                            tv_q2quiz3A.setText(cursor.getString(33));
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=4;
                        continue;
                    }
                    if(cursor.getInt(18)==1){
                        tv_q2quiz3.setText(q2quiz[3]);
                        if(cursor.getInt(26)==0){
                            tv_q2quiz3A.setText(cursor.getString(34));
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(cursor.getInt(19)==1){
                        tv_q2quiz3.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz3A.setText(cursor.getString(35));
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(cursor.getInt(20)==1){
                        tv_q2quiz3.setText(q2quiz[5]);
                        if(cursor.getInt(28)==0){
                            tv_q2quiz3A.setText(cursor.getString(36));
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                }
                if(j==4){
                    if(cursor.getInt(18)==1){
                        tv_q2quiz3.setText(q2quiz[3]);
                        if(cursor.getInt(26)==0){
                            tv_q2quiz3A.setText(cursor.getString(34));
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }
                    if(cursor.getInt(19)==1){
                        tv_q2quiz3.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz3A.setText(cursor.getString(35));
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(cursor.getInt(20)==1){
                        tv_q2quiz3.setText(q2quiz[5]);
                        if(cursor.getInt(28)==0){
                            tv_q2quiz3A.setText(cursor.getString(36));
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                }
                if(j==5){
                    if(cursor.getInt(19)==1){
                        tv_q2quiz3.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz3A.setText(cursor.getString(35));
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(cursor.getInt(20)==1){
                        tv_q2quiz3.setText(q2quiz[5]);
                        if(cursor.getInt(28)==0){
                            tv_q2quiz3A.setText(cursor.getString(36));
                        }
                        else{
                            tv_q2quiz3A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                }
                if(j==6){
                    if(cursor.getInt(20)==1){
                        tv_q2quiz3.setText(q2quiz[5]);
                        if(cursor.getInt(28)==0){
                            tv_q2quiz3A.setText(cursor.getString(36));
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
                    if(cursor.getInt(18)==1){
                        tv_q2quiz4.setText(q2quiz[3]);
                        if(cursor.getInt(26)==0){
                            tv_q2quiz4A.setText(cursor.getString(34));
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=5;
                        continue;
                    }

                    if(cursor.getInt(19)==1){
                        tv_q2quiz4.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz4A.setText(cursor.getString(35));
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(cursor.getInt(20)==1){
                        tv_q2quiz4.setText(q2quiz[5]);
                        if(cursor.getInt(28)==0){
                            tv_q2quiz4A.setText(cursor.getString(36));
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                    if(cursor.getInt(21)==1){
                        tv_q2quiz4.setText(q2quiz[6]);
                        if(cursor.getInt(29)==0){
                            tv_q2quiz4A.setText(cursor.getString(37));
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=8;
                        continue;
                    }
                }
                if(j==5){
                    if(cursor.getInt(19)==1){
                        tv_q2quiz4.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz4A.setText(cursor.getString(35));
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=6;
                        continue;
                    }
                    if(cursor.getInt(20)==1){
                        tv_q2quiz4.setText(q2quiz[5]);
                        if(cursor.getInt(28)==0){
                            tv_q2quiz4A.setText(cursor.getString(36));
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                    if(cursor.getInt(21)==1){
                        tv_q2quiz4.setText(q2quiz[6]);
                        if(cursor.getInt(29)==0){
                            tv_q2quiz4A.setText(cursor.getString(37));
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=8;
                        continue;
                    }
                }
                if(j==6){
                    if(cursor.getInt(20)==1){
                        tv_q2quiz4.setText(q2quiz[5]);
                        if(cursor.getInt(28)==0){
                            tv_q2quiz4A.setText(cursor.getString(36));
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=7;
                        continue;
                    }
                    if(cursor.getInt(21)==1){
                        tv_q2quiz4.setText(q2quiz[6]);
                        if(cursor.getInt(29)==0){
                            tv_q2quiz4A.setText(cursor.getString(37));
                        }
                        else{
                            tv_q2quiz4A.setText("受測者無法回答");
                        }
                        j=8;
                        continue;
                    }
                }
                if(j==7){
                    if(cursor.getInt(21)==1){
                        tv_q2quiz4.setText(q2quiz[6]);
                        if(cursor.getInt(29)==0){
                            tv_q2quiz4A.setText(cursor.getString(37));
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
                    if(cursor.getInt(19)==1){
                        tv_q2quiz5.setText(q2quiz[4]);
                        if(cursor.getInt(27)==0){
                            tv_q2quiz5A.setText(cursor.getString(35));
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(cursor.getInt(20)==1){
                        tv_q2quiz5.setText(q2quiz[5]);
                        if(cursor.getInt(28)==0){
                            tv_q2quiz5A.setText(cursor.getString(36));
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(cursor.getInt(21)==1){
                        tv_q2quiz5.setText(q2quiz[6]);
                        if(cursor.getInt(29)==0){
                            tv_q2quiz5A.setText(cursor.getString(37));
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(cursor.getInt(22)==1){
                        tv_q2quiz5.setText(q2quiz[7]);
                        if(cursor.getInt(30)==0){
                            tv_q2quiz5A.setText(cursor.getString(38));
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                }
                if(j==6){
                    if(cursor.getInt(20)==1){
                        tv_q2quiz5.setText(q2quiz[5]);
                        if(cursor.getInt(28)==0){
                            tv_q2quiz5A.setText(cursor.getString(36));
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(cursor.getInt(21)==1){
                        tv_q2quiz5.setText(q2quiz[6]);
                        if(cursor.getInt(29)==0){
                            tv_q2quiz5A.setText(cursor.getString(37));
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(cursor.getInt(22)==1){
                        tv_q2quiz5.setText(q2quiz[7]);
                        if(cursor.getInt(30)==0){
                            tv_q2quiz5A.setText(cursor.getString(38));
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                }
                if(j==7){
                    if(cursor.getInt(21)==1){
                        tv_q2quiz5.setText(q2quiz[6]);
                        if(cursor.getInt(29)==0){
                            tv_q2quiz5A.setText(cursor.getString(37));
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                    if(cursor.getInt(22)==1){
                        tv_q2quiz5.setText(q2quiz[7]);
                        if(cursor.getInt(30)==0){
                            tv_q2quiz5A.setText(cursor.getString(38));
                        }
                        else{
                            tv_q2quiz5A.setText("受測者無法回答");
                        }
                        continue;
                    }
                }
                if(j==8){
                    if(cursor.getInt(22)==1){
                        tv_q2quiz5.setText(q2quiz[7]);
                        if(cursor.getInt(30)==0){
                            tv_q2quiz5A.setText(cursor.getString(38));
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
        tv_q3score.setText(toString().valueOf(cursor.getInt(46)));
        tv_q3word1.setText(cursor.getString(40));
        tv_q3word2.setText(cursor.getString(41));
        tv_q3word3.setText(cursor.getString(42));
        if(cursor.getInt(43)==0){
            tv_q3A1.setText("(O)");
        }
        else{
            tv_q3A1.setText("(X)");
        }
        if(cursor.getInt(44)==0){
            tv_q3A2.setText("(O)");
        }
        else{
            tv_q3A2.setText("(X)");
        }
        if(cursor.getInt(45)==0){
            tv_q3A3.setText("(O)");
        }
        else{
            tv_q3A3.setText("(X)");
        }

        //注意力及計算能力
        tv_q4score.setText(toString().valueOf(cursor.getInt(52)));
        q4A1.setText(cursor.getString(47));
        q4A2.setText(cursor.getString(48));
        q4A3.setText(cursor.getString(49));
        q4A4.setText(cursor.getString(50));
        q4A5.setText(cursor.getString(51));

        //記憶力
        tv_q5score.setText(toString().valueOf(cursor.getInt(56)));
        q5W1.setText(cursor.getString(40));
        q5W2.setText(cursor.getString(40));
        q5W3.setText(cursor.getString(40));

        if(cursor.getInt(53)==0){
            tv_q5A1.setText("(O)");
        }
        else{
            tv_q5A1.setText("(X)");
        }
        if(cursor.getInt(54)==0){
            tv_q5A2.setText("(O)");
        }
        else{
            tv_q5A2.setText("(X)");
        }
        if(cursor.getInt(55)==0){
            tv_q5A3.setText("(O)");
        }
        else{
            tv_q5A3.setText("(X)");
        }

        //語言理解
        tv_q6score.setText(toString().valueOf(cursor.getInt(64)));
        if(!cursor.getString(57).equals("")){
            tv_q6a1W1.setText(cursor.getString(57));
        }
        else{
            tv_q6a1W1.setText("受測者無法回答");
        }
        if(!cursor.getString(58).equals("")){
            tv_q6a1W2.setText(cursor.getString(58));
        }
        else{
            tv_q6a1W2.setText("受測者無法回答");
        }

        tv_q6a2W.setText(cursor.getString(59));
        if(cursor.getInt(60)==0){
            tv_q6a2A.setText("(O)");
        }
        else{
            tv_q6a2A.setText("(X)");
        }

        tv_q6a3Q.setText(cursor.getString(61));
        if(cursor.getInt(62)==0){
            tv_q6a3A.setText("(O)");
        }
        else{
            tv_q6a3A.setText("(X)");
        }

        if(!cursor.getString(63).equals("")) {
            tv_q6a4A.setText(cursor.getString(63));
        }
        else{
            tv_q6a4A.setText("受測者無法回答");
        }

        //空間概念


        //顯示受測者所繪圖片
        byte[] bytearrayImage= Base64.decode(cursor.getString(65), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytearrayImage, 0, bytearrayImage.length);
        // 受測者的图片的宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        // 设置想要的大小
        //取得原本圖片寬高
        Bitmap originalBmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.quiz9_draw);
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

        tv_q7score.setText(toString().valueOf(cursor.getInt(67)));
        if(cursor.getInt(66)==0){
            tv_q7A.setText("(O)");
        }
        else{
            tv_q7A.setText("(X)");
        }

        //操作能力
        tv_q8score.setText(toString().valueOf(cursor.getInt(71)));
        if(cursor.getInt(68)==0) {
            tv_q8W1.setText("(O)");
        }
        else{
            tv_q8W1.setText("(X)");
        }
        if(cursor.getInt(69)==0) {
            tv_q8W2.setText("(O)");
        }
        else{
            tv_q8W2.setText("(X)");
        }
        if(cursor.getInt(70)==0) {
            tv_q8W3.setText("(O)");
        }
        else{
            tv_q8W3.setText("(X)");
        }

        tv_MMSE_total_score.setText(toString().valueOf(cursor.getInt(72)));

        if(cursor.getInt(72)<=30 && cursor.getInt(72)>=24) {
            tv_MMSE_comment.setText("認知功能正常");
        }
        else if(cursor.getInt(72)<=23 && cursor.getInt(72)>=18) {
            tv_MMSE_comment.setText("輕度認知功能障礙\n建議至鄰近醫院做更進一步的診療");
        }
        else if(cursor.getInt(72)<=17 && cursor.getInt(72)>=0) {
            tv_MMSE_comment.setText("重度認知功能障礙\n建議至鄰近醫院做更進一步的診療！");
        }
        else{
            tv_MMSE_comment.setText("系統錯誤！");
        }


    }
}
