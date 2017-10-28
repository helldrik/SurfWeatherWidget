package com.jeldrik.surfweatherwidget.data.datasource;

import android.text.TextUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 22/10/2017.
 */

public class OpenWeatherCachedDataSource {

    private CurrentWeather currentWeather;
    private SharedPrefsLocalDataSource sharedPrefsLocalDataSource;

    @Inject
    public OpenWeatherCachedDataSource(SharedPrefsLocalDataSource sharedPrefsLocalDataSource) {
        this.sharedPrefsLocalDataSource = sharedPrefsLocalDataSource;
        String currentWeatherAsString = sharedPrefsLocalDataSource.getString("currentWeather");
        if (!TextUtils.isEmpty(currentWeatherAsString)) {
            try {
                currentWeather = new ObjectMapper().readValue(currentWeatherAsString, CurrentWeather.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
        try {
            String currentWeatherAsString = new ObjectMapper().writeValueAsString(currentWeather);
            sharedPrefsLocalDataSource.save("currentWeather", currentWeatherAsString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
