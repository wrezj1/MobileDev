package com.example.wz.ns.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stop implements Serializable {

    @SerializedName("notes")
    @Expose
    private List<Note___> notes = null;
    @SerializedName("routeIdx")
    @Expose
    private Integer routeIdx;
    @SerializedName("departurePrognosisType")
    @Expose
    private String departurePrognosisType;
    @SerializedName("plannedDepartureDateTime")
    @Expose
    private String plannedDepartureDateTime;
    @SerializedName("plannedDepartureTimeZoneOffset")
    @Expose
    private Integer plannedDepartureTimeZoneOffset;
    @SerializedName("actualDepartureDateTime")
    @Expose
    private String actualDepartureDateTime;
    @SerializedName("plannedDepartureTrack")
    @Expose
    private String plannedDepartureTrack;
    @SerializedName("plannedArrivalDateTime")
    @Expose
    private String plannedArrivalDateTime;
    @SerializedName("plannedArrivalTimeZoneOffset")
    @Expose
    private Integer plannedArrivalTimeZoneOffset;
    @SerializedName("plannedArrivalTrack")
    @Expose
    private String plannedArrivalTrack;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
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
    @SerializedName("arrivalPrognosisType")
    @Expose
    private String arrivalPrognosisType;
    @SerializedName("actualArrivalDateTime")
    @Expose
    private String actualArrivalDateTime;
    @SerializedName("departureDelayInSeconds")
    @Expose
    private Integer departureDelayInSeconds;
    @SerializedName("arrivalDelayInSeconds")
    @Expose
    private Integer arrivalDelayInSeconds;

    public List<Note___> getNotes() {
        return notes;
    }

    public void setNotes(List<Note___> notes) {
        this.notes = notes;
    }

    public Integer getRouteIdx() {
        return routeIdx;
    }

    public void setRouteIdx(Integer routeIdx) {
        this.routeIdx = routeIdx;
    }

    public String getDeparturePrognosisType() {
        return departurePrognosisType;
    }

    public void setDeparturePrognosisType(String departurePrognosisType) {
        this.departurePrognosisType = departurePrognosisType;
    }

    public String getPlannedDepartureDateTime() {
        return plannedDepartureDateTime;
    }

    public void setPlannedDepartureDateTime(String plannedDepartureDateTime) {
        this.plannedDepartureDateTime = plannedDepartureDateTime;
    }

    public Integer getPlannedDepartureTimeZoneOffset() {
        return plannedDepartureTimeZoneOffset;
    }

    public void setPlannedDepartureTimeZoneOffset(Integer plannedDepartureTimeZoneOffset) {
        this.plannedDepartureTimeZoneOffset = plannedDepartureTimeZoneOffset;
    }

    public String getActualDepartureDateTime() {
        return actualDepartureDateTime;
    }

    public void setActualDepartureDateTime(String actualDepartureDateTime) {
        this.actualDepartureDateTime = actualDepartureDateTime;
    }

    public String getPlannedDepartureTrack() {
        return plannedDepartureTrack;
    }

    public void setPlannedDepartureTrack(String plannedDepartureTrack) {
        this.plannedDepartureTrack = plannedDepartureTrack;
    }

    public String getPlannedArrivalDateTime() {
        return plannedArrivalDateTime;
    }

    public void setPlannedArrivalDateTime(String plannedArrivalDateTime) {
        this.plannedArrivalDateTime = plannedArrivalDateTime;
    }

    public Integer getPlannedArrivalTimeZoneOffset() {
        return plannedArrivalTimeZoneOffset;
    }

    public void setPlannedArrivalTimeZoneOffset(Integer plannedArrivalTimeZoneOffset) {
        this.plannedArrivalTimeZoneOffset = plannedArrivalTimeZoneOffset;
    }

    public String getPlannedArrivalTrack() {
        return plannedArrivalTrack;
    }

    public void setPlannedArrivalTrack(String plannedArrivalTrack) {
        this.plannedArrivalTrack = plannedArrivalTrack;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
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

    public String getArrivalPrognosisType() {
        return arrivalPrognosisType;
    }

    public void setArrivalPrognosisType(String arrivalPrognosisType) {
        this.arrivalPrognosisType = arrivalPrognosisType;
    }

    public String getActualArrivalDateTime() {
        return actualArrivalDateTime;
    }

    public void setActualArrivalDateTime(String actualArrivalDateTime) {
        this.actualArrivalDateTime = actualArrivalDateTime;
    }

    public Integer getDepartureDelayInSeconds() {
        return departureDelayInSeconds;
    }

    public void setDepartureDelayInSeconds(Integer departureDelayInSeconds) {
        this.departureDelayInSeconds = departureDelayInSeconds;
    }

    public Integer getArrivalDelayInSeconds() {
        return arrivalDelayInSeconds;
    }

    public void setArrivalDelayInSeconds(Integer arrivalDelayInSeconds) {
        this.arrivalDelayInSeconds = arrivalDelayInSeconds;
    }

}