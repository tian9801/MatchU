package com.example.matchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.PopupWindow;

public class Popup extends AppCompatActivity {

    LinearLayout parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);


        parent = findViewById((R.id.parent_layout));
        Button show = findViewById(R.id.show_pop);
        show.setOnClickListener((v -> {

        }));
    }

}