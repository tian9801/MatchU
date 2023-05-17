package com.example.matchu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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
        createNotificationChannel();

        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        timeButton = findViewById(R.id.timeButton);

        Button event = findViewById(R.id.save);

        event.setOnClickListener(v -> {
            Toast.makeText(this,"reminder is set!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(EventEditActivity.this,ReminderBroadcast.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(EventEditActivity.this, 0, intent,0);

            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);


            long nooo = (hour*3600000) + (minute*60000 );
            long twentyFour = 10000;

            alarmManager.set(AlarmManager.RTC_WAKEUP,
                    nooo + twentyFour, pendingIntent);

            String eventName = eventNameET.getText().toString();

            Event newEvent;

            newEvent = new Event(eventName, CalendarUtils.formattedDate(CalendarUtils.selectedDate));
            newEvent.setHour(hour);
            newEvent.setMinute(minute);

            Event.eventsList.add(newEvent);
            LogIn.firebaseHelper.addDataEvent(newEvent);





            finish();


        });



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initWidgets() {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);









    }


    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "notif";
            String description = "descripton";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyuser", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
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
