package com.example.ncyu.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayOutputStream;

public class quiz7_draw extends AppCompatActivity {

    SignatureView sv;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz7_draw);
        sv=(SignatureView)findViewById(R.id.signature_view);
        context=this;
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.redraw:
                sv.clearCanvas();
                break;
            case R.id.finish:
                Bitmap bitmap=sv.getSignatureBitmap();

                Intent intent=new Intent();
                intent.setClass(quiz7_draw.this,quiz7_judge.class);
                Bundle bundle=new Bundle();
                bundle.putParcelable("quiz7_bundle",scaleDownBitmap(bitmap,100,context));
                Bundle bundle1=getIntent().getExtras();
                bundle.putBooleanArray("quiz1_ask1_disAnswer",bundle1.getBooleanArray("quiz1_ask1_disAnswer"));
                bundle.putString("quiz_ask1_answer_type",bundle1.getString("quiz_ask1_answer_type"));
                bundle.putString("quiz1_ask1_answer1",bundle1.getString("quiz1_ask1_answer1"));
                bundle.putString("quiz1_ask1_answer2",bundle1.getString("quiz1_ask1_answer2"));
                bundle.putString("quiz1_ask1_answer3",bundle1.getString("quiz1_ask1_answer3"));
                bundle.putString("quiz1_ask1_answer4",bundle1.getString("quiz1_ask1_answer4"));
                bundle.putString("quiz1_ask2_quiz",bundle1.getString("quiz1_ask2_quiz"));
                bundle.putString("quiz1_ask2_answer",bundle1.getString("quiz1_ask2_answer"));
                bundle.putBoolean("quiz1_ask2_disAnswer",bundle1.getBoolean("quiz1_ask2_disAnswer"));
                bundle.putBooleanArray("quiz2_ask_isAnswer", bundle1.getBooleanArray("quiz2_ask_isAnswer"));
                bundle.putBooleanArray("quiz2_ask_disAnswer",bundle1.getBooleanArray("quiz2_ask_disAnswer"));
                bundle.putStringArray("quiz2_answer",bundle1.getStringArray("quiz2_answer"));
                bundle.putStringArray("quiz3_word_bundle",bundle1.getStringArray("quiz3_word_bundle"));
                bundle.putBooleanArray("quiz3_word",bundle1.getBooleanArray("quiz3_word"));
                bundle.putStringArray("quiz4_answer",bundle1.getStringArray("quiz4_answer"));
                bundle.putBooleanArray("quiz5_word",bundle1.getBooleanArray("quiz5_word"));
                bundle.putStringArray("quiz6_ask1_word",bundle1.getStringArray("quiz6_ask1_word"));
                bundle.putString("quiz6_ask2_word",bundle1.getString("quiz6_ask2_word"));
                bundle.putBoolean("quiz6_ask2_answer",bundle1.getBoolean("quiz6_ask2_answer"));
                bundle.putString("quiz6_ask3_quiz",bundle1.getString("quiz6_ask3_quiz"));
                bundle.putBoolean("quiz6_ask3_answer",bundle1.getBoolean("quiz6_ask3_answer"));
                bundle.putString("quiz6_ask4_answer",bundle1.getString("quiz6_ask4_answer"));

                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putString("identity",bundle1.getString("identity"));

                intent.putExtras(bundle);
                startActivity(intent);
                quiz7_draw.this.finish();
                break;
        }
    }

    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context) {

        final float densityMultiplier = context.getResources().getDisplayMetrics().density;

        int h= (int) (newHeight*densityMultiplier);
        int w= (int) (h * photo.getWidth()/((double) photo.getHeight()));

        photo=Bitmap.createScaledBitmap(photo, w, h, true);

        return photo;
    }
}
