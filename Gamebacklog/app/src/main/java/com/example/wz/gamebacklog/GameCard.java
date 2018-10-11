package com.example.wz.gamebacklog;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity(tableName = "gameCard")
public class GameCard implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "cardTitle")
    private String title;

    @ColumnInfo(name = "platformType")
    private String platform;

    @ColumnInfo(name = "cardNote")
    private String notes;

    @ColumnInfo(name = "cardStatus")
    private String status;

    @ColumnInfo(name = "cardDate")
    private String date;


    public GameCard(String title, String platform, String notes, String status, String date) {
        this.title = title;
        this.platform = platform;
        this.notes = notes;
        this.status = status;
        this.date = date;
    }

    protected GameCard(Parcel in) {
        id = in.readLong();
        title = in.readString();
        platform = in.readString();
        notes = in.readString();
        date = in.readString();
        status = in.readString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GameCard{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", platform='" + platform + '\'' +
                ", notes='" + notes + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.title);
	dest.writeString(this.platform);
        dest.writeString(this.notes);
        dest.writeString(this.date);
        dest.writeString(this.status);
    }

    public static final Creator<GameCard> CREATOR = new Creator<GameCard>() {
        @Override
        public GameCard createFromParcel(Parcel in) {
            return new GameCard(in);
        }

        @Override
        public GameCard[] newArray(int size) {
            return new GameCard[size];
        }
    };

}
