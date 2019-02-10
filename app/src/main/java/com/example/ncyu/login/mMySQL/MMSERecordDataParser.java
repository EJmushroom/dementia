package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.mmseRecord;
import com.example.ncyu.login.mListView.MMSERecordAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/10/22.
 */

public class MMSERecordDataParser  extends AsyncTask<Void,Void,Integer> {
    Context c;
    ListView lv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<mmseRecord> mmseRecords=new ArrayList<>();
    static MMSERecordAdapter adapter;

    public MMSERecordDataParser(Context c, ListView lv, String jsonData) {
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
            adapter =new MMSERecordAdapter(c,mmseRecords);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            mmseRecords.clear();
            mmseRecord s=null;


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                int quiz1_ask1_disAnswer_year=jo.getInt("quiz1_ask1_disAnswer_year");
                int quiz1_ask1_disAnswer_month=jo.getInt("quiz1_ask1_disAnswer_month");
                int quiz1_ask1_disAnswer_day=jo.getInt("quiz1_ask1_disAnswer_day");
                int quiz1_ask1_disAnswer_weekday=jo.getInt("quiz1_ask1_disAnswer_weekday");
                String quiz_ask1_answer_type=jo.getString("quiz_ask1_answer_type");
                String quiz1_ask1_answer1=jo.getString("quiz1_ask1_answer1");
                String quiz1_ask1_answer2=jo.getString("quiz1_ask1_answer2");
                String quiz1_ask1_answer3=jo.getString("quiz1_ask1_answer3");
                String quiz1_ask1_answer4=jo.getString("quiz1_ask1_answer4");
                int quiz1_ask1_score=jo.getInt("quiz1_ask1_score");
                String quiz1_ask2_quiz=jo.getString("quiz1_ask2_quiz");
                String quiz1_ask2_answer=jo.getString("quiz1_ask2_answer");
                int quiz1_ask2_disAnswer=jo.getInt("quiz1_ask2_disAnswer");
                int quiz1_ask2_score=jo.getInt("quiz1_ask2_score");

                int quiz2_ask_isAnswer1=jo.getInt("quiz2_ask_isAnswer1");
                int quiz2_ask_isAnswer2=jo.getInt("quiz2_ask_isAnswer2");
                int quiz2_ask_isAnswer3=jo.getInt("quiz2_ask_isAnswer3");
                int quiz2_ask_isAnswer4=jo.getInt("quiz2_ask_isAnswer4");
                int quiz2_ask_isAnswer5=jo.getInt("quiz2_ask_isAnswer5");
                int quiz2_ask_isAnswer6=jo.getInt("quiz2_ask_isAnswer6");
                int quiz2_ask_isAnswer7=jo.getInt("quiz2_ask_isAnswer7");
                int quiz2_ask_isAnswer8=jo.getInt("quiz2_ask_isAnswer8");

                int quiz2_ask_disAnswer1=jo.getInt("quiz2_ask_disAnswer1");
                int quiz2_ask_disAnswer2=jo.getInt("quiz2_ask_disAnswer2");
                int quiz2_ask_disAnswer3=jo.getInt("quiz2_ask_disAnswer3");
                int quiz2_ask_disAnswer4=jo.getInt("quiz2_ask_disAnswer4");
                int quiz2_ask_disAnswer5=jo.getInt("quiz2_ask_disAnswer5");
                int quiz2_ask_disAnswer6=jo.getInt("quiz2_ask_disAnswer6");
                int quiz2_ask_disAnswer7=jo.getInt("quiz2_ask_disAnswer7");
                int quiz2_ask_disAnswer8=jo.getInt("quiz2_ask_disAnswer8");

                String quiz2_answer1=jo.getString("quiz2_answer1");
                String quiz2_answer2=jo.getString("quiz2_answer2");
                String quiz2_answer3=jo.getString("quiz2_answer3");
                String quiz2_answer4=jo.getString("quiz2_answer4");
                String quiz2_answer5=jo.getString("quiz2_answer5");
                String quiz2_answer6=jo.getString("quiz2_answer6");
                String quiz2_answer7=jo.getString("quiz2_answer7");
                String quiz2_answer8=jo.getString("quiz2_answer8");

                int quiz2_score=jo.getInt("quiz2_score");

                String quiz3_word_bundle1=jo.getString("quiz3_word_bundle1");
                String quiz3_word_bundle2=jo.getString("quiz3_word_bundle2");
                String quiz3_word_bundle3=jo.getString("quiz3_word_bundle3");

                int quiz3_word1=jo.getInt("quiz3_word1");
                int quiz3_word2=jo.getInt("quiz3_word2");
                int quiz3_word3=jo.getInt("quiz3_word3");

                int quiz3_score=jo.getInt("quiz3_score");

                String quiz4_answer1=jo.getString("quiz4_answer1");
                String quiz4_answer2=jo.getString("quiz4_answer2");
                String quiz4_answer3=jo.getString("quiz4_answer3");
                String quiz4_answer4=jo.getString("quiz4_answer4");
                String quiz4_answer5=jo.getString("quiz4_answer5");

                int quiz4_score=jo.getInt("quiz4_score");
                int quiz5_word1=jo.getInt("quiz5_word1");
                int quiz5_word2=jo.getInt("quiz5_word2");
                int quiz5_word3=jo.getInt("quiz5_word3");

                int quiz5_score=jo.getInt("quiz5_score");

                String quiz6_ask1_word1=jo.getString("quiz6_ask1_word1");
                String quiz6_ask1_word2=jo.getString("quiz6_ask1_word2");
                String quiz6_ask2_word=jo.getString("quiz6_ask2_word");
                int quiz6_ask2_answer=jo.getInt("quiz6_ask2_answer");
                String quiz6_ask3_quiz=jo.getString("quiz6_ask3_quiz");
                int quiz6_ask3_answer=jo.getInt("quiz6_ask3_answer");
                String quiz6_ask4_answer=jo.getString("quiz6_ask4_answer");
                int quiz6_score=jo.getInt("quiz6_score");
                String quiz7_bundle=jo.getString("quiz7_bundle");
                int quiz7_answer=jo.getInt("quiz7_answer");
                int quiz7_score=jo.getInt("quiz7_score");
                int quiz8_word1=jo.getInt("quiz8_word1");
                int quiz8_word2=jo.getInt("quiz8_word2");
                int quiz8_word3=jo.getInt("quiz8_word3");
                int quiz8_score=jo.getInt("quiz8_score");
                int MMSE_total_score=jo.getInt("MMSE_total_score");

                s=new mmseRecord();
                s.setQ1a1dAyear(quiz1_ask1_disAnswer_year);
                s.setQ1a1dAmonth(quiz1_ask1_disAnswer_month);
                s.setQ1a1dAday(quiz1_ask1_disAnswer_day);
                s.setQ1a1dAweekday(quiz1_ask1_disAnswer_weekday);
                s.setQ1a1atype(quiz_ask1_answer_type);
                s.setQ1a1A1(quiz1_ask1_answer1);
                s.setQ1a1A2(quiz1_ask1_answer2);
                s.setQ1a1A3(quiz1_ask1_answer3);
                s.setQ1a1A4(quiz1_ask1_answer4);
                s.setQ1a1score(quiz1_ask1_score);
                s.setQ1a2quiz(quiz1_ask2_quiz);
                s.setQ1a2A(quiz1_ask2_answer);
                s.setQ1a2dA(quiz1_ask2_disAnswer);
                s.setQ1a2score(quiz1_ask2_score);

                s.setQ2aisA1(quiz2_ask_isAnswer1);
                s.setQ2aisA2(quiz2_ask_isAnswer2);
                s.setQ2aisA3(quiz2_ask_isAnswer3);
                s.setQ2aisA4(quiz2_ask_isAnswer4);
                s.setQ2aisA5(quiz2_ask_isAnswer5);
                s.setQ2aisA6(quiz2_ask_isAnswer6);
                s.setQ2aisA7(quiz2_ask_isAnswer7);
                s.setQ2aisA8(quiz2_ask_isAnswer8);

                s.setQ2adA1(quiz2_ask_disAnswer1);
                s.setQ2adA2(quiz2_ask_disAnswer2);
                s.setQ2adA3(quiz2_ask_disAnswer3);
                s.setQ2adA4(quiz2_ask_disAnswer4);
                s.setQ2adA5(quiz2_ask_disAnswer5);
                s.setQ2adA6(quiz2_ask_disAnswer6);
                s.setQ2adA7(quiz2_ask_disAnswer7);
                s.setQ2adA8(quiz2_ask_disAnswer8);

                s.setQ2A1(quiz2_answer1);
                s.setQ2A2(quiz2_answer2);
                s.setQ2A3(quiz2_answer3);
                s.setQ2A4(quiz2_answer4);
                s.setQ2A5(quiz2_answer5);
                s.setQ2A6(quiz2_answer6);
                s.setQ2A7(quiz2_answer7);
                s.setQ2A8(quiz2_answer8);

                s.setQ2score(quiz2_score);

                s.setQ3wB1(quiz3_word_bundle1);
                s.setQ3wB2(quiz3_word_bundle2);
                s.setQ3wB3(quiz3_word_bundle3);

                s.setQ3w1(quiz3_word1);
                s.setQ3w2(quiz3_word2);
                s.setQ3w3(quiz3_word3);

                s.setQ3score(quiz3_score);

                s.setQ4A1(quiz4_answer1);
                s.setQ4A2(quiz4_answer2);
                s.setQ4A3(quiz4_answer3);
                s.setQ4A4(quiz4_answer4);
                s.setQ4A5(quiz4_answer5);

                s.setQ4score(quiz4_score);

                s.setQ5w1(quiz5_word1);
                s.setQ5w2(quiz5_word2);
                s.setQ5w3(quiz5_word3);

                s.setQ5score(quiz5_score);

                s.setQ6a1w1(quiz6_ask1_word1);
                s.setQ6a1w2(quiz6_ask1_word2);

                s.setQ6a2w(quiz6_ask2_word);
                s.setQ6a2A(quiz6_ask2_answer);
                s.setQ6a3quiz(quiz6_ask3_quiz);
                s.setQ6a3A(quiz6_ask3_answer);
                s.setQ6a4A(quiz6_ask4_answer);

                s.setQ6score(quiz6_score);
                s.setPdraw(quiz7_bundle);
                s.setQ7A(quiz7_answer);
                s.setQ7score(quiz7_score);

                s.setQ8w1(quiz8_word1);
                s.setQ8w2(quiz8_word2);
                s.setQ8w3(quiz8_word3);

                s.setQ8score(quiz8_score);

                s.setMMSE_total_score(MMSE_total_score);

                mmseRecords.add(s);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static MMSERecordAdapter getAdapter(){
        return adapter;
    }
}
