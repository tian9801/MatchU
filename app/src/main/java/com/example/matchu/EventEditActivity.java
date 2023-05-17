package com.example.matchu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalTime;
import java.util.Locale;

public class EventEditActivity extends AppCompatActivity {
    public static EditText eventNameET;

    public static String eventTime;
    private TextView eventDateTV;
    private EditText eventTimeTV;
    private String time;
    Button timeButton;
    private int hour, minute;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();

        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        timeButton = findViewById(R.id.timeButton);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initWidgets() {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);









    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saveEventAction(View view){
        String eventName = eventNameET.getText().toString();
        Event newEvent = null;

        newEvent = new Event(eventName, CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        newEvent.setHour(hour);
        newEvent.setMinute(minute);

        Event.eventsList.add(newEvent);
        LogIn.firebaseHelper.addDataEvent(newEvent);





        finish();


    }


    public void popTimePicker(View view){

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(),"%02d %02d", hour, minute));



            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener,hour,minute,true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();




    }

    public static EditText getEventNameET() {
        return eventNameET;
    }

    public void setEventNameET(EditText eventNameET) {
        this.eventNameET = eventNameET;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
