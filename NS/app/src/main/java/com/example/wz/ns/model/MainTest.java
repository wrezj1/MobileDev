package com.example.wz.ns.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainTest {

    @SerializedName("trips")
    @Expose
    private List<Trip> trips = null;
    @SerializedName("scrollRequestBackwardContext")
    @Expose
    private String scrollRequestBackwardContext;
    @SerializedName("scrollRequestForwardContext")
    @Expose
    private String scrollRequestForwardContext;

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public String getScrollRequestBackwardContext() {
        return scrollRequestBackwardContext;
    }

    public void setScrollRequestBackwardContext(String scrollRequestBackwardContext) {
        this.scrollRequestBackwardContext = scrollRequestBackwardContext;
    }

    public String getScrollRequestForwardContext() {
        return scrollRequestForwardContext;
    }

    public void setScrollRequestForwardContext(String scrollRequestForwardContext) {
        this.scrollRequestForwardContext = scrollRequestForwardContext;
    }

}