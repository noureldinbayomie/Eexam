package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;

public class ProfessorRequest extends AppCompatActivity {
    private DatabaseReference ref;

    private SharedPreferences sharedPreferences;
    public static final String KEY_FACULTY_USER_NAME="KEY_FACULTY_USER_NAME";
    private ArrayList<ProfessorClass> arrayList=new ArrayList<>();

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_request);

        ref= FirebaseDatabase.getInstance().getReference().child("Professor Request");
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        listView=findViewById(R.id.list_view_pro_requests);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                    ProfessorClass professorClass=postSnapshot.getValue(ProfessorClass.class);
                    String  facultyUsername=sharedPreferences.getString(KEY_FACULTY_USER_NAME,"");

                    if(facultyUsername.equals(professorClass.getFaculty())){
                       arrayList.add(professorClass);
                    }
                }

          ProfessorRequestListViewAdapter      professorRequestListViewAdapter=new ProfessorRequestListViewAdapter(ProfessorRequest.this,0,arrayList);
          listView.setAdapter(professorRequestListViewAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,AdminHome.class);
        startActivity(intent);
    }
}
