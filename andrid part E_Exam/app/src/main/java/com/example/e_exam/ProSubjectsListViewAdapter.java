package com.example.e_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProSubjectsListViewAdapter extends ArrayAdapter<SubjectsClass> {
    public ProSubjectsListViewAdapter(@NonNull Context context, int resource, @NonNull List<SubjectsClass> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       if (convertView== null)
           convertView= LayoutInflater.from(getContext()).inflate(R.layout.pro_subjects_list_items,parent,false);


       SubjectsClass subjectsClass=getItem(position);
        TextView textView=convertView.findViewById(R.id.tv_subject_name_pro_list);
        textView.setText(subjectsClass.getName());

        return convertView;
    }
}
