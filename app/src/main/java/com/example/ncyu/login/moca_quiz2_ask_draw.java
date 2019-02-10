package com.example.ncyu.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kyanogen.signatureview.SignatureView;

public class moca_quiz2_ask_draw extends AppCompatActivity {
    SignatureView sv;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca_quiz2_ask_draw);
        sv=(SignatureView)findViewById(R.id.signature_view);
        context=this;
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.redraw:
                sv.clearCanvas();
                break;
            case R.id.finish:
                Bitmap bitmap = sv.getSignatureBitmap();

                Intent intent = new Intent();
                intent.setClass(moca_quiz2_ask_draw.this, moca_quiz2_ask_judge.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = getIntent().getExtras();
                if(bundle1.getString("identity").equals("family")){
                    bundle.putString("name", bundle1.getString("name"));
                    bundle.putString("account", bundle1.getString("account"));
                }

                bundle.putString("identity",bundle1.getString("identity"));
                bundle.putString("testID",bundle1.getString("testID"));
                bundle.putParcelable("quiz2_ask_bundle",scaleDownBitmap(bitmap,40,context));
                bundle.putBoolean("quiz1_answer",bundle1.getBoolean("quiz1_answer"));

                intent.putExtras(bundle);
                startActivity(intent);

                moca_quiz2_ask_draw.this.finish();
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
