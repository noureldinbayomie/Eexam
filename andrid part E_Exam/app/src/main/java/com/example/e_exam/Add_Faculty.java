package com.example.e_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Add_Faculty extends AppCompatActivity {
   private DatabaseReference ref;

   private EditText etUsername,etNickname,etEmail,etPassword,etConfirmPassword;
   private Button btnSignUp,btnLogin;
    String username,nickname,email,numberOfLevels, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__faculty);

        ref= FirebaseDatabase.getInstance().getReference().child("Faculty");
        etUsername=findViewById(R.id.et_userName);
        etNickname=findViewById(R.id.et_nickname);
        etEmail=findViewById(R.id.et_email);

        etPassword=findViewById(R.id.et_password);
        etConfirmPassword=findViewById(R.id.et_confirm_password);

        btnSignUp=findViewById(R.id.btn_create_account);
        btnLogin=findViewById(R.id.btn_go_to_login);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 username=etUsername.getText().toString();
                 nickname=etNickname.getText().toString();
                 email=etEmail.getText().toString();

                 password=etPassword.getText().toString();
                String confirmPassword=etConfirmPassword.getText().toString();

                if (username.equals(" ")|| username.isEmpty())
                {
                    etUsername.setError("Required");
                    return;

                }
                if (nickname.isEmpty()|| nickname.equals(" ")){
                    etNickname.setError("Required");
                    return;

                }
                if (email.equals(" ")|| email.isEmpty()){
                    etEmail.setError("Required");
                    return;
                }

                if (password.equals(" ")|| password.isEmpty())
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

                            Toast.makeText(Add_Faculty.this, "Username Existed", Toast.LENGTH_SHORT).show();
                            etUsername.setText("");

                        }
                        else {

                            FacultyClass facultyClass=new FacultyClass();

                            facultyClass.setUsername(username);
                            facultyClass.setNickname(nickname);
                            facultyClass.setEmail(email);

                            facultyClass.setPassword(password);
                            ref.child(facultyClass.getUsername()).setValue(facultyClass).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    etConfirmPassword.setText("");
                                    etEmail.setText("");
                                    etNickname.setText("");

                                    etPassword.setText("");
                                    etUsername.setText("");
                                    Toast.makeText(Add_Faculty.this, "Save", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(Add_Faculty.this, Faculty_Login.class);
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
