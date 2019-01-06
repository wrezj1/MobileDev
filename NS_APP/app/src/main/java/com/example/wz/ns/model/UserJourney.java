package com.example.wz.ns.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

@Entity(tableName = "userJourney")
public class UserJourney implements Parcelable, Serializable{

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "fromStation")
    private String from;

    @ColumnInfo(name = "toStation")
    private String to;

    public UserJourney(String from, String to) {
        this.from = from;
        this.to = to;
    }

    protected UserJourney(Parcel in){
        id = in.readLong();
        from = in.readString();
        to = in.readString();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public static Creator<UserJourney> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "UserJourney{" +
                "form='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.id);
            parcel.writeString(this.from);
            parcel.writeString(this.to);



    }

    public static final Creator<UserJourney> CREATOR = new Creator<UserJourney>() {
        @Override
        public UserJourney createFromParcel(Parcel in) {
            return new UserJourney(in);
        }

        @Override
        public UserJourney[] newArray(int size) {
            return new UserJourney[size];
        }
    };

}
