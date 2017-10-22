package com.jeldrik.surfweatherwidget.data.datasource;

import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;

import java.util.Date;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 22/10/2017.
 */

public class OpenWeatherCachedDataSource {

    private CurrentWeather currentWeather;

    @Inject
    public OpenWeatherCachedDataSource() {
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }
}
