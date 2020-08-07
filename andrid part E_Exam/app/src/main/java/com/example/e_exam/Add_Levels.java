package com.example.e_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Add_Levels extends AppCompatActivity {

DatabaseReference refLevel,refDepartment;
    private SharedPreferences sharedPreferences;
    public static final String KEY_FACULTY_USER_NAME="KEY_FACULTY_USER_NAME";
    EditText editTextLevelName;
    Button btnAddDepartment,btnSave;
    LinearLayout linearLayoutAddDepartment;
    String levelKey,facultyKey,levelName;
    ArrayList<DepartmentClass> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__levels);

        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        refDepartment= FirebaseDatabase.getInstance().getReference().child("Department");
        refLevel=FirebaseDatabase.getInstance().getReference().child("Faculty Level");
        levelKey=refLevel.child("Faculty Level").push().getKey();
        facultyKey=sharedPreferences.getString(KEY_FACULTY_USER_NAME,"");

        editTextLevelName=findViewById(R.id.et_level_name);


        linearLayoutAddDepartment=findViewById(R.id.liner_layout_add_department);




        btnAddDepartment=findViewById(R.id.btn_add_department);
        btnAddDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addDepartment();


            }
        });


        btnSave=findViewById(R.id.btn_save_level);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendData();


            }
        });



    }




    private void addDepartment() {

        final View addDepartmentView=getLayoutInflater().inflate(R.layout.add_department_layout,null,false);
        EditText departmentName=(EditText)addDepartmentView.findViewById(R.id.et_department_name);

        ImageButton imageButtonClose=(ImageButton)addDepartmentView.findViewById(R.id.btn_remove_department);
        imageButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDepartmentView(addDepartmentView);
            }
        });

        linearLayoutAddDepartment.addView(addDepartmentView);
    }


    private void removeDepartmentView(View view) {
        linearLayoutAddDepartment.removeView(view);

    }















    private boolean newDepartment() {
        Boolean result=true;

        for(int i=0 ;i<linearLayoutAddDepartment.getChildCount();i++){

            View  addDepartmentView=linearLayoutAddDepartment.getChildAt(i);

            EditText editTextDepartmentName=(EditText) addDepartmentView.findViewById(R.id.et_department_name);
            if(!editTextDepartmentName.getText().toString().equals("")) {
                DepartmentClass departmentClass=new DepartmentClass();

                String key=refDepartment.child("Department").push().getKey();

                String departmentName=editTextDepartmentName.getText().toString();
                levelName=editTextLevelName.getText().toString();

                departmentClass.setKey(key);
                departmentClass.setFacultyUsername(facultyKey);
                departmentClass.setLevelKey(levelKey);
                departmentClass.setDepartmentName(departmentName);
                departmentClass.setLevelName(levelName);
                arrayList.add(departmentClass);
            }
        }
        return result;
    }


    public void  sendData(){


        if(newDepartment()){
            for (int i=0;i<arrayList.size();i++){
                DepartmentClass departmentClass=new DepartmentClass();
                departmentClass=arrayList.get(i);
                refDepartment.child(departmentClass.getKey()).setValue(departmentClass);
            }
        }


        levelName=editTextLevelName.getText().toString();

        LevelClass levelClass=new LevelClass();
        levelClass.setKey(levelKey);
        levelClass.setFacultyUsername(facultyKey);
        levelClass.setLevelName(levelName);
        refLevel.child(levelClass.getKey()).setValue(levelClass).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                finish();
                startActivity(getIntent());

            }
        });
    }


}
