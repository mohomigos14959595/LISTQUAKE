package com.example.sazgar.listquakes;

/**
 *
 */

public class Event {
    private double mag;
    private int felt;
    private String siteURL;

    public Event(double mag, int felt, String siteURL) {
        this.mag = mag;
        this.felt = felt;
        this.siteURL = siteURL;
    }
    public double getMag() {
        return mag;
    }

    public int getFelt() {
        return felt;
    }


    public String getSiteURL() {
        return siteURL;
    }



}