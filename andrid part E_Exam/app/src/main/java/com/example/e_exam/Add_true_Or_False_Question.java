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

public class Add_true_Or_False_Question extends AppCompatActivity {
    DatabaseReference ref;
    private SharedPreferences sharedPreferences;
    public static final String KEY_SUBJECT_KEY="KEY_SUBJECT_KEY";
    public static final String KEY_CHAPTER_KEY="KEY_CHAPTER_KEY";
    private   EditText etQuestion;
    private Spinner spCorrectAnswer,spCategory;
    private   Button btnSave;
    private int nu=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_true__or__false__question);
        ref= FirebaseDatabase.getInstance().getReference().child("True Or False Questions");
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);


        etQuestion=findViewById(R.id.et_true_question);
        spCorrectAnswer=findViewById(R.id.spinner_true_correct_answer);
        spCategory=findViewById(R.id.spinner_true_category);



        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot:dataSnapshot.getChildren()) {

                  TrueOrFalseClass trueOrFalseClass=snapshot.getValue(TrueOrFalseClass.class);
                    if (trueOrFalseClass.getChapterKey().equals(sharedPreferences.getString(KEY_CHAPTER_KEY,"")));
                    {
                        nu=nu+1;
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        btnSave=findViewById(R.id.btn_save_true_question);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendData();


            }




        });






    }

    private void sendData() {

        String key=ref.child("True Or False Questions").push().getKey();
        String question=etQuestion.getText().toString();
        String correctAnswer=spCorrectAnswer.getSelectedItem().toString();
        String category=spCategory.getSelectedItem().toString();
        final String chKey=sharedPreferences.getString(KEY_CHAPTER_KEY,"");
        String subKey=sharedPreferences.getString(KEY_SUBJECT_KEY,"");
        String QuestionNumber=String.valueOf(nu);


        TrueOrFalseClass trueOrFalseClass=new TrueOrFalseClass();


        trueOrFalseClass.setKey(key);
        trueOrFalseClass.setQuestion(question);
        trueOrFalseClass.setCorrectAnswer(correctAnswer);
        trueOrFalseClass.setCategory(category);
        trueOrFalseClass.setSubjectKey(subKey);
        trueOrFalseClass.setChapterKey(chKey);
        trueOrFalseClass.setQuestionNumber(QuestionNumber);

        ref.child(trueOrFalseClass.getKey()).setValue(trueOrFalseClass).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                Toast.makeText(Add_true_Or_False_Question.this, "Save", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());


            }
        });




    }
}
