package com.jeldrik.surfweatherwidget.data.datasource;

/**
 * Created by jeldrik on 17/10/17.
 */

public class LocalLocationDataSource {

    private String city;
    private String country;
    private String[] location;

    public LocalLocationDataSource() {
        //empty constructor
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getLocation() {
        return location;
    }

    public void setLocation(String[] location) {
        this.location = location;
    }
}
