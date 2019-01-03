package com.example.wz.ns.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("categoryCode")
    @Expose
    private String categoryCode;
    @SerializedName("shortCategoryName")
    @Expose
    private String shortCategoryName;
    @SerializedName("longCategoryName")
    @Expose
    private String longCategoryName;
    @SerializedName("operatorCode")
    @Expose
    private String operatorCode;
    @SerializedName("operatorName")
    @Expose
    private String operatorName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("displayName")
    @Expose
    private String displayName;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getShortCategoryName() {
        return shortCategoryName;
    }

    public void setShortCategoryName(String shortCategoryName) {
        this.shortCategoryName = shortCategoryName;
    }

    public String getLongCategoryName() {
        return longCategoryName;
    }

    public void setLongCategoryName(String longCategoryName) {
        this.longCategoryName = longCategoryName;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
