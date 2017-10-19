package com.jeldrik.surfweatherwidget.data.datasource;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.data.model.WeatherForecast;
import com.jeldrik.surfweatherwidget.data.restclient.RestApi;
import com.jeldrik.surfweatherwidget.data.restclient.RestClient;
import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherInteractor;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @author Madrid Tech Lab on 19/10/2017.
 */

public class OpenWeatherNetworkDataSource {

    public interface Callback{

        void onSuccess(CurrentWeather currentWeather);

        void onError();
    }

    private OkHttpClient okHttpClient;
    private LocalLocationDataSource localLocationDataSource;

    private static final String CURRENT_WEATHER_API_KEY = "f6f3756bb5aa4643f3864c1ed53ca590";
    private final String baseUrl = "http://api.openweathermap.org/data/2.5/";

    @Inject
    public OpenWeatherNetworkDataSource(@NonNull OkHttpClient okHttpClient, @NonNull LocalLocationDataSource localLocationDataSource) {
        this.okHttpClient = okHttpClient;
        this.localLocationDataSource = localLocationDataSource;
    }

    public void getCurrentWeather(Callback callback) {
        RestApi api = RestClient.getRestApiClient(baseUrl, okHttpClient);
        Call<CurrentWeather> call = api.loadCurrentWeatherByGeoLocation(localLocationDataSource.getLatitude(), localLocationDataSource.getLongitude(), CURRENT_WEATHER_API_KEY);
        try {
            if (call == null) {
                //callback.onError(new DomainException());
                callback.onError();
                return;
            }
            Response response = call.execute();

            if (response == null) {
                //callback.onError(new DomainException());
                callback.onError();
                return;
            }
            if (!response.isSuccessful()) {
                //callback.onError(new DomainException());
                callback.onError();
                return;
            }
            callback.onSuccess((CurrentWeather)response.body());

        } catch (IOException e) {
            //callback.onError(new DomainException());
        }

    }
}
