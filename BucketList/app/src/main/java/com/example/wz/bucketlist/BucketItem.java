package com.example.wz.bucketlist;

import android.text.Editable;
import android.widget.EditText;

public class BucketItem {

    private String text;
    private Boolean done;

    public BucketItem(Editable text, boolean done) {
        this.text = text.toString();
        this.done = done;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}