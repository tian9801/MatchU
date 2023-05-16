package com.example.matchu;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Settings extends AppCompatActivity {


    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        nav = findViewById(R.id.bottomNavigationView);
        nav.setSelectedItemId(R.id.settings);

        nav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.calender:
                        startActivity(new Intent(getApplicationContext(),Calendar.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.favorites:
                        startActivity(new Intent(getApplicationContext(),Favorites.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        return true;
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(),Serch.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.swipe:
                        startActivity(new Intent(getApplicationContext(),Swipe.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }

        });
    }
    public void changePreferences(View view) {
        Intent intent = new Intent(Settings.this, Questionare.class);
        startActivity(intent);
    }

    public void logOutClicked(View view) {
        //for(int i = 0; i< Swipe.likedList.size(); i++){
           // LogIn.firebaseHelper.addData(Swipe.likedList.get(i));
        //}

        LogIn.firebaseHelper.logOutUser();

        Log.i("HELLO", "user logged out");

        Intent intent = new Intent(Settings.this, LogIn.class);

        startActivity(intent);

    }



}



