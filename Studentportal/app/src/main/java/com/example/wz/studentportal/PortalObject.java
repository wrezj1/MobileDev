package com.example.wz.studentportal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class PortalObject {

    private String uri;
    private String title;

    public PortalObject(String uri, String title) {
        this.uri = uri;
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public String getTitle() {
        return title;
    }

}