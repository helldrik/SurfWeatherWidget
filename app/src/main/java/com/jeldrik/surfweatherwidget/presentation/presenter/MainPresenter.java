package com.jeldrik.surfweatherwidget.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.jeldrik.surfweatherwidget.common.Dagger.components.ApplicationComponent;
import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherInteractor;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;
import com.jeldrik.surfweatherwidget.presentation.Main;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 10/10/2017.
 */

public class MainPresenter {


    @Inject
    CurrentWeatherInteractor currentWeatherInteractor;


    public MainPresenter() {
    }
    /**
     * Initializes the dependency injection for this class.
     *
     */
    public void initInjection(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }

    public void create() {
        if (currentWeatherInteractor != null) {
            currentWeatherInteractor.execute(new CurrentWeatherInteractor.Callback() {
                @Override
                public void onSuccess(@NonNull CurrentWeather currentWeather) {
                    Log.d("MainPresenter", currentWeather.toString());
                }

                @Override
                public void onError() {
                    Log.d("MainPresenter", "an Error accured");
                }
            });
        }
    }
}
