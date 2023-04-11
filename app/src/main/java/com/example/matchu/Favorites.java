package com.example.matchu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Favorites extends AppCompatActivity {

    BottomNavigationView nav;

   // ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.listView,StringArray);
   // ListView listView = (ListView) findViewById(R.id.listview);
//listView.setAdapter(adapter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        //final ListView list = findViewById(R.id.list);
       // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(list.setAdapter(arrayAdapter);


        nav = findViewById(R.id.bottomNavigationView);
        nav.setSelectedItemId(R.id.favorites);

        nav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.calender:
                        startActivity(new Intent(getApplicationContext(),Calendar.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.favorites:
                        return true;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(),Settings.class));
                        overridePendingTransition(0,0);
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
}
