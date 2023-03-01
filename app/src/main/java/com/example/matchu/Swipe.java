package com.example.matchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Swipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
    }
    public void stepThree(View view) {
        Intent intent = new Intent(Swipe.this, Favorites.class);
        startActivity(intent);
    }

}