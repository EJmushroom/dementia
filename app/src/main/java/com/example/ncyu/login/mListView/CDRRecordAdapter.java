package com.example.ncyu.login.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncyu.login.R;
import com.example.ncyu.login.mDataObject.cdrRecord;

import java.util.ArrayList;

/**
 * Created by Ncyu on 2017/9/26.
 */

public class CDRRecordAdapter extends BaseAdapter {

    Context c;
    ArrayList<cdrRecord> cdrRecords;
    LayoutInflater inflater;



    String[] array_memory={"無記憶喪失 偶爾遺忘",
                "輕微的遺忘 回憶片段 良性的遺忘",
                    "對最近事物遺忘 影響日常生活",
            "嚴重記憶喪失只記得很熟的事物 無法記得新事物",
                       "嚴重記憶喪失 只有片段記憶"};


    String[] array_orientation={"人 事 地定位正常",
          "除了對時間順序稍微有困難外 其餘均正常",
    "涉及有時間關聯性時 有中度困難 對地點仍有定向力 但在某地可能有地理定向力的障礙",
                            "涉及有時間關聯性時 有嚴重困難 時間及地點都會有定向力的障礙",
                                  "只有人的定向力正常"};



    String[] array_PSA={"日常問題包括財務及商業性的事務都能處理很好",
                        "處理問題時 在分析類似性和差異性時稍有困難",
    "處理問題時 在分析類似性和差異性時有中度困難 社會價值的判斷力通常還能維持",
    "處理問題時 在分析類似性和差異性時有嚴重障礙 社會價值的判斷力已受影響",
                                                              "無法做判斷或解決問題"};

    String[] array_community_activity={"和平常一樣能獨立處理有關工作 購物 業務 財務和社區活動",
                                     "對處理有關工作 購物 業務 財務和社區活動有疑似或輕度障礙",
                                                      "雖從事某些活動但無法參與 偶而仍有正常表現",
                                   "無法獨立勝任家庭外的事務 但被帶出來外面活動時 外觀還似正常",
                              "無法獨立勝任家庭外的事務 且外觀上明顯可知病情嚴重 無法在外活動"};

    String[] array_home_hobby={"家庭生活 嗜好及知性行趣維持良好",
                             "對家庭生活 嗜好及知性行趣偶而有障礙",
                   "居家生活確已出現輕度之障礙 較困難的家事已經不做 放棄複雜外務 嗜好和興趣",
                       "只有簡單的家事還能做 興趣很少 也很難維持",
                                                         "無法做家事"};
    String[] array_self_care={"有完全自我照顧的能力",
                       "有大部分自我照顧的能力",
                                "需要時常的提醒",
       "在穿衣、個人衛生及個人情緒 需要協助",
                 "個人衛生失禁 需要專人協助"};

    String[] array_cdr_total_score={"沒有失智",
                             "未確定或待觀察",
                                   "輕度失智 ",
                                   "中度失智",
                                   "重度失智",
                                   "深度失智",
                                   "末期失智"};

