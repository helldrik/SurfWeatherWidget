package com.jeldrik.surfweatherwidget.data.datasource;

import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * Created by jeldrik on 17/10/17.
 */

public class LocalLocationDataSource {

    private SharedPrefsLocalDataSource sharedPrefsLocalDataSource;
    private String city;
    private String country;
    private String longitude;
    private String latitude;

    public LocalLocationDataSource(@NonNull SharedPrefsLocalDataSource sharedPrefsLocalDataSource) {
        this.sharedPrefsLocalDataSource = sharedPrefsLocalDataSource;
        city = sharedPrefsLocalDataSource.getString("city");
        country = sharedPrefsLocalDataSource.getString("country");
        longitude = sharedPrefsLocalDataSource.getString("longitude");
        latitude = sharedPrefsLocalDataSource.getString("latitude");
        //TODO delete these lines
        latitude = "40.4168";
        longitude = "-3.7038";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        sharedPrefsLocalDataSource.save("city", city);
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        sharedPrefsLocalDataSource.save("country", country);
        this.country = country;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        sharedPrefsLocalDataSource.save("longitude", longitude);
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        sharedPrefsLocalDataSource.save("latitude", latitude);
        this.latitude = latitude;
    }
}
