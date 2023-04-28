package com.example.matchu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CollegeAdapter extends ArrayAdapter<College> {
    public CollegeAdapter(Context context, int resource, List<College> collegeList){
        super(context, resource, collegeList);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        College college = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.college_cell, parent, false);
        }
        //add textview and other components from college cell 6:55 in video
        return super.getView(position, convertView, parent);
    }
}
