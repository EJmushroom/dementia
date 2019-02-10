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
import com.example.ncyu.login.mDataObject.mocaRecord;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/12/18.
 */

public class MOCARecordAdapter extends BaseAdapter {
    Context c;
    ArrayList<mocaRecord> mocaRecords;
    LayoutInflater inflater;

    public MOCARecordAdapter(Context c, ArrayList<mocaRecord> mocaRecords) {
        this.c = c;
        this.mocaRecords = mocaRecords;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mocaRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return mocaRecords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.moca_record_model, parent, false);
        }


        TextView tv_moca_quiz1_answer=(TextView)convertView.findViewById(R.id.tv_moca_quiz1_answer);
        TextView tv_moca_quiz1_score=(TextView)convertView.findViewById(R.id.tv_moca_quiz1_score);
        TextView tv_moca_quiz2_score=(TextView)convertView.findViewById(R.id.tv_moca_quiz2_score);
        ImageView img_Psquare=(ImageView)convertView.findViewById(R.id.img_Psquare);
        TextView tv_moca_quiz2_ask_answer=(TextView)convertView.findViewById(R.id.tv_moca_quiz2_ask_answer);
        ImageView img_Pclock=(ImageView)convertView.findViewById(R.id.img_Pclock);
        TextView tv_moca_quiz2_ask2_answer1=(TextView)convertView.findViewById(R.id.tv_moca_quiz2_ask2_answer1);
        TextView tv_moca_quiz2_ask2_answer2=(TextView)convertView.findViewById(R.id.tv_moca_quiz2_ask2_answer2);
        TextView tv_moca_quiz2_ask2_answer3=(TextView)convertView.findViewById(R.id.tv_moca_quiz2_ask2_answer3);
        TextView tv_moca_quiz3_score=(TextView)convertView.findViewById(R.id.tv_moca_quiz3_score);
        TextView tv_moca_quiz3_answer1=(TextView)convertView.findViewById(R.id.tv_moca_quiz3_answer1);
        TextView tv_moca_quiz3_answer2=(TextView)convertView.findViewById(R.id.tv_moca_quiz3_answer2);
        TextView tv_moca_quiz3_answer3=(TextView)convertView.findViewById(R.id.tv_moca_quiz3_answer3);
        TextView tv_moca_quiz4_score=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_score);
        TextView tv_moca_quiz4_word_bundle1=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_word_bundle1);
        TextView tv_moca_quiz4_answer_first1=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_first1);
        TextView tv_moca_quiz4_answer_second1=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_second1);
        TextView tv_moca_quiz4_word_bundle2=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_word_bundle2);
        TextView tv_moca_quiz4_answer_first2=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_first2);
        TextView tv_moca_quiz4_answer_second2=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_second2);
        TextView tv_moca_quiz4_word_bundle3=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_word_bundle3);
        TextView tv_moca_quiz4_answer_first3=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_first3);
        TextView tv_moca_quiz4_answer_second3=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_second3);
        TextView tv_moca_quiz4_word_bundle4=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_word_bundle4);
        TextView tv_moca_quiz4_answer_first4=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_first4);
        TextView tv_moca_quiz4_answer_second4=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_second4);
        TextView tv_moca_quiz4_word_bundle5=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_word_bundle5);
        TextView tv_moca_quiz4_answer_first5=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_first5);
        TextView tv_moca_quiz4_answer_second5=(TextView)convertView.findViewById(R.id.tv_moca_quiz4_answer_second5);
        TextView tv_moca_quiz5_score=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_score);
        TextView tv_moca_quiz5_ask1_answer1=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_ask1_answer1);
        TextView tv_moca_quiz5_ask1_answer2=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_ask1_answer2);
        TextView tv_moca_quiz5_ask1_answer3=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_ask1_answer3);
        TextView tv_moca_quiz5_ask2_answer1=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_ask2_answer1);
        TextView tv_moca_quiz5_ask2_answer2=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_ask2_answer2);
        TextView tv_moca_quiz5_ask2_answer3=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_ask2_answer3);
        TextView tv_moca_quiz5_ask2_answer4=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_ask2_answer4);
        TextView tv_moca_quiz5_ask2_answer5=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_ask2_answer5);
        TextView tv_moca_quiz5_ask2_isRight=(TextView)convertView.findViewById(R.id.tv_moca_quiz5_ask2_isRight);
        TextView tv_moca_quiz6_score=(TextView)convertView.findViewById(R.id.tv_moca_quiz6_score);
        TextView tv_moca_quiz6_ask_quiz_isRight1=(TextView)convertView.findViewById(R.id.tv_moca_quiz6_ask_quiz_isRight1);
        TextView tv_moca_quiz6_ask_quiz_isRight2=(TextView)convertView.findViewById(R.id.tv_moca_quiz6_ask_quiz_isRight2);
        TextView tv_moca_quiz6_ask2_answer=(TextView)convertView.findViewById(R.id.tv_moca_quiz6_ask2_answer);
        TextView tv_moca_quiz7_score=(TextView)convertView.findViewById(R.id.tv_moca_quiz7_score);
        TextView tv_moca_quiz7_answer1=(TextView)convertView.findViewById(R.id.tv_moca_quiz7_answer1);
        TextView tv_moca_quiz7_answer2=(TextView)convertView.findViewById(R.id.tv_moca_quiz7_answer2);
        TextView tv_moca_quiz8_score=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_score);
        TextView tv_moca_quiz8_word_bundle1=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_word_bundle1);
        TextView tv_moca_quiz8_answer1=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_answer1);
        TextView tv_moca_quiz8_word_bundle2=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_word_bundle2);
        TextView tv_moca_quiz8_answer2=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_answer2);
        TextView tv_moca_quiz8_word_bundle3=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_word_bundle3);
        TextView tv_moca_quiz8_answer3=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_answer3);
        TextView tv_moca_quiz8_word_bundle4=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_word_bundle4);
        TextView tv_moca_quiz8_answer4=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_answer4);
        TextView tv_moca_quiz8_word_bundle5=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_word_bundle5);
        TextView tv_moca_quiz8_answer5=(TextView)convertView.findViewById(R.id.tv_moca_quiz8_answer5);
        TextView tv_moca_quiz9_score=(TextView)convertView.findViewById(R.id.tv_moca_quiz9_score);
        TextView tv_moca_quiz9_answer1=(TextView)convertView.findViewById(R.id.tv_moca_quiz9_answer1);
        TextView tv_moca_quiz9_answer2=(TextView)convertView.findViewById(R.id.tv_moca_quiz9_answer2);
        TextView tv_moca_quiz9_answer3=(TextView)convertView.findViewById(R.id.tv_moca_quiz9_answer3);
        TextView tv_moca_quiz9_answer4=(TextView)convertView.findViewById(R.id.tv_moca_quiz9_answer4);
        TextView tv_moca_quiz9_answer5=(TextView)convertView.findViewById(R.id.tv_moca_quiz9_answer5);
        TextView tv_moca_quiz9_answer6=(TextView)convertView.findViewById(R.id.tv_moca_quiz9_answer6);
        TextView tv_moca_quiz9_answer7=(TextView)convertView.findViewById(R.id.tv_moca_quiz9_answer7);
        TextView tv_moca_MOCA_total_score=(TextView)convertView.findViewById(R.id.tv_moca_MOCA_total_score);
        TextView tv_moca_comment=(TextView)convertView.findViewById(R.id.tv_moca_comment);

        if(mocaRecords.get(position).getQuiz1_answer()==1){
            tv_moca_quiz1_answer.setText("( O )");
        }else{
            tv_moca_quiz1_answer.setText("( X )");
        }

        tv_moca_quiz1_score.setText(toString().valueOf(mocaRecords.get(position).getQuiz1_score())+" 分");
        tv_moca_quiz2_score.setText(toString().valueOf(mocaRecords.get(position).getQuiz2_score())+" 分");

        //顯示受測者所繪圖片
        byte[] bytearrayImage1= Base64.decode(mocaRecords.get(position).getQuiz2_ask_bundle(), Base64.DEFAULT);
        Bitmap bitmap1 = BitmapFactory.decodeByteArray(bytearrayImage1, 0, bytearrayImage1.length);
        // 受測者的图片的宽高
        int width1 = bitmap1.getWidth();
        int height1 = bitmap1.getHeight();
        // 设置想要的大小
        //取得原本圖片寬高
        Bitmap originalBmp1 = BitmapFactory.decodeResource(convertView.getResources(), R.drawable.quiz2_square);
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
        byte[] bytearrayImage2= Base64.decode(mocaRecords.get(position).getQuiz2_ask2_bundle(), Base64.DEFAULT);
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(bytearrayImage2, 0, bytearrayImage2.length);
        // 受測者的图片的宽高
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        // 设置想要的大小
        //取得原本圖片寬高
        Bitmap originalBmp2 = BitmapFactory.decodeResource(convertView.getResources(), R.drawable.quiz2_ask2_clock);
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

        if(mocaRecords.get(position).getQuiz2_ask_answer()==1) {
            tv_moca_quiz2_ask_answer.setText("( O )");
        }
        else{
            tv_moca_quiz2_ask_answer.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz2_ask2_answer1()==1){
            tv_moca_quiz2_ask2_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz2_ask2_answer1.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz2_ask2_answer2()==1){
            tv_moca_quiz2_ask2_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz2_ask2_answer2.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz2_ask2_answer3()==1){
            tv_moca_quiz2_ask2_answer3.setText("( O )");
        }
        else{
            tv_moca_quiz2_ask2_answer3.setText("( X )");
        }

        tv_moca_quiz3_score.setText(toString().valueOf(mocaRecords.get(position).getQuiz3_score())+" 分");

        if(mocaRecords.get(position).getQuiz3_answer1()==1){
            tv_moca_quiz3_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz3_answer1.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz3_answer2()==1){
            tv_moca_quiz3_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz3_answer2.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz3_answer3()==1){
            tv_moca_quiz3_answer3.setText("( O )");
        }
        else{
            tv_moca_quiz3_answer3.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_first1()==1){
            tv_moca_quiz4_answer_first1.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first1.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_first2()==1){
            tv_moca_quiz4_answer_first2.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first2.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_first3()==1){
            tv_moca_quiz4_answer_first3.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first3.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_first4()==1){
            tv_moca_quiz4_answer_first4.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first4.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_first5()==1){
            tv_moca_quiz4_answer_first5.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_first5.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_second1()==1){
            tv_moca_quiz4_answer_second1.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second1.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_second2()==1){
            tv_moca_quiz4_answer_second2.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second2.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_second3()==1){
            tv_moca_quiz4_answer_second3.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second3.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_second4()==1){
            tv_moca_quiz4_answer_second4.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second4.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz4_answer_second5()==1){
            tv_moca_quiz4_answer_second5.setText("( O )");
        }
        else{
            tv_moca_quiz4_answer_second5.setText("( X )");
        }

        tv_moca_quiz4_word_bundle1.setText(mocaRecords.get(position).getQuiz4_word_bundle1());
        tv_moca_quiz4_word_bundle2.setText(mocaRecords.get(position).getQuiz4_word_bundle2());
        tv_moca_quiz4_word_bundle3.setText(mocaRecords.get(position).getQuiz4_word_bundle3());
        tv_moca_quiz4_word_bundle4.setText(mocaRecords.get(position).getQuiz4_word_bundle4());
        tv_moca_quiz4_word_bundle5.setText(mocaRecords.get(position).getQuiz4_word_bundle5());

        tv_moca_quiz4_score.setText("不計分");

        if(mocaRecords.get(position).getQuiz5_ask1_answer1()==1){
            tv_moca_quiz5_ask1_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz5_ask1_answer1.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz5_ask1_answer2()==1){
            tv_moca_quiz5_ask1_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz5_ask1_answer2.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz5_ask1_answer3()==1){
            tv_moca_quiz5_ask1_answer3.setText("( O )");
        }
        else{
            tv_moca_quiz5_ask1_answer3.setText("( X )");
        }

        tv_moca_quiz5_ask2_answer1.setText(mocaRecords.get(position).getQuiz5_ask2_answer1());
        tv_moca_quiz5_ask2_answer2.setText(mocaRecords.get(position).getQuiz5_ask2_answer2());
        tv_moca_quiz5_ask2_answer3.setText(mocaRecords.get(position).getQuiz5_ask2_answer3());
        tv_moca_quiz5_ask2_answer4.setText(mocaRecords.get(position).getQuiz5_ask2_answer4());
        tv_moca_quiz5_ask2_answer5.setText(mocaRecords.get(position).getQuiz5_ask2_answer5());

        if(mocaRecords.get(position).getQuiz5_ask2_isRight()==1){
            tv_moca_quiz5_ask2_isRight.setText("( O )");
        }
        else{
            tv_moca_quiz5_ask2_isRight.setText("( X )");
        }

        tv_moca_quiz5_score.setText(toString().valueOf(mocaRecords.get(position).getQuiz5_score())+" 分");

        if(mocaRecords.get(position).getQuiz6_ask_quiz_isRight1()==1){
            tv_moca_quiz6_ask_quiz_isRight1.setText("( O )");
        }
        else{
            tv_moca_quiz6_ask_quiz_isRight1.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz6_ask_quiz_isRight2()==1){
            tv_moca_quiz6_ask_quiz_isRight2.setText("( O )");
        }
        else{
            tv_moca_quiz6_ask_quiz_isRight2.setText("( X )");
        }

        tv_moca_quiz6_ask2_answer.setText(toString().valueOf(mocaRecords.get(position).getQuiz6_ask2_answer()));

        tv_moca_quiz6_score.setText(toString().valueOf(mocaRecords.get(position).getQuiz6_score())+" 分");

        if(mocaRecords.get(position).getQuiz7_answer1()==1){
            tv_moca_quiz7_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz7_answer1.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz7_answer2()==1){
            tv_moca_quiz7_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz7_answer2.setText("( X )");
        }

        tv_moca_quiz7_score.setText(toString().valueOf(mocaRecords.get(position).getQuiz7_score())+" 分");

        if(mocaRecords.get(position).getQuiz8_answer1()==1){
            tv_moca_quiz8_answer1.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer1.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz8_answer2()==1){
            tv_moca_quiz8_answer2.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer2.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz8_answer3()==1){
            tv_moca_quiz8_answer3.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer3.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz8_answer4()==1){
            tv_moca_quiz8_answer4.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer4.setText("( X )");
        }

        if(mocaRecords.get(position).getQuiz8_answer5()==1){
            tv_moca_quiz8_answer5.setText("( O )");
        }
        else{
            tv_moca_quiz8_answer5.setText("( X )");
        }

        tv_moca_quiz8_word_bundle1.setText(mocaRecords.get(position).getQuiz4_word_bundle1());
        tv_moca_quiz8_word_bundle2.setText(mocaRecords.get(position).getQuiz4_word_bundle2());
        tv_moca_quiz8_word_bundle3.setText(mocaRecords.get(position).getQuiz4_word_bundle3());
        tv_moca_quiz8_word_bundle4.setText(mocaRecords.get(position).getQuiz4_word_bundle4());
        tv_moca_quiz8_word_bundle5.setText(mocaRecords.get(position).getQuiz4_word_bundle5());

        tv_moca_quiz8_score.setText(toString().valueOf(mocaRecords.get(position).getQuiz8_score())+" 分");

        if(mocaRecords.get(position).getQuiz9_isAnswer1()==1) {
            tv_moca_quiz9_answer1.setText(mocaRecords.get(position).getQuiz9_answer1());
        }
        else{
            tv_moca_quiz9_answer1.setText("受測者無法回答");
        }

        if(mocaRecords.get(position).getQuiz9_isAnswer1()==1) {
            tv_moca_quiz9_answer2.setText(mocaRecords.get(position).getQuiz9_answer2());
        }
        else{
            tv_moca_quiz9_answer2.setText("受測者無法回答");
        }

        if(mocaRecords.get(position).getQuiz9_isAnswer2()==1) {
            tv_moca_quiz9_answer3.setText(mocaRecords.get(position).getQuiz9_answer3());
        }
        else{
            tv_moca_quiz9_answer3.setText("受測者無法回答");
        }

        if(mocaRecords.get(position).getQuiz9_isAnswer3()==1) {
            tv_moca_quiz9_answer4.setText(mocaRecords.get(position).getQuiz9_answer4());
        }
        else{
            tv_moca_quiz9_answer4.setText("受測者無法回答");
        }

        if(mocaRecords.get(position).getQuiz9_isAnswer4()==1) {
            tv_moca_quiz9_answer5.setText(mocaRecords.get(position).getQuiz9_answer5());
        }
        else{
            tv_moca_quiz9_answer5.setText("受測者無法回答");
        }

        if(mocaRecords.get(position).getQuiz9_isAnswer5()==1) {
            tv_moca_quiz9_answer6.setText(mocaRecords.get(position).getQuiz9_answer6());
        }
        else{
            tv_moca_quiz9_answer6.setText("受測者無法回答");
        }

        if(mocaRecords.get(position).getQuiz9_isAnswer6()==1) {
            tv_moca_quiz9_answer7.setText(mocaRecords.get(position).getQuiz9_answer7());
        }
        else{
            tv_moca_quiz9_answer7.setText("受測者無法回答");
        }

        tv_moca_quiz9_score.setText(toString().valueOf(mocaRecords.get(position).getQuiz9_score())+" 分");

        tv_moca_MOCA_total_score.setText(toString().valueOf(mocaRecords.get(position).getMOCA_total_score())+" 分");

        if(mocaRecords.get(position).getMOCA_total_score()>=26 && mocaRecords.get(position).getMOCA_total_score()<=30){
            tv_moca_comment.setText("正常");
        }
        else if(mocaRecords.get(position).getMOCA_total_score()>=0 && mocaRecords.get(position).getMOCA_total_score()<26){
            tv_moca_comment.setText("異常 建議至醫院做更進一步的檢查");
        }
        else{
            tv_moca_comment.setTextColor(convertView.getResources().getColor(R.color.red));
            tv_moca_comment.setText("系統錯誤");
        }

        return convertView;
    }
}
