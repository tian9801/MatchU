package com.example.matchu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Favorites extends AppCompatActivity {

    BottomNavigationView nav;
    ListView listView;
    List<College> likedList = Swipe.likedList;

    LinearLayout parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        listView = (ListView)findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), likedList);
        listView.setAdapter(customBaseAdapter);

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
