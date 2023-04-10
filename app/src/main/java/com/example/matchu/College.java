package com.example.matchu;
import android.os.Parcel;
import android.os.Parcelable;

public class College {
    private String collegeName;
    private String aliasName;
    private String state;
    private String city;
    private String photo;
    private String rank;
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


    private String location;
    private String name;

    public College (int image, String collegeName, String location, String mula){
        this.collegeName = collegeName;
        this.image = image;
        this.location = location;
        this.mula = mula;

    }




    public College(String collegeName, String aliasName, String state, String city, String photo, String rank, int ACT, int aidPercent, int acceptance, int tuition, double gpa, int enrollment, int SAT, int costAfterAid, String type, String academicCalendar, String setting) {
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

    }
    public College (){

    }


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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeName='" + collegeName + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", photo='" + photo + '\'' +
                ", rank='" + rank + '\'' +
                ", ACT=" + ACT +
                ", aidPercent=" + aidPercent +
                ", acceptance=" + acceptance +
                ", tuition=" + tuition +
                ", gpa=" + gpa +
                ", enrollment=" + enrollment +
                ", SAT=" + SAT +
                ", costAfterAid=" + costAfterAid +
                ", type='" + type + '\'' +
                ", academicCalendar='" + academicCalendar + '\'' +
                ", setting='" + setting + '\'' +
                ", docID='" + docID + '\'' +
                ", mula='" + mula + '\'' +
                ", image=" + image +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
