package com.example.e_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {

Button btnLevels,btnPro,btnSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);




        btnLevels=findViewById(R.id.btn_go_to_levels);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHome.this,Levels.class);
                startActivity(intent);

            }
        });


        btnPro=findViewById(R.id.btn_go_to_pro);
        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AdminHome.this,ProfessorRequest.class);
                startActivity(intent);

            }
        });


btnSub=findViewById(R.id.btn_go_to_subject);
btnSub.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent=new Intent(AdminHome.this,Subjects.class);
        startActivity(intent);

    }
});








    }








}
