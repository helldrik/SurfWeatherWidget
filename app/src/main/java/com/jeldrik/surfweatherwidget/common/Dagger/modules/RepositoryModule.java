package com.jeldrik.surfweatherwidget.common.Dagger.modules;

import com.jeldrik.surfweatherwidget.data.datasource.GeoLocationDataSource;
import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherCachedDataSource;
import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherNetworkDataSource;
import com.jeldrik.surfweatherwidget.data.repository.CurrentWeatherRepositoryImpl;
import com.jeldrik.surfweatherwidget.data.repository.GeoLocationRepositoryImpl;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;
import com.jeldrik.surfweatherwidget.domain.repository.GeoLocationRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Madrid Tech Lab on 19/10/2017.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    CurrentWeatherRepository providesCurrentWeatherRepository(OpenWeatherNetworkDataSource openWeatherNetworkDataSource, OpenWeatherCachedDataSource openWeatherCachedDataSource){
        return new CurrentWeatherRepositoryImpl(openWeatherNetworkDataSource, openWeatherCachedDataSource);
    }

    @Provides
    @Singleton
    GeoLocationRepository providesGeoLocationRepository(GeoLocationDataSource geoLocationDataSource){
        return new GeoLocationRepositoryImpl(geoLocationDataSource);
    }
}
