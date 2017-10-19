package com.jeldrik.surfweatherwidget.data.datasource;

import javax.inject.Inject;

/**
 * Created by jeldrik on 17/10/17.
 */

public class LocalLocationDataSource {

    private String city;
    private String country;
    private String longitude;
    private String latitude;

    public LocalLocationDataSource() {
        latitude = "40.4168";
        longitude = "3.7038";
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
