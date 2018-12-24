package com.example.wz.ns.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Note__ {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("noteType")
    @Expose
    private String noteType;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("routeIdxFrom")
    @Expose
    private Integer routeIdxFrom;
    @SerializedName("routeIdxTo")
    @Expose
    private Integer routeIdxTo;
    @SerializedName("isPresentationRequired")
    @Expose
    private Boolean isPresentationRequired;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getRouteIdxFrom() {
        return routeIdxFrom;
    }

    public void setRouteIdxFrom(Integer routeIdxFrom) {
        this.routeIdxFrom = routeIdxFrom;
    }

    public Integer getRouteIdxTo() {
        return routeIdxTo;
    }

    public void setRouteIdxTo(Integer routeIdxTo) {
        this.routeIdxTo = routeIdxTo;
    }

    public Boolean getIsPresentationRequired() {
        return isPresentationRequired;
    }

    public void setIsPresentationRequired(Boolean isPresentationRequired) {
        this.isPresentationRequired = isPresentationRequired;
    }

}
