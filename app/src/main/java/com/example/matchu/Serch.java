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

import java.util.ArrayList;
import java.util.Locale;

public class Serch extends AppCompatActivity {

    //public static ArrayList <College> collegeListSerch = new ArrayList<College>();
    private ListView listView;



    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch);
        initiateSearch();
        setupData();
        setUpList();
        setUpOnclickListener();

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

    }

    private void setupData(){
        Questionare.getCollegeDB();
    }
    private void setUpList(){
        listView = (ListView) findViewById(R.id.listviewcollege);
        CollegeAdapter adapter = new CollegeAdapter(getApplicationContext(), 0, Questionare.getCollegeDB());
        listView.setAdapter(adapter);
    }

    //might need to set this up for scroll view
    private void setUpOnclickListener(){

    }

    private void initiateSearch(){
        SearchView searchView = (SearchView) findViewById(R.id.searchicon);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<College> filteredColleges = new ArrayList<College>();
                for (College college: Questionare.getCollegeDB()){
                    if(college.getCollegeName().toLowerCase().contains(s.toLowerCase())){
                        filteredColleges.add(college);
                    }
                }

                CollegeAdapter adapter = new CollegeAdapter(getApplicationContext(), 0, filteredColleges);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }
}
