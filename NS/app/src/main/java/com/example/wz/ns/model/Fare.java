package com.example.wz.ns.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fare {

    @SerializedName("priceInCents")
    @Expose
    private Integer priceInCents;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("travelClass")
    @Expose
    private String travelClass;
    @SerializedName("discountType")
    @Expose
    private String discountType;

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(Integer priceInCents) {
        this.priceInCents = priceInCents;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

}