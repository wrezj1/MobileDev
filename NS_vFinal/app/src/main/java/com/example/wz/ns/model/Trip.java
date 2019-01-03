package com.example.wz.ns.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trip implements Parcelable, Serializable {

    @SerializedName("plannedDurationInMinutes")
    @Expose
    private Integer plannedDurationInMinutes;
    @SerializedName("transfers")
    @Expose
    private Integer transfers;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("legs")
    @Expose
    private List<Leg> legs = null;
    @SerializedName("overviewPolyLine")
    @Expose
    private List<Object> overviewPolyLine = null;
    @SerializedName("checksum")
    @Expose
    private String checksum;
    @SerializedName("crowdForecast")
    @Expose
    private String crowdForecast;
    @SerializedName("punctuality")
    @Expose
    private double punctuality;
    @SerializedName("ctxRecon")
    @Expose
    private String ctxRecon;
    @SerializedName("actualDurationInMinutes")
    @Expose
    private Integer actualDurationInMinutes;
    @SerializedName("idx")
    @Expose
    private Integer idx;
    @SerializedName("optimal")
    @Expose
    private Boolean optimal;
    @SerializedName("fares")
    @Expose
    private List<Fare> fares = null;
    @SerializedName("productFare")
    @Expose
    private ProductFare productFare;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("shareUrl")
    @Expose
    private ShareUrl shareUrl;
    @SerializedName("realtime")
    @Expose
    private Boolean realtime;

    public Trip(Parcel in) {
    }

    public Integer getPlannedDurationInMinutes() {
        return plannedDurationInMinutes;
    }

    public void setPlannedDurationInMinutes(Integer plannedDurationInMinutes) {
        this.plannedDurationInMinutes = plannedDurationInMinutes;
    }

    public Integer getTransfers() {
        return transfers;
    }

    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public List<Object> getOverviewPolyLine() {
        return overviewPolyLine;
    }

    public void setOverviewPolyLine(List<Object> overviewPolyLine) {
        this.overviewPolyLine = overviewPolyLine;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getCrowdForecast() {
        return crowdForecast;
    }

    public void setCrowdForecast(String crowdForecast) {
        this.crowdForecast = crowdForecast;
    }

    public double getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(double punctuality) {
        this.punctuality = punctuality;
    }

    public String getCtxRecon() {
        return ctxRecon;
    }

    public void setCtxRecon(String ctxRecon) {
        this.ctxRecon = ctxRecon;
    }

    public Integer getActualDurationInMinutes() {
        return actualDurationInMinutes;
    }

    public void setActualDurationInMinutes(Integer actualDurationInMinutes) {
        this.actualDurationInMinutes = actualDurationInMinutes;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Boolean getOptimal() {
        return optimal;
    }

    public void setOptimal(Boolean optimal) {
        this.optimal = optimal;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

    public ProductFare getProductFare() {
        return productFare;
    }

    public void setProductFare(ProductFare productFare) {
        this.productFare = productFare;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ShareUrl getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(ShareUrl shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Boolean getRealtime() {
        return realtime;
    }

    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
    public static final Creator<Trip> CREATOR = new Creator<Trip>() {
        @Override
        public Trip createFromParcel(Parcel in) {
            return new Trip(in);
        }

        @Override
        public Trip[] newArray(int size) {
            return new Trip[size];
        }
    };
}