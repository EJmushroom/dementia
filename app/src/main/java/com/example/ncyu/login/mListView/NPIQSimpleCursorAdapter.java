package com.example.ncyu.login.mListView;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.ncyu.login.R;

/**
 * Created by Ncyu on 2017/9/20.
 */

public class NPIQSimpleCursorAdapter extends SimpleCursorAdapter {

    public NPIQSimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    };

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);
        // final int position = cursor.getPosition();    //获取当前位置

        TextView tv_npiq_severity1 = (TextView) view.findViewById(R.id.tv_npiq_severity1);
        TextView tv_npiq_severity2 = (TextView) view.findViewById(R.id.tv_npiq_severity2);
        TextView tv_npiq_severity3 = (TextView) view.findViewById(R.id.tv_npiq_severity3);
        TextView tv_npiq_severity4 = (TextView) view.findViewById(R.id.tv_npiq_severity4);
        TextView tv_npiq_severity5 = (TextView) view.findViewById(R.id.tv_npiq_severity5);
        TextView tv_npiq_severity6 = (TextView) view.findViewById(R.id.tv_npiq_severity6);
        TextView tv_npiq_severity7 = (TextView) view.findViewById(R.id.tv_npiq_severity7);
        TextView tv_npiq_severity8 = (TextView) view.findViewById(R.id.tv_npiq_severity8);
        TextView tv_npiq_severity9 = (TextView) view.findViewById(R.id.tv_npiq_severity9);
        TextView tv_npiq_severity10 = (TextView) view.findViewById(R.id.tv_npiq_severity10);
        TextView tv_npiq_severity11 = (TextView) view.findViewById(R.id.tv_npiq_severity11);
        TextView tv_npiq_severity12 = (TextView) view.findViewById(R.id.tv_npiq_severity12);

        TextView tv_npiq_distress1 = (TextView) view.findViewById(R.id.tv_npiq_distress1);
        TextView tv_npiq_distress2 = (TextView) view.findViewById(R.id.tv_npiq_distress2);
        TextView tv_npiq_distress3 = (TextView) view.findViewById(R.id.tv_npiq_distress3);
        TextView tv_npiq_distress4 = (TextView) view.findViewById(R.id.tv_npiq_distress4);
        TextView tv_npiq_distress5 = (TextView) view.findViewById(R.id.tv_npiq_distress5);
        TextView tv_npiq_distress6 = (TextView) view.findViewById(R.id.tv_npiq_distress6);
        TextView tv_npiq_distress7 = (TextView) view.findViewById(R.id.tv_npiq_distress7);
        TextView tv_npiq_distress8 = (TextView) view.findViewById(R.id.tv_npiq_distress8);
        TextView tv_npiq_distress9 = (TextView) view.findViewById(R.id.tv_npiq_distress9);
        TextView tv_npiq_distress10 = (TextView) view.findViewById(R.id.tv_npiq_distress10);
        TextView tv_npiq_distress11 = (TextView) view.findViewById(R.id.tv_npiq_distress11);
        TextView tv_npiq_distress12 = (TextView) view.findViewById(R.id.tv_npiq_distress12);


        for (int i = 1; i <= 36; i=i+3) {
            if (i == 1) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity1.setText("無");
                    tv_npiq_distress1.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity1.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress1.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 4) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity2.setText("無");
                    tv_npiq_distress2.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity2.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress2.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 7) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity3.setText("無");
                    tv_npiq_distress3.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity3.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress3.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 10) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity4.setText("無");
                    tv_npiq_distress4.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity4.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress4.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 13) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity5.setText("無");
                    tv_npiq_distress5.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity5.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress5.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 16) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity6.setText("無");
                    tv_npiq_distress6.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity6.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress6.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 19) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity7.setText("無");
                    tv_npiq_distress7.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity7.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress7.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 22) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity8.setText("無");
                    tv_npiq_distress8.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity8.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress8.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 25) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity9.setText("無");
                    tv_npiq_distress9.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity9.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress9.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 28) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity10.setText("無");
                    tv_npiq_distress10.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity10.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress10.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 31) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity11.setText("無");
                    tv_npiq_distress11.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity11.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress11.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
            else if (i == 34) {
                if (cursor.getInt(i) == 0) {
                    tv_npiq_severity12.setText("無");
                    tv_npiq_distress12.setText("無");
                }
                else if (cursor.getInt(i) == 1) {
                    tv_npiq_severity12.setText(toString().valueOf(cursor.getInt(i+1)));
                    tv_npiq_distress12.setText(toString().valueOf(cursor.getInt(i+2)));
                }
            }
        }
    }
}
