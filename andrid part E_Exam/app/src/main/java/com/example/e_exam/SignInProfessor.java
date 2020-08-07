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

public class SignInProfessor extends AppCompatActivity {
    DatabaseReference ref;
    private SharedPreferences sharedPreferences;
    public static final String KEY_PRO_USER_NAME="KEY_PRO_USER_NAME";
    EditText etUsername,etPassword;


Button buttonSignUp,buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_professor);
        ref= FirebaseDatabase.getInstance().getReference().child("Professors");
        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);

        etPassword=findViewById(R.id.et_pro_password_login);
        etUsername=findViewById(R.id.et_pro_username_login);




        buttonLogin=findViewById(R.id.btn_pro_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String password=etPassword.getText().toString();
                final String username=etUsername.getText().toString();

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if (dataSnapshot.child(username).exists())
                        {
                            ProfessorClass professorClass=dataSnapshot.child(username).getValue(ProfessorClass.class);

                            if (password.equals(professorClass.getPassword())){

                                SharedPreferences.Editor editor=sharedPreferences.edit();

                                editor.putString(KEY_PRO_USER_NAME,username);
                                editor.commit();

                                Intent intent=new Intent(SignInProfessor.this,ProfessorHome.class);
                                startActivity(intent);

                            }
                            else {
                                Toast.makeText(SignInProfessor.this, "Password Not Correct", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else {
                            Toast.makeText(SignInProfessor.this, "Username Not Registered", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });












        buttonSignUp=findViewById(R.id.btn_professor_sign_up);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SignInProfessor.this,SignUpProfessore.class);
                startActivity(intent);

            }
        });
    }
}
