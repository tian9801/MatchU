package com.example.matchu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CollegeAdapter extends ArrayAdapter<College> {
    public CollegeAdapter(Context context, int resource, List<College> collegeList){
        super(context, resource, collegeList);
    }



    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        College college = getItem(i);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.college_cell, parent, false);
        }
        //added textviews from college cell xml
        TextView tv1 = (TextView) convertView.findViewById(R.id.nameCollege);
        TextView tv2 = (TextView) convertView.findViewById(R.id.stateCollege);
        TextView tv3 = (TextView) convertView.findViewById(R.id.budgetCollege);
        Button addHeart = (Button) convertView.findViewById(R.id.heartCollege);


        tv1.setText(college.getCollegeName());
        tv2.setText(college.getState());
        String tuition = String.valueOf(college.getTuition());
        tv3.setText("$" + tuition + "/yr");

        addHeart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Swipe.likedList.add(college);
            }
        });
        return convertView;
    }

}
