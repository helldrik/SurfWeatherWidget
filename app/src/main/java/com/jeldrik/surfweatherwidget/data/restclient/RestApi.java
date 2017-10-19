package com.jeldrik.surfweatherwidget.data.restclient;

import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.data.model.WeatherForecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jeldrik on 17/10/17.
 */

public interface RestApi {

    @GET("weather")
    Call<CurrentWeather> loadCurrentWeatherByGeoLocation(@Query("lat") String latitude, @Query("lon") String longitude);

    @GET("weather")
    Call<CurrentWeather> loadCurrentWeatherByZipCode(@Query("zip") String zipCodePlusCountryCode);

    @GET("forecast")
    Call<WeatherForecast> loadForecastByGeoLocation(@Query("lat") String latitude, @Query("lon") String longitude);

    @GET("forecast")
    Call<WeatherForecast> loadForecastByZipCode(@Query("zip") String zipCodePlusCountryCode);
}
