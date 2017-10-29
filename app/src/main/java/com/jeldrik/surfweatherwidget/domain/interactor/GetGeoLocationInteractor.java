package com.jeldrik.surfweatherwidget.domain.interactor;


import java.util.Map;

/**
 * Created by jeldrik on 29/10/17.
 */

public interface GetGeoLocationInteractor {

     interface Callback{
        void onSucess(Map<String, String> geoLocation);
        void onError();
    }

    void execute(Callback callback);
}
