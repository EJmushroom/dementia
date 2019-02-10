package com.example.ncyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class choose_identity extends AppCompatActivity {
    ImageButton btn_visitor,btn_family,btn_doctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_identity);

        btn_visitor=(ImageButton)findViewById(R.id.btn_visitor);
        btn_family=(ImageButton)findViewById(R.id.btn_family);
        btn_doctor=(ImageButton)findViewById(R.id.btn_doctor);



        btn_visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(choose_identity.this,visitor_function.class);
                startActivity(in);
                choose_identity.this.finish();
            }
        });

        btn_family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(choose_identity.this,family_login.class);
                startActivity(in);
                choose_identity.this.finish();
            }
        });

        btn_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(choose_identity.this,doctor_login.class);
                startActivity(in);
                choose_identity.this.finish();
            }
        });
        

    }
}
