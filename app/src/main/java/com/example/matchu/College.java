package com.example.matchu;
import android.os.Parcel;
import android.os.Parcelable;

public class College implements Parcelable {
    private int image;
    private String collegeName;
    private String location;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int price;
    private String setting;
    private String docId;

    public College(String collegeName, String location, int price, String setting, String docId) {
        this.collegeName = collegeName;
        this.location = location;
        this.price = price;
        this.setting = setting;
        this.docId = docId;
    }

    public College(int image, String collegeName, String location, int price) {
        this.image = image;
        this.collegeName = collegeName;
        this.location = location;
        this.price = price;
    }

    public College(String collegeName, String location, int price) {
        this.collegeName = collegeName;
        this.location = location;
        this.price = price;
    }

    public College(String collegeName) {
        this.collegeName = collegeName;
    }

    // A default constructor is required for the Parcelable interface to work
    public College() {
        price = 0;
        collegeName = "No name";
        location = "No desc";
        setting = "No setting";
        docId = "No docID yet";
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
        price = parcel.readInt();
        collegeName = parcel.readString();
        location = parcel.readString();
        setting = parcel.readString();
        docId = parcel.readString();
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
        dest.writeInt(price);
        dest.writeString(collegeName);
        dest.writeString(location);
        dest.writeString(setting);
        dest.writeString(docId);

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

    @Override
    public int describeContents() {
        return 0;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }
}
