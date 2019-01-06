package com.example.wz.ns.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductFare implements Serializable {

    @SerializedName("priceInCents")
    @Expose
    private Integer priceInCents;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("travelClass")
    @Expose
    private String travelClass;
    @SerializedName("priceInCentsExcludingSupplement")
    @Expose
    private Integer priceInCentsExcludingSupplement;
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

    public Integer getPriceInCentsExcludingSupplement() {
        return priceInCentsExcludingSupplement;
    }

    public void setPriceInCentsExcludingSupplement(Integer priceInCentsExcludingSupplement) {
        this.priceInCentsExcludingSupplement = priceInCentsExcludingSupplement;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

}