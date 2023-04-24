package com.example.matchu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Serch extends AppCompatActivity {

    //when this dummy list works, use the collegesDB from the other class
    ListView listView;
    String names[] = {"Chris", "Emma", "Jack", "Shreya", "Liana"};

    ArrayAdapter<String> arrayAdapter;

    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch);
        nav = findViewById(R.id.bottomNavigationView);
        nav.setSelectedItemId(R.id.search);

        nav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.calender:
                        startActivity(new Intent(getApplicationContext(), Calendar.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.favorites:
                        startActivity(new Intent(getApplicationContext(), Favorites.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(), Settings.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.search:
                        return true;

                    case R.id.swipe:
                        startActivity(new Intent(getApplicationContext(), Swipe.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }

        });

        listView = findViewById(R.id.listviewcollege);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.serchpage, menu);
        MenuItem collegeItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) collegeItem.getActionView();
        searchView.setQueryHint("Type here to search a college");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //this method is called when the user types in something and enters
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            //this method is called when the user types in a new character or makes any changes while typing
            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
