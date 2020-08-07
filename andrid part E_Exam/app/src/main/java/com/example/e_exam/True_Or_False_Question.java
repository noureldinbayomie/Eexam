package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class True_Or_False_Question extends AppCompatActivity {
    DatabaseReference ref;
    private SharedPreferences sharedPreferences;
    public static final String KEY_CHAPTER_KEY="KEY_CHAPTER_KEY";
    ListView listView;
    ArrayList<TrueOrFalseClass> arrayList=new ArrayList<>();
    TrueQuestionListViewAdapter trueQuestionListViewAdapter;
    Button buttonAddQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true__or__false__question);
        ref= FirebaseDatabase.getInstance().getReference().child("True Or False Questions");
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
         listView=findViewById(R.id.list_view_true_question);
         ref.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                     TrueOrFalseClass trueOrFalseClass=snapshot.getValue(TrueOrFalseClass.class);
                     if (trueOrFalseClass.getChapterKey().equals(sharedPreferences.getString(KEY_CHAPTER_KEY,""))){
                         arrayList.add(trueOrFalseClass);
                     }
                 }
                 trueQuestionListViewAdapter=new TrueQuestionListViewAdapter(True_Or_False_Question.this,0,arrayList);
                 listView.setAdapter(trueQuestionListViewAdapter);
             }
             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {
             }
         });
        buttonAddQ=findViewById(R.id.btn_add_true_question);
        buttonAddQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(True_Or_False_Question.this,Add_true_Or_False_Question.class);
                startActivity(intent);
            }
        });

    }
}
