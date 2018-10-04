package com.example.sina.assign6;

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private String mUrl;
    private Long mTimeInMilliSeconds;
    private String latitude;
    protected String longitude;

    public Earthquake(double magnitude, String place,String url, long timeInMilliSeconds, String mlongitude , String mlatitude) {
        this.mMagnitude = magnitude;
        this.mLocation = place;
        this.mUrl = url;
        this.mTimeInMilliSeconds = timeInMilliSeconds;
        this.latitude = mlatitude;
        this.longitude = mlongitude;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliSeconds() {
        return mTimeInMilliSeconds;
    }

    public String getUrl() {
        return mUrl;
    }

    public String GETlatitude() {
        return latitude;
    }

    public String GETlongitude() {
        return longitude;
    }
}