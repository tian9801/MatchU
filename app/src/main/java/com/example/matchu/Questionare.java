package com.example.matchu;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Questionare extends AppCompatActivity {

    private int budget;
    private String stateInput;
    private String setting;
    private int population;

    EditText hi;
    CheckBox urban;
    CheckBox suburban;
    CheckBox rural;

    CheckBox lessThan;
    CheckBox tenTo;
    CheckBox twentyFiveTo;
    CheckBox fiftyPlus;

    EditText state;

    String[] fiftyStates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionare);
        readCollegeData();

        hi = (EditText) findViewById(R.id.budget);
        urban = (CheckBox) findViewById(R.id.urban);
        suburban = (CheckBox) findViewById(R.id.suburban);
        rural = (CheckBox) findViewById(R.id.rural);

        lessThan = (CheckBox) findViewById(R.id.lessthan);
        tenTo = (CheckBox) findViewById(R.id.tenToTwentyFive);
        twentyFiveTo = (CheckBox) findViewById(R.id.twentyFiveTo);
        fiftyPlus = (CheckBox) findViewById(R.id.fiftyPlus);

        state = (EditText) findViewById(R.id.state);
        fiftyStates = new String[]{"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME"
                , "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX"
                , "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

    }

    public static List<College> collegeDB = new ArrayList<>();
    public static List<College> newColleges = new ArrayList<>();

    public static List<College> getCollegeDB() {
        return collegeDB;
    }

    public static void setCollegeDB(List<College> collegeDB) {
        Questionare.collegeDB = collegeDB;
    }

    public static List<College> getNewColleges() {
        return newColleges;
    }

    public static void setNewColleges(List<College> newColleges) {
        Questionare.newColleges = newColleges;
    }

    private void readCollegeData() {
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
                if (tokens[0].length() > 0) {
                    college.setCollegeName(tokens[0]);
                } else {
                    college.setCollegeName("na");
                }
                if (tokens[1].length() > 0) {
                    college.setAliasName(tokens[1]);
                } else {
                    college.setAliasName("na");
                }
                if (tokens[2].length() > 0) {
                    college.setState(tokens[2]);
                } else {
                    college.setState("na");
                }
                if (tokens[3].length() > 0) {
                    college.setCity(tokens[3]);
                } else {
                    college.setCity("na");
                }
                if (tokens[4].length() > 0) {
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
                if (tokens[8].length() > 0) {
                    college.setAcceptance(parseInt(tokens[8]));
                } else {
                    college.setAcceptance(0);
                }
                if (tokens[9].length() > 0) {
                    college.setTuition(parseInt(tokens[9]));
                } else {
                    college.setTuition(0);
                }
                if (tokens[10].length() > 0) {
                    college.setGpa(Double.parseDouble(tokens[10]));
                } else {
                    college.setGpa(0.0);
                }
                 if (tokens[11].length() > 0){
                     college.setEnrollment(parseInt(tokens[11]));
                  } else {
                   college.setEnrollment(0);
                 }
                if (tokens[12].length() > 0) {
                    college.setSAT(parseInt(tokens[12]));
                } else {
                    college.setSAT(0);
                }
                if (tokens[13].length() > 0) {
                    college.setCostAfterAid(parseInt(tokens[13]));
                } else {
                    college.setCostAfterAid(0);
                }
                if (tokens[14].length() > 0) {
                    college.setType(tokens[14]);
                } else {
                    college.setType("na");
                }
                if (tokens[15].length() > 0) {
                    college.setAcademicCalendar(tokens[15]);
                } else {
                    college.setAcademicCalendar("na");
                }
                if (tokens[16].length() > 0) {
                    college.setSetting(tokens[16]);
                } else {
                    college.setSetting("na");
                }
                if (tokens[17].length() > 0) {
                    Log.d("myActivity", "Hi " + college);

                } else {
                    Log.d("myActivity", "Hi " + college);
                }


                collegeDB.add(college);
                Log.d("myActivity", "Hi " + college);


            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading file" + line, e);
            e.printStackTrace();
        }

    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getStateInput() {
        return stateInput;
    }

    public void setStateInput(String stateInput) {
        this.stateInput = stateInput;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


    public void stepTwo(View view) {
        newColleges.clear();
        Log.i("yo", "hi" + collegeDB);
        int counter = 0;
        boolean isTrue = false;
        boolean pref = false;

        if (TextUtils.isEmpty(hi.getText().toString())) {
            Toast.makeText(Questionare.this, "Enter a budget!", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(state.getText().toString())) {
            Toast.makeText(Questionare.this, "Enter a State!", Toast.LENGTH_SHORT).show();
        } else {
            setBudget(Integer.parseInt(hi.getText().toString()));
            Log.i("budget", "" + budget);
            Log.i("kevin", "hi" + state.getText());

            for (int i = 0; i < collegeDB.size(); i++) {

                for (int v = 0; v < fiftyStates.length; v++) {
                    if (fiftyStates[v].equalsIgnoreCase(collegeDB.get(i).getState()) && collegeDB.get(i).getState().equalsIgnoreCase(state.getText().toString())) {
                        isTrue = true;

                    }
                    if(isTrue) {
                        Log.i("check", "hi" + collegeDB.get(i));
                            if (collegeDB.get(i).getTuition() < budget) {

                                if ((rural.isChecked() && collegeDB.get(i).getSetting().equalsIgnoreCase("rural"))
                                   ||( urban.isChecked() && collegeDB.get(i).getSetting().equalsIgnoreCase("urban"))
                                || (suburban.isChecked() && collegeDB.get(i).getSetting().equalsIgnoreCase("suburban"))) {
                                    newColleges.add(collegeDB.get(i));
                                }
                                if ((lessThan.isChecked() && (collegeDB.get(i).getEnrollment() < 10000 && collegeDB.get(i).getEnrollment() > 1))
                                  || (tenTo.isChecked() && (collegeDB.get(i).getEnrollment() < 25000 && collegeDB.get(i).getEnrollment() > 10000))
                                || (twentyFiveTo.isChecked() && (collegeDB.get(i).getEnrollment() < 50000 && collegeDB.get(i).getEnrollment() > 25000))
                                 || (fiftyPlus.isChecked() && collegeDB.get(i).getEnrollment() > 50000)) {
                                    newColleges.add(collegeDB.get(i));
                                }




                                Log.i("v", "hi" + newColleges);


                            }
<<<<<<< Updated upstream
                            isTrue = false;
=======


                                newColleges.add(collegeDB.get(i));

                              Log.i("hi", "hi" + newColleges);
>>>>>>> Stashed changes
                        }




                    }

                }


                Log.i("kevin", "NEW ONE" + newColleges);


                Intent intent = new Intent(Questionare.this, Swipe.class);
                startActivity(intent);

            }


        }
    }