package com.example.handlingformsubmission;


import java.io.IOException;


import org.json.JSONException;
import org.json.JSONArray;

public class Mortgage {
    private long year;
    private double principle;
    private double apr;



    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public double getPrinciple() {
        return principle;
    }

    public void setPrinciple(double principle) {
        this.principle = principle;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) throws IOException, InterruptedException, JSONException {
        this.apr = apr;
    }


}


