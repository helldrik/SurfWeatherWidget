package com.jeldrik.surfweatherwidget.domain.repository;

import java.util.Map;

/**
 * Created by jeldrik on 29/10/17.
 */

public interface GeoLocationRepository {

    interface Callback{
        void onSucess(Map<String, String> geoLocation);
        void onError();
    }
    public void getGeoLocation(Callback callback);
}
