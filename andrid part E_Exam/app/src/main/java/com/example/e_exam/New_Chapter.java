package com.example.e_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class New_Chapter extends AppCompatActivity {

    DatabaseReference ref;
    private SharedPreferences sharedPreferences;
    public static final String KEY_SUBJECT_KEY="KEY_SUBJECT_KEY";
    EditText editTextName;
    Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__chapter);

        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        ref= FirebaseDatabase.getInstance().getReference().child("Chapters");


        editTextName=findViewById(R.id.et_chapter_name);
        buttonSave=findViewById(R.id.btn_save_chapter);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editTextName.getText().toString();
                String subKey=sharedPreferences.getString(KEY_SUBJECT_KEY,"");
                String key=ref.child("Chapters").push().getKey();


                if (name.equals(" ")|| name.isEmpty())
                {
                    editTextName.setError("Required");
                    return;
                }

                ChapterClass chapterClass=new ChapterClass();

                chapterClass.setKey(key);
                chapterClass.setChapterName(name);
                chapterClass.setSubjectKey(subKey);

                ref.child(chapterClass.getKey()).setValue(chapterClass).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(New_Chapter.this, "Save", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(getIntent());
                    }
                });








            }
        });






    }
}
