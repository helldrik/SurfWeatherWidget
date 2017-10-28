package com.jeldrik.surfweatherwidget.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.jeldrik.surfweatherwidget.common.Dagger.components.ApplicationComponent;
import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.data.model.MainWeatherInfo;
import com.jeldrik.surfweatherwidget.data.model.Sys;
import com.jeldrik.surfweatherwidget.data.model.Weather;
import com.jeldrik.surfweatherwidget.data.model.Wind;
import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherInteractor;
import com.jeldrik.surfweatherwidget.presentation.view.MainView;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                    handler.postDelayed(this, 600000);
                }
            };
            handler.post(runnable);
        }

    }

    private void loadData() {
        currentWeatherInteractor.execute(new CurrentWeatherInteractor.Callback() {
            @Override
            public void onSuccess(@NonNull CurrentWeather currentWeather) {
                MainWeatherInfo mainWeatherInfo = currentWeather.getMain();
                if (mainWeatherInfo != null) {
                    setCurrentTemp(mainWeatherInfo.getTemp());
                    setMinTemp(mainWeatherInfo.getTemp_min());
                    setMaxTemp(mainWeatherInfo.getTemp_max());
                    setHumidity(mainWeatherInfo.getHumidity());
                }
                Weather weather = currentWeather.getWeather()[0];
                if (weather != null) {
                    setCondition(weather.getDescription());
                }
                Wind wind = currentWeather.getWind();
                if(wind!=null) {
                    setWind(wind.getSpeed());
                }
                Sys sys = currentWeather.getSys();
                if(sys!=null){
                    setSunrise(sys.getSunrise());
                    setSunset(sys.getSunset());
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

    public void setWind(String wind) {
        view.setWind(wind);
    }

    private void setHumidity(String humidity) {
        view.setHumidity(humidity);
    }

    private void setSunrise(String sunrise){
        view.setSunrise(convertTimeStampToTime(sunrise));
    }

    private void setSunset(String sunset){
        view.setSunset(convertTimeStampToTime(sunset));
    }

    private String convertKelvinToCelcius(String kelvin) {
        double kelvinAsNumber = Double.parseDouble(kelvin);
        double celcius = (double) (Math.round(10 * (kelvinAsNumber - 273.15))) / 10;
        String formattedTemp = Double.toString(celcius);
        return formattedTemp.replace(".0", "");
    }
    private String convertTimeStampToTime(String timestamp){
        long timestampAsLong = Long.parseLong(timestamp);
        Date date = new Date(timestampAsLong * 1000L);
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }
}
