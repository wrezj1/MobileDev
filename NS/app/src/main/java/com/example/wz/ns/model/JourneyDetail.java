package com.example.wz.ns.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JourneyDetail {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("link")
    @Expose
    private Link link;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

}