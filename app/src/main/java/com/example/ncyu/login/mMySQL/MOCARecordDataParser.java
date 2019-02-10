package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.mocaRecord;
import com.example.ncyu.login.mListView.MOCARecordAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/12/18.
 */

public class MOCARecordDataParser extends AsyncTask<Void,Void,Integer> {
    Context c;
    ListView lv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<mocaRecord> mocaRecords=new ArrayList<>();
    static MOCARecordAdapter adapter;

    public MOCARecordDataParser(Context c, ListView lv, String jsonData) {
        this.c = c;
        this.lv = lv;
        this.jsonData = jsonData;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("載入中");
        pd.setMessage("載入中...請稍候...");
        pd.show();
    }
    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();
        if(result ==0)
        {
            Toast.makeText(c,"無資料",Toast.LENGTH_SHORT).show();
        }else{
            //CALL ADAPTER TO BIND DATA
            adapter =new MOCARecordAdapter(c,mocaRecords);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            mocaRecords.clear();
            mocaRecord s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int quiz1_answer=jo.getInt("quiz1_answer");
                int quiz1_score=jo.getInt("quiz1_score");
                int quiz2_ask_answer=jo.getInt("quiz2_ask_answer");
                int quiz2_ask2_answer1=jo.getInt("quiz2_ask2_answer1");
                int quiz2_ask2_answer2=jo.getInt("quiz2_ask2_answer2");
                int quiz2_ask2_answer3=jo.getInt("quiz2_ask2_answer3");
                int quiz2_score=jo.getInt("quiz2_score");
                int quiz3_answer1=jo.getInt("quiz3_answer1");
                int quiz3_answer2=jo.getInt("quiz3_answer2");
                int quiz3_answer3=jo.getInt("quiz3_answer3");
                int quiz3_score=jo.getInt("quiz3_score");
                int quiz4_answer_first1=jo.getInt("quiz4_answer_first1");
                int quiz4_answer_first2=jo.getInt("quiz4_answer_first2");
                int quiz4_answer_first3=jo.getInt("quiz4_answer_first3");
                int quiz4_answer_first4=jo.getInt("quiz4_answer_first4");
                int quiz4_answer_first5=jo.getInt("quiz4_answer_first5");
                int quiz4_answer_second1=jo.getInt("quiz4_answer_second1");
                int quiz4_answer_second2=jo.getInt("quiz4_answer_second2");
                int quiz4_answer_second3=jo.getInt("quiz4_answer_second3");
                int quiz4_answer_second4=jo.getInt("quiz4_answer_second4");
                int quiz4_answer_second5=jo.getInt("quiz4_answer_second5");
                int quiz4_score=jo.getInt("quiz4_score");
                int quiz5_ask1_answer1=jo.getInt("quiz5_ask1_answer1");
                int quiz5_ask1_answer2=jo.getInt("quiz5_ask1_answer2");
                int quiz5_ask1_answer3=jo.getInt("quiz5_ask1_answer3");
                int quiz5_ask2_isRight=jo.getInt("quiz5_ask2_isRight");
                int quiz5_score=jo.getInt("quiz5_score");
                int quiz6_ask_quiz_isRight1=jo.getInt("quiz6_ask_quiz_isRight1");
                int quiz6_ask_quiz_isRight2=jo.getInt("quiz6_ask_quiz_isRight2");
                int quiz6_ask2_answer=jo.getInt("quiz6_ask2_answer");
                int quiz6_score=jo.getInt("quiz6_score");
                int quiz7_answer1=jo.getInt("quiz7_answer1");
                int quiz7_answer2=jo.getInt("quiz7_answer2");
                int quiz7_score=jo.getInt("quiz7_score");
                int quiz8_answer1=jo.getInt("quiz8_answer1");
                int quiz8_answer2=jo.getInt("quiz8_answer2");
                int quiz8_answer3=jo.getInt("quiz8_answer3");
                int quiz8_answer4=jo.getInt("quiz8_answer4");
                int quiz8_answer5=jo.getInt("quiz8_answer5");
                int quiz8_score=jo.getInt("quiz8_score");
                int quiz9_isAnswer1=jo.getInt("quiz9_isAnswer1");
                int quiz9_isAnswer2=jo.getInt("quiz9_isAnswer2");
                int quiz9_isAnswer3=jo.getInt("quiz9_isAnswer3");
                int quiz9_isAnswer4=jo.getInt("quiz9_isAnswer4");
                int quiz9_isAnswer5=jo.getInt("quiz9_isAnswer5");
                int quiz9_isAnswer6=jo.getInt("quiz9_isAnswer6");
                int quiz9_score=jo.getInt("quiz9_score");
                int MOCA_total_score=jo.getInt("MOCA_total_score");

                String quiz2_ask_bundle=jo.getString("quiz2_ask_bundle");
                String quiz2_ask2_bundle=jo.getString("quiz2_ask2_bundle");
                String quiz4_word_bundle1=jo.getString("quiz4_word_bundle1");
                String quiz4_word_bundle2=jo.getString("quiz4_word_bundle2");
                String quiz4_word_bundle3=jo.getString("quiz4_word_bundle3");
                String quiz4_word_bundle4=jo.getString("quiz4_word_bundle4");
                String quiz4_word_bundle5=jo.getString("quiz4_word_bundle5");
                String quiz5_ask2_answer1=jo.getString("quiz5_ask2_answer1");
                String quiz5_ask2_answer2=jo.getString("quiz5_ask2_answer2");
                String quiz5_ask2_answer3=jo.getString("quiz5_ask2_answer3");
                String quiz5_ask2_answer4=jo.getString("quiz5_ask2_answer4");
                String quiz5_ask2_answer5=jo.getString("quiz5_ask2_answer5");
                String quiz9_answer1=jo.getString("quiz9_answer1");
                String quiz9_answer2=jo.getString("quiz9_answer2");
                String quiz9_answer3=jo.getString("quiz9_answer3");
                String quiz9_answer4=jo.getString("quiz9_answer4");
                String quiz9_answer5=jo.getString("quiz9_answer5");
                String quiz9_answer6=jo.getString("quiz9_answer6");
                String quiz9_answer7=jo.getString("quiz9_answer7");

                s=new mocaRecord();
                s.setQuiz1_answer(quiz1_answer);
                s.setQuiz1_score(quiz1_score);
                s.setQuiz2_ask_bundle(quiz2_ask_bundle);
                s.setQuiz2_ask_answer(quiz2_ask_answer);
                s.setQuiz2_ask2_bundle(quiz2_ask2_bundle);
                s.setQuiz2_ask2_answer1(quiz2_ask2_answer1);
                s.setQuiz2_ask2_answer2(quiz2_ask2_answer2);
                s.setQuiz2_ask2_answer3(quiz2_ask2_answer3);
                s.setQuiz2_score(quiz2_score);
                s.setQuiz3_answer1(quiz3_answer1);
                s.setQuiz3_answer2(quiz3_answer2);
                s.setQuiz3_answer3(quiz3_answer3);
                s.setQuiz3_score(quiz3_score);
                s.setQuiz4_answer_first1(quiz4_answer_first1);
                s.setQuiz4_answer_first2(quiz4_answer_first2);
                s.setQuiz4_answer_first3(quiz4_answer_first3);
                s.setQuiz4_answer_first4(quiz4_answer_first4);
                s.setQuiz4_answer_first5(quiz4_answer_first5);
                s.setQuiz4_answer_second1(quiz4_answer_second1);
                s.setQuiz4_answer_second2(quiz4_answer_second2);
                s.setQuiz4_answer_second3(quiz4_answer_second3);
                s.setQuiz4_answer_second4(quiz4_answer_second4);
                s.setQuiz4_answer_second5(quiz4_answer_second5);
                s.setQuiz4_word_bundle1(quiz4_word_bundle1);
                s.setQuiz4_word_bundle2(quiz4_word_bundle2);
                s.setQuiz4_word_bundle3(quiz4_word_bundle3);
                s.setQuiz4_word_bundle4(quiz4_word_bundle4);
                s.setQuiz4_word_bundle5(quiz4_word_bundle5);
                s.setQuiz4_score(quiz4_score);
                s.setQuiz5_ask1_answer1(quiz5_ask1_answer1);
                s.setQuiz5_ask1_answer2(quiz5_ask1_answer2);
                s.setQuiz5_ask1_answer3(quiz5_ask1_answer3);
                s.setQuiz5_ask2_answer1(quiz5_ask2_answer1);
                s.setQuiz5_ask2_answer2(quiz5_ask2_answer2);
                s.setQuiz5_ask2_answer3(quiz5_ask2_answer3);
                s.setQuiz5_ask2_answer4(quiz5_ask2_answer4);
                s.setQuiz5_ask2_answer5(quiz5_ask2_answer5);
                s.setQuiz5_ask2_isRight(quiz5_ask2_isRight);
                s.setQuiz5_score(quiz5_score);
                s.setQuiz6_ask_quiz_isRight1(quiz6_ask_quiz_isRight1);
                s.setQuiz6_ask_quiz_isRight2(quiz6_ask_quiz_isRight2);
                s.setQuiz6_ask2_answer(quiz6_ask2_answer);
                s.setQuiz6_score(quiz6_score);
                s.setQuiz7_answer1(quiz7_answer1);
                s.setQuiz7_answer2(quiz7_answer2);
                s.setQuiz7_score(quiz7_score);
                s.setQuiz8_answer1(quiz8_answer1);
                s.setQuiz8_answer2(quiz8_answer2);
                s.setQuiz8_answer3(quiz8_answer3);
                s.setQuiz8_answer4(quiz8_answer4);
                s.setQuiz8_answer5(quiz8_answer5);
                s.setQuiz8_score(quiz8_score);
                s.setQuiz9_answer1(quiz9_answer1);
                s.setQuiz9_answer2(quiz9_answer2);
                s.setQuiz9_answer3(quiz9_answer3);
                s.setQuiz9_answer4(quiz9_answer4);
                s.setQuiz9_answer5(quiz9_answer5);
                s.setQuiz9_answer6(quiz9_answer6);
                s.setQuiz9_answer7(quiz9_answer7);
                s.setQuiz9_isAnswer1(quiz9_isAnswer1);
                s.setQuiz9_isAnswer2(quiz9_isAnswer2);
                s.setQuiz9_isAnswer3(quiz9_isAnswer3);
                s.setQuiz9_isAnswer4(quiz9_isAnswer4);
                s.setQuiz9_isAnswer5(quiz9_isAnswer5);
                s.setQuiz9_isAnswer6(quiz9_isAnswer6);
                s.setQuiz9_score(quiz9_score);
                s.setMOCA_total_score(MOCA_total_score);

                mocaRecords.add(s);

            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
    public static MOCARecordAdapter getAdapter(){
        return adapter;
    }

}