    public CDRRecordAdapter(Context c, ArrayList<cdrRecord> cdrRecords) {
        this.c = c;
        this.cdrRecords = cdrRecords;

        //INITIALIE
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return cdrRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return cdrRecords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cdr_record_model, parent, false);
        }

        TextView tv_cdr_memory_score=(TextView)convertView.findViewById(R.id.tv_cdr_memory_score);
        TextView tv_cdr_orientation_score=(TextView)convertView.findViewById(R.id.tv_cdr_orientation_score);
        TextView tv_cdr_problem_solving_ability_score=(TextView)convertView.findViewById(R.id.tv_cdr_problem_solving_ability_score);
        TextView tv_cdr_community_activity_score=(TextView)convertView.findViewById(R.id.tv_cdr_community_activity_score);
        TextView tv_cdr_home_hobby_score=(TextView)convertView.findViewById(R.id.tv_cdr_home_hobby_score);
        TextView tv_cdr_self_care_score=(TextView)convertView.findViewById(R.id.tv_cdr_self_care_score);
        TextView tv_cdr_total_score=(TextView)convertView.findViewById(R.id.tv_cdr_total_score);

        TextView tv_cdr_memory_comment=(TextView)convertView.findViewById(R.id.tv_cdr_memory_comment);
        TextView tv_cdr_orientation_comment=(TextView)convertView.findViewById(R.id.tv_cdr_orientation_comment);
        TextView tv_cdr_problem_solving_ability_comment=(TextView)convertView.findViewById(R.id.tv_cdr_problem_solving_ability_comment);
        TextView tv_cdr_community_activity_comment=(TextView)convertView.findViewById(R.id.tv_cdr_community_activity_comment);
        TextView tv_cdr_home_hobby_comment=(TextView)convertView.findViewById(R.id.tv_cdr_home_hobby_comment);
        TextView tv_cdr_self_care_comment=(TextView)convertView.findViewById(R.id.tv_cdr_self_care_comment);
        TextView tv_cdr_total_score_comment=(TextView)convertView.findViewById(R.id.tv_cdr_total_score_comment);

        tv_cdr_memory_score.setText(toString().valueOf(cdrRecords.get(position).getMemory()));
        tv_cdr_orientation_score.setText(toString().valueOf(cdrRecords.get(position).getOrientation()));
        tv_cdr_problem_solving_ability_score.setText(toString().valueOf(cdrRecords.get(position).getProblem_solving_ability()));
        tv_cdr_community_activity_score.setText(toString().valueOf(cdrRecords.get(position).getCommunity_activity()));
        tv_cdr_home_hobby_score.setText(toString().valueOf(cdrRecords.get(position).getHome_hobby()));
        tv_cdr_self_care_score.setText(toString().valueOf(cdrRecords.get(position).getSelf_care()));
        tv_cdr_total_score.setText(toString().valueOf(cdrRecords.get(position).getCDR_total_score()));

        if(cdrRecords.get(position).getMemory()==0){
            tv_cdr_memory_comment.setText(array_memory[0]);
        }
        else if(cdrRecords.get(position).getMemory()==0.5){
            tv_cdr_memory_comment.setText(array_memory[1]);
        }
        else if(cdrRecords.get(position).getMemory()==1){
            tv_cdr_memory_comment.setText(array_memory[2]);
        }
        else if(cdrRecords.get(position).getMemory()==2){
            tv_cdr_memory_comment.setText(array_memory[3]);
        }
        else if(cdrRecords.get(position).getMemory()==3){
            tv_cdr_memory_comment.setText(array_memory[4]);
        }
        else{
            tv_cdr_memory_comment.setText("錯誤!");
        }

        if(cdrRecords.get(position).getOrientation()==0){
            tv_cdr_orientation_comment.setText(array_orientation[0]);
        }
        else if(cdrRecords.get(position).getOrientation()==0.5){
            tv_cdr_orientation_comment.setText(array_orientation[1]);
        }
        else if(cdrRecords.get(position).getOrientation()==1){
            tv_cdr_orientation_comment.setText(array_orientation[2]);
        }
        else if(cdrRecords.get(position).getOrientation()==2){
            tv_cdr_orientation_comment.setText(array_orientation[3]);
        }
        else if(cdrRecords.get(position).getOrientation()==3){
            tv_cdr_orientation_comment.setText(array_orientation[4]);
        }
        else{
            tv_cdr_orientation_comment.setText("錯誤!");
        }

        if(cdrRecords.get(position).getProblem_solving_ability()==0){
            tv_cdr_problem_solving_ability_comment.setText(array_PSA[0]);
        }
        else if(cdrRecords.get(position).getProblem_solving_ability()==0.5){
            tv_cdr_problem_solving_ability_comment.setText(array_PSA[1]);
        }
        else if(cdrRecords.get(position).getProblem_solving_ability()==1){
            tv_cdr_problem_solving_ability_comment.setText(array_PSA[2]);
        }
        else if(cdrRecords.get(position).getProblem_solving_ability()==2){
            tv_cdr_problem_solving_ability_comment.setText(array_PSA[3]);
        }
        else if(cdrRecords.get(position).getProblem_solving_ability()==3){
            tv_cdr_problem_solving_ability_comment.setText(array_PSA[4]);
        }
        else{
            tv_cdr_problem_solving_ability_comment.setText("錯誤!");
        }

        if(cdrRecords.get(position).getCommunity_activity()==0){
            tv_cdr_community_activity_comment.setText(array_community_activity[0]);
        }
        else if(cdrRecords.get(position).getCommunity_activity()==0.5){
            tv_cdr_community_activity_comment.setText(array_community_activity[1]);
        }
        else if(cdrRecords.get(position).getCommunity_activity()==1){
            tv_cdr_community_activity_comment.setText(array_community_activity[2]);
        }
        else if(cdrRecords.get(position).getCommunity_activity()==2){
            tv_cdr_community_activity_comment.setText(array_community_activity[3]);
        }
        else if(cdrRecords.get(position).getCommunity_activity()==3){
            tv_cdr_community_activity_comment.setText(array_community_activity[4]);
        }
        else{
            tv_cdr_community_activity_comment.setText("錯誤!");
        }

        if(cdrRecords.get(position).getHome_hobby()==0){
            tv_cdr_home_hobby_comment.setText(array_home_hobby[0]);
        }
        else if(cdrRecords.get(position).getHome_hobby()==0.5){
            tv_cdr_home_hobby_comment.setText(array_home_hobby[1]);
        }
        else if(cdrRecords.get(position).getHome_hobby()==1){
            tv_cdr_home_hobby_comment.setText(array_home_hobby[2]);
        }
        else if(cdrRecords.get(position).getHome_hobby()==2){
            tv_cdr_home_hobby_comment.setText(array_home_hobby[3]);
        }
        else if(cdrRecords.get(position).getHome_hobby()==3){
            tv_cdr_home_hobby_comment.setText(array_home_hobby[4]);
        }
        else{
            tv_cdr_home_hobby_comment.setText("錯誤!");
        }

        if(cdrRecords.get(position).getSelf_care()==0){
            tv_cdr_self_care_comment.setText(array_self_care[0]);
        }
        else if(cdrRecords.get(position).getSelf_care()==0.5){
            tv_cdr_self_care_comment.setText(array_self_care[1]);
        }
        else if(cdrRecords.get(position).getSelf_care()==1){
            tv_cdr_self_care_comment.setText(array_self_care[2]);
        }
        else if(cdrRecords.get(position).getSelf_care()==2){
            tv_cdr_self_care_comment.setText(array_self_care[3]);
        }
        else if(cdrRecords.get(position).getSelf_care()==3){
            tv_cdr_self_care_comment.setText(array_self_care[4]);
        }
        else{
            tv_cdr_self_care_comment.setText("錯誤!");
        }

        if(cdrRecords.get(position).getCDR_total_score()==0){
            tv_cdr_total_score_comment.setText(array_cdr_total_score[0]);
        }
        else if(cdrRecords.get(position).getCDR_total_score()==0.5){
            tv_cdr_total_score_comment.setText(array_cdr_total_score[1]);
        }
        else if(cdrRecords.get(position).getCDR_total_score()==1){
            tv_cdr_total_score_comment.setText(array_cdr_total_score[2]);
        }
        else if(cdrRecords.get(position).getCDR_total_score()==2){
            tv_cdr_total_score_comment.setText(array_cdr_total_score[3]);
        }
        else if(cdrRecords.get(position).getCDR_total_score()==3){
            tv_cdr_total_score_comment.setText(array_cdr_total_score[4]);
        }
        else if(cdrRecords.get(position).getCDR_total_score()==4){
            tv_cdr_total_score_comment.setText(array_cdr_total_score[5]);
        }
        else if(cdrRecords.get(position).getCDR_total_score()==5){
            tv_cdr_total_score_comment.setText(array_cdr_total_score[6]);
        }
        else{
            tv_cdr_total_score_comment.setText("錯誤!");
        }
        return convertView;
    }


}
