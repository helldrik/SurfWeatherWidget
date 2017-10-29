package com.jeldrik.surfweatherwidget.data.repository;

import com.jeldrik.surfweatherwidget.data.datasource.GeoLocationDataSource;
import com.jeldrik.surfweatherwidget.domain.repository.GeoLocationRepository;

import java.util.Map;

/**
 * Created by jeldrik on 29/10/17.
 */

public class GeoLocationRepositoryImpl implements GeoLocationRepository {



    private GeoLocationDataSource geoLocationDataSource;

    public GeoLocationRepositoryImpl(GeoLocationDataSource geoLocationDataSource) {
        this.geoLocationDataSource = geoLocationDataSource;
    }

    public void getGeoLocation(final GeoLocationRepository.Callback callback){
        geoLocationDataSource.getLocation(new GeoLocationDataSource.GeoLocationCallback() {
            @Override
            public void onNewGpsData(Map<String, String> locationData) {
                callback.onSucess(locationData);
            }

            @Override
            public void onError(String msg) {
                callback.onError();
            }
        });
    }
}
