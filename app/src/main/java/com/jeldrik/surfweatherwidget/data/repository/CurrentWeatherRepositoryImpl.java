package com.jeldrik.surfweatherwidget.data.repository;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherNetworkDataSource;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;

/**
 * @author Madrid Tech Lab on 19/10/2017.
 */

public class CurrentWeatherRepositoryImpl implements CurrentWeatherRepository {


    private OpenWeatherNetworkDataSource openWeatherNetworkDataSource;


    public CurrentWeatherRepositoryImpl(@NonNull OpenWeatherNetworkDataSource openWeatherNetworkDataSource) {
        this.openWeatherNetworkDataSource = openWeatherNetworkDataSource;
    }

    @Override
    public void getCurrentWeather(CurrentWeatherCallback callback) {

    }
}
