package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfessorHome extends AppCompatActivity {
    DatabaseReference ref;
    private SharedPreferences sharedPreferences;
    public static final String KEY_PRO_USER_NAME="KEY_PRO_USER_NAME";
    public static final String KEY_SUBJECT_KEY="KEY_SUBJECT_KEY";
    ListView listView;

    ArrayList<SubjectsClass> arrayList=new ArrayList<>();
    ProSubjectsListViewAdapter proSubjectsListViewAdapter;





    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_home);

        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        ref= FirebaseDatabase.getInstance().getReference().child("Subjects");

        listView=findViewById(R.id.list_view_pro_subjects);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){

                  SubjectsClass subjectsClass=snapshot.getValue(SubjectsClass.class);
                  String proUsername=sharedPreferences.getString(KEY_PRO_USER_NAME,"");


                  if (proUsername.equals(subjectsClass.getProName())){

                      arrayList.add(subjectsClass);
                  }

                }

           proSubjectsListViewAdapter =new ProSubjectsListViewAdapter(ProfessorHome.this,0,arrayList);
                listView.setAdapter(proSubjectsListViewAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SubjectsClass subjectsClass=arrayList.get(position);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_SUBJECT_KEY,subjectsClass.getKey());
                editor.commit();
                Intent intent=new Intent(ProfessorHome.this,Subjects_Chaptres.class);
                startActivity(intent);





            }
        });


    }
}
