package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SignUpProfessore extends AppCompatActivity {


    DatabaseReference ref,ref2,ref3;

    List<String> list=new ArrayList<>();
    EditText etUsername,etNickname,etEmail,etPassword,etConfirmPassword;
    Button buttonSave;
    Spinner spinner;

    String username,nickname,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_professore);

        ref= FirebaseDatabase.getInstance().getReference().child("Professor Request");
        ref2= FirebaseDatabase.getInstance().getReference().child("Professors");
        ref3= FirebaseDatabase.getInstance().getReference().child("Faculty");
        list.add("Select Faculty");


        spinner=findViewById(R.id.spinner_faculty);
        etUsername=findViewById(R.id.et_professor_username);
        etNickname=findViewById(R.id.et_professor_nickname);
        etEmail=findViewById(R.id.et_professor_email);
        etPassword=findViewById(R.id.et_professor_password);
        etConfirmPassword=findViewById(R.id.et_professor_confirm_password);


        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    FacultyClass facultyClass=postSnapshot.getValue(FacultyClass.class);
                    list.add(facultyClass.getUsername());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
spinner.setAdapter(arrayAdapter);

        buttonSave=findViewById(R.id.btn_professor_create_account);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  username=etUsername.getText().toString();
                 nickname=etNickname.getText().toString();
                 email=etEmail.getText().toString();
                password=etPassword.getText().toString();
                String confirmPassword=etConfirmPassword.getText().toString();

                final String faculty=spinner.getSelectedItem().toString();
if (faculty.equals("Select Faculty"))
{
    Toast.makeText(SignUpProfessore.this, "Select Faculty", Toast.LENGTH_SHORT).show();
    return;
}

                if (username.equals(" ")|| username.isEmpty()){

                    etUsername.setError("Required");
                    return;
                }
                if (nickname.isEmpty()|| nickname.equals(" "))
                {

                    etNickname.setError("Required");
                    return;

                }


                if (email.equals(" ")||email.isEmpty())
                {
                    etEmail.setError("Required");
                    return;
                }

                if (password.isEmpty()|| password.equals(" "))
                {
                    etPassword.setError("Required");
                    return;

                }
                if (!confirmPassword.equals(password))
                {
                    etConfirmPassword.setError("Password Not Match");
                    return;
                }


                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(username).exists()){

                            Toast.makeText(SignUpProfessore.this, "Username Existed", Toast.LENGTH_SHORT).show();
                            etUsername.setText("");

                        }
                        else {
                            ProfessorClass professorClass=new ProfessorClass();

                            professorClass.setUsername(username);
                            professorClass.setNickname(nickname);
                            professorClass.setEmail(email);
                            professorClass.setPassword(password);
                            professorClass.setFaculty(faculty);

                            ref.child(professorClass.getUsername()).setValue(professorClass).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    Toast.makeText(SignUpProfessore.this, "Request Send", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(SignUpProfessore.this,SignInProfessor.class);
                                    startActivity(intent);




                                }
                            });




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
