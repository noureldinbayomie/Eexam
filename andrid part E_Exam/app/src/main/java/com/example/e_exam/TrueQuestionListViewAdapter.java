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

public class TrueQuestionListViewAdapter extends ArrayAdapter<TrueOrFalseClass> {
    public TrueQuestionListViewAdapter(@NonNull Context context, int resource, @NonNull List<TrueOrFalseClass> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null)
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.choose_question_list_items,parent,false);



        TrueOrFalseClass trueOrFalseClass=getItem(position);

        TextView textView=convertView.findViewById(R.id.tv_choose_question_in_list);
        textView.setText(position+1+" ) "+trueOrFalseClass.getQuestion());





        return  convertView;
    }
}
