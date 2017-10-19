package com.jeldrik.surfweatherwidget.presentation.presenter;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.common.Dagger.components.ApplicationComponent;
import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;
import com.jeldrik.surfweatherwidget.presentation.Main;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 10/10/2017.
 */

public class MainPresenter {


    @Inject
    CurrentWeatherRepository currentWeatherRepository;

    public MainPresenter() {
        currentWeatherRepository.getCurrentWeather(new CurrentWeatherRepository.CurrentWeatherCallback() {
            @Override
            public void onSuccess(@NonNull CurrentWeather currentWeather) {

            }

            @Override
            public void onError() {

            }
        });
    }

    /**
     * Initializes the dependency injection for this class.
     *
     */
    public void initInjection(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }
}
