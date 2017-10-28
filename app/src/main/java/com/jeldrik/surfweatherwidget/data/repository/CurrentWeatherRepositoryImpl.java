package com.jeldrik.surfweatherwidget.data.repository;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherCachedDataSource;
import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherNetworkDataSource;
import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;

import java.util.Date;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 19/10/2017.
 */

public class CurrentWeatherRepositoryImpl implements CurrentWeatherRepository {


    private OpenWeatherNetworkDataSource openWeatherNetworkDataSource;
    private OpenWeatherCachedDataSource openWeatherCachedDataSource;
    private long timestamp;

    @Inject
    public CurrentWeatherRepositoryImpl(@NonNull OpenWeatherNetworkDataSource openWeatherNetworkDataSource, @NonNull OpenWeatherCachedDataSource openWeatherCachedDataSource) {
        this.openWeatherNetworkDataSource = openWeatherNetworkDataSource;
        this.openWeatherCachedDataSource = openWeatherCachedDataSource;
        timestamp = new Date().getTime();
    }

    @Override
    public void getCurrentWeather(final CurrentWeatherCallback callback) {
        if(openWeatherCachedDataSource.getCurrentWeather()!= null && (new Date().getTime()-600000 < timestamp)){
            callback.onSuccess(openWeatherCachedDataSource.getCurrentWeather());
        } else {
            timestamp = new Date().getTime();
            openWeatherNetworkDataSource.getCurrentWeather(new OpenWeatherNetworkDataSource.Callback() {
                @Override
                public void onSuccess(CurrentWeather currentWeather) {
                    callback.onSuccess(currentWeather);
                    openWeatherCachedDataSource.setCurrentWeather(currentWeather);
                }

                @Override
                public void onError() {
                    callback.onError();
                }
            });
        }
    }
}
