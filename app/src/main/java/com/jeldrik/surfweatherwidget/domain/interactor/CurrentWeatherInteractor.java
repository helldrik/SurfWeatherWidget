package com.jeldrik.surfweatherwidget.domain.interactor;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;

/**
 * @author Madrid Tech Lab on 19/10/2017.
 */

public interface CurrentWeatherInteractor {

    /**
            * Callback
     */
    interface Callback {

        /**
         * Called when the  information is received.
         */
        void onSuccess(@NonNull CurrentWeather currentWeather);

        /**
         * Called when an error happens
         */
        void onError();
    }
    void execute(Callback callback);
}
