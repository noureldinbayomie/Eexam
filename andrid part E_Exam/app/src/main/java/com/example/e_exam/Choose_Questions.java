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

public class Choose_Questions extends AppCompatActivity {
DatabaseReference ref;
    private SharedPreferences sharedPreferences;
    public static final String KEY_CHAPTER_KEY="KEY_CHAPTER_KEY";
    ListView listView;
    ArrayList<ChooseQuestionClass> arrayList=new ArrayList<>();
    ChooseQuestionListViewAdapter chooseQuestionListViewAdapter;

    Button buttonAddQuestion;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__questions);
        ref= FirebaseDatabase.getInstance().getReference().child("Choose Question");
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
listView=findViewById(R.id.list_view_choose_question);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot:dataSnapshot.getChildren()){

                    ChooseQuestionClass chooseQuestionClass=snapshot.getValue(ChooseQuestionClass.class);
                    if (chooseQuestionClass.getChapterKey().equals(sharedPreferences.getString(KEY_CHAPTER_KEY,""))){

                        arrayList.add(chooseQuestionClass);
                    }


                }

                chooseQuestionListViewAdapter=new ChooseQuestionListViewAdapter(Choose_Questions.this,0,arrayList);
                listView.setAdapter(chooseQuestionListViewAdapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        buttonAddQuestion=findViewById(R.id.btn_add_choose_question);
        buttonAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Choose_Questions.this,Add_Choose_Question.class);
                startActivity(intent);

            }
        });

    }
}
