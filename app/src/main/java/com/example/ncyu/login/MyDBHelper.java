package com.example.ncyu.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ncyu on 2017/9/12.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    private  static final String DATABASE_NAME = "dementia";
    private  static final int DATABASE_VERSION = 1;

    public MyDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  IF NOT EXISTS test (_id "+"INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                      "scaleID "+"INTEGER NO NULL, "+
                                "start_test_time "+"TEXT NULL, "+
                                "end_test_time "+"TEXT NULL)");

        db.execSQL("CREATE TABLE IF NOT EXISTS ad8( _id "+"INTEGER PRIMARY KEY, "+
                                                        "Q1 "+"INTEGER NULL, "+
                                                        "Q2 "+"INTEGER NULL, "+
                                                        "Q3 "+"INTEGER NULL, "+
                                                        "Q4 "+"INTEGER NULL, "+
                                                        "Q5 "+"INTEGER NULL, "+
                                                        "Q6 "+"INTEGER NULL, "+
                                                        "Q7 "+"INTEGER NULL, "+
                                                        "Q8 "+"INTEGER NULL, "+
                                                        "AD8_total_score "+"INTEGER NULL, "+
                                                        "FOREIGN KEY(_id) REFERENCES test(_id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS cdr(_id "+"INTEGER PRIMARY KEY, "+
                "memory "+"REAL NULL, "+
                "orientation "+"REAL NULL, "+
                "problem_solving_ability "+"REAL NULL, "+
                "community_activity "+"REAL NULL, "+
                "home_hobby "+"REAL NULL, "+
                "self_care "+"REAL NULL, "+
                "CDR_total_score "+"REAL NULL, "+
                "FOREIGN KEY(_id) REFERENCES test(_id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS mmse(_id "+"INTEGER PRIMARY KEY, "+
                "quiz1_ask1_disAnswer_year "+"INTEGER NULL, "+
                "quiz1_ask1_disAnswer_month "+"INTEGER NULL, "+
                "quiz1_ask1_disAnswer_day "+"INTEGER NULL, "+
                "quiz1_ask1_disAnswer_weekday "+"INTEGER NULL, "+
                "quiz_ask1_answer_type "+"TEXT NULL, "+
                "quiz1_ask1_answer1 "+"TEXT NULL, "+
                "quiz1_ask1_answer2 "+"TEXT NULL, "+
                "quiz1_ask1_answer3 "+"TEXT NULL, "+
                "quiz1_ask1_answer4 "+"TEXT NULL, "+
                "quiz1_ask1_score "+"INTEGER NULL, "+
                "quiz1_ask2_quiz "+"TEXT NULL, "+
                "quiz1_ask2_answer "+"TEXT NULL, "+
                "quiz1_ask2_disAnswer "+"INTEGER NULL, "+
                "quiz1_ask2_score "+"INTEGER NULL, "+
                "quiz2_ask_isAnswer1 "+"INTEGER NULL, "+
                "quiz2_ask_isAnswer2 "+"INTEGER NULL, "+
                "quiz2_ask_isAnswer3 "+"INTEGER NULL, "+
                "quiz2_ask_isAnswer4 "+"INTEGER NULL, "+
                "quiz2_ask_isAnswer5 "+"INTEGER NULL, "+
                "quiz2_ask_isAnswer6 "+"INTEGER NULL, "+
                "quiz2_ask_isAnswer7 "+"INTEGER NULL, "+
                "quiz2_ask_isAnswer8 "+"INTEGER NULL, "+
                "quiz2_ask_disAnswer1 "+"INTEGER NULL, "+
                "quiz2_ask_disAnswer2 "+"INTEGER NULL, "+
                "quiz2_ask_disAnswer3 "+"INTEGER NULL, "+
                "quiz2_ask_disAnswer4 "+"INTEGER NULL, "+
                "quiz2_ask_disAnswer5 "+"INTEGER NULL, "+
                "quiz2_ask_disAnswer6 "+"INTEGER NULL, "+
                "quiz2_ask_disAnswer7 "+"INTEGER NULL, "+
                "quiz2_ask_disAnswer8 "+"INTEGER NULL, "+
                "quiz2_answer1 "+"TEXT NULL, "+
                "quiz2_answer2 "+"TEXT NULL, "+
                "quiz2_answer3 "+"TEXT NULL, "+
                "quiz2_answer4 "+"TEXT NULL, "+
                "quiz2_answer5 "+"TEXT NULL, "+
                "quiz2_answer6 "+"TEXT NULL, "+
                "quiz2_answer7 "+"TEXT NULL, "+
                "quiz2_answer8 "+"TEXT NULL, "+
                "quiz2_score "+"INTEGER NULL, "+
                "quiz3_word_bundle1 "+"TEXT NULL, "+
                "quiz3_word_bundle2 "+"TEXT NULL, "+
                "quiz3_word_bundle3 "+"TEXT NULL, "+
                "quiz3_word1 "+"INTEGER NULL, "+
                "quiz3_word2 "+"INTEGER NULL, "+
                "quiz3_word3 "+"INTEGER NULL, "+
                "quiz3_score "+"INTEGER NULL, "+
                "quiz4_answer1 "+"TEXT NULL, "+
                "quiz4_answer2 "+"TEXT NULL, "+
                "quiz4_answer3 "+"TEXT NULL, "+
                "quiz4_answer4 "+"TEXT NULL, "+
                "quiz4_answer5 "+"TEXT NULL, "+
                "quiz4_score "+"INTEGER NULL, "+
                "quiz5_word1 "+"INTEGER NULL, "+
                "quiz5_word2 "+"INTEGER NULL, "+
                "quiz5_word3 "+"INTEGER NULL, "+
                "quiz5_score "+"INTEGER NULL, "+
                "quiz6_ask1_word1 "+"TEXT NULL, "+
                "quiz6_ask1_word2 "+"TEXT NULL, "+
                "quiz6_ask2_word "+"TEXT NULL, "+
                "quiz6_ask2_answer "+"INTEGER NULL, "+
                "quiz6_ask3_quiz "+"TEXT NULL, "+
                "quiz6_ask3_answer "+"INTEGER NULL, "+
                "quiz6_ask4_answer "+"TEXT NULL, "+
                "quiz6_score "+"INTEGER NULL, "+
                "quiz7_bundle "+"TEXT NULL, "+
                "quiz7_answer "+"INTEGER NULL, "+
                "quiz7_score "+"INTEGER NULL, "+
                "quiz8_word1 "+"INTEGER NULL, "+
                "quiz8_word2 "+"INTEGER NULL, "+
                "quiz8_word3 "+"INTEGER NULL, "+
                "quiz8_score "+"INTEGER NULL, "+
                "MMSE_total_score "+"INTEGER NULL, "+
                "FOREIGN KEY(_id) REFERENCES test(_id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS moca(_id "+"INTEGER PRIMARY KEY, "+
                "quiz1_answer "+"INTEGER NULL, "+
                "quiz1_score "+"INTEGER NULL, "+
                "quiz2_ask_bundle "+"TEXT NULL, "+
                "quiz2_ask_answer "+"INTEGER NULL, "+
                "quiz2_ask2_bundle "+"TEXT NULL, "+
                "quiz2_ask2_answer1 "+"INTEGER NULL, "+
                "quiz2_ask2_answer2 "+"INTEGER NULL, "+
                "quiz2_ask2_answer3 "+"INTEGER NULL, "+
                "quiz2_score "+"INTEGER NULL, "+
                "quiz3_answer1 "+"INTEGER NULL, "+
                "quiz3_answer2 "+"INTEGER NULL, "+
                "quiz3_answer3 "+"INTEGER NULL, "+
                "quiz3_score "+"INTEGER NULL, "+
                "quiz4_answer_first1 "+"INTEGER NULL, "+
                "quiz4_answer_first2 "+"INTEGER NULL, "+
                "quiz4_answer_first3 "+"INTEGER NULL, "+
                "quiz4_answer_first4 "+"INTEGER NULL, "+
                "quiz4_answer_first5 "+"INTEGER NULL, "+
                "quiz4_answer_second1 "+"INTEGER NULL, "+
                "quiz4_answer_second2 "+"INTEGER NULL, "+
                "quiz4_answer_second3 "+"INTEGER NULL, "+
                "quiz4_answer_second4 "+"INTEGER NULL, "+
                "quiz4_answer_second5 "+"INTEGER NULL, "+
                "quiz4_word_bundle1 "+"TEXT NULL, "+
                "quiz4_word_bundle2 "+"TEXT NULL, "+
                "quiz4_word_bundle3 "+"TEXT NULL, "+
                "quiz4_word_bundle4 "+"TEXT NULL, "+
                "quiz4_word_bundle5 "+"TEXT NULL, "+
                "quiz4_score "+"INTEGER NULL, "+
                "quiz5_ask1_answer1 "+"INTEGER NULL, "+
                "quiz5_ask1_answer2 "+"INTEGER NULL, "+
                "quiz5_ask1_answer3 "+"INTEGER NULL, "+
                "quiz5_ask2_answer1 "+"TEXT NULL, "+
                "quiz5_ask2_answer2 "+"TEXT NULL, "+
                "quiz5_ask2_answer3 "+"TEXT NULL, "+
                "quiz5_ask2_answer4 "+"TEXT NULL, "+
                "quiz5_ask2_answer5 "+"TEXT NULL, "+
                "quiz5_ask2_isRight "+"INTEGER NULL, "+
                "quiz5_score "+"INTEGER NULL, "+
                "quiz6_ask_quiz_isRight1 "+"INTEGER NULL, "+
                "quiz6_ask_quiz_isRight2 "+"INTEGER NULL, "+
                "quiz6_ask2_answer "+"INTEGER NULL, "+
                "quiz6_score "+"INTEGER NULL, "+
                "quiz7_answer1 "+"INTEGER NULL, "+
                "quiz7_answer2 "+"INTEGER NULL, "+
                "quiz7_score "+"INTEGER NULL, "+
                "quiz8_answer1 "+"INTEGER NULL, "+
                "quiz8_answer2 "+"INTEGER NULL, "+
                "quiz8_answer3 "+"INTEGER NULL, "+
                "quiz8_answer4 "+"INTEGER NULL, "+
                "quiz8_answer5 "+"INTEGER NULL, "+
                "quiz8_score "+"INTEGER NULL, "+
                "quiz9_answer1 "+"TEXT NULL, "+
                "quiz9_answer2 "+"TEXT NULL, "+
                "quiz9_answer3 "+"TEXT NULL, "+
                "quiz9_answer4 "+"TEXT NULL, "+
                "quiz9_answer5 "+"TEXT NULL, "+
                "quiz9_answer6 "+"TEXT NULL, "+
                "quiz9_answer7 "+"TEXT NULL, "+
                "quiz9_isAnswer1 "+"INTEGER NULL, "+
                "quiz9_isAnswer2 "+"INTEGER NULL, "+
                "quiz9_isAnswer3 "+"INTEGER NULL, "+
                "quiz9_isAnswer4 "+"INTEGER NULL, "+
                "quiz9_isAnswer5 "+"INTEGER NULL, "+
                "quiz9_isAnswer6 "+"INTEGER NULL, "+
                "quiz9_score "+"INTEGER NULL, "+
                "MOCA_total_score "+"INTEGER NULL, "+
                "FOREIGN KEY(_id) REFERENCES test(_id))");


        db.execSQL("CREATE TABLE IF NOT EXISTS npiq(_id "+"INTEGER PRIMARY KEY, "+
                                       "if_wishful_thinking "+"INTEGER NULL, "+
                                 "wishful_thinking_severity "+"INTEGER NULL, "+
                                  "wishful_thinking_distress "+"INTEGER NULL, "+
                                                "if_illusion "+"INTEGER NULL, "+
                                          "illusion_severity "+"INTEGER NULL, "+
                                          "illusion_distress "+"INTEGER NULL, "+
                                                 "if_attack "+"INTEGER NULL, "+
                                           "attack_severity "+"INTEGER NULL, "+
                                            "attack_distress "+"INTEGER NULL, "+
                                            "if_melancholy "+"INTEGER NULL, "+
                                      "melancholy_severity "+"INTEGER NULL, "+
                                      "melancholy_distress "+"INTEGER NULL, "+
                                               "if_anxious "+"INTEGER NULL, "+
                                         "anxious_severity "+"INTEGER NULL, "+
                                          "anxious_distress "+"INTEGER NULL, "+
                                                 "if_happy "+"INTEGER NULL, "+
                                           "happy_severity "+"INTEGER NULL, "+
                                            "happy_distress "+"INTEGER NULL, "+
                                                  "if_cold "+"INTEGER NULL, "+
                                            "cold_severity "+"INTEGER NULL, "+
                                            "cold_distress "+"INTEGER NULL, "+
                                        "if_out_of_control "+"INTEGER NULL, "+
                                  "out_of_control_severity "+"INTEGER NULL, "+
                                  "out_of_control_distress "+"INTEGER NULL, "+
                                           "if_easy_angry "+"INTEGER NULL, "+
                                     "easy_angry_severity "+"INTEGER NULL, "+
                                      "easy_angry_distress "+"INTEGER NULL, "+
                                          "if_weird_action "+"INTEGER NULL, "+
                                     "weird_action_severity "+"INTEGER NULL, "+
                                     "weird_action_distress "+"INTEGER NULL, "+
                                    "if_nighttime_behavior "+"INTEGER NULL, "+
                               "nighttime_behavior_severity "+"INTEGER NULL, "+
                               "nighttime_behavior_distress "+"INTEGER NULL, "+
                                 "if_appetite_diet_changed "+"INTEGER NULL, "+
                           "appetite_diet_changed_severity "+"INTEGER NULL, "+
                            "appetite_diet_changed_distress "+"INTEGER NULL, "+
                                   "FOREIGN KEY(_id) REFERENCES test(_id))");





        db.execSQL("CREATE TABLE IF NOT EXISTS family(_id INTEGER PRIMARY KEY, frequency INTEGER NULL)");

        db.execSQL("CREATE TABLE IF NOT EXISTS guest(_id INTEGER PRIMARY KEY, frequency INTEGER NULL)");






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS test");
        db.execSQL("DROP TABLE IF EXISTS ad8");
        db.execSQL("DROP TABLE IF EXISTS cdr");
        db.execSQL("DROP TABLE IF EXISTS mmse");
        db.execSQL("DROP TABLE IF EXISTS moca");
        db.execSQL("DROP TABLE IF EXISTS npiq");
        db.execSQL("DROP TABLE IF EXISTS family");
        db.execSQL("DROP TABLE IF EXISTS guest");

        onCreate(db);
    }

    public void delete(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS family");
        db.execSQL("DROP TABLE IF EXISTS guest");
        onCreate(db);
    }

}