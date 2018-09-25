package com.example.wz.geoguesswipe;

/**
 * author: Wrezj kebabdji
 */

public class GeoImage {
    private boolean mInEurope;
    private int mGeoImageName;

    public GeoImage(boolean mInEurope, int mGeoImageName) {

        this.mInEurope = mInEurope;
        this.mGeoImageName = mGeoImageName;
    }

    public boolean getmInEurope() {
        return mInEurope;
    }

    public int getmGeoImageName() {
        return mGeoImageName;
    }


    public static final boolean[] IN_EUROPE = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };


    public static final int[] IMAGE_NAME = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

}
