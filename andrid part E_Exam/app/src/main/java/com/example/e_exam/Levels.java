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

public class Levels extends AppCompatActivity {
DatabaseReference ref;
    private SharedPreferences sharedPreferences;
    public static final String KEY_FACULTY_USER_NAME="KEY_FACULTY_USER_NAME";
    ListView listView;
ArrayList<LevelClass> arrayList=new ArrayList<>();
LevelsListViewAdapter levelsListViewAdapter;
    Button buttonAddLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        ref=FirebaseDatabase.getInstance().getReference().child("Faculty Level");
        listView=findViewById(R.id.list_view_levels);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
for (DataSnapshot snapshot: dataSnapshot.getChildren()){
    LevelClass levelClass=snapshot.getValue(LevelClass.class);
    if (levelClass.getFacultyUsername().equals(sharedPreferences.getString(KEY_FACULTY_USER_NAME,""))){

        arrayList.add(levelClass);
    }



}

levelsListViewAdapter=new LevelsListViewAdapter(Levels.this,0,arrayList);
listView.setAdapter(levelsListViewAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        buttonAddLevel=findViewById(R.id.btn_add_level);
        buttonAddLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Levels.this,Add_Levels.class);
                startActivity(intent);

            }
        });


    }
}
