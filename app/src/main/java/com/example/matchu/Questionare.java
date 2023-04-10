package com.example.matchu;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Questionare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionare);
        readCollegeData();
    }
    public void stepTwo(View view) {
        Intent intent = new Intent(Questionare.this, Swipe.class);
        startActivity(intent);
    }
    public static List<College> collegeDB = new ArrayList<>();

    public static List<College> getCollegeDB() {
        return collegeDB;
    }

    public static void setCollegeDB(List<College> collegeDB) {
        Questionare.collegeDB = collegeDB;
    }

    private void readCollegeData(){
        InputStream is = getResources().openRawResource(R.raw.collegedata);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );


        String line = "";
        try {
            //Step over headers
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                //split by commas
                String[] tokens = line.split(",");
                //read the data
                College college = new College();
                if (tokens[0].length() > 0){
                    college.setCollegeName(tokens[0]);
                } else {
                    college.setCollegeName("na");
                }
                if (tokens[1].length() > 0){
                    college.setAliasName(tokens[1]);
                } else {
                    college.setAliasName("na");
                }
                if (tokens[2].length() > 0){
                    college.setState(tokens[2]);
                } else {
                    college.setState("na");
                }
                if (tokens[3].length() > 0){
                    college.setCity(tokens[3]);
                } else {
                    college.setCity("na");
                }
                if (tokens[4].length() > 0){
                    college.setPhoto(tokens[4]);
                } else {
                    college.setPhoto("na");
                }
                //if (tokens[5].length() > 0){
                  //  college.setACT(Integer.parseInt(tokens[5]));
              // } else {
                 //   college.setACT(0);
               // }
                //if (tokens[6].length() > 0){
                  //  college.setAidPercent(parseInt(tokens[6]));
              //  } else {
                //    college.setAidPercent(0);
              //  }
                if (tokens[7].length() > 0){
                    college.setAcceptance(parseInt(tokens[7]));
                } else {
                    college.setAcceptance(0);
                }
                if (tokens[8].length() > 0){
                    college.setTuition(parseInt(tokens[8]));
                } else {
                    college.setTuition(0);
                }
                if (tokens[9].length() > 0){
                    college.setGpa(Double.parseDouble(tokens[9]));
                } else {
                    college.setGpa(0.0);
                }
                if (tokens[10].length() > 0){
                    college.setEnrollment(parseInt(tokens[10]));
                } else {
                    college.setEnrollment(0);
                }
                if (tokens[11].length() > 0){
                    college.setSAT(parseInt(tokens[11]));
                } else {
                    college.setSAT(0);
                }
                if (tokens[12].length() > 0){
                    college.setCostAfterAid(parseInt(tokens[12]));
                } else {
                    college.setCostAfterAid(0);
                }
                if (tokens[13].length() > 0){
                    college.setType(tokens[13]);
                } else {
                    college.setType("na");
                }
                if (tokens[14].length() > 0){
                    college.setAcademicCalendar(tokens[14]);
                } else {
                    college.setAcademicCalendar("na");
                }


                collegeDB.add(college);
                Log.d("myActivity", "Hi "+college);



            }
        }catch(IOException e){
            Log.wtf("MyActivity", "Error reading file" + line, e);
            e.printStackTrace();
        }
    }
}