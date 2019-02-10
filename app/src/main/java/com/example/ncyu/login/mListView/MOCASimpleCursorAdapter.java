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
 * Created by Ncyu on 2017/12/18.
 */

public class MOCASimpleCursorAdapter extends SimpleCursorAdapter {

    public MOCASimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    };

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);

        TextView tv_moca_quiz1_answer=(TextView)view.findViewById(R.id.tv_moca_quiz1_answer);
        TextView tv_moca_quiz1_score=(TextView)view.findViewById(R.id.tv_moca_quiz1_score);
        TextView tv_moca_quiz2_score=(TextView)view.findViewById(R.id.tv_moca_quiz2_score);
        ImageView img_Psquare=(ImageView)view.findViewById(R.id.img_Psquare);
        TextView tv_moca_quiz2_ask_answer=(TextView)view.findViewById(R.id.tv_moca_quiz2_ask_answer);
        ImageView img_Pclock=(ImageView)view.findViewById(R.id.img_Pclock);
        TextView tv_moca_quiz2_ask2_answer1=(TextView)view.findViewById(R.id.tv_moca_quiz2_ask2_answer1);
        TextView tv_moca_quiz2_ask2_answer2=(TextView)view.findViewById(R.id.tv_moca_quiz2_ask2_answer2);
        TextView tv_moca_quiz2_ask2_answer3=(TextView)view.findViewById(R.id.tv_moca_quiz2_ask2_answer3);
        TextView tv_moca_quiz3_score=(TextView)view.findViewById(R.id.tv_moca_quiz3_score);
        TextView tv_moca_quiz3_answer1=(TextView)view.findViewById(R.id.tv_moca_quiz3_answer1);
        TextView tv_moca_quiz3_answer2=(TextView)view.findViewById(R.id.tv_moca_quiz3_answer2);
        TextView tv_moca_quiz3_answer3=(TextView)view.findViewById(R.id.tv_moca_quiz3_answer3);
        TextView tv_moca_quiz4_score=(TextView)view.findViewById(R.id.tv_moca_quiz4_score);
        TextView tv_moca_quiz4_word_bundle1=(TextView)view.findViewById(R.id.tv_moca_quiz4_word_bundle1);
        TextView tv_moca_quiz4_answer_first1=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_first1);
        TextView tv_moca_quiz4_answer_second1=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_second1);
        TextView tv_moca_quiz4_word_bundle2=(TextView)view.findViewById(R.id.tv_moca_quiz4_word_bundle2);
        TextView tv_moca_quiz4_answer_first2=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_first2);
        TextView tv_moca_quiz4_answer_second2=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_second2);
        TextView tv_moca_quiz4_word_bundle3=(TextView)view.findViewById(R.id.tv_moca_quiz4_word_bundle3);
        TextView tv_moca_quiz4_answer_first3=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_first3);
        TextView tv_moca_quiz4_answer_second3=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_second3);
        TextView tv_moca_quiz4_word_bundle4=(TextView)view.findViewById(R.id.tv_moca_quiz4_word_bundle4);
        TextView tv_moca_quiz4_answer_first4=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_first4);
        TextView tv_moca_quiz4_answer_second4=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_second4);
        TextView tv_moca_quiz4_word_bundle5=(TextView)view.findViewById(R.id.tv_moca_quiz4_word_bundle5);
        TextView tv_moca_quiz4_answer_first5=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_first5);
        TextView tv_moca_quiz4_answer_second5=(TextView)view.findViewById(R.id.tv_moca_quiz4_answer_second5);
        TextView tv_moca_quiz5_score=(TextView)view.findViewById(R.id.tv_moca_quiz5_score);
        TextView tv_moca_quiz5_ask1_answer1=(TextView)view.findViewById(R.id.tv_moca_quiz5_ask1_answer1);
        TextView tv_moca_quiz5_ask1_answer2=(TextView)view.findViewById(R.id.tv_moca_quiz5_ask1_answer2);
        TextView tv_moca_quiz5_ask1_answer3=(TextView)view.findViewById(R.id.tv_moca_quiz5_ask1_answer3);
        TextView tv_moca_quiz5_ask2_answer1=(TextView)view.findViewById(R.id.tv_moca_quiz5_ask2_answer1);
        TextView tv_moca_quiz5_ask2_answer2=(TextView)view.findViewById(R.id.tv_moca_quiz5_ask2_answer2);
        TextView tv_moca_quiz5_ask2_answer3=(TextView)view.findViewById(R.id.tv_moca_quiz5_ask2_answer3);
        TextView tv_moca_quiz5_ask2_answer4=(TextView)view.findViewById(R.id.tv_moca_quiz5_ask2_answer4);
        TextView tv_moca_quiz5_ask2_answer5=(TextView)view.findViewById(R.id.tv_moca_quiz5_ask2_answer5);
        TextView tv_moca_quiz5_ask2_isRight=(TextView)view.findViewById(R.id.tv_moca_quiz5_ask2_isRight);
        TextView tv_moca_quiz6_score=(TextView)view.findViewById(R.id.tv_moca_quiz6_score);
        TextView tv_moca_quiz6_ask_quiz_isRight1=(TextView)view.findViewById(R.id.tv_moca_quiz6_ask_quiz_isRight1);
        TextView tv_moca_quiz6_ask_quiz_isRight2=(TextView)view.findViewById(R.id.tv_moca_quiz6_ask_quiz_isRight2);
        TextView tv_moca_quiz6_ask2_answer=(TextView)view.findViewById(R.id.tv_moca_quiz6_ask2_answer);
        TextView tv_moca_quiz7_score=(TextView)view.findViewById(R.id.tv_moca_quiz7_score);
        TextView tv_moca_quiz7_answer1=(TextView)view.findViewById(R.id.tv_moca_quiz7_answer1);
        TextView tv_moca_quiz7_answer2=(TextView)view.findViewById(R.id.tv_moca_quiz7_answer2);
        TextView tv_moca_quiz8_score=(TextView)view.findViewById(R.id.tv_moca_quiz8_score);
        TextView tv_moca_quiz8_word_bundle1=(TextView)view.findViewById(R.id.tv_moca_quiz8_word_bundle1);
        TextView tv_moca_quiz8_answer1=(TextView)view.findViewById(R.id.tv_moca_quiz8_answer1);
        TextView tv_moca_quiz8_word_bundle2=(TextView)view.findViewById(R.id.tv_moca_quiz8_word_bundle2);
        TextView tv_moca_quiz8_answer2=(TextView)view.findViewById(R.id.tv_moca_quiz8_answer2);
        TextView tv_moca_quiz8_word_bundle3=(TextView)view.findViewById(R.id.tv_moca_quiz8_word_bundle3);
        TextView tv_moca_quiz8_answer3=(TextView)view.findViewById(R.id.tv_moca_quiz8_answer3);
        TextView tv_moca_quiz8_word_bundle4=(TextView)view.findViewById(R.id.tv_moca_quiz8_word_bundle4);
        TextView tv_moca_quiz8_answer4=(TextView)view.findViewById(R.id.tv_moca_quiz8_answer4);
        TextView tv_moca_quiz8_word_bundle5=(TextView)view.findViewById(R.id.tv_moca_quiz8_word_bundle5);
        TextView tv_moca_quiz8_answer5=(TextView)view.findViewById(R.id.tv_moca_quiz8_answer5);
        TextView tv_moca_quiz9_score=(TextView)view.findViewById(R.id.tv_moca_quiz9_score);
        TextView tv_moca_quiz9_answer1=(TextView)view.findViewById(R.id.tv_moca_quiz9_answer1);
        TextView tv_moca_quiz9_answer2=(TextView)view.findViewById(R.id.tv_moca_quiz9_answer2);
        TextView tv_moca_quiz9_answer3=(TextView)view.findViewById(R.id.tv_moca_quiz9_answer3);
        TextView tv_moca_quiz9_answer4=(TextView)view.findViewById(R.id.tv_moca_quiz9_answer4);
        TextView tv_moca_quiz9_answer5=(TextView)view.findViewById(R.id.tv_moca_quiz9_answer5);
        TextView tv_moca_quiz9_answer6=(TextView)view.findViewById(R.id.tv_moca_quiz9_answer6);
        TextView tv_moca_quiz9_answer7=(TextView)view.findViewById(R.id.tv_moca_quiz9_answer7);
        TextView tv_moca_MOCA_total_score=(TextView)view.findViewById(R.id.tv_moca_MOCA_total_score);
        TextView tv_moca_comment=(TextView)view.findViewById(R.id.tv_moca_comment);


        if(cursor.getInt(1)==1){
            tv_moca_quiz1_answer.setText("( O )");
        }else{
            tv_moca_quiz1_answer.setText("( X )");
        }

        tv_moca_quiz1_score.setText(toString().valueOf(cursor.getInt(2))+" 分");
        tv_moca_quiz2_score.setText(toString().valueOf(cursor.getInt(9))+" 分");

        //顯示受測者所繪圖片
        byte[] bytearrayImage1= Base64.decode(cursor.getString(3), Base64.DEFAULT);
        Bitmap bitmap1 = BitmapFactory.decodeByteArray(bytearrayImage1, 0, bytearrayImage1.length);
        // 受測者的图片的宽高
        int width1 = bitmap1.getWidth();
        int height1 = bitmap1.getHeight();
        // 设置想要的大小
        //取得原本圖片寬高
        Bitmap originalBmp1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.quiz2_square);
        int oHeight1 = originalBmp1.getHeight();
        int oWidth1 = originalBmp1.getWidth();

        // 计算缩放比例
        float scaleWidth1 = ((float) oWidth1) / width1;
        float scaleHeight1 = ((float) oHeight1) / height1;
        // 取得想要缩放的matrix参数
        Matrix matrix1 = new Matrix();
        matrix1.postScale(scaleWidth1, scaleHeight1);
        // 得到新的图片
        Bitmap newbitmap1 = Bitmap.createBitmap(bitmap1, 0, 0, width1, height1, matrix1, true);

        img_Psquare.setImageBitmap(newbitmap1);

        //顯示受測者所繪圖片
        byte[] bytearrayImage2= Base64.decode(cursor.getString(5), Base64.DEFAULT);
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(bytearrayImage2, 0, bytearrayImage2.length);
        // 受測者的图片的宽高
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        // 设置想要的大小
        //取得原本圖片寬高
        Bitmap originalBmp2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.quiz2_ask2_clock);
        int oHeight2 = originalBmp2.getHeight();
        int oWidth2 = originalBmp2.getWidth();

        // 计算缩放比例
        float scaleWidth2 = ((float) oWidth2) / width2;
        float scaleHeight2 = ((float) oHeight2) / height2;
        // 取得想要缩放的matrix参数
        Matrix matrix2 = new Matrix();
        matrix2.postScale(scaleWidth2, scaleHeight2);
        // 得到新的图片
        Bitmap newbitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, width2, height2, matrix2, true);

        img_Pclock.setImageBitmap(newbitmap2);

        if(cursor.getInt(4)==1) {
            tv_moca_quiz2_ask_answer.setText("( O )");
        }
        else{
            tv_moca_quiz2_ask_answer.setText("( X )");
        }

        if(cursor.getInt(6)==1){
            tv_moca_quiz2_ask2_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz2_ask2_answer1.setText("( X )");
        }

        if(cursor.getInt(7)==1){
            tv_moca_quiz2_ask2_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz2_ask2_answer2.setText("( X )");
        }

        if(cursor.getInt(8)==1){
            tv_moca_quiz2_ask2_answer3.setText("( O )");
        }
        else{
            tv_moca_quiz2_ask2_answer3.setText("( X )");
        }

        tv_moca_quiz3_score.setText(toString().valueOf(cursor.getInt(13))+" 分");

        if(cursor.getInt(10)==1){
            tv_moca_quiz3_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz3_answer1.setText("( X )");
        }

        if(cursor.getInt(11)==1){
            tv_moca_quiz3_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz3_answer2.setText("( X )");
        }

        if(cursor.getInt(12)==1){
            tv_moca_quiz3_answer3.setText("( O )");
        }
        else{
            tv_moca_quiz3_answer3.setText("( X )");
        }

        if(cursor.getInt(14)==1){
            tv_moca_quiz4_answer_first1.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first1.setText("( X )");
        }

        if(cursor.getInt(15)==1){
            tv_moca_quiz4_answer_first2.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first2.setText("( X )");
        }

        if(cursor.getInt(16)==1){
            tv_moca_quiz4_answer_first3.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first3.setText("( X )");
        }

        if(cursor.getInt(17)==1){
            tv_moca_quiz4_answer_first4.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first4.setText("( X )");
        }

        if(cursor.getInt(18)==1){
            tv_moca_quiz4_answer_first5.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first5.setText("( X )");
        }

        if(cursor.getInt(19)==1){
            tv_moca_quiz4_answer_second1.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second1.setText("( X )");
        }

        if(cursor.getInt(20)==1){
            tv_moca_quiz4_answer_second2.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second2.setText("( X )");
        }

        if(cursor.getInt(21)==1){
            tv_moca_quiz4_answer_second3.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second3.setText("( X )");
        }

        if(cursor.getInt(22)==1){
            tv_moca_quiz4_answer_second4.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second4.setText("( X )");
        }

        if(cursor.getInt(23)==1){
            tv_moca_quiz4_answer_second5.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second5.setText("( X )");
        }

        tv_moca_quiz4_word_bundle1.setText(cursor.getString(24));
        tv_moca_quiz4_word_bundle2.setText(cursor.getString(25));
        tv_moca_quiz4_word_bundle3.setText(cursor.getString(26));
        tv_moca_quiz4_word_bundle4.setText(cursor.getString(27));
        tv_moca_quiz4_word_bundle5.setText(cursor.getString(28));

        tv_moca_quiz4_score.setText("不計分");

        if(cursor.getInt(30)==1){
            tv_moca_quiz5_ask1_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz5_ask1_answer1.setText("( X )");
        }

        if(cursor.getInt(31)==1){
            tv_moca_quiz5_ask1_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz5_ask1_answer2.setText("( X )");
        }

        if(cursor.getInt(32)==1){
            tv_moca_quiz5_ask1_answer3.setText("( O )");
        }
        else{
            tv_moca_quiz5_ask1_answer3.setText("( X )");
        }

        tv_moca_quiz5_ask2_answer1.setText(cursor.getString(33));
        tv_moca_quiz5_ask2_answer2.setText(cursor.getString(34));
        tv_moca_quiz5_ask2_answer3.setText(cursor.getString(35));
        tv_moca_quiz5_ask2_answer4.setText(cursor.getString(36));
        tv_moca_quiz5_ask2_answer5.setText(cursor.getString(37));

        if(cursor.getInt(38)==1){
            tv_moca_quiz5_ask2_isRight.setText("( O )");
        }
        else{
            tv_moca_quiz5_ask2_isRight.setText("( X )");
        }

        tv_moca_quiz5_score.setText(toString().valueOf(cursor.getInt(39))+" 分");

        if(cursor.getInt(40)==1){
            tv_moca_quiz6_ask_quiz_isRight1.setText("( O )");
        }
        else{
            tv_moca_quiz6_ask_quiz_isRight1.setText("( X )");
        }

        if(cursor.getInt(41)==1){
            tv_moca_quiz6_ask_quiz_isRight2.setText("( O )");
        }
        else{
            tv_moca_quiz6_ask_quiz_isRight2.setText("( X )");
        }

        tv_moca_quiz6_ask2_answer.setText(toString().valueOf(cursor.getInt(42)));

        tv_moca_quiz6_score.setText(toString().valueOf(cursor.getInt(43))+" 分");

        if(cursor.getInt(44)==1){
            tv_moca_quiz7_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz7_answer1.setText("( X )");
        }

        if(cursor.getInt(45)==1){
            tv_moca_quiz7_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz7_answer2.setText("( X )");
        }

        tv_moca_quiz7_score.setText(toString().valueOf(cursor.getInt(46))+" 分");

        if(cursor.getInt(47)==1){
            tv_moca_quiz8_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer1.setText("( X )");
        }

        if(cursor.getInt(48)==1){
            tv_moca_quiz8_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer2.setText("( X )");
        }

        if(cursor.getInt(49)==1){
            tv_moca_quiz8_answer3.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer3.setText("( X )");
        }

        if(cursor.getInt(50)==1){
            tv_moca_quiz8_answer4.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer4.setText("( X )");
        }

        if(cursor.getInt(51)==1){
            tv_moca_quiz8_answer5.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer5.setText("( X )");
        }

        tv_moca_quiz8_word_bundle1.setText(cursor.getString(24));
        tv_moca_quiz8_word_bundle2.setText(cursor.getString(25));
        tv_moca_quiz8_word_bundle3.setText(cursor.getString(26));
        tv_moca_quiz8_word_bundle4.setText(cursor.getString(27));
        tv_moca_quiz8_word_bundle5.setText(cursor.getString(28));

        tv_moca_quiz8_score.setText(toString().valueOf(cursor.getInt(52))+" 分");

        if(cursor.getInt(60)==1) {
            tv_moca_quiz9_answer1.setText(cursor.getString(53));
        }
        else{
            tv_moca_quiz9_answer1.setText("受測者無法回答");
        }

        if(cursor.getInt(60)==1) {
            tv_moca_quiz9_answer2.setText(cursor.getString(54));
        }
        else{
            tv_moca_quiz9_answer2.setText("受測者無法回答");
        }

        if(cursor.getInt(61)==1) {
            tv_moca_quiz9_answer3.setText(cursor.getString(55));
        }
        else{
            tv_moca_quiz9_answer3.setText("受測者無法回答");
        }

        if(cursor.getInt(62)==1) {
            tv_moca_quiz9_answer4.setText(cursor.getString(56));
        }
        else{
            tv_moca_quiz9_answer4.setText("受測者無法回答");
        }

        if(cursor.getInt(63)==1) {
            tv_moca_quiz9_answer5.setText(cursor.getString(57));
        }
        else{
            tv_moca_quiz9_answer5.setText("受測者無法回答");
        }

        if(cursor.getInt(64)==1) {
            tv_moca_quiz9_answer6.setText(cursor.getString(58));
        }
        else{
            tv_moca_quiz9_answer6.setText("受測者無法回答");
        }

        if(cursor.getInt(65)==1) {
            tv_moca_quiz9_answer7.setText(cursor.getString(59));
        }
        else{
            tv_moca_quiz9_answer7.setText("受測者無法回答");
        }

        tv_moca_quiz9_score.setText(toString().valueOf(cursor.getInt(66))+" 分");

        tv_moca_MOCA_total_score.setText(toString().valueOf(cursor.getInt(67))+" 分");

        if(cursor.getInt(67)>=26 && cursor.getInt(67)<=30){
            tv_moca_comment.setText("正常");
        }
        else if(cursor.getInt(67)>=0 && cursor.getInt(67)<26){
            tv_moca_comment.setText("異常 建議至醫院做更進一步的檢查");
        }
        else{
            tv_moca_comment.setTextColor(context.getResources().getColor(R.color.red));
            tv_moca_comment.setText("系統錯誤");
        }
    }

}
