package com.example.matchu;

import static com.example.matchu.CalendarUtils.daysInMonthArray;
import static com.example.matchu.CalendarUtils.monthYearfromDate;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalDate;
import java.util.ArrayList;

public class Calendar extends AppCompatActivity implements CalendarAdapter.OnItemListener {

    BottomNavigationView nav;
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initWidgets();
        CalendarUtils.selectedDate = LocalDate.now();
        setMonthView();




        nav = findViewById(R.id.bottomNavigationView);
        nav.setSelectedItemId(R.id.calender);

        nav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.calender:
                        return true;

                    case R.id.favorites:
                        startActivity(new Intent(getApplicationContext(),Favorites.class));
                        overridePendingTransition(0,0);
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

    private void initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setMonthView(){
        monthYearText.setText(monthYearfromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(CalendarUtils.selectedDate);
        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth,this);
        RecyclerView.LayoutManager  layoutManager = new GridLayoutManager(getApplicationContext(),7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);



    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public void previousMonthAction(View view){
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
        setMonthView();



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void nextMonthAction(View view){
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
        setMonthView();



    }








    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, LocalDate date) {
        if(date != null){
            CalendarUtils.selectedDate = date;
            setMonthView();


        }

    }


    public void weeklyAction(View view) {
        startActivity(new Intent(this, WeekViewActivity.class));
    }
}


