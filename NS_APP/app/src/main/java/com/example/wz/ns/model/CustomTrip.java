package com.example.wz.ns.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomTrip implements Parcelable, Serializable {

    private String origin;
    private String originTime;
    private String dest;
    private String destTime;
    private String journeyTime;
    private String crowdForecast;
    private String status;
    private List<Leg> customLeg;


    public CustomTrip(String origin, String originTime,
                      String dest, String destTime, String journeyTime,
                      String crowdForecast, String status) {
        this.origin = origin;
        this.originTime = originTime;
        this.dest = dest;
        this.destTime = destTime;
        this.journeyTime = journeyTime;
        this.crowdForecast = crowdForecast;
        this.status = status;

    }


    protected CustomTrip(Parcel in) {
        origin = in.readString();
        originTime = in.readString();
        dest = in.readString();
        destTime = in.readString();
        journeyTime = in.readString();
        crowdForecast = in.readString();
        status = in.readString();
    }


    public static final Creator<CustomTrip> CREATOR = new Creator<CustomTrip>() {
        @Override
        public CustomTrip createFromParcel(Parcel in) {
            return new CustomTrip(in);
        }

        @Override
        public CustomTrip[] newArray(int size) {
            return new CustomTrip[size];
        }
    };

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginTime() {
        return originTime;
    }

    public void setOriginTime(String originTime) {
        this.originTime = originTime;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDestTime() {
        return destTime;
    }

    public void setDestTime(String destTime) {
        this.destTime = destTime;
    }

    public String getJourneyTime() {
        return journeyTime;
    }

    public void setJourneyTime(String journeyTime) {
        this.journeyTime = journeyTime;
    }

    public String getCrowdForecast() {
        return crowdForecast;
    }

    public void setCrowdForecast(String crowdForecast) {
        this.crowdForecast = crowdForecast;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Leg> getCustomLeg() {
        return customLeg;
    }

    public void setCustomLeg(List<Leg> customLeg) {
        this.customLeg = customLeg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(origin);
        parcel.writeString(originTime);
        parcel.writeString(dest);
        parcel.writeString(destTime);
        parcel.writeString(journeyTime);
        parcel.writeString(crowdForecast);
        parcel.writeString(status);
    }
}
