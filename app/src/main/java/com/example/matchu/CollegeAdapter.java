package com.example.matchu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CollegeAdapter extends ArrayAdapter<College> {
    public CollegeAdapter(Context context, int resource, List<College> ScollegeList){
        super(context, resource, ScollegeList);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        College college = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.college_cell, parent, false);
        }
        //added textviews from college cell xml
        TextView tv1 = (TextView) convertView.findViewById(R.id.nameCollege);
        TextView tv2 = (TextView) convertView.findViewById(R.id.stateCollege);
        TextView tv3 = (TextView) convertView.findViewById(R.id.budgetCollege);

        tv1.setText(college.getCollegeName());
        tv2.setText(college.getState());
        String tuition = String.valueOf(college.getTuition());
        tv3.setText("$" + tuition + "/yr");


        return convertView;
    }
}
