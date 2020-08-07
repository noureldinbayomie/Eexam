package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Add_Choose_Question extends AppCompatActivity {
    DatabaseReference ref;
    private SharedPreferences sharedPreferences;
    public static final String KEY_SUBJECT_KEY="KEY_SUBJECT_KEY";
    public static final String KEY_CHAPTER_KEY="KEY_CHAPTER_KEY";
    EditText etQuestion,etA,etB,etC,etD;
    Spinner spCorrectAnswer,spCategory;
    Button btnSave;
    int nu=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__choose__question);


        ref= FirebaseDatabase.getInstance().getReference().child("Choose Question");
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        etQuestion=findViewById(R.id.et_question);
        etA=findViewById(R.id.et_choose_a);
        etB=findViewById(R.id.et_choose_b);
        etC=findViewById(R.id.et_choose_c);
        etD=findViewById(R.id.et_choose_D);
        spCorrectAnswer=findViewById(R.id.spinner_choose_correct_answer);
        spCategory=findViewById(R.id.spinner_choose_category);





        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot:dataSnapshot.getChildren()) {

                    ChooseQuestionClass chooseQuestionClass=snapshot.getValue(ChooseQuestionClass.class);
                    if (chooseQuestionClass.getChapterKey().equals(sharedPreferences.getString(KEY_CHAPTER_KEY,"")));
                    {
                        nu=nu+1;
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });



        btnSave=findViewById(R.id.btn_save_new_choose_question);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sendData();



            }

            private void sendData() {

                String key=ref.child("Choose Question").push().getKey();
                String question=etQuestion.getText().toString();
                String a=etA.getText().toString();
                String b=etB.getText().toString();
                String c=etC.getText().toString();
                String d=etD.getText().toString();
                String correctAnswer="";

                if (question.equals(" ")|| question.isEmpty()){
                    etQuestion.setError("Required");
                    return;
                }

                if (a.isEmpty()|| a.equals(" ")){
                    etA.setError("Required");
                    return;

                }


                if (c.isEmpty()|| c.equals(" ")){
                    etC.setError("Required");
                    return;

                }
                if (b.isEmpty()|| b.equals(" ")){
                    etB.setError("Required");
                    return;

                }
                if (d.isEmpty()|| d.equals(" ")){
                    etD.setError("Required");
                    return;

                }



                if (spCorrectAnswer.getSelectedItem().toString().equals("A")){
                    correctAnswer=a;
                }
                else if (spCorrectAnswer.getSelectedItem().toString().equals("B")){

                    correctAnswer=b;
                }
               else if (spCorrectAnswer.getSelectedItem().toString().equals("C")){
                   correctAnswer=c;
                }

                else if (spCorrectAnswer.getSelectedItem().toString().equals("D")){

                    correctAnswer=d;
                }

                String category=spCategory.getSelectedItem().toString();
                final String chKey=sharedPreferences.getString(KEY_CHAPTER_KEY,"");
                String subKey=sharedPreferences.getString(KEY_SUBJECT_KEY,"");





                 String QuestionNumber=String.valueOf(nu);



                 ChooseQuestionClass chooseQuestionClass=new ChooseQuestionClass();

                 chooseQuestionClass.setKey(key);
                 chooseQuestionClass.setQuestion(question);
                 chooseQuestionClass.setA(a);
                 chooseQuestionClass.setB(b);
                 chooseQuestionClass.setC(c);
                 chooseQuestionClass.setD(d);
                 chooseQuestionClass.setCorrectAnswer(correctAnswer);
                 chooseQuestionClass.setCategory(category);
                 chooseQuestionClass.setChapterKey(chKey);
                 chooseQuestionClass.setSubjectKey(subKey);
                 chooseQuestionClass.setQuestionNumber(QuestionNumber);

                 ref.child(chooseQuestionClass.getKey()).setValue(chooseQuestionClass).addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void aVoid) {
                         Toast.makeText(Add_Choose_Question.this, "Save", Toast.LENGTH_SHORT).show();
                         finish();
                         startActivity(getIntent());
                     }
                 });








            }
        });

















    }
}
