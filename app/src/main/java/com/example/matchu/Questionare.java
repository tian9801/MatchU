package com.example.matchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Questionare extends AppCompatActivity {
    public String state;
    public int budget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionare);
    }
    public void next(View view) {
        Intent intent = new Intent(Questionare.this, Favorites.class);
        startActivity(intent);
    }

    public void userPreferences(View view) {
        EditText budgetT = findViewById(R.id.budget);
        EditText stateT = findViewById(R.id.state);

        try {
            budget = Integer.parseInt((budgetT.getText().toString()));
            state = stateT.getText().toString();
        } catch (NumberFormatException e) {
            Toast.makeText(Questionare.this, "Enter an integer please.", Toast.LENGTH_SHORT).show();
        }

    }

}








