package com.example.ncyu.login.mListView;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.R;

/**
 * Created by Ncyu on 2017/9/16.
 */

public class AD8SimpleCursorAdapter extends SimpleCursorAdapter {


    public AD8SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    };

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);

        TextView tv_has_changed1 = (TextView) view.findViewById(R.id.tv_has_changed1);
        TextView tv_has_changed2 = (TextView) view.findViewById(R.id.tv_has_changed2);
        TextView tv_has_changed3 = (TextView) view.findViewById(R.id.tv_has_changed3);
        TextView tv_has_changed4 = (TextView) view.findViewById(R.id.tv_has_changed4);
        TextView tv_has_changed5 = (TextView) view.findViewById(R.id.tv_has_changed5);
        TextView tv_has_changed6 = (TextView) view.findViewById(R.id.tv_has_changed6);
        TextView tv_has_changed7 = (TextView) view.findViewById(R.id.tv_has_changed7);
        TextView tv_has_changed8 = (TextView) view.findViewById(R.id.tv_has_changed8);
        TextView tv_ad8_total_score = (TextView) view.findViewById(R.id.tv_ad8_total_score);
        TextView tv_ad8_comment = (TextView) view.findViewById(R.id.tv_ad8_comment);

        for (int i = 0; i <= 8; i++) {
            if (i == 0) {
                if (cursor.getInt(i + 1) == 0) {
                    tv_has_changed1.setText("無改變");
                } else if (cursor.getInt(i + 1) == 1) {
                    tv_has_changed1.setText("有改變");
                } else if (cursor.getInt(i + 1) == 2) {
                    tv_has_changed1.setText("不知道");
                } else {
                    tv_has_changed1.setText("錯誤!");
                }
            } else if (i == 1) {
                if (cursor.getInt(i + 1) == 0) {
                    tv_has_changed2.setText("無改變");
                } else if (cursor.getInt(i + 1) == 1) {
                    tv_has_changed2.setText("有改變");
                } else if (cursor.getInt(i + 1) == 2) {
                    tv_has_changed2.setText("不知道");
                } else {
                    tv_has_changed2.setText("錯誤!");
                }
            } else if (i == 2) {
                if (cursor.getInt(i + 1) == 0) {
                    tv_has_changed3.setText("無改變");
                } else if (cursor.getInt(i + 1) == 1) {
                    tv_has_changed3.setText("有改變");
                } else if (cursor.getInt(i + 1) == 2) {
                    tv_has_changed3.setText("不知道");
                } else {
                    tv_has_changed3.setText("錯誤!");
                }
            } else if (i == 3) {
                if (cursor.getInt(i + 1) == 0) {
                    tv_has_changed4.setText("無改變");
                } else if (cursor.getInt(i + 1) == 1) {
                    tv_has_changed4.setText("有改變");
                } else if (cursor.getInt(i + 1) == 2) {
                    tv_has_changed4.setText("不知道");
                } else {
                    tv_has_changed4.setText("錯誤!");
                }
            } else if (i == 4) {
                if (cursor.getInt(i + 1) == 0) {
                    tv_has_changed5.setText("無改變");
                } else if (cursor.getInt(i + 1) == 1) {
                    tv_has_changed5.setText("有改變");
                } else if (cursor.getInt(i + 1) == 2) {
                    tv_has_changed5.setText("不知道");
                } else {
                    tv_has_changed5.setText("錯誤!");
                }
            } else if (i == 5) {
                if (cursor.getInt(i + 1) == 0) {
                    tv_has_changed6.setText("無改變");
                } else if (cursor.getInt(i + 1) == 1) {
                    tv_has_changed6.setText("有改變");
                } else if (cursor.getInt(i + 1) == 2) {
                    tv_has_changed6.setText("不知道");
                } else {
                    tv_has_changed6.setText("錯誤!");
                }
            } else if (i == 6) {
                if (cursor.getInt(i + 1) == 0) {
                    tv_has_changed7.setText("無改變");
                } else if (cursor.getInt(i + 1) == 1) {
                    tv_has_changed7.setText("有改變");
                } else if (cursor.getInt(i + 1) == 2) {
                    tv_has_changed7.setText("不知道");
                } else {
                    tv_has_changed7.setText("錯誤!");
                }
            } else if (i == 7) {
                if (cursor.getInt(i + 1) == 0) {
                    tv_has_changed8.setText("無改變");
                } else if (cursor.getInt(i + 1) == 1) {
                    tv_has_changed8.setText("有改變");
                } else if (cursor.getInt(i + 1) == 2) {
                    tv_has_changed8.setText("不知道");
                } else {
                    tv_has_changed8.setText("錯誤!");
                }
            } else if (i == 8) {
                tv_ad8_total_score.setText(toString().valueOf(cursor.getInt(i + 1)));
                if (cursor.getInt(i + 1) >= 2) {
                    tv_ad8_comment.setText("建議到鄰近醫院做更進一步的檢查！");
                } else {
                    tv_ad8_comment.setText("恭喜你，你是個正常人！");
                }
            }
        }
    }

}
