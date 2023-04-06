package com.example.matchu;
import android.os.Parcel;
import android.os.Parcelable;

public class College implements Parcelable {
    private String collegeName;
    private String aliasName;
    private String state;
    private String city;
    private String photo;
    private int rank;
    private int ACT;
    private int aidPercent;
    private int acceptance;
    private int tuition;
    private double gpa;
    private int enrollment;



    private int SAT;
    private int costAfterAid;
    private String type;
    private String academicCalendar;
    private String setting;
    private String docID;

    private String mula;
    private int image;


    public String getMula() {
        return mula;
    }

    public void setMula(String mula) {
        this.mula = mula;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String location;
    private String name;

    public College (int image, String name, String location, String mula){
        this.name = name;
        this.image = image;
        this.location = location;
        this.mula = mula;

    }



    public College(String collegeName, String aliasName, String state, String city, String photo, int rank, int ACT, int aidPercent, int acceptance, int tuition, double gpa, int enrollment, int SAT, int costAfterAid, String type, String academicCalendar, String setting, String docID) {
        this.collegeName = collegeName;
        this.aliasName = aliasName;
        this.state = state;
        this.city = city;
        this.photo = photo;
        this.rank = rank;
        this.ACT = ACT;
        this.aidPercent = aidPercent;
        this.acceptance = acceptance;
        this.tuition = tuition;
        this.gpa = gpa;
        this.enrollment = enrollment;
        this.SAT = SAT;
        this.costAfterAid = costAfterAid;
        this.type = type;
        this.academicCalendar = academicCalendar;
        this.setting = setting;
        this.docID = docID;
    }


    public College(String photo, String collegeName, String state, int tuition) {
        this.photo = photo;
        this.collegeName = collegeName;
        this.state = state;
        this.tuition = tuition;
    }




    // A default constructor is required for the Parcelable interface to work
    public College() {
        collegeName="No name";
        aliasName="No alias";
        state="No state";
        city= "No city";
        photo="No photo";
        rank= 0;
        ACT = 0;
        aidPercent = 0;
        acceptance = 0;
        tuition = 0;
        gpa = 0.0;
        enrollment = 0;
        SAT = 0;
        costAfterAid = 0;
        type = "No type";
        academicCalendar = "No calendar";
        setting = "No setting";
        docID = "No docID";
    }


    /**
     * This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Memory object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * <p>
     * MAKE SURE THE ORDER OF THESE VARS IS CONSISTENT WITH ALL CONSTRUCTOR TYPE METHODS
     *
     * @param parcel the parcel that is received from the intent
     */


    public College(Parcel parcel) {
        collegeName=parcel.readString();
        aliasName=parcel.readString();
        state=parcel.readString();
        city= parcel.readString();
        photo=parcel.readString();
        rank= parcel.readInt();
        ACT = parcel.readInt();
        aidPercent = parcel.readInt();
        acceptance = parcel.readInt();
        tuition = parcel.readInt();
        gpa = parcel.readInt();
        enrollment = parcel.readInt();
        SAT = parcel.readInt();
        costAfterAid = parcel.readInt();
        type = parcel.readString();
        academicCalendar = parcel.readString();
        setting =parcel.readString();
        docID =parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
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
        dest.writeString(collegeName);
        dest.writeString(aliasName);
        dest.writeString(state);
        dest.writeString(city);
        dest.writeString(photo);
        dest.writeInt(rank);
        dest.writeInt(ACT);
        dest.writeInt(aidPercent);
        dest.writeInt(acceptance);
        dest.writeInt(tuition);
        dest.writeDouble(gpa);
        dest.writeInt(enrollment);
        dest.writeInt(SAT);
        dest.writeInt(costAfterAid);
        dest.writeString(type);
        dest.writeString(academicCalendar);
        dest.writeString(setting);
        dest.writeString(docID);

    }

    // this code is needed for the Memory class to work with Parcelable
    public static final Parcelable.Creator<College> CREATOR = new
            Parcelable.Creator<College>() {

                @Override
                public College createFromParcel(Parcel parcel) {
                    return new College(parcel);
                }

                @Override
                public College[] newArray(int size) {
                    return new College[0];
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

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getACT() {
        return ACT;
    }

    public void setACT(int ACT) {
        this.ACT = ACT;
    }

    public int getAidPercent() {
        return aidPercent;
    }

    public void setAidPercent(int aidPercent) {
        this.aidPercent = aidPercent;
    }

    public int getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(int acceptance) {
        this.acceptance = acceptance;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public int getSAT() {
        return SAT;
    }

    public void setSAT(int SAT) {
        this.SAT = SAT;
    }

    public int getCostAfterAid() {
        return costAfterAid;
    }

    public void setCostAfterAid(int costAfterAid) {
        this.costAfterAid = costAfterAid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAcademicCalendar() {
        return academicCalendar;
    }

    public void setAcademicCalendar(String academicCalendar) {
        this.academicCalendar = academicCalendar;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }
}

