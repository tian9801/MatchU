package com.example.matchu;



import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;

import java.util.ArrayList;

public class Event implements Parcelable
{



    private String name;
    private String date;


    private String docID;

    private int hour;

    private int minute;
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public static ArrayList<Event> eventsForDate(String date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }






    public Event(String eventName, LocalDate selectedDate){
        this.docID = "no doc Id";
    }

    public Event(String name, String date)
    {
        this.name = name;
        this.date = date;

    }

    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Memory object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     *
     * MAKE SURE THE ORDER OF THESE VARS IS CONSISTENT WITH ALL CONSTRUCTOR TYPE METHODS
     * @param parcel    the parcel that is received from the intent
     */

    public Event(Parcel parcel) {
        name = parcel.readString();

        docID = parcel.readString();



    }

    public Event() {




    }

    /**
     * This is what is used when we send the Memory object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Memory constructor that accepts a Parcel reference can "unpack it"
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);

        dest.writeString(docID);



    }


    // this code is needed for the Memory class to work with Parcelable
    public static final Parcelable.Creator<Event> CREATOR = new
            Parcelable.Creator<Event>() {

                @Override
                public Event createFromParcel(Parcel parcel) {
                    return new Event(parcel);
                }

                @Override
                public Event[] newArray(int size) {
                    return new Event[0];
                }
            };


    /**
     * This method is required for the Parceable interface.  As of now, this method
     * is in the default state and doesn't really do anything.
     *
     * If your Parcelable class will have child classes, you'll need to
     * take some extra care with the describeContents() method. This would
     * let you identify the specific child class that should be created by
     * the Parcelable.Creator. You can read more about how this works on
     *  Stack Overflow with this link.
     *           https://stackoverflow.com/questions/4778834/purpose-of-describecontents-of-parcelable-interface
     * @return
     */

    @Override
    public int describeContents() {
        return 0;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }



    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
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
