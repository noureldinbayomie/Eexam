package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;
import java.util.List;

public class Add_Subject extends AppCompatActivity {
DatabaseReference refSub,refPro,refLevel,refDep;
    private SharedPreferences sharedPreferences;
    public static final String KEY_FACULTY_USER_NAME="KEY_FACULTY_USER_NAME";
    List<String> listPro=new ArrayList<>();
    List<String> listLevel=new ArrayList<>();
    List<String> listDep=new ArrayList<>();
    Spinner spinnerPro,spinnerLevel,spinnerDep;
    Button btnSave;
    EditText editTextName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__subject);

        refPro= FirebaseDatabase.getInstance().getReference().child("Professors");
        refLevel=FirebaseDatabase.getInstance().getReference().child("Faculty Level");
        refDep= FirebaseDatabase.getInstance().getReference().child("Department");
        refSub=FirebaseDatabase.getInstance().getReference().child("Subjects");
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
       spinnerPro=findViewById(R.id.spinner_choose_pro);
       spinnerLevel=findViewById(R.id.spinner_choose_level);
       spinnerDep=findViewById(R.id.spinner_choose_dep);
       editTextName=findViewById(R.id.et_subject_name);



btnSave=findViewById(R.id.btn_save_sub);
btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sendData();

    }
});



        listPro.add("Select Professor");
        listLevel.add("Select Level");




        refPro.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                    String faculty=sharedPreferences.getString(KEY_FACULTY_USER_NAME,"");

                    ProfessorClass professorClass=postSnapshot.getValue(ProfessorClass.class);

                    if (professorClass.getFaculty().equals(faculty)){
                        listPro.add(professorClass.getUsername());
                    }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,listPro);
        spinnerPro.setAdapter(arrayAdapter);












        refLevel.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                    String faculty=sharedPreferences.getString(KEY_FACULTY_USER_NAME,"");

LevelClass levelClass=postSnapshot.getValue(LevelClass.class);

                    if (levelClass.getFacultyUsername().equals(faculty)){
                        listLevel.add(levelClass.getLevelName());
                    }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        final ArrayAdapter arrayAdapterLevel=new ArrayAdapter(this,android.R.layout.simple_spinner_item,listLevel);
        spinnerLevel.setAdapter(arrayAdapterLevel);




spinnerLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        listDep.clear();
        listDep.add("Public");

        refDep.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                    String faculty=sharedPreferences.getString(KEY_FACULTY_USER_NAME,"");

                    DepartmentClass departmentClass=postSnapshot.getValue(DepartmentClass.class);


                    if (departmentClass.getFacultyUsername().equals(faculty) && departmentClass.getLevelName().equals(spinnerLevel.getSelectedItem().toString()))
                    {
                        listDep.add(departmentClass.getDepartmentName());
                    }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        final ArrayAdapter arrayAdapterDep=new ArrayAdapter(Add_Subject.this,android.R.layout.simple_spinner_item,listDep);
        spinnerDep.setAdapter(arrayAdapterDep);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});





        refDep.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                    String faculty=sharedPreferences.getString(KEY_FACULTY_USER_NAME,"");

                   DepartmentClass departmentClass=postSnapshot.getValue(DepartmentClass.class);


                    if (departmentClass.getFacultyUsername().equals(faculty) && departmentClass.getLevelName().equals(spinnerLevel.getSelectedItem().toString()))
                    {
                        listDep.add(departmentClass.getDepartmentName());
                   }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        final ArrayAdapter arrayAdapterDep=new ArrayAdapter(this,android.R.layout.simple_spinner_item,listDep);
        spinnerDep.setAdapter(arrayAdapterDep);


    }

    private void sendData() {
        String key=refSub.child("Subjects").push().getKey();
        String depName=editTextName.getText().toString();
         SubjectsClass subjectsClass=new SubjectsClass();

         subjectsClass.setKey(key);
         subjectsClass.setFacultyUsername(sharedPreferences.getString(KEY_FACULTY_USER_NAME,""));
         subjectsClass.setName(depName);
         subjectsClass.setProName(spinnerPro.getSelectedItem().toString());
         subjectsClass.setLevelName(spinnerLevel.getSelectedItem().toString());
         subjectsClass.setDepName(spinnerDep.getSelectedItem().toString());

         refSub.child(subjectsClass.getKey()).setValue(subjectsClass).addOnSuccessListener(new OnSuccessListener<Void>() {
             @Override
             public void onSuccess(Void aVoid) {

                 Toast.makeText(Add_Subject.this, "Save", Toast.LENGTH_SHORT).show();
                 finish();
                 startActivity(getIntent());
             }
         });












    }
}
