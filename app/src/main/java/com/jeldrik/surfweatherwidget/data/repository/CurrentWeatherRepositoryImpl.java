package com.jeldrik.surfweatherwidget.data.repository;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherNetworkDataSource;
import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 19/10/2017.
 */

public class CurrentWeatherRepositoryImpl implements CurrentWeatherRepository {


    private OpenWeatherNetworkDataSource openWeatherNetworkDataSource;

    @Inject
    public CurrentWeatherRepositoryImpl(@NonNull OpenWeatherNetworkDataSource openWeatherNetworkDataSource) {
        this.openWeatherNetworkDataSource = openWeatherNetworkDataSource;
    }

    @Override
    public void getCurrentWeather(final CurrentWeatherCallback callback) {
        openWeatherNetworkDataSource.getCurrentWeather(new OpenWeatherNetworkDataSource.Callback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {
                callback.onSuccess(currentWeather);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }
}
