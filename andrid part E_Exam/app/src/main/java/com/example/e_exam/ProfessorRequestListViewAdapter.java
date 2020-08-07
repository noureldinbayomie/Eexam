package com.example.e_exam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ProfessorRequestListViewAdapter extends ArrayAdapter<ProfessorClass> {
    public ProfessorRequestListViewAdapter(@NonNull Context context, int resource, @NonNull List<ProfessorClass> objects) {
        super(context, resource, objects);
    }

    DatabaseReference reference,ref;
    //ProfessorClass professorClass;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.professor_request_list_items, parent, false);
        }

       final   ProfessorClass professorClass=getItem(position);


        TextView textViewName=convertView.findViewById(R.id.tv1_professor_name);
        textViewName.setText(professorClass.getNickname());

        Button btnSave=convertView.findViewById(R.id.btn_accept_pro_request);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference= FirebaseDatabase.getInstance().getReference().child("Professors");
                ref= FirebaseDatabase.getInstance().getReference().child("Professor Request");
                reference.child(professorClass.getUsername()).setValue(professorClass);
                ref.child(professorClass.getUsername()).removeValue();
                Intent intent=new Intent(getContext(),ProfessorRequest.class);
                getContext().startActivity(intent);


            }
        });


        Button btnDelete=convertView.findViewById(R.id.btn_delete_pro_request);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ref= FirebaseDatabase.getInstance().getReference().child("Professor Request");

                ref.child(professorClass.getUsername()).removeValue();
                Intent intent=new Intent(getContext(),ProfessorRequest.class);
                getContext().startActivity(intent);



            }
        });















        return  convertView;
    }
}
