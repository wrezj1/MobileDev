package com.example.wz.ns.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Leg implements Serializable {

    @SerializedName("idx")
    @Expose
    private String idx;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("travelType")
    @Expose
    private String travelType;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("changePossible")
    @Expose
    private Boolean changePossible;
    @SerializedName("alternativeTransport")
    @Expose
    private Boolean alternativeTransport;
    @SerializedName("journeyDetailRef")
    @Expose
    private String journeyDetailRef;
    @SerializedName("origin")
    @Expose
    private Origin origin;
    @SerializedName("destination")
    @Expose
    private Destination destination;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("notes")
    @Expose
    private List<Note__> notes = null;
    @SerializedName("messages")
    @Expose
    private List<Object> messages = null;
    @SerializedName("stops")
    @Expose
    private List<Stop> stops = null;
    @SerializedName("steps")
    @Expose
    private List<Object> steps = null;
    @SerializedName("crowdForecast")
    @Expose
    private String crowdForecast;
    @SerializedName("punctuality")
    @Expose
    private double punctuality;
    @SerializedName("shorterStock")
    @Expose
    private Boolean shorterStock;
    @SerializedName("journeyDetail")
    @Expose
    private List<JourneyDetail> journeyDetail = null;
    @SerializedName("reachable")
    @Expose
    private Boolean reachable;

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Boolean getChangePossible() {
        return changePossible;
    }

    public void setChangePossible(Boolean changePossible) {
        this.changePossible = changePossible;
    }

    public Boolean getAlternativeTransport() {
        return alternativeTransport;
    }

    public void setAlternativeTransport(Boolean alternativeTransport) {
        this.alternativeTransport = alternativeTransport;
    }

    public String getJourneyDetailRef() {
        return journeyDetailRef;
    }

    public void setJourneyDetailRef(String journeyDetailRef) {
        this.journeyDetailRef = journeyDetailRef;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Note__> getNotes() {
        return notes;
    }

    public void setNotes(List<Note__> notes) {
        this.notes = notes;
    }

    public List<Object> getMessages() {
        return messages;
    }

    public void setMessages(List<Object> messages) {
        this.messages = messages;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Object> getSteps() {
        return steps;
    }

    public void setSteps(List<Object> steps) {
        this.steps = steps;
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

    public Boolean getShorterStock() {
        return shorterStock;
    }

    public void setShorterStock(Boolean shorterStock) {
        this.shorterStock = shorterStock;
    }

    public List<JourneyDetail> getJourneyDetail() {
        return journeyDetail;
    }

    public void setJourneyDetail(List<JourneyDetail> journeyDetail) {
        this.journeyDetail = journeyDetail;
    }

    public Boolean getReachable() {
        return reachable;
    }

    public void setReachable(Boolean reachable) {
        this.reachable = reachable;
    }

}