package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Make_Exam extends AppCompatActivity {
DatabaseReference refChapters,refExam;
    private SharedPreferences sharedPreferences;
    public static final String KEY_SUBJECT_KEY="KEY_SUBJECT_KEY";
  LinearLayout linearLayout;
  EditText etTime,etQuestionNumber,etChooseQuestionNumber,etTrueQuestionNumber,etQuestionNumberCategoryA,etQuestionNumberCategoryB,etQuestionNumberCategoryC;
          Button btnSave;
   int nu=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make__exam);


        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        refChapters= FirebaseDatabase.getInstance().getReference().child("Chapters");
        refExam=FirebaseDatabase.getInstance().getReference().child("Exams");
        linearLayout=findViewById(R.id.liner_chapter);

        etTime=findViewById(R.id.et_exam_time);
        etQuestionNumber=findViewById(R.id.et_exam_question_number);
        etChooseQuestionNumber=findViewById(R.id.et_exam_choose_question_number);
        etTrueQuestionNumber=findViewById(R.id.et_exam_true_question_number);
        etQuestionNumberCategoryA=findViewById(R.id.et_exam_question_number_category_a);
        etQuestionNumberCategoryB=findViewById(R.id.et_exam_question_number_category_b);
        etQuestionNumberCategoryC=findViewById(R.id.et_exam_question_number_category_c);

        btnSave=findViewById(R.id.btn_save_exam);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendData();

            }
        });





        refChapters.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot:dataSnapshot.getChildren()){

                    ChapterClass chapterClass=snapshot.getValue(ChapterClass.class);
                    if (chapterClass.getSubjectKey().equals(sharedPreferences.getString(KEY_SUBJECT_KEY,"")) ){


                        showChapters();
                        nu=nu+1;

                    }


                }




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sendData() {




        String key=refExam.child("Exams").push().getKey();
        String subKey=sharedPreferences.getString(KEY_SUBJECT_KEY,"");
        String time=etTime.getText().toString();
        String questionNumbers=etQuestionNumber.getText().toString();
        String chooseQuestionNumbers=etChooseQuestionNumber.getText().toString();
        String trueQuestionNumbers=etTrueQuestionNumber.getText().toString();
        String questionNumbersCategoryA=etQuestionNumberCategoryA.getText().toString();
        String questionNumbersCategoryB=etQuestionNumberCategoryB.getText().toString();
        String questionNumbersCategoryC=etQuestionNumberCategoryC.getText().toString();



        ExamClass examClass=new ExamClass();
        examClass.setKey(key);
        examClass.setSubjectKey(subKey);
        examClass.setExamTime(time);
        examClass.setNumberOfQuestion(questionNumbers);
        examClass.setNumberOfChooseQuestion(chooseQuestionNumbers);
        examClass.setNumberOfTrueQuestion(trueQuestionNumbers);
        examClass.setNumberOfQuestionCategoryA(questionNumbersCategoryA);
        examClass.setNumberOfQuestionCategoryB(questionNumbersCategoryB);
        examClass.setNumberOfQuestionCategoryC(questionNumbersCategoryC);

        refExam.child(examClass.getKey()).setValue(examClass).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(Make_Exam.this, "Save", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());


            }
        });
    }

    private  void showChapters(){
        final View chapterView=getLayoutInflater().inflate(R.layout.liner_layout_chapter,null,false);
        EditText chapterQuestionNumber=(EditText)chapterView.findViewById(R.id.et_chapter_number_questions);
        TextView chapterName=(TextView) chapterView.findViewById(R.id.tv_chapter_name);
        chapterName.setText("Chapter "+nu);
        linearLayout.addView(chapterView);
    }

}

