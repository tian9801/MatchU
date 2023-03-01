package com.example.matchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Questionare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionare);
    }
    public void stepTwo(View view) {
        Intent intent = new Intent(Questionare.this, Swipe.class);
        startActivity(intent);
    }
}