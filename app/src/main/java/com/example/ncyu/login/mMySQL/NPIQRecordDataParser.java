package com.example.ncyu.login.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ncyu.login.mDataObject.npiqRecord;
import com.example.ncyu.login.mListView.NPIQRecordAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/9/18.
 */

public class NPIQRecordDataParser extends AsyncTask<Void,Void,Integer> {
    Context c;
    ListView lv;
    String jsonData;
    ProgressDialog pd;
    ArrayList<npiqRecord> npiqRecords=new ArrayList<>();
    static NPIQRecordAdapter adapter;

    public NPIQRecordDataParser(Context c, ListView lv, String jsonData) {
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
            adapter =new NPIQRecordAdapter(c,npiqRecords);
            lv.setAdapter(adapter);
        }
    }
    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;


            npiqRecords.clear();
            npiqRecord s=null;


            for(int i=0;i<ja.length();i++)
            {
                Boolean if_wishful_thinking;
                jo=ja.getJSONObject(i);

                if(jo.getInt("if_wishful_thinking")==1){
                    if_wishful_thinking=true;
                }
                else{
                    if_wishful_thinking=false;
                }
                Boolean if_illusion;

                if(jo.getInt("if_illusion")==1){
                    if_illusion=true;
                }
                else{
                    if_illusion=false;
                }
                Boolean if_attack;
                if(jo.getInt("if_attack")==1){
                    if_attack=true;
                }
                else{
                    if_attack=false;
                }
                Boolean if_melancholy;
                if(jo.getInt("if_melancholy")==1){
                    if_melancholy=true;
                }
                else{
                    if_melancholy=false;
                }
                Boolean if_anxious;
                if(jo.getInt("if_anxious")==1){
                    if_anxious=true;
                }
                else{
                    if_anxious=false;
                }
                Boolean if_happy;
                if(jo.getInt("if_happy")==1){
                    if_happy=true;
                }
                else{
                    if_happy=false;
                }
                Boolean if_cold;
                if(jo.getInt("if_cold")==1){
                    if_cold=true;
                }
                else{
                    if_cold=false;
                }
                Boolean if_out_of_control;
                if(jo.getInt("if_out_of_control")==1){
                    if_out_of_control=true;
                }
                else{
                    if_out_of_control=false;
                }
                Boolean if_easy_angry;
                if(jo.getInt("if_easy_angry")==1){
                    if_easy_angry=true;
                }
                else{
                    if_easy_angry=false;
                }
                Boolean if_weird_action;
                if(jo.getInt("if_weird_action")==1){
                    if_weird_action=true;
                }
                else{
                    if_weird_action=false;
                }
                Boolean if_nighttime_behavior;
                if(jo.getInt("if_nighttime_behavior")==1){
                    if_nighttime_behavior=true;
                }
                else{
                    if_nighttime_behavior=false;
                }
                Boolean if_appetite_diet_changed;
                if(jo.getInt("if_appetite_diet_changed")==1){
                    if_appetite_diet_changed=true;
                }
                else{
                    if_appetite_diet_changed=false;
                }

                int wishful_thinking_severity=jo.getInt("wishful_thinking_severity");
                int illusion_severity=jo.getInt("illusion_severity");
                int attack_severity=jo.getInt("attack_severity");
                int melancholy_severity=jo.getInt("melancholy_severity");
                int anxious_severity=jo.getInt("anxious_severity");
                int happy_severity=jo.getInt("happy_severity");
                int cold_severity=jo.getInt("cold_severity");
                int out_of_control_severity=jo.getInt("out_of_control_severity");
                int easy_angry_severity=jo.getInt("easy_angry_severity");
                int weird_action_severity=jo.getInt("weird_action_severity");
                int nighttime_behavior_severity=jo.getInt("nighttime_behavior_severity");
                int appetite_diet_changed_severity=jo.getInt("appetite_diet_changed_severity");

                int wishful_thinking_distress=jo.getInt("wishful_thinking_distress");
                int illusion_distress=jo.getInt("illusion_distress");
                int attack_distress=jo.getInt("attack_distress");
                int melancholy_distress=jo.getInt("melancholy_distress");
                int anxious_distress=jo.getInt("anxious_distress");
                int happy_distress=jo.getInt("happy_distress");
                int cold_distress=jo.getInt("cold_distress");
                int out_of_control_distress=jo.getInt("out_of_control_distress");
                int easy_angry_distress=jo.getInt("easy_angry_distress");
                int weird_action_distress=jo.getInt("weird_action_distress");
                int nighttime_behavior_distress=jo.getInt("nighttime_behavior_distress");
                int appetite_diet_changed_distress=jo.getInt("appetite_diet_changed_distress");


                s=new npiqRecord();
                s.setIf_wishful_thinking(if_wishful_thinking);
                s.setIf_illusion(if_illusion);
                s.setIf_attack(if_attack);
                s.setIf_melancholy(if_melancholy);
                s.setIf_anxious(if_anxious);
                s.setIf_happy(if_happy);
                s.setIf_cold(if_cold);
                s.setIf_out_of_control(if_out_of_control);
                s.setIf_easy_angry(if_easy_angry);
                s.setIf_weird_action(if_weird_action);
                s.setIf_nighttime_behavior(if_nighttime_behavior);
                s.setIf_appetite_diet_changed(if_appetite_diet_changed);

                s.setWishful_thinking_severity(wishful_thinking_severity);
                s.setIllusion_severity(illusion_severity);
                s.setAttack_severity(attack_severity);
                s.setMelancholy_severity(melancholy_severity);
                s.setAnxious_severity(anxious_severity);
                s.setHappy_severity(happy_severity);
                s.setCold_severity(cold_severity);
                s.setOut_of_control_severity(out_of_control_severity);
                s.setEasy_angry_severity(easy_angry_severity);
                s.setWeird_action_severity(weird_action_severity);
                s.setNighttime_behavior_severity(nighttime_behavior_severity);
                s.setAppetite_diet_changed_severity(appetite_diet_changed_severity);

                s.setWishful_thinking_distress(wishful_thinking_distress);
                s.setIllusion_distress(illusion_distress);
                s.setAttack_distress(attack_distress);
                s.setMelancholy_distress(melancholy_distress);
                s.setAnxious_distress(anxious_distress);
                s.setHappy_distress(happy_distress);
                s.setCold_distress(cold_distress);
                s.setOut_of_control_distress(out_of_control_distress);
                s.setEasy_angry_distress(easy_angry_distress);
                s.setWeird_action_distress(weird_action_distress);
                s.setNighttime_behavior_distress(nighttime_behavior_distress);
                s.setAppetite_diet_changed_distress(appetite_diet_changed_distress);

                npiqRecords.add(s);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static NPIQRecordAdapter getAdapter(){
        return adapter;
    }
}
