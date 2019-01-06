package com.example.wz.ns.model;


import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Origin implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("prognosisType")
    @Expose
    private String prognosisType;
    @SerializedName("plannedTimeZoneOffset")
    @Expose
    private Integer plannedTimeZoneOffset;
    @SerializedName("plannedDateTime")
    @Expose
    private String plannedDateTime;
    @SerializedName("actualTimeZoneOffset")
    @Expose
    private Integer actualTimeZoneOffset;
    @SerializedName("actualDateTime")
    @Expose
    private String actualDateTime;
    @SerializedName("plannedTrack")
    @Expose
    private String plannedTrack;
    @SerializedName("checkinStatus")
    @Expose
    private String checkinStatus;
    @SerializedName("notes")
    @Expose
    private List<Note> notes = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("uicCode")
    @Expose
    private String uicCode;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("products")
    @Expose
    private Integer products;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrognosisType() {
        return prognosisType;
    }

    public void setPrognosisType(String prognosisType) {
        this.prognosisType = prognosisType;
    }

    public Integer getPlannedTimeZoneOffset() {
        return plannedTimeZoneOffset;
    }

    public void setPlannedTimeZoneOffset(Integer plannedTimeZoneOffset) {
        this.plannedTimeZoneOffset = plannedTimeZoneOffset;
    }

    public String getPlannedDateTime() {
        return plannedDateTime;
    }

    public void setPlannedDateTime(String plannedDateTime) {
        this.plannedDateTime = plannedDateTime;
    }

    public Integer getActualTimeZoneOffset() {
        return actualTimeZoneOffset;
    }

    public void setActualTimeZoneOffset(Integer actualTimeZoneOffset) {
        this.actualTimeZoneOffset = actualTimeZoneOffset;
    }

    public String getActualDateTime() {
        return actualDateTime;
    }

    public void setActualDateTime(String actualDateTime) {
        this.actualDateTime = actualDateTime;
    }

    public String getPlannedTrack() {
        return plannedTrack;
    }

    public void setPlannedTrack(String plannedTrack) {
        this.plannedTrack = plannedTrack;
    }

    public String getCheckinStatus() {
        return checkinStatus;
    }

    public void setCheckinStatus(String checkinStatus) {
        this.checkinStatus = checkinStatus;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getUicCode() {
        return uicCode;
    }

    public void setUicCode(String uicCode) {
        this.uicCode = uicCode;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getProducts() {
        return products;
    }

    public void setProducts(Integer products) {
        this.products = products;
    }

}
