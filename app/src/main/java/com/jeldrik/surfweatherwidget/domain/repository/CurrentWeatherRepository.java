package com.jeldrik.surfweatherwidget.domain.repository;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;

/**
 * @author Madrid Tech Lab on 19/10/2017.
 */

public interface CurrentWeatherRepository {

    /**
     * Callback for the Product details.
     */
    interface CurrentWeatherCallback {

        /**
         * Called when the product information is received.
         */
        void onSuccess(@NonNull CurrentWeather currentWeather);

        /**
         * Called when an error happens while getting the product info.
         */
        void onError();
    }
    void getCurrentWeather(CurrentWeatherCallback callback);
}
