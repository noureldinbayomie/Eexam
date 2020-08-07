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

public class ChapterProListViewAdapter extends ArrayAdapter<ChapterClass> {
    public ChapterProListViewAdapter(@NonNull Context context, int resource, @NonNull List<ChapterClass> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null)
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.chapters_list_items,parent,false);

        ChapterClass chapterClass=getItem(position);


        TextView textView=convertView.findViewById(R.id.tv_chapter_name_pro_list);
        textView.setText(chapterClass.getChapterName());






        return  convertView;
    }
}
