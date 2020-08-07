package com.example.e_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chapter_Question extends AppCompatActivity {

    Button buttonChoose,buttonTrue;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter__question);

        buttonChoose=findViewById(R.id.btn_go_to_choose_question);
        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Chapter_Question.this,Choose_Questions.class);
                startActivity(intent);

            }
        });


        buttonTrue=findViewById(R.id.btn_go_to_true_question);
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Chapter_Question.this,True_Or_False_Question.class);
                startActivity(intent);

            }
        });

    }
}
