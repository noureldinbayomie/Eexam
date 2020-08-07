package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Faculty_Login extends AppCompatActivity {
   private DatabaseReference ref;

    private SharedPreferences sharedPreferences;
    public static final String KEY_FACULTY_USER_NAME="KEY_FACULTY_USER_NAME";
   private EditText editTextUsername,etPassword;
   private Button addFaculty,btnLogin;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__login);
  ref= FirebaseDatabase.getInstance().getReference().child("Faculty");
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);



        editTextUsername=findViewById(R.id.et_userName_faculty_login);
        etPassword=findViewById(R.id.et_password_faculty_login);


        addFaculty=findViewById(R.id.btn_add_new_faculty);
        addFaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Faculty_Login.this,Add_Faculty.class);
                startActivity(intent);
            }
        });

        btnLogin=findViewById(R.id.btn_faculty_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username=editTextUsername.getText().toString();
                final String password=etPassword.getText().toString();

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(username).exists()){

                            FacultyClass facultyClass=dataSnapshot.child(username).getValue(FacultyClass.class);
                            if (username.equals(facultyClass.getUsername()) && password.equals(facultyClass.getPassword())){
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString(KEY_FACULTY_USER_NAME,username);
                                editor.commit();
                                Intent intent=new Intent(Faculty_Login.this,AdminHome.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(Faculty_Login.this, "Password Not Correct", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Faculty_Login.this, "Not Registered", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });











            }
        });






    }
}
