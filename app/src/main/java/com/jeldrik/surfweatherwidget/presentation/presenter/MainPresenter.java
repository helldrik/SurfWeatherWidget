package com.jeldrik.surfweatherwidget.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.jeldrik.surfweatherwidget.common.Dagger.components.ApplicationComponent;
import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.data.model.MainWeatherInfo;
import com.jeldrik.surfweatherwidget.data.model.Weather;
import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherInteractor;
import com.jeldrik.surfweatherwidget.presentation.view.MainView;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 10/10/2017.
 */

public class MainPresenter {

    CurrentWeatherInteractor currentWeatherInteractor;

    MainView view;

    @Inject
    public MainPresenter(CurrentWeatherInteractor currentWeatherInteractor) {
        this.currentWeatherInteractor = currentWeatherInteractor;
    }

    public void create() {
        if (currentWeatherInteractor != null) {
            final android.os.Handler handler = new android.os.Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    loadData();
                    handler.postDelayed(this,600000);
                }
            };
            handler.post(runnable);
        }

    }

    private void loadData(){
        currentWeatherInteractor.execute(new CurrentWeatherInteractor.Callback() {
            @Override
            public void onSuccess(@NonNull CurrentWeather currentWeather) {
                MainWeatherInfo mainWeatherInfo = currentWeather.getMain();
                if (mainWeatherInfo != null) {
                    setCurrentTemp(mainWeatherInfo.getTemp());
                    setMinTemp(mainWeatherInfo.getTemp_min());
                    setMaxTemp(mainWeatherInfo.getTemp_max());
                }
                Weather weather = currentWeather.getWeather()[0];
                if (weather != null) {
                    setCondition(weather.getDescription());
                }
            }

            @Override
            public void onError() {
                Log.d("MainPresenter", "an Error accured");
            }
        });
    }

    public void setView(MainView view) {
        this.view = view;
    }

    private void setCurrentTemp(String currentTemp) {
        view.setCurrentTemp(convertKelvinToCelcius(currentTemp));
    }

    private void setMinTemp(String minTemp) {
        view.setMinTemp(convertKelvinToCelcius(minTemp));
    }

    private void setMaxTemp(String minTemp) {
        view.setMaxTemp(convertKelvinToCelcius(minTemp));
    }

    private void setCondition(String condition) {
        view.setCondition(condition);
    }

    private String convertKelvinToCelcius(String kelvin) {
        double kelvinAsNumber = Double.parseDouble(kelvin);
        double celcius = (double)(Math.round(10 * (kelvinAsNumber - 273.15))) / 10;
        String formattedTemp = Double.toString(celcius);
        return formattedTemp.replace(".0","");
    }
}
