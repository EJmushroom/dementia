package com.example.ncyu.login.mListView;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;



/**
 * Created by Ncyu on 2017/9/15.
 */

public class MySimpleCursorAdapter extends SimpleCursorAdapter {

    int id=-1;

    public MySimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    };

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);

        final int position = cursor.getPosition();    //获取当前位置
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor.moveToPosition(position);
                id=cursor.getInt(0);
                Toast.makeText(context," _id: "+cursor.getInt(0),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int getId(){
        return id;
    };
}
