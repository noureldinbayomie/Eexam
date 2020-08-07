package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Subjects_Chaptres extends AppCompatActivity {
    DatabaseReference ref;
    private SharedPreferences sharedPreferences;
    public static final String KEY_SUBJECT_KEY="KEY_SUBJECT_KEY";
    public static final String KEY_CHAPTER_KEY="KEY_CHAPTER_KEY";
    ListView listView;
    ArrayList<ChapterClass> arrayList=new ArrayList<>();
    ChapterProListViewAdapter chapterProListViewAdapter;

    Button addChapter,btnMakeExam;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects__chaptres);
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        ref= FirebaseDatabase.getInstance().getReference().child("Chapters");

        listView=findViewById(R.id.list_view_subjects_chapters);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                     ChapterClass chapterClass=snapshot.getValue(ChapterClass.class);

                     String subKey=sharedPreferences.getString(KEY_SUBJECT_KEY,"");

                     if (subKey.equals(chapterClass.getSubjectKey())){
                         arrayList.add(chapterClass);
                     }
                }

                chapterProListViewAdapter =new ChapterProListViewAdapter(Subjects_Chaptres.this,0,arrayList);
                listView.setAdapter(chapterProListViewAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ChapterClass chapterClass=arrayList.get(position);

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_CHAPTER_KEY,chapterClass.getKey());
                editor.commit();
                Intent intent=new Intent(Subjects_Chaptres.this,Chapter_Question.class);
                startActivity(intent);




            }
        });




        addChapter=findViewById(R.id.btn_add_chapter);
        addChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(Subjects_Chaptres.this,New_Chapter.class);
                startActivity(intent);

            }
        });




        btnMakeExam=findViewById(R.id.btn_make_exam);
        btnMakeExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(Subjects_Chaptres.this,Make_Exam.class);
                startActivity(intent);

            }
        });

    }
}
